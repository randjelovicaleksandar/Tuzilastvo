/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nit;

import forme.GlavnaFormaServer;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import kontroler.Kontroler;
import model.Zaposleni;
import model.OpstiDomenskiObjekat;
import model.Osumnjiceni;
import model.Predmet;
import model.Vodjenje;
import transfer.TransferObjekatOdgovor;
import transfer.TransferObjekatZahtev;
import util.Operacija;

/**
 *
 * @author  Aleksandar Randjelovic
 */
public class KlijentNit extends Thread {

    private Socket soket;
    private boolean kraj = false;
    private Zaposleni zaposleni;
    private GlavnaFormaServer gf;

    public KlijentNit(Socket soket) {
        this.soket = soket;
    }

    KlijentNit(Socket soket, GlavnaFormaServer gf) {
        this.soket = soket;
        this.gf = gf;
        Kontroler.getInstance().postaviFormu(gf);
    }

    @Override
    public void run() {
        try {
            obaviOperaciju();
        } catch (IOException | ClassNotFoundException ex) {
            kraj = true;
            System.out.println("PREKINUTA IZ RUN METODE");
            
        }
    }

    public void posaljiOdgovor(TransferObjekatOdgovor odgovor) throws IOException {
        ObjectOutputStream outSocket = new ObjectOutputStream(soket.getOutputStream());
        outSocket.writeObject(odgovor);
    }

    private void obaviOperaciju() throws IOException, ClassNotFoundException {
        while (!kraj) {
            ObjectInputStream inSocket = new ObjectInputStream(soket.getInputStream());
            TransferObjekatZahtev zahtev = (TransferObjekatZahtev) inSocket.readObject();
            TransferObjekatOdgovor odgovor = new TransferObjekatOdgovor();
            try {
                switch (zahtev.getOperacija()) {
                    case Operacija.LOGIN:
                        zaposleni = (Zaposleni) zahtev.getParametar();
                        if (Kontroler.getInstance().ulogujSe(zaposleni)) {
                            odgovor.setPoruka("Uspesno ste se ulogovali.");
                            Kontroler.getInstance().dodajKlijentskuNit(this);
                        } else {
                            odgovor.setIzuzetak("Korisnicko ime ili lozinka nisu dobri. Pokusajte ponovo!");
                        }
                        break;
                    case Operacija.VRATI_OSUMNJICENE:
                        List<OpstiDomenskiObjekat> listaOsumnjicenih = Kontroler.getInstance().vratiOsumnjicene();
                        odgovor.setRezultat(listaOsumnjicenih);
                        odgovor.setPoruka("Ucitana je lista osumnjicenih.");
                        break;
                    case Operacija.VRATI_MESTA:
                        List<OpstiDomenskiObjekat> listaMesta = Kontroler.getInstance().vratiMesta();
                        odgovor.setRezultat(listaMesta);
                        odgovor.setPoruka("Ucitana je lista mesta.");
                        break;
                    case Operacija.VRATI_PREDMETE:
                        List<OpstiDomenskiObjekat> listaPredmeta = Kontroler.getInstance().vratiPredmete();
                        odgovor.setRezultat(listaPredmeta);
                        odgovor.setPoruka("Ucitana je lista predmeta.");
                        break;
                    case Operacija.UNOS_OSUMNJICENOG:
                        Osumnjiceni osumnjiceni = (Osumnjiceni) zahtev.getParametar();
                        Kontroler.getInstance().dodajOsumnjicenog(osumnjiceni);
                        odgovor.setPoruka("Osumnjiceni je uspesno sacuvan.");
                        break;
                    case Operacija.IZMENA_OSUMNJICENOG:
                        Osumnjiceni osumnjiceniIzmena = (Osumnjiceni) zahtev.getParametar();
                        Kontroler.getInstance().izmeniOsumnjicenog(osumnjiceniIzmena);
                        odgovor.setPoruka("Osumnjiceni je uspesno izmenjen.");
                        break;
                    case Operacija.VRATI_TUZIOCE:
                        List<OpstiDomenskiObjekat> listaTuzioca = Kontroler.getInstance().vratiTuzioce();
                        odgovor.setRezultat(listaTuzioca);
                        odgovor.setPoruka("Ucitana je lista Tuzioca.");
                        break;
                    case Operacija.VRATI_VODJENJA:
                        List<OpstiDomenskiObjekat> listaVodjenja = Kontroler.getInstance().vratiVodjenja();
                        odgovor.setRezultat(listaVodjenja);
                        odgovor.setPoruka("Ucitana je lista vodjenja.");
                        break;
                    case Operacija.UNOS_PREDMETA:
                        Predmet predmet = (Predmet) zahtev.getParametar();
                        Kontroler.getInstance().dodajPredmet(predmet);
                        odgovor.setPoruka("Predmet je uspesno sacuvan.");
                        break;
                    case Operacija.UNOS_VODJENJA:
                        Vodjenje vodjenje = (Vodjenje) zahtev.getParametar();
                        Kontroler.getInstance().dodajVodjenje(vodjenje);
                        odgovor.setPoruka("Vodjenje je uspesno sacuvano.");
                        break;
                    case Operacija.IZMENA_PREDMETA:
                        Predmet predmetIzmena = (Predmet) zahtev.getParametar();
                        Kontroler.getInstance().izmeniPredmet(predmetIzmena);
                        odgovor.setPoruka("Predmet je uspesno izmenjen.");
                        break;
                    case Operacija.IZMENA_VODJENJA:
                        Vodjenje vodjenjeIzmena = (Vodjenje) zahtev.getParametar();
                        Kontroler.getInstance().izmeniVodjenje(vodjenjeIzmena);
                        odgovor.setPoruka("Vodjenje je uspesno izmenjeno.");
                        break;
                    case Operacija.BRISANJE_OSUMNJICENOG:
                        Osumnjiceni osumnjiceniBrisanje = (Osumnjiceni) zahtev.getParametar();
                        Kontroler.getInstance().obrisiOsumnjicenog(osumnjiceniBrisanje);
                        odgovor.setPoruka("Osumnjiceni je uspesno obrisan.");
                        break;
                    case Operacija.BRISANJE_PREDMETA:
                        Predmet predmetBrisanje = (Predmet) zahtev.getParametar();
                        Kontroler.getInstance().obrisiPredmet(predmetBrisanje);
                        odgovor.setPoruka("Predmet je uspesno obrisan.");
                        break; 
                    case Operacija.BRISANJE_VODJENJA:
                        Vodjenje vodjenjeBrisanje = (Vodjenje) zahtev.getParametar();
                        Kontroler.getInstance().obrisiVodjenje(vodjenjeBrisanje);
                        odgovor.setPoruka("Vodjenje je uspesno obrisano.");
                        break; 
                    case Operacija.KRAJ:
                        Kontroler.getInstance().obrisiKlijentskuNit(this);
                        odgovor.setPoruka("Izlogovao se zaposleni!");
                        kraj = true;
                        break;
                }
            } catch (Exception ex) {
                odgovor.setPoruka(ex.getMessage());
                odgovor.setIzuzetak(ex);
            }
            posaljiOdgovor(odgovor);
        }
    }

    public Socket getSoket() {
        return soket;
    }

    public void setSoket(Socket soket) {
        this.soket = soket;
    }

    public boolean isKraj() {
        return kraj;
    }

    public void setKraj(boolean kraj) {
        this.kraj = kraj;
    }

    public Zaposleni getZaposleni() {
        return zaposleni;
    }

    public void setZaposleni(Zaposleni zaposleni) {
        this.zaposleni = zaposleni;
    }

    public void prekid() {
        try {
            kraj = true;
            soket.close();
        } catch (IOException ex) {
            Logger.getLogger(KlijentNit.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("PREKINUTA IZ PREKID METODE");
    }
}

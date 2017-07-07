/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kontroler;

import forme.GlavnaFormaServer;
import java.util.LinkedList;
import java.util.List;
import model.Korisnik;
import model.Mesto;
import model.OpstiDomenskiObjekat;
import model.Osumnjiceni;
import model.Predmet;
import model.Tuzilac;
import nit.KlijentNit;
import so.OpstaSO;
import so.korisnik.PronadjiZaposlenogSO;
import so.mesto.UcitajMestaSO;
import so.osumnjiceni.ArhivirajOsumnjicenogSO;
import so.osumnjiceni.UcitajOsumnjiceneSO;
import so.osumnjiceni.ZapamtiOsumnjicenogSO;
import so.predmet.ArhivirajPredmetSO;
import so.predmet.PronadjiPredmeteSO;
import so.predmet.ZapamtiPredmetSO;
import so.tuzilac.UcitajTuzioceSO;


/**
 *
 * @author  Aleksandar Randjelovic
 */
public class Kontroler {

    private static Kontroler instance;
    private LinkedList<KlijentNit> listaKlijentskihNiti;
    private GlavnaFormaServer gf;

    private Kontroler() {
        listaKlijentskihNiti = new LinkedList<>();
    }

    public static Kontroler getInstance() {
        if (instance == null) {
            instance = new Kontroler();
        }
        return instance;
    }

    public List<OpstiDomenskiObjekat> vratiOsumnjicene() throws Exception {
        OpstaSO vratiOsumnjiceneSO = new UcitajOsumnjiceneSO();
        vratiOsumnjiceneSO.izvrsenjeSO(new Osumnjiceni());
        return ((UcitajOsumnjiceneSO) vratiOsumnjiceneSO).getListaOsumnjicenih();
    }

    public List<OpstiDomenskiObjekat> vratiMesta() throws Exception {
        OpstaSO vratiMestaSO = new UcitajMestaSO();
        vratiMestaSO.izvrsenjeSO(new Mesto());
        return ((UcitajMestaSO) vratiMestaSO).getListaMesta();
    }

    public List<OpstiDomenskiObjekat> vratiPredmete() throws Exception {
        OpstaSO vratiPredmeteSO = new PronadjiPredmeteSO();
        vratiPredmeteSO.izvrsenjeSO(new Predmet());
        return ((PronadjiPredmeteSO) vratiPredmeteSO).getListaPredmeta();
    }

    public void dodajOsumnjicenog(Osumnjiceni osumnjiceni) throws Exception {
        OpstaSO unosOsumnjicenogSO = new ZapamtiOsumnjicenogSO();
        unosOsumnjicenogSO.izvrsenjeSO(osumnjiceni);
    }

    public void izmeniOsumnjicenog(Osumnjiceni osumnjiceni) throws Exception {
        OpstaSO unosOsumnjicenogSO = new ZapamtiOsumnjicenogSO();
        unosOsumnjicenogSO.izvrsenjeSO(osumnjiceni);
    }
    
    
    public void obrisiOsumnjicenog(Osumnjiceni osumnjiceni) throws Exception {
        OpstaSO brisanjeOsumnjicenogSO = new ArhivirajOsumnjicenogSO();
        brisanjeOsumnjicenogSO.izvrsenjeSO(osumnjiceni);
    }
    
    public void dodajPredmet(Predmet predmet) throws Exception {
        OpstaSO unosPredmetSO = new ZapamtiPredmetSO();
        unosPredmetSO.izvrsenjeSO(predmet);
    }
    
    public void izmeniPredmet(Predmet predmet) throws Exception {
        OpstaSO unosPredmetSO = new ZapamtiPredmetSO();
        unosPredmetSO.izvrsenjeSO(predmet);
    }
    
    public void obrisiPredmet(Predmet predmet) throws Exception {
        OpstaSO brisanjePredmetaSO = new ArhivirajPredmetSO();
        brisanjePredmetaSO.izvrsenjeSO(predmet);
    }

    public List<OpstiDomenskiObjekat> vratiTuzioce() throws Exception {
        OpstaSO vratiTuzioceSO = new UcitajTuzioceSO();
        vratiTuzioceSO.izvrsenjeSO(new Tuzilac());
        return ((UcitajTuzioceSO) vratiTuzioceSO).getListaTuzioca();
    }

    public boolean ulogujSe(Korisnik korisnik) throws Exception {
        OpstaSO pronadjiZaposlenogSO = new PronadjiZaposlenogSO();
        pronadjiZaposlenogSO.izvrsenjeSO(korisnik);
        return ((PronadjiZaposlenogSO) pronadjiZaposlenogSO).isRezultat();
    }

    public void dodajKlijentskuNit(KlijentNit klijentskaNit) {
        listaKlijentskihNiti.add(klijentskaNit);
        gf.DodajRed(klijentskaNit);
    }

    public void obrisiKlijentskuNit(KlijentNit klijentskaNit) {
        for (KlijentNit klijentNit : listaKlijentskihNiti) {
            if (klijentNit.getKorisnik().getKorisnickoIme().equals(klijentskaNit.getKorisnik().getKorisnickoIme())) {
                listaKlijentskihNiti.remove(klijentNit);
                gf.obrisiRed(klijentNit);
                return;
            }
        }
    }

    public void obrisiSveNiti() {
        if (listaKlijentskihNiti.size() > 0) {
            for (KlijentNit klijentNit : listaKlijentskihNiti) {
//                TransferObjekatOdgovor odgovor = new TransferObjekatOdgovor();
//                odgovor.setPoruka("Klijentska nit ugasena");
//                try {
//                    klijentNit.posaljiOdgovor(odgovor);
                klijentNit.prekid();
//                } catch (IOException ex) {
//                    Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
//                }
            }
            int brojNiti = listaKlijentskihNiti.size();
            for (int i = 0; i < brojNiti; i++) {
                listaKlijentskihNiti.removeFirst();
            }
            gf.obrisiSveRedoveTabele();
            System.out.println("Obrisani svi klijenti");
        }
        System.out.println("Nema u listi podataka");
    }

    public List<KlijentNit> getListaKlijentskihNiti() {
        return listaKlijentskihNiti;
    }

    public void setListaKlijentskihNiti(LinkedList<KlijentNit> listaKlijentskihNiti) {
        this.listaKlijentskihNiti = listaKlijentskihNiti;
    }

    public void postaviFormu(GlavnaFormaServer gf) {
        this.gf = gf;
    }

}

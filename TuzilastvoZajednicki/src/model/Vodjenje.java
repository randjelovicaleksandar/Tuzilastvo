/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Aleksandar Randjelovic
 */
public class Vodjenje implements OpstiDomenskiObjekat {

    private int vodjenjeID;
    private Osumnjiceni osumnjiceni;
    private Predmet predmet;
    private Date datumOd;
    private Date datumDo;
    private String opis;

    public Vodjenje() {
    }

    public Vodjenje(int vodjenjeID, Osumnjiceni osumnjiceni, Predmet predmet, Date datumOd, Date datumDo, String opis) {
        this.vodjenjeID = vodjenjeID;
        this.osumnjiceni = osumnjiceni;
        this.predmet = predmet;
        this.datumOd = datumOd;
        this.datumDo = datumDo;
        this.opis = opis;
    }

    public Vodjenje(Osumnjiceni osumnjiceni, Predmet predmet, Date datumOd, Date datumDo, String opis) {
        this.osumnjiceni = osumnjiceni;
        this.predmet = predmet;
        this.datumOd = datumOd;
        this.datumDo = datumDo;
        this.opis = opis;
    }

    public int getVodjenjeID() {
        return vodjenjeID;
    }

    public void setVodjenjeID(int vodjenjeID) {
        this.vodjenjeID = vodjenjeID;
    }

    public Osumnjiceni getOsumnjiceni() {
        return osumnjiceni;
    }

    public void setOsumnjiceni(Osumnjiceni osumnjiceni) {
        this.osumnjiceni = osumnjiceni;
    }

    public Predmet getPredmet() {
        return predmet;
    }

    public void setPredmet(Predmet predmet) {
        this.predmet = predmet;
    }

    public Date getDatumOd() {
        return datumOd;
    }

    public void setDatumOd(Date datumOd) {
        this.datumOd = datumOd;
    }

    public Date getDatumDo() {
        return datumDo;
    }

    public void setDatumDo(Date datumDo) {
        this.datumDo = datumDo;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    @Override
    public String toString() {
        return "Vodjenje(" + vodjenjeID + ") predmeta: " + predmet + " protiv osumnjicenog: " + osumnjiceni + " od " + datumOd + " do" + datumDo + ".\n Sadrzaj: " + opis;
    }

    @Override
    public String vratiNazivTabele() {
        return "vodjenje";
    }

    @Override
    public String vratiVrednostiZaInsert() {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        return null + ", '" + predmet.getPredmetID() + "', '" + osumnjiceni.getOsumnjiceniID() + "', '" + df.format(datumOd) + "', '" + df.format(datumDo) + "', '" + opis + "'";
    }

    @Override
    public String vratiVrednostiZaUpdate() {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        return "osumnjiceniID = '" + osumnjiceni.getOsumnjiceniID() + "', predmetID= '" + predmet.getPredmetID() + "', datumOd= '"
                + df.format(datumOd) + "', datumDo= '"
                + df.format(datumDo) + "', opis= '" + opis + "' WHERE vodjenjeID= '" + vodjenjeID + "'";
    }

    @Override
    public String vratiUslovZaBrisanje() {
        return " vodjenjeID= " + vodjenjeID;
    }

    @Override
    public List<OpstiDomenskiObjekat> ucitaj(ResultSet rs) throws Exception {
        List<OpstiDomenskiObjekat> listaVodjenja = new LinkedList<>();
        while (rs.next()) {
            int vodjenjeID = rs.getInt("vodjenjeID");
            Date datumOd = rs.getDate("datumOd");
            Date datumDo = rs.getDate("datumDo");
            String opis = rs.getString("opis");

            int osumnjiceniID = rs.getInt("osumnjiceniID");
            String imePrezime = rs.getString("imePrezime");
            String JMBG = rs.getString("JMBG");
            Date datumRodjenja = rs.getDate("datumRodjenja");
            String adresa = rs.getString("adresa");
            String zanimanje = rs.getString("zanimanje");
            boolean osudjivanost = (rs.getInt("osudjivanost") == 1) ? true : false;
            int mestoID = rs.getInt("mestoID");
            Mesto mesto = new Mesto();
            mesto.setMestoID(mestoID);

            int predmetID = rs.getInt("predmetID");
            String delo = rs.getString("delo");
            String opisDela = rs.getString("opisDela");
            String obrazlozenje = rs.getString("obrazlozenje");
            String stanjePredmeta = rs.getString("stanjePredmeta");
            int tuzilacID = rs.getInt("tuzilacID");
            Tuzilac tuzilac = new Tuzilac();
            tuzilac.setTuzilacID(tuzilacID);

            Osumnjiceni o = new Osumnjiceni(osumnjiceniID, imePrezime, JMBG, datumRodjenja, adresa, zanimanje, osudjivanost, mesto);
            Predmet p = new Predmet(predmetID, delo, opisDela, obrazlozenje, stanjePredmeta, tuzilac);

            Vodjenje vodjenje = new Vodjenje(vodjenjeID, o, p, datumOd, datumDo, opis);
            listaVodjenja.add(vodjenje);
        }
        return listaVodjenja;
    }

    @Override
    public String vratiUslovZaLogin() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiUslovZaSortiranje() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiVrednostiZaJoin() {
        return " JOIN osumnjiceni USING(osumnjiceniID) JOIN predmet USING(predmetID)";
    }

    @Override
    public String vratiUslovZaProveru() {
        return "where vodjenjeID= " + vodjenjeID;
    }
}

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
public class Osumnjiceni implements OpstiDomenskiObjekat {

    private int osumnjiceniID;
    private String imePrezime;
    private String JMBG;
    private Date datumRodjenja;
    private String adresa;
    private String zanimanje;
    private boolean osudjivanost;
    private Mesto mesto;

    public Osumnjiceni() {
    }

    public Osumnjiceni(int osumnjiceniID, String imePrezime, String JMBG, Date datumRodjenja, String adresa, String zanimanje, boolean osudjivanost, Mesto mesto) {
        this.osumnjiceniID = osumnjiceniID;
        this.imePrezime = imePrezime;
        this.JMBG = JMBG;
        this.datumRodjenja = datumRodjenja;
        this.adresa = adresa;
        this.zanimanje = zanimanje;
        this.osudjivanost = osudjivanost;
        this.mesto = mesto;
    }

    public Osumnjiceni(String imePrezime, String JMBG, Date datumRodjenja, String adresa, String zanimanje, boolean osudjivanost, Mesto mesto) {
        this.imePrezime = imePrezime;
        this.JMBG = JMBG;
        this.datumRodjenja = datumRodjenja;
        this.adresa = adresa;
        this.zanimanje = zanimanje;
        this.osudjivanost = osudjivanost;
        this.mesto = mesto;
    }

    public int getOsumnjiceniID() {
        return osumnjiceniID;
    }

    public void setOsumnjiceniID(int osumnjiceniID) {
        this.osumnjiceniID = osumnjiceniID;
    }

    public String getImePrezime() {
        return imePrezime;
    }

    public void setImePrezime(String imePrezime) {
        this.imePrezime = imePrezime;
    }

    public String getJMBG() {
        return JMBG;
    }

    public void setJMBG(String JMBG) {
        this.JMBG = JMBG;
    }

    public Date getDatumRodjenja() {
        return datumRodjenja;
    }

    public void setDatumRodjenja(Date datumRodjenja) {
        this.datumRodjenja = datumRodjenja;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getZanimanje() {
        return zanimanje;
    }

    public void setZanimanje(String zanimanje) {
        this.zanimanje = zanimanje;
    }

    public boolean isOsudjivanost() {
        return osudjivanost;
    }

    public void setOsudjivanost(boolean osudjivanost) {
        this.osudjivanost = osudjivanost;
    }

    public Mesto getMesto() {
        return mesto;
    }

    public void setMesto(Mesto mesto) {
        this.mesto = mesto;
    }

    @Override
    public String toString() {
        return imePrezime;
    }

    @Override
    public String vratiNazivTabele() {
        return "osumnjiceni";
    }

    @Override
    public String vratiVrednostiZaInsert() {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        int osudjivanostInt = (osudjivanost) ? 1 : 0;
        String vrednost = null + ",'" + imePrezime + "','" + JMBG + "','" + df.format(datumRodjenja) + "','" + adresa + "','" + zanimanje + "','"
                + osudjivanostInt + "','" + mesto.getMestoID() + "'";
        return vrednost;
    }

    @Override
    public String vratiVrednostiZaUpdate() {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        int osudjivanostInt = (osudjivanost) ? 1 : 0;
        return "imePrezime= '" + imePrezime + "', JMBG= '" + JMBG + "', datumRodjenja= '"
                + df.format(datumRodjenja) + "', adresa= '"
                + adresa + "', zanimanje= '" + zanimanje + "', osudjivanost= '" + osudjivanostInt + "', mestoID= "
                + mesto.getMestoID()+ " WHERE osumnjiceniID= " + osumnjiceniID;
    }

    @Override
    public String vratiUslovZaBrisanje() {
        return " osumnjiceniID= " + osumnjiceniID;
    }

    @Override
    public List<OpstiDomenskiObjekat> ucitaj(ResultSet rs) throws Exception {
        List<OpstiDomenskiObjekat> listaOsumnjicenih = new LinkedList<>();
        while (rs.next()) {
            int osumnjiceniID = rs.getInt("osumnjiceniID");
            String imePrezime = rs.getString("imePrezime");
            String JMBG = rs.getString("JMBG");
            Date datumRodjenja = rs.getDate("datumRodjenja");
            String adresa = rs.getString("adresa");
            String zanimanje = rs.getString("zanimanje");
            boolean osudjivanost = (rs.getInt("osudjivanost") == 1) ? true : false;

            int mestoID = rs.getInt("mestoID");
            String nazivMesta = rs.getString("naziv");
            int ptt = rs.getInt("ptt");
            Mesto mesto = new Mesto(mestoID, nazivMesta, ptt);
            Osumnjiceni osumnjiceni = new Osumnjiceni(osumnjiceniID, imePrezime, JMBG, datumRodjenja, adresa, zanimanje, osudjivanost, mesto);
            listaOsumnjicenih.add(osumnjiceni);
        }
        return listaOsumnjicenih;
    }

    @Override
    public String vratiUslovZaLogin() {
        return "";
    }

    @Override
    public String vratiUslovZaSortiranje() {
        return "";
    }

    @Override
    public String vratiVrednostiZaJoin() {
        return " JOIN mesto USING(mestoID)";
    }

    @Override
    public String vratiUslovZaProveru() {
        return " WHERE osumnjiceniID= " + osumnjiceniID;
    }

}

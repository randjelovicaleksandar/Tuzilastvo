/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Aleksandar Randjelovic
 */
public class Tuzilac implements OpstiDomenskiObjekat {

    private int tuzilacID;
    private String imePrezime;
    private boolean dostupan;
    private int radniStaz;
    private int brojPredmeta;

    public Tuzilac() {
    }

    public Tuzilac(int tuzilacID, String imePrezime, boolean dostupan, int radniStaz, int brojPredmeta) {
        this.tuzilacID = tuzilacID;
        this.imePrezime = imePrezime;
        this.dostupan = dostupan;
        this.radniStaz = radniStaz;
        this.brojPredmeta = brojPredmeta;
    }

    public Tuzilac(String imePrezime, boolean dostupan, int radniStaz, int brojPredmeta) {
        this.imePrezime = imePrezime;
        this.dostupan = dostupan;
        this.radniStaz = radniStaz;
        this.brojPredmeta = brojPredmeta;
    }

    public int getRadniStaz() {
        return radniStaz;
    }

    public void setRadniStaz(int radniStaz) {
        this.radniStaz = radniStaz;
    }

    public int getBrojPredmeta() {
        return brojPredmeta;
    }

    public void setBrojPredmeta(int brojPredmeta) {
        this.brojPredmeta = brojPredmeta;
    }

    public int getTuzilacID() {
        return tuzilacID;
    }

    public void setTuzilacID(int tuzilacID) {
        this.tuzilacID = tuzilacID;
    }

    public String getImePrezime() {
        return imePrezime;
    }

    public void setImePrezime(String imePrezime) {
        this.imePrezime = imePrezime;
    }

    public boolean isDostupan() {
        return dostupan;
    }

    public void setDostupan(boolean dostupan) {
        this.dostupan = dostupan;
    }

    @Override
    public String toString() {
        return imePrezime;
    }
    
    @Override
    public String vratiNazivTabele() {
        return "tuzilac";
    }

    @Override
    public String vratiVrednostiZaInsert() {
        int dostupanInt = (dostupan) ? 1 : 0;
        return null + ", '" + imePrezime + ", '" + dostupan + ", '" + radniStaz + ", '" + brojPredmeta + "'";
    }

    @Override
    public String vratiVrednostiZaUpdate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiUslovZaBrisanje() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<OpstiDomenskiObjekat> ucitaj(ResultSet rs) throws Exception {
        List<OpstiDomenskiObjekat> listaTuzilaca = new LinkedList<>();
        while(rs.next()) {
            int tuzilacID = rs.getInt("tuzilacID");
            String imePrezime = rs.getString("imePrezime");
            boolean dostupan = (rs.getInt("dostupan") == 1) ? true : false;
            int brojPredmeta = rs.getInt("brojPredmeta");
            int radniStaz = rs.getInt("radniStaz");
            
            Tuzilac tuzilac = new Tuzilac(tuzilacID, imePrezime, dostupan, radniStaz, brojPredmeta);
            listaTuzilaca.add(tuzilac);
        }
        return listaTuzilaca;
    }

    @Override
    public String vratiUslovZaLogin() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiUslovZaSortiranje() {
        return " ORDER BY imePrezime ASC";
    }

    @Override
    public String vratiVrednostiZaJoin() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiUslovZaProveru() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

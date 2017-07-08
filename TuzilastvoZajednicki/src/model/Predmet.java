/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Aleksndar Randjelovic
 */
public class Predmet implements OpstiDomenskiObjekat {

    private int predmetID;
    private String delo;
    private String opisDela;
    private String obrazlozenje;
    private String stanjePredmeta;
    private Tuzilac tuzilac;

    public Predmet() {
    }

    public Predmet(int predmetID, String delo, String opisDela, String obrazlozenje, String stanjePredmeta, Tuzilac tuzilac) {
        this.predmetID = predmetID;
        this.delo = delo;
        this.opisDela = opisDela;
        this.obrazlozenje = obrazlozenje;
        this.stanjePredmeta = stanjePredmeta;
        this.tuzilac = tuzilac;
    }

    public Predmet(String delo, String opisDela, String obrazlozenje, String stanjePredmeta, Tuzilac tuzilac) {
        this.delo = delo;
        this.opisDela = opisDela;
        this.obrazlozenje = obrazlozenje;
        this.stanjePredmeta = stanjePredmeta;
        this.tuzilac = tuzilac;
    }

    public int getPredmetID() {
        return predmetID;
    }

    public void setPredmetID(int predmetID) {
        this.predmetID = predmetID;
    }

    public String getDelo() {
        return delo;
    }

    public void setDelo(String delo) {
        this.delo = delo;
    }

    public String getOpisDela() {
        return opisDela;
    }

    public void setOpisDela(String opisDela) {
        this.opisDela = opisDela;
    }

    public String getObrazlozenje() {
        return obrazlozenje;
    }

    public void setObrazlozenje(String obrazlozenje) {
        this.obrazlozenje = obrazlozenje;
    }

    public String getStanjePredmeta() {
        return stanjePredmeta;
    }

    public void setStanjePredmeta(String stanjePredmeta) {
        this.stanjePredmeta = stanjePredmeta;
    }

    public Tuzilac getTuzilac() {
        return tuzilac;
    }

    public void setTuzilac(Tuzilac tuzilac) {
        this.tuzilac = tuzilac;
    }

    @Override
    public String toString() {
        return delo;
    }

    @Override
    public String vratiNazivTabele() {
        return "predmet";
    }

    @Override
    public String vratiVrednostiZaInsert() {
        return null + ", '" + delo + "', '" + opisDela + "', '" + obrazlozenje + "', '" + stanjePredmeta + "', '" + tuzilac.getTuzilacID() + "'";
    }

    @Override
    public String vratiVrednostiZaUpdate() {
        return "delo = '" + delo + "', opisDela= '" + opisDela + "', obrazlozenje= '" + obrazlozenje + "', stanjePredmeta= '"
                + stanjePredmeta + "', tuzilacID= '"
                + tuzilac.getTuzilacID() + "' WHERE predmetID= '" + predmetID + "'";
    }

    @Override
    public String vratiUslovZaBrisanje() {
        return " predmetID= " + predmetID;
    }

    @Override
    public List<OpstiDomenskiObjekat> ucitaj(ResultSet rs) throws Exception {
        List<OpstiDomenskiObjekat> listaPredmeta = new LinkedList<>();
        while (rs.next()) {
            int predmetID = rs.getInt("predmetID");
            String delo = rs.getString("delo");
            String opisDela = rs.getString("opisDela");
            String obrazlozenje = rs.getString("obrazlozenje");
            String stanjePredmeta = rs.getString("stanjePredmeta");

            int tuzilacID = rs.getInt("tuzilacID");
            String imePrezimeTuzioca = rs.getString("imePrezime");
            boolean dostupan = (rs.getInt("dostupan") == 1) ? true : false;
            int brojPredmeta = rs.getInt("brojPredmeta");
            int radniStaz = rs.getInt("radniStaz");

            Tuzilac tuzilac = new Tuzilac(tuzilacID, imePrezimeTuzioca, dostupan, radniStaz, brojPredmeta);
            Predmet predmet = new Predmet(predmetID, delo, opisDela, obrazlozenje, stanjePredmeta, tuzilac);
            listaPredmeta.add(predmet);
        }
        return listaPredmeta;
    }

    @Override
    public String vratiUslovZaLogin() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiUslovZaSortiranje() {
        return " ORDER BY stanjePredmeta ASC";
    }

    @Override
    public String vratiVrednostiZaJoin() {
        return " JOIN tuzilac USING(tuzilacID)";
    }

    @Override
    public String vratiUslovZaProveru() {
        return "where predmetID= " + predmetID;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Aleksandar Randjelovic
 */
public class Mesto implements OpstiDomenskiObjekat {

    private int mestoID;
    private String naziv;
    private int ptt;

    public Mesto() {
    }

    public Mesto(int mestoID, String naziv, int ptt) {
        this.mestoID = mestoID;
        this.naziv = naziv;
        this.ptt = ptt;
    }

    public Mesto(String naziv, int ptt) {
        this.naziv = naziv;
        this.ptt = ptt;
    }

    public int getMestoID() {
        return mestoID;
    }

    public void setMestoID(int mestoID) {
        this.mestoID = mestoID;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public int getPtt() {
        return ptt;
    }

    public void setPtt(int ptt) {
        this.ptt = ptt;
    }

    @Override
    public String toString() {
        return naziv;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Mesto other = (Mesto) obj;
        if (this.mestoID != other.mestoID) {
            return false;
        }
        if (this.ptt != other.ptt) {
            return false;
        }
        if (!Objects.equals(this.naziv, other.naziv)) {
            return false;
        }
        return true;
    }

    @Override
    public String vratiNazivTabele() {
        return "mesto";
    }

    @Override
    public String vratiVrednostiZaInsert() {
        return null + ", '" + naziv + "', " + ptt;
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
        List<OpstiDomenskiObjekat> listaMesta = new LinkedList<>();
        while (rs.next()) {
            int ptt = rs.getInt("ptt");
            int mestoID = rs.getInt("mestoID");
            String naziv = rs.getString("naziv");
            Mesto m = new Mesto(mestoID, naziv, ptt);

            listaMesta.add(m);
        }
        return listaMesta;
    }

    @Override
    public String vratiUslovZaLogin() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiUslovZaSortiranje() {
        return " ORDER BY naziv ASC";
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

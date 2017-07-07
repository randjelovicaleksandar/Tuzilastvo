/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author Aleksandar Randjelovic
 */
public interface OpstiDomenskiObjekat extends Serializable {

    public String vratiNazivTabele();

    public String vratiVrednostiZaInsert();

    public String vratiVrednostiZaUpdate();

    public String vratiUslovZaBrisanje();

    public List<OpstiDomenskiObjekat> ucitaj(ResultSet rs) throws Exception;

    public String vratiUslovZaLogin();

    public String vratiUslovZaSortiranje();

    public String vratiVrednostiZaJoin();
    
    public String vratiUslovZaProveru();
}

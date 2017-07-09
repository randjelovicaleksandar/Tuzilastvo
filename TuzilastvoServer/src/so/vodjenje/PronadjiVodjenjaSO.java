/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.vodjenje;

import dbb.DBBroker;
import java.util.List;
import model.OpstiDomenskiObjekat;
import model.Vodjenje;
import so.OpstaSO;

/**
 *
 * @author Aleksandar Randjelovic
 */
public class PronadjiVodjenjaSO extends OpstaSO {
    
    private List<OpstiDomenskiObjekat> listaVodjenja;

    public List<OpstiDomenskiObjekat> getListaVodjenja() {
        return listaVodjenja;
    }

    public void setListaVodjenja(List<OpstiDomenskiObjekat> listaVodjenja) {
        this.listaVodjenja = listaVodjenja;
    }

    @Override
    protected void proveriPreduslov(Object obj) throws Exception {
    }

    @Override
    protected void izvrsiKonkretnuOperaciju(Object obj) throws Exception {
        listaVodjenja = DBBroker.getInstance().vratiSveJoin((Vodjenje) obj);
    }
    
}

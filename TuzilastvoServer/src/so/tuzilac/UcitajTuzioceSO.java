/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.tuzilac;

import dbb.DBBroker;
import java.util.List;
import model.OpstiDomenskiObjekat;
import model.Tuzilac;
import so.OpstaSO;

/**
 *
 * @author Aleksandar Randjelovic
 */
public class UcitajTuzioceSO extends OpstaSO {

    private List<OpstiDomenskiObjekat> listaTuzioca;

    public List<OpstiDomenskiObjekat> getListaTuzioca() {
        return listaTuzioca;
    }

    public void setListaTuzioca(List<OpstiDomenskiObjekat> listaTuzioca) {
        this.listaTuzioca = listaTuzioca;
    }

    @Override
    protected void proveriPreduslov(Object obj) throws Exception {
    }

    @Override
    protected void izvrsiKonkretnuOperaciju(Object obj) throws Exception {
        listaTuzioca = DBBroker.getInstance().vratiSve((Tuzilac) obj);
    }

}

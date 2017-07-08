/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.predmet;

import dbb.DBBroker;
import java.util.List;
import model.OpstiDomenskiObjekat;
import model.Predmet;
import so.OpstaSO;

/**
 *
 * @author Aleksandar Randjelovic
 */
public class PronadjiPredmeteSO extends OpstaSO {

    private List<OpstiDomenskiObjekat> listaPredmeta;

    public List<OpstiDomenskiObjekat> getListaPredmeta() {
        return listaPredmeta;
    }

    public void setListaPredmeta(List<OpstiDomenskiObjekat> listaPredmeta) {
        this.listaPredmeta = listaPredmeta;
    }

    @Override
    protected void proveriPreduslov(Object obj) throws Exception {
    }

    @Override
    protected void izvrsiKonkretnuOperaciju(Object obj) throws Exception {
        listaPredmeta = DBBroker.getInstance().vratiSveJoin((Predmet) obj);
    }

}

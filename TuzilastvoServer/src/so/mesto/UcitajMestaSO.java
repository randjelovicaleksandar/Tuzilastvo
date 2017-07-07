/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.mesto;

import dbb.DBBroker;
import java.util.List;
import model.Mesto;
import model.OpstiDomenskiObjekat;
import so.OpstaSO;

/**
 *
 * @author  Aleksandar Randjelovic
 */
public class UcitajMestaSO extends OpstaSO {

    private List<OpstiDomenskiObjekat> listaMesta;

    @Override
    protected void proveriPreduslov(Object obj) throws Exception {
    }

    @Override
    protected void izvrsiKonkretnuOperaciju(Object obj) throws Exception {
        listaMesta = DBBroker.getInstance().vratiSve((Mesto) obj);
    }

    public List<OpstiDomenskiObjekat> getListaMesta() {
        return listaMesta;
    }

    public void setListaMesta(List<OpstiDomenskiObjekat> listaMesta) {
        this.listaMesta = listaMesta;
    }

}

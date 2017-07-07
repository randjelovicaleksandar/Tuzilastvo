/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.osumnjiceni;

import dbb.DBBroker;
import java.util.List;
import model.OpstiDomenskiObjekat;
import model.Osumnjiceni;
import so.OpstaSO;

/**
 *
 * @author Aleksandar Randjelovic
 */
public class UcitajOsumnjiceneSO extends OpstaSO {

    private List<OpstiDomenskiObjekat> listaOsumnjicenih;

    public List<OpstiDomenskiObjekat> getListaOsumnjicenih() {
        return listaOsumnjicenih;
    }

    public void setListaOsumnjicenih(List<OpstiDomenskiObjekat> listaOsumnjicenih) {
        this.listaOsumnjicenih = listaOsumnjicenih;
    }

    @Override
    protected void proveriPreduslov(Object obj) throws Exception {
    }

    @Override
    protected void izvrsiKonkretnuOperaciju(Object obj) throws Exception {
        listaOsumnjicenih = DBBroker.getInstance().vratiSveJoin((Osumnjiceni) obj);
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.zaposleni;

import dbb.DBBroker;
import model.Zaposleni;
import so.OpstaSO;

/**
 *
 * @author  Aleksandar Randjelovic
 */
public class PronadjiZaposlenogSO extends OpstaSO {

    private boolean rezultat;

    public boolean isRezultat() {
        return rezultat;
    }

    public void setRezultat(boolean rezultat) {
        this.rezultat = rezultat;
    }
    
    @Override
    protected void proveriPreduslov(Object obj) throws Exception {
    }

    @Override
    protected void izvrsiKonkretnuOperaciju(Object obj) throws Exception {
        rezultat = DBBroker.getInstance().logovanje((Zaposleni) obj);
    }
    
}

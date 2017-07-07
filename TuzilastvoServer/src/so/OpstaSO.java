/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import dbb.DBBroker;

/**
 *
 * @author  Aleksandar Randjelovic
 */
public abstract class OpstaSO {

    private void ucitajDriver() throws Exception {
        DBBroker.getInstance().ucitajDriver();
    }

    private void otvoriKonekciju() throws Exception {
        DBBroker.getInstance().otvoriKonekciju();
    }

    private void commitTransakcije() throws Exception {
        DBBroker.getInstance().commitTransakcije();
    }

    private void rollbackTransakcije() throws Exception {
        DBBroker.getInstance().rollbackTransakcije();
    }

    private void zatvoriKonekciju() throws Exception {
        DBBroker.getInstance().zatvoriKonekciju();
    }

    public final void izvrsenjeSO(Object obj) throws Exception {
        try {
            ucitajDriver();
            otvoriKonekciju();
            proveriPreduslov(obj);
            izvrsiKonkretnuOperaciju(obj);
            commitTransakcije();
        } catch (Exception ex) {
            rollbackTransakcije();
            throw ex;
        } finally {
            zatvoriKonekciju();
        }
    }

    protected abstract void proveriPreduslov(Object obj) throws Exception;

    protected abstract void izvrsiKonkretnuOperaciju(Object obj) throws Exception;
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.predmet;

import dbb.DBBroker;
import model.Predmet;
import so.OpstaSO;

/**
 *
 * @author Aleksandar Randjelovic
 */
public class DodeliPredmetSO extends OpstaSO {

    @Override
    protected void proveriPreduslov(Object obj) throws Exception {
    }

    @Override
    protected void izvrsiKonkretnuOperaciju(Object obj) throws Exception {
        DBBroker.getInstance().izmeni((Predmet) obj);
    }

}

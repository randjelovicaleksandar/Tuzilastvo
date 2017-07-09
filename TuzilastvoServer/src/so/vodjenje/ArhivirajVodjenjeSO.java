/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.vodjenje;

import dbb.DBBroker;
import model.Vodjenje;
import so.OpstaSO;

/**
 *
 * @author Aleksandar Randjelovic
 */
public class ArhivirajVodjenjeSO extends OpstaSO {

    @Override
    protected void proveriPreduslov(Object obj) throws Exception {
        DBBroker.getInstance().proveriUslov((Vodjenje) obj);
    }

    @Override
    protected void izvrsiKonkretnuOperaciju(Object obj) throws Exception {
        DBBroker.getInstance().obrisi((Vodjenje) obj);
    }

}

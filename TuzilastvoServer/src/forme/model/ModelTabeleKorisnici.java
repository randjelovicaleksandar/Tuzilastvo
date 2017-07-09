/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forme.model;

import java.util.LinkedList;
import javax.swing.table.AbstractTableModel;
import nit.KlijentNit;

/**
 *
 * @author Aleksandar Randjelovic
 */
public class ModelTabeleKorisnici extends AbstractTableModel {

    private LinkedList<KlijentNit> listaKlijentskihNiti;
    String[] kolone = {"Korisnicko ime", "Lozinka"};

    public ModelTabeleKorisnici() {
        listaKlijentskihNiti = new LinkedList<>();
    }

    public ModelTabeleKorisnici(LinkedList<KlijentNit> listaKlijentskihNiti) {
        this.listaKlijentskihNiti = listaKlijentskihNiti;
    }

    @Override
    public int getRowCount() {
        return listaKlijentskihNiti.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        KlijentNit klijentNit = listaKlijentskihNiti.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return klijentNit.getKorisnik().getKorisnickoIme();
            case 1:
                return klijentNit.getKorisnik().getSifra();
            default:
                return "n/a";
        }
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }

    public void dodajRed(KlijentNit klijentskaNit) {
        listaKlijentskihNiti.add(klijentskaNit);
        fireTableDataChanged();
    }

    public void obrisiRed(KlijentNit klijentNit) {
        listaKlijentskihNiti.remove(klijentNit);
        fireTableDataChanged();
    }

    public void obrisiSveRedoveTabele() {
        int brojNiti = listaKlijentskihNiti.size();
        for (int i = 0; i < brojNiti; i++) {
            listaKlijentskihNiti.removeFirst();
            fireTableDataChanged();
        }
    }

}

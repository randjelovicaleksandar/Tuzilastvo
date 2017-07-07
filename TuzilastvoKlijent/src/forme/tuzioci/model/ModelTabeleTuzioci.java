/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forme.tuzioci.model;

import java.util.LinkedList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Tuzilac;

/**
 *
 * @author  Aleksandar Randjelovic
 */
public class ModelTabeleTuzioci extends AbstractTableModel {

    private List<Tuzilac> listaTuzilaca;
    private String[] kolone = {"ID", "Ime i prezime", "Radni staz", "Ukupan broj predmeta", "Dostupnost"};

    public ModelTabeleTuzioci() {
        listaTuzilaca = new LinkedList<>();
    }

    public ModelTabeleTuzioci(List<Tuzilac> listaTuzilaca) {
        this.listaTuzilaca = listaTuzilaca;
    }

    @Override
    public int getRowCount() {
        if (listaTuzilaca == null) {
            return 0;
        }
        return listaTuzilaca.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Tuzilac tuzilac = listaTuzilaca.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return tuzilac.getTuzilacID();
            case 1:
                return tuzilac.getImePrezime();
            case 2:
                return tuzilac.getRadniStaz();
            case 3:
                return tuzilac.getBrojPredmeta();
            case 4:
                if(tuzilac.isDostupan()) {
                    return "dostupan";
                } else {
                    return "nije dostupan";
                }
            default:
                return "n/a";
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forme.predmeti.model;

import forme.osumnjiceni.model.*;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Osumnjiceni;
import model.Predmet;

/**
 *
 * @author  Aleksandar Randjelovic
 */
public class ModelTabelePredmet extends AbstractTableModel {

    private List<Predmet> listaPredmeta;
    private String[] kolone = {"ID predmeta", "Delo", "Opis dela", "Obrazlozenje", "Stanje predmeta", "Tuzilac"};

    public ModelTabelePredmet() {
        listaPredmeta = new LinkedList<>();
    }

    public ModelTabelePredmet(List<Predmet> listaPredmeta) {
        this.listaPredmeta = listaPredmeta;
    }

    @Override
    public int getRowCount() {
        if (listaPredmeta == null) {
            return 0;
        }
        return listaPredmeta.size();
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
        Predmet predmet = listaPredmeta.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return predmet.getPredmetID();
            case 1:
                return predmet.getDelo();
            case 2:
                return predmet.getOpisDela();
            case 3:
                return predmet.getObrazlozenje();
            case 4:
                return predmet.getStanjePredmeta();
            case 5:
                return predmet.getTuzilac();
            default:
                return "n/a";
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    public Predmet vratiPredmet(int selectedRow) {
        return listaPredmeta.get(selectedRow);
    }

    public void obrisiRed(Predmet predmet) {
        listaPredmeta.remove(predmet);
        fireTableDataChanged();
    }

    public void izmeniRed(Predmet predmet) {
        for (Predmet predmetIzmeni : listaPredmeta) {
            if (predmetIzmeni.getPredmetID()== predmet.getPredmetID()) {
                predmetIzmeni.setDelo(predmet.getDelo());
                predmetIzmeni.setOpisDela(predmet.getOpisDela());
                predmetIzmeni.setObrazlozenje(predmet.getObrazlozenje());
                predmetIzmeni.setStanjePredmeta(predmet.getStanjePredmeta());
                predmetIzmeni.setTuzilac(predmet.getTuzilac());
                break;
            }
        }
        fireTableDataChanged();
    }

}

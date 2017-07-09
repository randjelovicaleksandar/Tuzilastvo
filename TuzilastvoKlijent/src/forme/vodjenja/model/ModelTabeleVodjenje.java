/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forme.vodjenja.model;

import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Vodjenje;

/**
 *
 * @author  Aleksandar Randjelovic
 */
public class ModelTabeleVodjenje extends AbstractTableModel {

    private List<Vodjenje> listaVodjenja;
    private String[] kolone = {"ID vodjenja", "Predmet", "Osumnjiceni", "Od", "Do", "Opis"};

    public ModelTabeleVodjenje() {
        listaVodjenja = new LinkedList<>();
    }

    public ModelTabeleVodjenje(List<Vodjenje> listaVodjenja) {
        this.listaVodjenja = listaVodjenja;
    }

    @Override
    public int getRowCount() {
        if (listaVodjenja == null) {
            return 0;
        }
        return listaVodjenja.size();
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
        Vodjenje vodjenje = listaVodjenja.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return vodjenje.getVodjenjeID();
            case 1:
                return vodjenje.getPredmet().getDelo();
            case 2:
                return vodjenje.getOsumnjiceni();
            case 3:
                return new SimpleDateFormat("dd-MM-yyyy").format(vodjenje.getDatumOd());
            case 4:
                return new SimpleDateFormat("dd-MM-yyyy").format(vodjenje.getDatumDo());
            case 5:
                return vodjenje.getOpis();
            default:
                return "n/a";
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    public Vodjenje vratiVodjenje(int selectedRow) {
        return listaVodjenja.get(selectedRow);
    }

    public void obrisiRed(Vodjenje vodjenje) {
        listaVodjenja.remove(vodjenje);
        fireTableDataChanged();
    }

    public void izmeniRed(Vodjenje vodjenje) {
        for (Vodjenje vodjenjeIzmeni : listaVodjenja) {
            if (vodjenjeIzmeni.getVodjenjeID() == vodjenje.getVodjenjeID()) {
                vodjenjeIzmeni.setPredmet(vodjenje.getPredmet());
                vodjenjeIzmeni.setOsumnjiceni(vodjenje.getOsumnjiceni());
                vodjenjeIzmeni.setDatumOd(vodjenje.getDatumOd());
                vodjenjeIzmeni.setDatumDo(vodjenje.getDatumDo());
                vodjenjeIzmeni.setOpis(vodjenje.getOpis());
                break;
            }
        }
        fireTableDataChanged();
    }

}

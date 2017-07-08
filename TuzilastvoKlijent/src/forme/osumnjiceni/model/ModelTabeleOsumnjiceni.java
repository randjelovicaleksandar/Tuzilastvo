/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forme.osumnjiceni.model;

import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Osumnjiceni;

/**
 *
 * @author  Aleksandar Randjelovic
 */
public class ModelTabeleOsumnjiceni extends AbstractTableModel {

    private List<Osumnjiceni> listaOsumnjicenih;
    private String[] kolone = {"Sifra", "Ime i prezime", "JMBG", "Datum rodjenja", "Adresa", "Zanimanje", "Osudjivanost", "Mesto"};

    public ModelTabeleOsumnjiceni() {
        listaOsumnjicenih = new LinkedList<>();
    }

    public ModelTabeleOsumnjiceni(List<Osumnjiceni> listaOsumnjicenih) {
        this.listaOsumnjicenih = listaOsumnjicenih;
    }

    @Override
    public int getRowCount() {
        if (listaOsumnjicenih == null) {
            return 0;
        }
        return listaOsumnjicenih.size();
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
        Osumnjiceni osumnjiceni = listaOsumnjicenih.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return osumnjiceni.getOsumnjiceniID();
            case 1:
                return osumnjiceni.getImePrezime();
            case 2:
                return osumnjiceni.getJMBG();
            case 3:
                return new SimpleDateFormat("dd-MM-yyyy").format(osumnjiceni.getDatumRodjenja());
            case 4:
                return osumnjiceni.getAdresa();
            case 5:
                return osumnjiceni.getZanimanje();
            case 6:
                if(osumnjiceni.isOsudjivanost()) {
                    return "osudjivan";
                } else {
                    return "nije osudjivan";
                }
            case 7:
                return osumnjiceni.getMesto();
            default:
                return "n/a";
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    public Osumnjiceni vratiOsumnjicenog(int selectedRow) {
        return listaOsumnjicenih.get(selectedRow);
    }

    public void obrisiRed(Osumnjiceni osumnjiceni) {
        listaOsumnjicenih.remove(osumnjiceni);
        fireTableDataChanged();
    }

    public void izmeniRed(Osumnjiceni osumnjiceni) {
        for (Osumnjiceni osumnjiceniIzmeni : listaOsumnjicenih) {
            if (osumnjiceniIzmeni.getOsumnjiceniID() == osumnjiceni.getOsumnjiceniID()) {
                osumnjiceniIzmeni.setImePrezime(osumnjiceni.getImePrezime());
                osumnjiceniIzmeni.setAdresa(osumnjiceni.getAdresa());
                osumnjiceniIzmeni.setOsudjivanost(osumnjiceni.isOsudjivanost());
                osumnjiceniIzmeni.setDatumRodjenja(osumnjiceni.getDatumRodjenja());
                osumnjiceniIzmeni.setJMBG(osumnjiceni.getJMBG());
                osumnjiceniIzmeni.setZanimanje(osumnjiceni.getZanimanje());
                osumnjiceniIzmeni.setMesto(osumnjiceni.getMesto());
                break;
            }
        }
        fireTableDataChanged();
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forme.predmeti;

import forme.GlavnaFormaKlijent;
import java.util.List;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import komunikacija.Komunikacija;
import model.Predmet;
import model.Tuzilac;
import transfer.TransferObjekatOdgovor;
import transfer.TransferObjekatZahtev;
import util.Operacija;
import util.OperacijaForme;
import validacija.Validacija;

/**
 *
 * @author Aleksandar Randjelovic
 */
public class FormaUnosPredmeta extends javax.swing.JFrame {

    private FormaPretragaPredmeta formaPretragaPredmeta;
    private GlavnaFormaKlijent glavnaFormaKlijent;
    private List<Predmet> listaPredmeta;
    boolean osudjivanost = false;
    ButtonGroup bg;
    private Predmet predmet;

    public FormaUnosPredmeta(boolean btnUnesi, boolean btnObrisi, boolean btnIzmeni, JFrame forma) {
        initComponents();
        formaPretragaPredmeta = (FormaPretragaPredmeta) forma;
        jbtnUnesi.setEnabled(btnUnesi);
        jbtnObrisi.setEnabled(btnObrisi);
        jbtnIzmeni.setEnabled(btnIzmeni);

        postaviKomponente();

    }

    public FormaUnosPredmeta(boolean btnUnesi, boolean btnObrisi, boolean btnIzmeni) {
        initComponents();
        jbtnUnesi.setEnabled(btnUnesi);
        jbtnObrisi.setEnabled(btnObrisi);
        jbtnIzmeni.setEnabled(btnIzmeni);

        postaviKomponente();

    }

    public FormaUnosPredmeta(FormaPretragaPredmeta formaPretragaPredmeta) {
        initComponents();
        postaviKomponente();
        this.formaPretragaPredmeta = formaPretragaPredmeta;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jtxtDelo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jtxtStanjePredmeta = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jcmbTuzilac = new javax.swing.JComboBox();
        jlblDelo = new javax.swing.JLabel();
        jlblStanjePredmeta = new javax.swing.JLabel();
        jlblOpisDela = new javax.swing.JLabel();
        jlblObrazlozenje = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextObrazlozenje = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextOpisDela = new javax.swing.JTextArea();
        jbtnUnesi = new javax.swing.JButton();
        jbtnObrisi = new javax.swing.JButton();
        jbtnIzmeni = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Unos predmeta");
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Detalji o predmetu", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 16))); // NOI18N
        jPanel1.setToolTipText("");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel1.setText("Delo:");

        jtxtDelo.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel2.setText("Opis dela:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel3.setText("Obrazlozenje:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel4.setText("Stanje predmeta:");

        jtxtStanjePredmeta.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel9.setText("Tuzilac:");

        jcmbTuzilac.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jcmbTuzilac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcmbTuzilacActionPerformed(evt);
            }
        });

        jlblDelo.setText(".");

        jlblStanjePredmeta.setText(".");

        jlblOpisDela.setText(".");

        jlblObrazlozenje.setText(".");

        jTextObrazlozenje.setColumns(20);
        jTextObrazlozenje.setRows(5);
        jScrollPane1.setViewportView(jTextObrazlozenje);

        jTextOpisDela.setColumns(20);
        jTextOpisDela.setRows(5);
        jScrollPane2.setViewportView(jTextOpisDela);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtxtStanjePredmeta, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jlblDelo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jlblOpisDela, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jtxtDelo, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jlblStanjePredmeta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jcmbTuzilac, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlblObrazlozenje, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtxtDelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlblDelo)
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlblOpisDela)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(88, 88, 88))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jlblObrazlozenje)
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jtxtStanjePredmeta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlblStanjePredmeta)
                .addGap(47, 47, 47)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jcmbTuzilac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        jbtnUnesi.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jbtnUnesi.setText("Unesi predmet");
        jbtnUnesi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnUnesiActionPerformed(evt);
            }
        });

        jbtnObrisi.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jbtnObrisi.setText("Obrisi predmet");
        jbtnObrisi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnObrisiActionPerformed(evt);
            }
        });

        jbtnIzmeni.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jbtnIzmeni.setText("Sacuvaj izmene");
        jbtnIzmeni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnIzmeniActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jbtnUnesi, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addComponent(jbtnObrisi, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(jbtnIzmeni, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtnUnesi, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnObrisi, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnIzmeni, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnUnesiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnUnesiActionPerformed
        String delo = jtxtDelo.getText();
        String opisDela = jTextOpisDela.getText();
        String obrazlozenje = jTextObrazlozenje.getText();
        String stanjePredmeta = jtxtStanjePredmeta.getText();

        Tuzilac t = (Tuzilac) jcmbTuzilac.getSelectedItem();

        TransferObjekatZahtev zahtev = new TransferObjekatZahtev();
        try {
            if (validateFields()) {
                Predmet predemt = new Predmet(delo, opisDela, obrazlozenje, stanjePredmeta, t);
                zahtev.setOperacija(Operacija.UNOS_PREDMETA);
                zahtev.setParametar(predemt);
                Komunikacija.getInstance().posaljiZahtev(zahtev);
                TransferObjekatOdgovor odgovor = Komunikacija.getInstance().primiOdgovor();
                if (odgovor.getIzuzetak() == null) {
                    JOptionPane.showMessageDialog(this, "Sistem je zapamtio predmet!");
                    this.dispose();
                } else {
                    throw (Exception) odgovor.getIzuzetak();
                }
            }
        } catch (Exception ex) {
//            JOptionPane.showMessageDialog(this, ex.getMessage());
            JOptionPane.showMessageDialog(this, "Sistem nije uspeo da zapamti predmet");
        }
    }//GEN-LAST:event_jbtnUnesiActionPerformed

    private void jbtnObrisiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnObrisiActionPerformed
        try {
            TransferObjekatZahtev zahtev = new TransferObjekatZahtev();
            zahtev.setOperacija(Operacija.BRISANJE_PREDMETA);
            zahtev.setParametar(predmet);
            Komunikacija.getInstance().posaljiZahtev(zahtev);
            TransferObjekatOdgovor odgovor = Komunikacija.getInstance().primiOdgovor();
            if (odgovor.getIzuzetak() == null) {
                JOptionPane.showMessageDialog(this, odgovor.getPoruka());
                formaPretragaPredmeta.obrisiRed(predmet);
                this.dispose();
            } else {
                throw (Exception) odgovor.getIzuzetak();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_jbtnObrisiActionPerformed

    private void jbtnIzmeniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnIzmeniActionPerformed
        try {
            TransferObjekatZahtev zahtev = new TransferObjekatZahtev();
            if (validateFields()) {
                zahtev.setOperacija(Operacija.IZMENA_PREDMETA);
                Predmet predmetIzmena = new Predmet(this.predmet.getPredmetID(), jtxtDelo.getText(), jTextOpisDela.getText(), jTextObrazlozenje.getText(), jtxtStanjePredmeta.getText(), (Tuzilac) jcmbTuzilac.getSelectedItem());
                zahtev.setParametar(predmetIzmena);
                Komunikacija.getInstance().posaljiZahtev(zahtev);
                TransferObjekatOdgovor odgovor = Komunikacija.getInstance().primiOdgovor();
                if (odgovor.getIzuzetak() == null) {
                    JOptionPane.showMessageDialog(this, odgovor.getPoruka());
                    formaPretragaPredmeta.izmeniRed(predmetIzmena);
                    this.dispose();
                } else {
                    throw (Exception) odgovor.getIzuzetak();
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_jbtnIzmeniActionPerformed

    private void jcmbTuzilacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcmbTuzilacActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcmbTuzilacActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextObrazlozenje;
    private javax.swing.JTextArea jTextOpisDela;
    private javax.swing.JButton jbtnIzmeni;
    private javax.swing.JButton jbtnObrisi;
    private javax.swing.JButton jbtnUnesi;
    private javax.swing.JComboBox jcmbTuzilac;
    private javax.swing.JLabel jlblDelo;
    private javax.swing.JLabel jlblObrazlozenje;
    private javax.swing.JLabel jlblOpisDela;
    private javax.swing.JLabel jlblStanjePredmeta;
    private javax.swing.JTextField jtxtDelo;
    private javax.swing.JTextField jtxtStanjePredmeta;
    // End of variables declaration//GEN-END:variables

    private void postaviKomponente() {
        setLocationRelativeTo(null);
        this.setTitle("Unos predmet");
        this.repaint();
        this.pack();
        ucitajComboBox();
        podesiLabele(false);
    }

    void postaviIzgledForme(int operacijaForme) {
        if (operacijaForme == OperacijaForme.UPRAVLJANJE) {
            this.setTitle("Izmena/brisanje predmeta");
            jbtnUnesi.setVisible(false);
            jbtnIzmeni.setVisible(true);
            jbtnObrisi.setVisible(true);
            this.repaint();
            this.pack();
        }
    }

    void postaviPodatkeOPredemtu(Predmet predmet) {
        this.predmet = predmet;
        jtxtDelo.setText(predmet.getDelo());
        jTextOpisDela.setText(predmet.getOpisDela());
        jTextObrazlozenje.setText(predmet.getObrazlozenje());
        jtxtStanjePredmeta.setText(predmet.getStanjePredmeta());
        jcmbTuzilac.getModel().setSelectedItem(predmet.getTuzilac());
    }

    public boolean validateFields() {

        podesiLabele(true);
        podesiVrednostLabela("");

        if (!Validacija.validateField(jtxtDelo, jlblDelo, "Unesite polje za delo")) {
            return false;
        } else if (!Validacija.validateTextAreaField(jTextOpisDela, jlblOpisDela, "Unesite polje za opis dela")) {
            return false;
        } else if (!Validacija.validateField(jtxtStanjePredmeta, jlblStanjePredmeta, "Unesite polje za stanje predmeta")) {
            return false;
        } else if (!Validacija.validateField(jTextObrazlozenje, jlblObrazlozenje, "Unesite polje za obrazlozenje")) {
            return false;
        } else {
            return true;
        }
    }

    public void ucitajComboBox() {
        try {
            jcmbTuzilac.removeAllItems();

            TransferObjekatZahtev zahtev = new TransferObjekatZahtev();
            zahtev.setOperacija(Operacija.VRATI_TUZIOCE);
            Komunikacija.getInstance().posaljiZahtev(zahtev);
            TransferObjekatOdgovor odgovor = Komunikacija.getInstance().primiOdgovor();
            if (odgovor.getIzuzetak() != null) {
                throw (Exception) odgovor.getIzuzetak();
            }
            List<Tuzilac> listaTuzilaca = (List<Tuzilac>) odgovor.getRezultat();

            for (Tuzilac tuzilac : listaTuzilaca) {
                jcmbTuzilac.addItem(tuzilac);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Server je ugasen. Gasenje klijenta!");
            System.exit(0);
        }
    }

    private void podesiLabele(boolean bool) {
        jlblDelo.setVisible(bool);
        jlblDelo.revalidate();

        jlblOpisDela.setVisible(bool);
        jlblOpisDela.revalidate();

        jlblObrazlozenje.setVisible(bool);
        jlblObrazlozenje.revalidate();

        jlblStanjePredmeta.setVisible(bool);
        jlblStanjePredmeta.revalidate();

        this.pack();
        this.repaint();
    }

    private void podesiVrednostLabela(String string) {
        jlblDelo.setText(string);
        jlblOpisDela.setText(string);
        jlblObrazlozenje.setText(string);
        jlblStanjePredmeta.setText(string);

        this.pack();
        this.repaint();
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forme.predmeti;


import forme.predmeti.model.ModelTabelePredmet;
import java.util.LinkedList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import komunikacija.Komunikacija;
import model.Predmet;
import transfer.TransferObjekatOdgovor;
import transfer.TransferObjekatZahtev;
import util.Operacija;

/**
 *
 * @author  Aleksandar Randjelovic
 */
public class FormaPretragaPredmeta extends javax.swing.JFrame {

    private List<Predmet> listaPredmeta;
    private String[] poljaZaPretragu = {"Delo", "Stanje predmeta", "Tuzilac"};

    public FormaPretragaPredmeta() {
        initComponents();
        setLocationRelativeTo(null);
        postaviKomponente();
        postaviTabelu();
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
        jcmbKriterijumPretrage = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jtxtVredenostPretrage = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtabelaPredmeti = new javax.swing.JTable();
        jbtnPretragaPredmeta = new javax.swing.JButton();
        jbtnPrikaziPodatke = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Pretraga predmeta");
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Detalji pretrage predmeta", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 16))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel1.setText("Kriterijum pretrage:");

        jcmbKriterijumPretrage.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jcmbKriterijumPretrage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcmbKriterijumPretrageActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel2.setText("Vrednost pretrage:");

        jtxtVredenostPretrage.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(49, 49, 49)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jtxtVredenostPretrage)
                    .addComponent(jcmbKriterijumPretrage, 0, 201, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jcmbKriterijumPretrage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtxtVredenostPretrage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jtabelaPredmeti.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jtabelaPredmeti.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtabelaPredmetiMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtabelaPredmeti);

        jbtnPretragaPredmeta.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jbtnPretragaPredmeta.setText("Pretraga predmeta");
        jbtnPretragaPredmeta.setToolTipText("");
        jbtnPretragaPredmeta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnPretragaPredmetaActionPerformed(evt);
            }
        });

        jbtnPrikaziPodatke.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jbtnPrikaziPodatke.setText("Detaljni podaci o predmetu");
        jbtnPrikaziPodatke.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnPrikaziPodatkeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 754, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jbtnPrikaziPodatke, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbtnPretragaPredmeta, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbtnPrikaziPodatke, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnPretragaPredmeta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnPrikaziPodatkeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnPrikaziPodatkeActionPerformed
        
        int selectedRow = jtabelaPredmeti.getSelectedRow();
        ModelTabelePredmet model = (ModelTabelePredmet) jtabelaPredmeti.getModel();
        Predmet predemt = model.vratiPredmet(selectedRow);
        FormaUnosPredmeta fup = new FormaUnosPredmeta(false,true,true,this);
        fup.postaviPodatkeOPredemtu(predemt);
        fup.setVisible(true);
    }//GEN-LAST:event_jbtnPrikaziPodatkeActionPerformed

    private void jtabelaPredmetiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtabelaPredmetiMouseClicked
        jbtnPrikaziPodatke.setEnabled(true);
    }//GEN-LAST:event_jtabelaPredmetiMouseClicked

    private void jbtnPretragaPredmetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnPretragaPredmetaActionPerformed
        String vrednostPretrage = jtxtVredenostPretrage.getText().toLowerCase().trim();
        String poljeZaPretragu = (String) jcmbKriterijumPretrage.getSelectedItem();

        List<Predmet> filtriranaListaPredmeta = new LinkedList<>();
        if (vrednostPretrage.equals("")) {
            filtriranaListaPredmeta = listaPredmeta;
            JOptionPane.showMessageDialog(this, "Unesite vrednost pretrage.");
        } else {
            switch (poljeZaPretragu) {
                case "Delo":
                    for (Predmet predmet : listaPredmeta) {
                        if (predmet.getDelo().toLowerCase().equals(vrednostPretrage)) {
                            filtriranaListaPredmeta.add(predmet);
                        }
                    }
                    break;
                case "Stanje predmeta":
                    for (Predmet predmet : listaPredmeta) {
                        if (predmet.getStanjePredmeta().toLowerCase().equals(vrednostPretrage)) {
                            filtriranaListaPredmeta.add(predmet);
                        }
                    }
                    break;
                case "Tuzilac":
                    for (Predmet predmet : listaPredmeta) {
                        if (predmet.getTuzilac().toString().toLowerCase().contains(vrednostPretrage)) {
                            filtriranaListaPredmeta.add(predmet);
                        }
                    }
                    break;
                default:
                    filtriranaListaPredmeta = listaPredmeta;
            }
        }
        if(filtriranaListaPredmeta.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Sistem ne moze da nadje predmet po zadatoj vrednosti");
            return;
        }
        ModelTabelePredmet model = new ModelTabelePredmet(filtriranaListaPredmeta);
        jtabelaPredmeti.setModel(model);
    }//GEN-LAST:event_jbtnPretragaPredmetaActionPerformed

    private void jcmbKriterijumPretrageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcmbKriterijumPretrageActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcmbKriterijumPretrageActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtnPretragaPredmeta;
    private javax.swing.JButton jbtnPrikaziPodatke;
    private javax.swing.JComboBox jcmbKriterijumPretrage;
    private javax.swing.JTable jtabelaPredmeti;
    private javax.swing.JTextField jtxtVredenostPretrage;
    // End of variables declaration//GEN-END:variables

    private void postaviKomponente() {
        jbtnPrikaziPodatke.setEnabled(false);

        jcmbKriterijumPretrage.removeAllItems();
        jcmbKriterijumPretrage.setModel(new DefaultComboBoxModel(poljaZaPretragu));
    }

    private void postaviTabelu() {
        try {
            TransferObjekatZahtev zahtev = new TransferObjekatZahtev();
            zahtev.setOperacija(Operacija.VRATI_PREDMETE);
            Komunikacija.getInstance().posaljiZahtev(zahtev);
            TransferObjekatOdgovor odgovor = Komunikacija.getInstance().primiOdgovor();
            if (odgovor.getIzuzetak() != null) {
                JOptionPane.showMessageDialog(this, (String) odgovor.getIzuzetak());
                return;
            }
            listaPredmeta = (List<Predmet>) odgovor.getRezultat();
            ModelTabelePredmet modelTabele = new ModelTabelePredmet(listaPredmeta);
            jtabelaPredmeti.setModel(modelTabele);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Server je ugasen. Gasenje klijenta!");
            System.exit(0);
        }
    }

    void obrisiRed(Predmet predmet) {
        jbtnPrikaziPodatke.setEnabled(false);
        ModelTabelePredmet model = (ModelTabelePredmet) jtabelaPredmeti.getModel();
        model.obrisiRed(predmet);
    }

    void izmeniRed(Predmet predmet) {
        jbtnPrikaziPodatke.setEnabled(false);
        ModelTabelePredmet model = (ModelTabelePredmet) jtabelaPredmeti.getModel();
        model.izmeniRed(predmet);
    }
}

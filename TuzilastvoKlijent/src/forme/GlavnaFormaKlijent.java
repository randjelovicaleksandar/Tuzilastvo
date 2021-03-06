/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forme;

import forme.login.LoginForma;
import forme.osumnjiceni.FormaPretragaOsumnjicenih;
import forme.osumnjiceni.FormaUnosOsumnjicenog;
import forme.predmeti.FormaPretragaPredmeta;
import forme.predmeti.FormaUnosPredmeta;
import forme.tuzioci.FormaPretragaTuzilaca;
import forme.vodjenja.FormaPretragaVodjenja;
import forme.vodjenja.FormaUnosVodjenja;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import komunikacija.Komunikacija;
import transfer.TransferObjekatOdgovor;
import transfer.TransferObjekatZahtev;
import util.Operacija;

/**
 *
 * @author Aleksandar Randjelovic
 */
public class GlavnaFormaKlijent extends javax.swing.JFrame {

    private FormaUnosOsumnjicenog fuo;
    private FormaPretragaOsumnjicenih fpo;
    private FormaPretragaTuzilaca fpt;
    private FormaUnosPredmeta fup;
    private FormaPretragaPredmeta fpp;
    private FormaPretragaVodjenja fpv;
    private FormaUnosVodjenja fuv;
    private String userName;

    /**
     * Creates new form GlavnaForma
     */
    public GlavnaFormaKlijent() {
        initComponents();
        setLocationRelativeTo(null);
    }

    public GlavnaFormaKlijent(String userName) {
        initComponents();
        setLocationRelativeTo(null);
        this.userName = userName;
        jlbluserName.setText(userName);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we) {
                logout();
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jbtnLogout = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jlbluserName = new javax.swing.JLabel();
        btnVodjenje = new javax.swing.JButton();
        btnUnosVodjenja = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Vodjenje predmeta");

        jbtnLogout.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jbtnLogout.setText("Logout");
        jbtnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnLogoutActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Ulogovani ste kao:");

        jlbluserName.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jlbluserName.setForeground(new java.awt.Color(0, 204, 0));
        jlbluserName.setText("userName");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlbluserName, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jlbluserName)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        btnVodjenje.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        btnVodjenje.setText("Vodjenje predmeta");
        btnVodjenje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVodjenjeActionPerformed(evt);
            }
        });

        btnUnosVodjenja.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        btnUnosVodjenja.setText("Unos vodjenja");
        btnUnosVodjenja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUnosVodjenjaActionPerformed(evt);
            }
        });

        jMenuBar1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        jMenu1.setText("Osumnjiceni");
        jMenu1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jMenu1.setMargin(new java.awt.Insets(0, 5, 0, 5));

        jMenuItem2.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jMenuItem2.setText("Pretraga osumnjicenih");
        jMenuItem2.setActionCommand("Pretraga osumnjicenih");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);
        jMenuItem2.getAccessibleContext().setAccessibleName("Pretraga osumnjicenih");

        jMenuItem1.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jMenuItem1.setText("Unos osumnjicenog");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Predmeti");
        jMenu2.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jMenu2.setMargin(new java.awt.Insets(0, 5, 0, 5));

        jMenuItem3.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jMenuItem3.setText("Unos predmeta");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem3);

        jMenuItem4.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jMenuItem4.setText("Pretraga predmeta");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem4);

        jMenuBar1.add(jMenu2);

        jMenu5.setText("Tuzioci");
        jMenu5.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jMenu5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu5ActionPerformed(evt);
            }
        });

        jMenuItem5.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jMenuItem5.setText("Pretraga tuzilaca");
        jMenuItem5.setToolTipText("");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem5);

        jMenuBar1.add(jMenu5);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnVodjenje, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbtnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(btnUnosVodjenja, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnVodjenje, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
                    .addComponent(btnUnosVodjenja, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        fuo = new FormaUnosOsumnjicenog(true, false, false);
        fuo.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        fup = new FormaUnosPredmeta(true, false, false);
        fup.setVisible(true);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        fpp = new FormaPretragaPredmeta();
        fpp.setVisible(true);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jbtnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnLogoutActionPerformed
        logout();
    }//GEN-LAST:event_jbtnLogoutActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        fpo = new FormaPretragaOsumnjicenih();
        fpo.setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenu5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu5ActionPerformed
    }//GEN-LAST:event_jMenu5ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        fpt = new FormaPretragaTuzilaca();
        fpt.setVisible(true);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void btnVodjenjeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVodjenjeActionPerformed
        fpv = new FormaPretragaVodjenja();
        fpv.setVisible(true);
    }//GEN-LAST:event_btnVodjenjeActionPerformed

    private void btnUnosVodjenjaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUnosVodjenjaActionPerformed
        fuv = new FormaUnosVodjenja(true, false, false);
        fuv.setVisible(true);
    }//GEN-LAST:event_btnUnosVodjenjaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnUnosVodjenja;
    private javax.swing.JButton btnVodjenje;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jbtnLogout;
    private javax.swing.JLabel jlbluserName;
    // End of variables declaration//GEN-END:variables

    private void logout() {
        int action = JOptionPane.showConfirmDialog(GlavnaFormaKlijent.this,
                "Da li zelite da se izlogujete i napustite program?",
                "Napustanje programa", JOptionPane.OK_CANCEL_OPTION);

        if (action == JOptionPane.OK_OPTION) {
            try {
                TransferObjekatZahtev zahtev = new TransferObjekatZahtev();
                zahtev.setOperacija(Operacija.KRAJ);
                Komunikacija.getInstance().posaljiZahtev(zahtev);
                TransferObjekatOdgovor odgovor = Komunikacija.getInstance().primiOdgovor();
                JOptionPane.showMessageDialog(this, odgovor.getPoruka());
                this.dispose();
                LoginForma loginForma = new LoginForma();
                loginForma.setVisible(true);
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(GlavnaFormaKlijent.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        }
    }

    public void ugasiFormu(String poruka) {
        JOptionPane.showMessageDialog(this, poruka);
        this.dispose();
        LoginForma loginForma = new LoginForma();
        loginForma.setVisible(true);
    }

}

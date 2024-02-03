package gui;

import javax.swing.JOptionPane;
import logica.Jugar;
import logica.Partida;
import persistencia.Conectar;

/**
 *
 * @author USUARIO
 */
public class HomeGame extends javax.swing.JFrame {

    /**
     * Creates new form HomeGame
     */
    Conectar conectar;
    public HomeGame() {
        initComponents();
    }                                                                                                                                                            
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        partidaRapida = new javax.swing.JButton();
        personalizeGame = new javax.swing.JButton();
        salir = new javax.swing.JButton();
        verListaJugadores = new javax.swing.JButton();
        cargarUltimaPartida = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        registar1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        partidaRapida.setBackground(new java.awt.Color(200, 150, 41));
        partidaRapida.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        partidaRapida.setForeground(new java.awt.Color(0, 0, 0));
        partidaRapida.setText("Partida Rápida");
        partidaRapida.setBorder(new javax.swing.border.MatteBorder(null));
        partidaRapida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                partidaRapidaActionPerformed(evt);
            }
        });

        personalizeGame.setBackground(new java.awt.Color(200, 150, 41));
        personalizeGame.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        personalizeGame.setForeground(new java.awt.Color(0, 0, 0));
        personalizeGame.setText("Partida Personalizada");
        personalizeGame.setBorder(new javax.swing.border.MatteBorder(null));
        personalizeGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                personalizeGameActionPerformed(evt);
            }
        });

        salir.setBackground(new java.awt.Color(200, 150, 41));
        salir.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        salir.setForeground(new java.awt.Color(0, 0, 0));
        salir.setText("Salir del juego");
        salir.setBorder(new javax.swing.border.MatteBorder(null));
        salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirActionPerformed(evt);
            }
        });

        verListaJugadores.setBackground(new java.awt.Color(200, 150, 41));
        verListaJugadores.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        verListaJugadores.setForeground(new java.awt.Color(0, 0, 0));
        verListaJugadores.setText("Ver lista de jugadores");
        verListaJugadores.setBorder(new javax.swing.border.MatteBorder(null));
        verListaJugadores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verListaJugadoresActionPerformed(evt);
            }
        });

        cargarUltimaPartida.setBackground(new java.awt.Color(200, 150, 41));
        cargarUltimaPartida.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        cargarUltimaPartida.setForeground(new java.awt.Color(0, 0, 0));
        cargarUltimaPartida.setText("Cargar última partida");
        cargarUltimaPartida.setBorder(new javax.swing.border.MatteBorder(null));
        cargarUltimaPartida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cargarUltimaPartidaActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/thane.jpg"))); // NOI18N

        registar1.setBackground(new java.awt.Color(200, 150, 41));
        registar1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        registar1.setForeground(new java.awt.Color(0, 0, 0));
        registar1.setText("Registrar Retadores");
        registar1.setBorder(new javax.swing.border.MatteBorder(null));
        registar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registar1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(126, 126, 126)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(partidaRapida, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(personalizeGame, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(verListaJugadores, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(salir, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cargarUltimaPartida, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(registar1, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 111, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 563, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(partidaRapida, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(personalizeGame, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(cargarUltimaPartida, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(registar1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(verListaJugadores, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(salir, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 531, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void partidaRapidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_partidaRapidaActionPerformed
        // TODO add your handling code here:
        QuickGameWindows quick = new QuickGameWindows(null, null);
        quick.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_partidaRapidaActionPerformed

    private void personalizeGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_personalizeGameActionPerformed
        PersonalizeGame juegoPersonalizado = new PersonalizeGame();
        juegoPersonalizado.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_personalizeGameActionPerformed

    private void salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_salirActionPerformed

    private void verListaJugadoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verListaJugadoresActionPerformed
        // TODO add your handling code here:
        conectar = Conectar.obtenerInstancia();
        conectar.mostrarTablaJugadores();
    }//GEN-LAST:event_verListaJugadoresActionPerformed

    private void cargarUltimaPartidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cargarUltimaPartidaActionPerformed
        // TODO add your handling code here:
        Jugar juego;
        Partida partida;
        conectar = Conectar.obtenerInstancia();
        
        partida = conectar.obtenerUltima();
        
        juego = new Jugar(partida);
        juego.game();
        this.dispose();
    }//GEN-LAST:event_cargarUltimaPartidaActionPerformed

    private void registar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registar1ActionPerformed
        // TODO add your handling code here:
        Login login = new Login();
        login.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_registar1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(HomeGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HomeGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HomeGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomeGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HomeGame().setVisible(true);
            }
        });
        
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cargarUltimaPartida;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton partidaRapida;
    private javax.swing.JButton personalizeGame;
    private javax.swing.JButton registar1;
    private javax.swing.JButton salir;
    private javax.swing.JButton verListaJugadores;
    // End of variables declaration//GEN-END:variables
    
}

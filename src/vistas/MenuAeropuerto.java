/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

/**
 *
 * @author majuetcheverry
 */
public class MenuAeropuerto extends javax.swing.JDialog {

    /**
     * Creates new form MenuAeropuerto
     */
    public MenuAeropuerto(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
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

        lblNombre = new javax.swing.JLabel();
        lblAeropuerto = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstFrecuenciasPendientes = new javax.swing.JList<>();
        btnAprobar = new javax.swing.JButton();
        lblAprobarRechazarFrecuencia = new javax.swing.JLabel();
        btnRechazar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstFrecuenciasPendientes1 = new javax.swing.JList<>();
        btnAprobar1 = new javax.swing.JButton();
        btnRechazar1 = new javax.swing.JButton();
        lblAeropuertoDestino = new javax.swing.JLabel();
        lblAeropuertoOrigen = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        lstVuelosDiariosPartidas = new javax.swing.JList<>();
        btnIngresarPartida = new javax.swing.JButton();
        lblPartidas = new javax.swing.JLabel();
        lblArribos = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        lstVuelosDiariosArribos = new javax.swing.JList<>();
        btnIngresarArribo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblNombre.setText("Nombre");

        lblAeropuerto.setText("Aeropuerto");

        jScrollPane1.setViewportView(lstFrecuenciasPendientes);

        btnAprobar.setText("Aprobar");
        btnAprobar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAprobarActionPerformed(evt);
            }
        });

        lblAprobarRechazarFrecuencia.setText("Aprobar / Rechazar Frecuencia ");

        btnRechazar.setText("Rechazar");

        jScrollPane2.setViewportView(lstFrecuenciasPendientes1);

        btnAprobar1.setText("Aprobar");
        btnAprobar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAprobar1ActionPerformed(evt);
            }
        });

        btnRechazar1.setText("Rechazar");

        lblAeropuertoDestino.setText("Aeropuerto Destino");

        lblAeropuertoOrigen.setText("Aeropuerto Origen");

        jLabel1.setText("Lista de vuelos ");

        jScrollPane3.setViewportView(lstVuelosDiariosPartidas);

        btnIngresarPartida.setText("Partio");

        lblPartidas.setText("Partidas");

        lblArribos.setText("Arribos");

        jScrollPane5.setViewportView(lstVuelosDiariosArribos);

        btnIngresarArribo.setText("Llego");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnIngresarPartida)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblNombre)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblAeropuerto)
                        .addGap(24, 24, 24))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jScrollPane1)
                                .addGap(8, 8, 8))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnAprobar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnRechazar)))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane3)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblAprobarRechazarFrecuencia)
                            .addComponent(lblAeropuertoOrigen)
                            .addComponent(jLabel1)
                            .addComponent(lblPartidas)
                            .addComponent(lblArribos))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane5)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnIngresarArribo))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 386, Short.MAX_VALUE)
                                .addGap(8, 8, 8))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnAprobar1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnRechazar1))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(lblAeropuertoDestino)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 192, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre)
                    .addComponent(lblAeropuerto))
                .addGap(18, 18, 18)
                .addComponent(lblAprobarRechazarFrecuencia, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblAeropuertoOrigen)
                .addGap(7, 7, 7)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAprobar)
                    .addComponent(btnRechazar))
                .addGap(18, 18, 18)
                .addComponent(lblAeropuertoDestino)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAprobar1)
                    .addComponent(btnRechazar1))
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(20, 20, 20)
                .addComponent(lblPartidas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnIngresarPartida)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblArribos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnIngresarArribo)
                .addContainerGap(116, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAprobarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAprobarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAprobarActionPerformed

    private void btnAprobar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAprobar1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAprobar1ActionPerformed

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
            java.util.logging.Logger.getLogger(MenuAeropuerto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuAeropuerto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuAeropuerto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuAeropuerto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                MenuAeropuerto dialog = new MenuAeropuerto(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAprobar;
    private javax.swing.JButton btnAprobar1;
    private javax.swing.JButton btnIngresarArribo;
    private javax.swing.JButton btnIngresarPartida;
    private javax.swing.JButton btnRechazar;
    private javax.swing.JButton btnRechazar1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JLabel lblAeropuerto;
    private javax.swing.JLabel lblAeropuertoDestino;
    private javax.swing.JLabel lblAeropuertoOrigen;
    private javax.swing.JLabel lblAprobarRechazarFrecuencia;
    private javax.swing.JLabel lblArribos;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblPartidas;
    private javax.swing.JList<String> lstFrecuenciasPendientes;
    private javax.swing.JList<String> lstFrecuenciasPendientes1;
    private javax.swing.JList<String> lstVuelosDiariosArribos;
    private javax.swing.JList<String> lstVuelosDiariosPartidas;
    // End of variables declaration//GEN-END:variables
}

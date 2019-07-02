/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import controladores.ControladorLogin;
import controladores.IVistaLogIn;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import modelo.Usuario;
import utilities.ExceptionLogin;

/**
 *
 * @author majuetcheverry
 */
public class Login extends javax.swing.JDialog implements IVistaLogIn {

    public Login(java.awt.Frame parent, boolean modal, TipoVentanaEnum tipoProxVentana) {
        super(parent, modal);
        initComponents();
        this.tipoProxVentana = tipoProxVentana;
        this.parent = parent;
        controlador = new ControladorLogin(this);
    }
    //TODO COMO SOLUCIONAR EL USO DE tipoVentanaEnum EN LA VERSION WEB DE LA APLICACION

    @Override
    public void ingresar(Usuario u) {
        if (u == null) {
            JOptionPane.showMessageDialog(parent, this);
        } else {
            JDialog proxDialogo;
            switch (tipoProxVentana) {
                case Compania:
                    proxDialogo = new AplicacionCompania(parent, false, u);
                    break;
                case Aeropuerto:
                    proxDialogo = new AplicacionAeropuerto(parent, false, u);
                    break;
                case Monitoreo:
                    proxDialogo = new AplicacionMonitoreo(parent, false, u);
                    break;
                default:
                    proxDialogo = null;
            }
            dispose();
            proxDialogo.setVisible(true);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblNombre = new javax.swing.JLabel();
        lblPass = new javax.swing.JLabel();
        bntLogin = new javax.swing.JToggleButton();
        txtUsuario = new javax.swing.JTextField();
        txtPass = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        lblError = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblNombre.setText("Nombre");

        lblPass.setText("Password");

        bntLogin.setText("Ingresar");
        bntLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntLoginActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel1.setText("INICIAR SESION");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(bntLogin)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblNombre)
                                        .addComponent(lblPass))
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtPass, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
                                        .addComponent(txtUsuario))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(135, 135, 135)
                        .addComponent(lblError)))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPass)
                    .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bntLogin)
                .addGap(18, 18, 18)
                .addComponent(lblError)
                .addContainerGap(47, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bntLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntLoginActionPerformed
        String pass = String.valueOf(txtPass.getPassword());
        try {
            controlador.autenticar(txtUsuario.getText(), pass, this.tipoProxVentana);
        } catch (ExceptionLogin x) {
            lblError.setText(x.getMessage());
        }

    }//GEN-LAST:event_bntLoginActionPerformed

    public ControladorLogin controlador;
    private TipoVentanaEnum tipoProxVentana;
    private java.awt.Frame parent;


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton bntLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblError;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblPass;
    private javax.swing.JPasswordField txtPass;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}

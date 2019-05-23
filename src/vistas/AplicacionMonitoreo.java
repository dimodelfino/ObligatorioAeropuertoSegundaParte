/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import controladores.ControladoraMonitoreo;
import controladores.IVistaAeropuerto;
import modelo.UsuAeropuerto;
import modelo.Usuario;

/**
 *
 * @author majuetcheverry
 */
public class AplicacionMonitoreo extends javax.swing.JDialog implements IVistaAeropuerto{

    /**
     * Creates new form AplicacionMonitoreo
     */
    public AplicacionMonitoreo(java.awt.Frame parent, boolean modal, Usuario u) {
        super(parent, modal);
        initComponents();
        this.controlador = new ControladoraMonitoreo(this);                        
        ua = (UsuAeropuerto) u; 
        actualizarListas();
    }    
    
     @Override
    public void actualizarListas() {
        lstPartidas.setListData(controlador.getVuelosPorAeropuertoMonitoreo(ua.aeropuerto.nombre, "Origen").toArray());
        lstArribos.setListData(controlador.getVuelosPorAeropuertoMonitoreo(ua.aeropuerto.nombre, "Destino").toArray());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblPartidas = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstPartidas = new javax.swing.JList();
        lblArribos = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstArribos = new javax.swing.JList();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblPartidas.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        lblPartidas.setText("PARTIDAS");

        jScrollPane1.setViewportView(lstPartidas);

        lblArribos.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        lblArribos.setText("ARRIBOS");

        jScrollPane2.setViewportView(lstArribos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblPartidas)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblArribos))))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(lblPartidas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblArribos)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    ControladoraMonitoreo controlador;    
    UsuAeropuerto ua = null;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblArribos;
    private javax.swing.JLabel lblPartidas;
    private javax.swing.JList lstArribos;
    private javax.swing.JList lstPartidas;
    // End of variables declaration//GEN-END:variables
   
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import controladores.ControladoraAeropuerto;
import java.util.ArrayList;
import modelo.FrecuenciaDeVuelo;
import modelo.UsuAeropuerto;
import modelo.UsuCompania;
import modelo.Usuario;

/**
 *
 * @author majuetcheverry
 */
public class AplicacionAeropuerto extends javax.swing.JDialog {

    /**
     * Creates new form MenuAeropuerto
     */
    public AplicacionAeropuerto(java.awt.Frame parent, boolean modal, Usuario u) {
        super(parent, modal);
        initComponents();
        lblNombre.setText(u.nombreCompleto);
        ua = (UsuAeropuerto) u;
        lblAeropuerto.setText(ua.aeropuerto.nombre);
        actualizarListaFVOrigen(ControladoraAeropuerto.getInstancia().frecuenciasPorAeropuertoOrigen(ua.aeropuerto.nombre));
        actualizarListaFVDestino(ControladoraAeropuerto.getInstancia().frecuenciasPorAeropuertoDestino(ua.aeropuerto.nombre));
        actualizarListaFVDestinoPartio(ControladoraAeropuerto.getInstancia().frecuenciasAprobadasOrigen(ua.aeropuerto.nombre));
        actualizarListaFVDestinoLlego(ControladoraAeropuerto.getInstancia().frecuenciasAprobadasDestino(ua.aeropuerto.nombre));
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
        lstFrecuenciasPendientesOrigen = new javax.swing.JList();
        btnAprobar = new javax.swing.JButton();
        lblAprobarRechazarFrecuencia = new javax.swing.JLabel();
        btnRechazar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstFrecuenciasPendientesDestino = new javax.swing.JList();
        btnAprobar1 = new javax.swing.JButton();
        btnRechazar1 = new javax.swing.JButton();
        lblAeropuertoDestino = new javax.swing.JLabel();
        lblAeropuertoOrigen = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        lstVuelosDiariosPartidas = new javax.swing.JList();
        btnIngresarPartida = new javax.swing.JButton();
        lblPartidas = new javax.swing.JLabel();
        lblArribos = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        lstVuelosDiariosArribos = new javax.swing.JList();
        btnIngresarArribo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblNombre.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        lblNombre.setText("Nombre");

        lblAeropuerto.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        lblAeropuerto.setText("Aeropuerto");

        lstFrecuenciasPendientesOrigen.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstFrecuenciasPendientesOrigenValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(lstFrecuenciasPendientesOrigen);

        btnAprobar.setText("Aprobar");
        btnAprobar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAprobarActionPerformed(evt);
            }
        });

        lblAprobarRechazarFrecuencia.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        lblAprobarRechazarFrecuencia.setText("APROBAR / RECHAZAR FRECUENCIAS");

        btnRechazar.setText("Rechazar");
        btnRechazar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRechazarActionPerformed(evt);
            }
        });

        lstFrecuenciasPendientesDestino.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstFrecuenciasPendientesDestinoValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(lstFrecuenciasPendientesDestino);

        btnAprobar1.setText("Aprobar");
        btnAprobar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAprobar1ActionPerformed(evt);
            }
        });

        btnRechazar1.setText("Rechazar");
        btnRechazar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRechazar1ActionPerformed(evt);
            }
        });

        lblAeropuertoDestino.setText("Aeropuerto Destino");

        lblAeropuertoOrigen.setText("Aeropuerto Origen");

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel1.setText("LISTA DE VUELOS");

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
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNombre)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblAeropuertoOrigen)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(btnAprobar)
                                    .addGap(18, 18, 18)
                                    .addComponent(btnRechazar))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblAeropuertoDestino)
                                    .addComponent(lblAprobarRechazarFrecuencia)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(btnAprobar1)
                                            .addGap(18, 18, 18)
                                            .addComponent(btnRechazar1))
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)))))
                        .addGap(74, 74, 74)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblPartidas)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1))
                                .addComponent(lblArribos, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblAeropuerto)
                                .addComponent(btnIngresarPartida))
                            .addComponent(btnIngresarArribo)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(14, 53, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre)
                    .addComponent(lblAeropuerto))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblAprobarRechazarFrecuencia, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblAeropuertoOrigen)
                        .addGap(7, 7, 7)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(lblPartidas)
                        .addGap(7, 7, 7)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAprobar)
                            .addComponent(btnRechazar)
                            .addComponent(btnIngresarPartida))
                        .addGap(20, 20, 20)
                        .addComponent(lblAeropuertoDestino))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(lblArribos)))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAprobar1)
                            .addComponent(btnRechazar1)
                            .addComponent(btnIngresarArribo)))
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(62, 62, 62))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAprobarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAprobarActionPerformed
        ControladoraAeropuerto.getInstancia().aprobarEstadoFrecuenciaOrigen(frecPendOrigen);
        actualizarListaFVOrigen(ControladoraAeropuerto.getInstancia().frecuenciasPorAeropuertoOrigen(ua.aeropuerto.nombre));
        actualizarListaFVDestino(ControladoraAeropuerto.getInstancia().frecuenciasPorAeropuertoDestino(ua.aeropuerto.nombre));
        actualizarListaFVDestinoPartio(ControladoraAeropuerto.getInstancia().frecuenciasAprobadasOrigen(ua.aeropuerto.nombre));
        actualizarListaFVDestinoLlego(ControladoraAeropuerto.getInstancia().frecuenciasAprobadasDestino(ua.aeropuerto.nombre));
    }//GEN-LAST:event_btnAprobarActionPerformed

    private void btnAprobar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAprobar1ActionPerformed
        ControladoraAeropuerto.getInstancia().aprobarEstadoFrecuenciaDestino(frecPendDestino);
        actualizarListaFVOrigen(ControladoraAeropuerto.getInstancia().frecuenciasPorAeropuertoOrigen(ua.aeropuerto.nombre));
        actualizarListaFVDestino(ControladoraAeropuerto.getInstancia().frecuenciasPorAeropuertoDestino(ua.aeropuerto.nombre));
        actualizarListaFVDestinoPartio(ControladoraAeropuerto.getInstancia().frecuenciasAprobadasOrigen(ua.aeropuerto.nombre));
        actualizarListaFVDestinoLlego(ControladoraAeropuerto.getInstancia().frecuenciasAprobadasDestino(ua.aeropuerto.nombre));
    }//GEN-LAST:event_btnAprobar1ActionPerformed

    private void lstFrecuenciasPendientesDestinoValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstFrecuenciasPendientesDestinoValueChanged
        Object obj = lstFrecuenciasPendientesDestino.getSelectedValue();
        if (obj != null && obj instanceof FrecuenciaDeVuelo) {
            frecPendDestino = (FrecuenciaDeVuelo) obj;
        }
    }//GEN-LAST:event_lstFrecuenciasPendientesDestinoValueChanged

    private void lstFrecuenciasPendientesOrigenValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstFrecuenciasPendientesOrigenValueChanged
        Object obj = lstFrecuenciasPendientesOrigen.getSelectedValue();
        if (obj != null && obj instanceof FrecuenciaDeVuelo) {
            frecPendOrigen = (FrecuenciaDeVuelo) obj;
        }
    }//GEN-LAST:event_lstFrecuenciasPendientesOrigenValueChanged

    private void btnRechazarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRechazarActionPerformed
        ControladoraAeropuerto.getInstancia().rechazarEstadoFrecuenciaOrigen(frecPendOrigen);
        actualizarListaFVOrigen(ControladoraAeropuerto.getInstancia().frecuenciasPorAeropuertoOrigen(ua.aeropuerto.nombre));
        actualizarListaFVDestino(ControladoraAeropuerto.getInstancia().frecuenciasPorAeropuertoDestino(ua.aeropuerto.nombre));
        actualizarListaFVDestinoPartio(ControladoraAeropuerto.getInstancia().frecuenciasAprobadasOrigen(ua.aeropuerto.nombre));
        actualizarListaFVDestinoLlego(ControladoraAeropuerto.getInstancia().frecuenciasAprobadasDestino(ua.aeropuerto.nombre));
    }//GEN-LAST:event_btnRechazarActionPerformed

    private void btnRechazar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRechazar1ActionPerformed
        ControladoraAeropuerto.getInstancia().rechazarEstadoFrecuenciaDestino(frecPendDestino);
        actualizarListaFVOrigen(ControladoraAeropuerto.getInstancia().frecuenciasPorAeropuertoOrigen(ua.aeropuerto.nombre));
        actualizarListaFVDestino(ControladoraAeropuerto.getInstancia().frecuenciasPorAeropuertoDestino(ua.aeropuerto.nombre));
        actualizarListaFVDestinoPartio(ControladoraAeropuerto.getInstancia().frecuenciasAprobadasOrigen(ua.aeropuerto.nombre));
        actualizarListaFVDestinoLlego(ControladoraAeropuerto.getInstancia().frecuenciasAprobadasDestino(ua.aeropuerto.nombre));
    }//GEN-LAST:event_btnRechazar1ActionPerformed

    public final void actualizarListaFVOrigen(ArrayList<FrecuenciaDeVuelo> frecuencias) {
        lstFrecuenciasPendientesOrigen.setListData(frecuencias.toArray());
    }

    public final void actualizarListaFVDestino(ArrayList<FrecuenciaDeVuelo> frecuencias) {
        lstFrecuenciasPendientesDestino.setListData(frecuencias.toArray());
    }

    public final void actualizarListaFVDestinoPartio(ArrayList<FrecuenciaDeVuelo> frecuencias) {
        lstVuelosDiariosPartidas.setListData(frecuencias.toArray());
    }

    public final void actualizarListaFVDestinoLlego(ArrayList<FrecuenciaDeVuelo> frecuencias) {
        lstVuelosDiariosArribos.setListData(frecuencias.toArray());
    }

    /**
     * @param args the command line arguments
     */
    UsuAeropuerto ua = null;
    FrecuenciaDeVuelo frecPendOrigen;
    FrecuenciaDeVuelo frecPendDestino;
    FrecuenciaDeVuelo partida;
    FrecuenciaDeVuelo arribo;


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
    private javax.swing.JList lstFrecuenciasPendientesDestino;
    private javax.swing.JList lstFrecuenciasPendientesOrigen;
    private javax.swing.JList lstVuelosDiariosArribos;
    private javax.swing.JList lstVuelosDiariosPartidas;
    // End of variables declaration//GEN-END:variables
}

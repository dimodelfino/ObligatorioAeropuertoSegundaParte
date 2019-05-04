/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import modelo.UsuCompania;
import modelo.Usuario;

/**
 *
 * @author dmoreno
 */
public class AplicacionCompania extends javax.swing.JDialog {

    /**
     * Creates new form IngresarFrecuencia
     */
    public AplicacionCompania(java.awt.Frame parent, boolean modal, Usuario u) {
        super(parent, modal);
        initComponents();
        lblNombreCompleto.setText(u.nombreCompleto);
        UsuCompania uc = (UsuCompania)u;
        lblCompania.setText(uc.compania.nombre);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbAeropOrigen = new javax.swing.JLabel();
        lbAeropDestino = new javax.swing.JLabel();
        cmbAeropOrigen = new javax.swing.JComboBox<>();
        cmbAeropDestino = new javax.swing.JComboBox<>();
        lblDiaSemana = new javax.swing.JLabel();
        rbtLunes = new javax.swing.JRadioButton();
        rbtDomingo = new javax.swing.JRadioButton();
        rbtMiercoles = new javax.swing.JRadioButton();
        lblJueves = new javax.swing.JRadioButton();
        rbtViernes = new javax.swing.JRadioButton();
        rbtSabado = new javax.swing.JRadioButton();
        rbtMartes = new javax.swing.JRadioButton();
        lblHoraPartida = new javax.swing.JLabel();
        txtHoraPartida = new javax.swing.JTextField();
        lblHoraPartida1 = new javax.swing.JLabel();
        txtDuracion = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstVisualizarFrecuencias = new javax.swing.JList<>();
        lblFrecuencias = new javax.swing.JLabel();
        lblNombreCompleto = new javax.swing.JLabel();
        lblCompania = new javax.swing.JLabel();
        lblIngresarFrecuencia = new javax.swing.JLabel();
        btnIngresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lbAeropOrigen.setText("Aeropuerto Origen");

        lbAeropDestino.setText("Aeropuerto Destino");

        cmbAeropOrigen.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbAeropOrigen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbAeropOrigenActionPerformed(evt);
            }
        });

        cmbAeropDestino.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lblDiaSemana.setText("Dia De la Semana");

        rbtLunes.setText("Lunes");

        rbtDomingo.setText("Domingo");

        rbtMiercoles.setText("Miercoles");

        lblJueves.setText("Jueves");

        rbtViernes.setText("Viernes");

        rbtSabado.setText("Sabado");

        rbtMartes.setText("Martes");

        lblHoraPartida.setText("Hora Partida");

        lblHoraPartida1.setText("Duración");

        jScrollPane1.setViewportView(lstVisualizarFrecuencias);

        lblFrecuencias.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        lblFrecuencias.setText("FRECUENCIAS");

        lblNombreCompleto.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N

        lblCompania.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N

        lblIngresarFrecuencia.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        lblIngresarFrecuencia.setText("INGRESAR FRECUENCIA");

        btnIngresar.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        btnIngresar.setText("Ingresar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblIngresarFrecuencia)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lbAeropOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lbAeropDestino))
                                    .addGap(51, 51, 51)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(cmbAeropDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(cmbAeropOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblHoraPartida, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblHoraPartida1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtDuracion, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtHoraPartida, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lblNombreCompleto)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblCompania))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lblDiaSemana, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(7, 7, 7)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(rbtLunes)
                                        .addComponent(rbtViernes))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(rbtSabado)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(rbtDomingo))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(rbtMartes)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(rbtMiercoles)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(lblJueves))))
                                .addComponent(btnIngresar, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addComponent(lblFrecuencias))
                        .addGap(0, 20, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombreCompleto)
                    .addComponent(lblCompania))
                .addGap(18, 18, 18)
                .addComponent(lblIngresarFrecuencia)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbAeropOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbAeropOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbAeropDestino, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbAeropDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDiaSemana, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rbtLunes)
                    .addComponent(rbtMartes)
                    .addComponent(rbtMiercoles)
                    .addComponent(lblJueves))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbtViernes)
                    .addComponent(rbtSabado)
                    .addComponent(rbtDomingo))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblHoraPartida, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtHoraPartida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblHoraPartida1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDuracion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addComponent(btnIngresar)
                .addGap(22, 22, 22)
                .addComponent(lblFrecuencias)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbAeropOrigenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbAeropOrigenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbAeropOrigenActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIngresar;
    private javax.swing.JComboBox<String> cmbAeropDestino;
    private javax.swing.JComboBox<String> cmbAeropOrigen;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbAeropDestino;
    private javax.swing.JLabel lbAeropOrigen;
    private javax.swing.JLabel lblCompania;
    private javax.swing.JLabel lblDiaSemana;
    private javax.swing.JLabel lblFrecuencias;
    private javax.swing.JLabel lblHoraPartida;
    private javax.swing.JLabel lblHoraPartida1;
    private javax.swing.JLabel lblIngresarFrecuencia;
    private javax.swing.JRadioButton lblJueves;
    private javax.swing.JLabel lblNombreCompleto;
    private javax.swing.JList<String> lstVisualizarFrecuencias;
    private javax.swing.JRadioButton rbtDomingo;
    private javax.swing.JRadioButton rbtLunes;
    private javax.swing.JRadioButton rbtMartes;
    private javax.swing.JRadioButton rbtMiercoles;
    private javax.swing.JRadioButton rbtSabado;
    private javax.swing.JRadioButton rbtViernes;
    private javax.swing.JTextField txtDuracion;
    private javax.swing.JTextField txtHoraPartida;
    // End of variables declaration//GEN-END:variables
}

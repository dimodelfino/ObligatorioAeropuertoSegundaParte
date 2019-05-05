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
        lblHoraPartida1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstVisualizarFrecuencias = new javax.swing.JList<>();
        lblFrecuencias = new javax.swing.JLabel();
        lblNombreCompleto = new javax.swing.JLabel();
        lblCompania = new javax.swing.JLabel();
        lblIngresarFrecuencia = new javax.swing.JLabel();
        btnIngresar = new javax.swing.JButton();
        cmbHorasPartida = new javax.swing.JComboBox<>();
        rbtnAM = new javax.swing.JRadioButton();
        rbtnPm = new javax.swing.JRadioButton();
        cmbMinutoPartida = new javax.swing.JComboBox<>();
        lblHs = new javax.swing.JLabel();
        lblMin = new javax.swing.JLabel();
        lblHsDuracion = new javax.swing.JLabel();
        cmbHoraDuracion = new javax.swing.JComboBox<>();
        lblMinDuracion = new javax.swing.JLabel();
        cmbMinutosDuracion = new javax.swing.JComboBox<>();

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
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });

        cmbHorasPartida.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
        cmbHorasPartida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbHorasPartidaActionPerformed(evt);
            }
        });

        rbtnAM.setText("AM");

        rbtnPm.setText("PM");

        cmbMinutoPartida.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", "60" }));

        lblHs.setText("Hs: ");

        lblMin.setText("Min: ");

        lblHsDuracion.setText("Hs: ");

        cmbHoraDuracion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
        cmbHoraDuracion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbHoraDuracionActionPerformed(evt);
            }
        });

        lblMinDuracion.setText("Min: ");

        cmbMinutosDuracion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", "60" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
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
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lblHs)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(cmbHorasPartida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 113, Short.MAX_VALUE)
                                    .addComponent(rbtnAM)
                                    .addGap(18, 18, 18)
                                    .addComponent(rbtnPm))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(lblHsDuracion)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(cmbHoraDuracion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(86, 86, 86)
                                            .addComponent(lblMinDuracion)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(cmbMinutosDuracion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGap(0, 0, Short.MAX_VALUE))))
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
                                    .addComponent(rbtMartes)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(rbtMiercoles)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(lblJueves))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(rbtSabado)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(lblMin)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(cmbMinutoPartida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(rbtDomingo))))
                        .addComponent(btnIngresar, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addComponent(lblFrecuencias))
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
                    .addComponent(cmbHorasPartida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rbtnAM)
                    .addComponent(rbtnPm)
                    .addComponent(cmbMinutoPartida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblHs)
                    .addComponent(lblMin))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblHoraPartida1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cmbHoraDuracion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cmbMinutosDuracion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblHsDuracion)
                        .addComponent(lblMinDuracion)))
                .addGap(18, 18, 18)
                .addComponent(btnIngresar)
                .addGap(22, 22, 22)
                .addComponent(lblFrecuencias)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(44, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbAeropOrigenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbAeropOrigenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbAeropOrigenActionPerformed

    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnIngresarActionPerformed

    private void cmbHorasPartidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbHorasPartidaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbHorasPartidaActionPerformed

    private void cmbHoraDuracionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbHoraDuracionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbHoraDuracionActionPerformed

    
    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIngresar;
    private javax.swing.JComboBox<String> cmbAeropDestino;
    private javax.swing.JComboBox<String> cmbAeropOrigen;
    private javax.swing.JComboBox<String> cmbHoraDuracion;
    private javax.swing.JComboBox<String> cmbHorasPartida;
    private javax.swing.JComboBox<String> cmbMinutoPartida;
    private javax.swing.JComboBox<String> cmbMinutosDuracion;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbAeropDestino;
    private javax.swing.JLabel lbAeropOrigen;
    private javax.swing.JLabel lblCompania;
    private javax.swing.JLabel lblDiaSemana;
    private javax.swing.JLabel lblFrecuencias;
    private javax.swing.JLabel lblHoraPartida;
    private javax.swing.JLabel lblHoraPartida1;
    private javax.swing.JLabel lblHs;
    private javax.swing.JLabel lblHsDuracion;
    private javax.swing.JLabel lblIngresarFrecuencia;
    private javax.swing.JRadioButton lblJueves;
    private javax.swing.JLabel lblMin;
    private javax.swing.JLabel lblMinDuracion;
    private javax.swing.JLabel lblNombreCompleto;
    private javax.swing.JList<String> lstVisualizarFrecuencias;
    private javax.swing.JRadioButton rbtDomingo;
    private javax.swing.JRadioButton rbtLunes;
    private javax.swing.JRadioButton rbtMartes;
    private javax.swing.JRadioButton rbtMiercoles;
    private javax.swing.JRadioButton rbtSabado;
    private javax.swing.JRadioButton rbtViernes;
    private javax.swing.JRadioButton rbtnAM;
    private javax.swing.JRadioButton rbtnPm;
    // End of variables declaration//GEN-END:variables
}

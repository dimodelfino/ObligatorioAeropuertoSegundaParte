/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import controladores.ControladoraCompania;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ButtonGroup;
import modelo.Aeropuerto;
import modelo.FrecuenciaDeVuelo;
import modelo.LogicaAeropuerto;
import modelo.LogicaFrecuenciaVuelo;
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
        groupButton();
        lblNombreCompleto.setText(u.nombreCompleto);
        uc = (UsuCompania) u;
        lblCompania.setText(uc.compania.nombre);
        getNombreAeropuertos();
    }

public void ActualizarListaFrecuencias(ArrayList<FrecuenciaDeVuelo> frecuencias){
        lstVisualizarFrecuencias.setListData(frecuencias.toArray());
}            
            
            
    private void groupButton() {
        rbtLunes.setActionCommand(DiaSemanaEnum.L.toString());
        rbtMartes.setActionCommand("Martes");
        rbtMiercoles.setActionCommand("Miercoles");
        rbtJueves.setActionCommand("Jueves");
        rbtViernes.setActionCommand("Viernes");
        rbtSabado.setActionCommand("Sabado");
        rbtDomingo.setActionCommand("Domingo");
        bgDiaSemana.add(rbtLunes);
        bgDiaSemana.add(rbtMartes);
        bgDiaSemana.add(rbtMiercoles);
        bgDiaSemana.add(rbtJueves);
        bgDiaSemana.add(rbtViernes);
        bgDiaSemana.add(rbtSabado);
        bgDiaSemana.add(rbtDomingo);
        rbtnAM.setActionCommand("Am");
        rbtnPm.setActionCommand("Pm");
        bgAmPm.add(rbtnAM);
        bgAmPm.add(rbtnPm);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rbtnGroupDiaSemana = new javax.swing.ButtonGroup();
        rbtnGroupAmPm = new javax.swing.ButtonGroup();
        lbAeropOrigen = new javax.swing.JLabel();
        lbAeropDestino = new javax.swing.JLabel();
        cmbAeropOrigen = new javax.swing.JComboBox<>();
        cmbAeropDestino = new javax.swing.JComboBox<>();
        lblDiaSemana = new javax.swing.JLabel();
        rbtLunes = new javax.swing.JRadioButton();
        rbtDomingo = new javax.swing.JRadioButton();
        rbtMiercoles = new javax.swing.JRadioButton();
        rbtJueves = new javax.swing.JRadioButton();
        rbtViernes = new javax.swing.JRadioButton();
        rbtSabado = new javax.swing.JRadioButton();
        rbtMartes = new javax.swing.JRadioButton();
        lblHoraPartida = new javax.swing.JLabel();
        lblHoraPartida1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstVisualizarFrecuencias = new javax.swing.JList();
        lblFrecuencias = new javax.swing.JLabel();
        lblNombreCompleto = new javax.swing.JLabel();
        lblCompania = new javax.swing.JLabel();
        lblIngresarFrecuencia = new javax.swing.JLabel();
        btnIngresar = new javax.swing.JButton();
        cmbHoraPartida = new javax.swing.JComboBox<>();
        rbtnAM = new javax.swing.JRadioButton();
        rbtnPm = new javax.swing.JRadioButton();
        cmbMinutoPartida = new javax.swing.JComboBox<>();
        lblHs = new javax.swing.JLabel();
        lblMin = new javax.swing.JLabel();
        lblHsDuracion = new javax.swing.JLabel();
        cmbHoraDuracion = new javax.swing.JComboBox<>();
        lblMinDuracion = new javax.swing.JLabel();
        cmbMinutosDuracion = new javax.swing.JComboBox<>();
        lblIngresarMessage = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lbAeropOrigen.setText("Aeropuerto Origen");

        lbAeropDestino.setText("Aeropuerto Destino");

        cmbAeropOrigen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbAeropOrigenActionPerformed(evt);
            }
        });

        lblDiaSemana.setText("Dia De la Semana");

        rbtLunes.setText("Lunes");

        rbtDomingo.setText("Domingo");

        rbtMiercoles.setText("Miercoles");

        rbtJueves.setText("Jueves");

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

        cmbHoraPartida.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
        cmbHoraPartida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbHoraPartidaActionPerformed(evt);
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
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblHoraPartida, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                                    .addComponent(lblHoraPartida1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(101, 101, 101)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblMinDuracion, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
                                    .addComponent(lblMin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(cmbMinutosDuracion, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(118, 118, 118))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(cmbMinutoPartida, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(rbtnAM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGap(18, 18, 18)
                                                .addComponent(rbtnPm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addComponent(btnIngresar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblNombreCompleto)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblCompania)))
                        .addGap(134, 134, 134))
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbAeropOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbAeropDestino))
                                .addGap(51, 51, 51)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cmbAeropDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmbAeropOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(lblIngresarFrecuencia)
                            .addComponent(lblFrecuencias))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblIngresarMessage, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(lblDiaSemana, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(rbtViernes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(0, 0, 0)
                                        .addComponent(rbtSabado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(rbtDomingo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(rbtLunes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(rbtMartes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(rbtMiercoles, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(rbtJueves, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(70, 70, 70)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblHsDuracion, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblHs, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cmbHoraPartida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmbHoraDuracion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(104, 104, 104))))
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
                    .addComponent(rbtLunes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rbtMartes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rbtMiercoles, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rbtJueves, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbtViernes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rbtSabado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rbtDomingo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblHoraPartida, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rbtnAM)
                    .addComponent(rbtnPm)
                    .addComponent(cmbMinutoPartida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblHs)
                    .addComponent(lblMin)
                    .addComponent(cmbHoraPartida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cmbHoraDuracion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cmbMinutosDuracion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblHsDuracion)
                        .addComponent(lblMinDuracion))
                    .addComponent(lblHoraPartida1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addComponent(btnIngresar)
                .addGap(23, 23, 23)
                .addComponent(lblIngresarMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblFrecuencias)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbAeropOrigenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbAeropOrigenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbAeropOrigenActionPerformed
   
    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
        String aeroOrigen = cmbAeropOrigen.getSelectedItem().toString();
        String aeroDestino = cmbAeropDestino.getSelectedItem().toString();    
        String diaSemana = bgDiaSemana.getSelection().getActionCommand();
        String partidaHora = cmbHoraPartida.getSelectedItem().toString();
        String partidaMinutos = cmbMinutoPartida.getSelectedItem().toString();
        String amPm = bgAmPm.getSelection().getActionCommand();
        String duracionHora = cmbHoraDuracion.getSelectedItem().toString();
        String duracionMinutos = cmbMinutosDuracion.getSelectedItem().toString();
        if(ControladoraCompania.getInstancia().IngresoFrecuenciaVuelo(aeroOrigen, aeroDestino, getDiaSemana(diaSemana), partidaHora, partidaMinutos, duracionHora, duracionMinutos, amPm, uc.compania)){
        lblIngresarMessage.setText("Se ingreso la frecuencia correctamente.");
        }else {
        lblIngresarMessage.setText("Ingrese datos correctos.");
        }
       ActualizarListaFrecuencias(LogicaFrecuenciaVuelo.getInstancia().getFrecuencias());
    }//GEN-LAST:event_btnIngresarActionPerformed

    private void cmbHoraPartidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbHoraPartidaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbHoraPartidaActionPerformed

    private void cmbHoraDuracionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbHoraDuracionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbHoraDuracionActionPerformed

    private void getNombreAeropuertos() {
        List<Aeropuerto> aeropuertos = LogicaAeropuerto.getInstancia().getAeropuertos();

        for (Aeropuerto a : aeropuertos) {
            cmbAeropDestino.addItem(a.nombre);

            cmbAeropOrigen.addItem(a.nombre);
        }

    }

    private DiaSemanaEnum getDiaSemana(String diaSemana) {
        DiaSemanaEnum result = DiaSemanaEnum.L;
        switch (diaSemana) {
            case "Martes":
                result = DiaSemanaEnum.M;
                break;
            case "Miercoles":
                result = DiaSemanaEnum.X;
                break;
            case "Jueves":
                result = DiaSemanaEnum.J;
                break;
            case "Viernes":
                result = DiaSemanaEnum.V;
                break;
            case "Sabado":
                result = DiaSemanaEnum.S;
                break;
            case "Domingo":
                result = DiaSemanaEnum.D;
                break;
        }
        return result;
    }
    ButtonGroup bgDiaSemana = new ButtonGroup();
    ButtonGroup bgAmPm = new ButtonGroup();
    UsuCompania uc = null;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIngresar;
    private javax.swing.JComboBox<String> cmbAeropDestino;
    private javax.swing.JComboBox<String> cmbAeropOrigen;
    private javax.swing.JComboBox<String> cmbHoraDuracion;
    private javax.swing.JComboBox<String> cmbHoraPartida;
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
    private javax.swing.JLabel lblIngresarMessage;
    private javax.swing.JLabel lblMin;
    private javax.swing.JLabel lblMinDuracion;
    private javax.swing.JLabel lblNombreCompleto;
    private javax.swing.JList lstVisualizarFrecuencias;
    private javax.swing.JRadioButton rbtDomingo;
    private javax.swing.JRadioButton rbtJueves;
    private javax.swing.JRadioButton rbtLunes;
    private javax.swing.JRadioButton rbtMartes;
    private javax.swing.JRadioButton rbtMiercoles;
    private javax.swing.JRadioButton rbtSabado;
    private javax.swing.JRadioButton rbtViernes;
    private javax.swing.JRadioButton rbtnAM;
    private javax.swing.ButtonGroup rbtnGroupAmPm;
    private javax.swing.ButtonGroup rbtnGroupDiaSemana;
    private javax.swing.JRadioButton rbtnPm;
    // End of variables declaration//GEN-END:variables
}

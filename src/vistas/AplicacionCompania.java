package vistas;

import modelo.DiaSemanaEnum;
import controladores.ControladoraCompania;
import controladores.IVistaCompania;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ButtonGroup;
import modelo.Aeropuerto;
import modelo.FrecuenciaDeVuelo;
import modelo.LogicaAeropuerto;
import modelo.LogicaFrecuenciaVuelo;
import modelo.UsuCompania;
import modelo.Usuario;
import utilities.Utils;

public class AplicacionCompania extends javax.swing.JDialog implements IVistaCompania {

    public AplicacionCompania(java.awt.Frame parent, boolean modal, Usuario u) {
        super(parent, modal);
        initComponents();
        groupButton();
        lblNombreCompleto.setText(u.nombreCompleto);
        uc = (UsuCompania) u;
        lblCompania.setText(uc.compania.nombre);
        this.controlador = new ControladoraCompania(this);        
        getNombreAeropuertos();
        checkboxManager();
        actualizarFrecuencias();        
    }

    private void groupButton() {
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
        chkBxLunes = new javax.swing.JCheckBox();
        chkBxMartes = new javax.swing.JCheckBox();
        chkBxMiercoles = new javax.swing.JCheckBox();
        chkBxJueves = new javax.swing.JCheckBox();
        chkBxViernes = new javax.swing.JCheckBox();
        chkBxSabado = new javax.swing.JCheckBox();
        chkBxDomingo = new javax.swing.JCheckBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstVuelosDeFrecuencia = new javax.swing.JList();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lbAeropOrigen.setText("Aeropuerto Origen");

        lbAeropDestino.setText("Aeropuerto Destino");

        lblDiaSemana.setText("Dia De la Semana");

        lblHoraPartida.setText("Hora Partida");

        lblHoraPartida1.setText("Duración");

        lstVisualizarFrecuencias.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstVisualizarFrecuenciasValueChanged(evt);
            }
        });
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

        cmbHoraPartida.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));

        rbtnAM.setText("AM");

        rbtnPm.setText("PM");

        cmbMinutoPartida.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", "60" }));

        lblHs.setText("Hs: ");

        lblMin.setText("Min: ");

        lblHsDuracion.setText("Hs: ");

        cmbHoraDuracion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17" }));

        lblMinDuracion.setText("Min: ");

        cmbMinutosDuracion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", "60" }));

        chkBxLunes.setText("Lunes");

        chkBxMartes.setText("Martes");

        chkBxMiercoles.setText("Miercoles");

        chkBxJueves.setText("Jueves");

        chkBxViernes.setText("Viernes");

        chkBxSabado.setText("Sabado");

        chkBxDomingo.setText("Domingo");

        jScrollPane2.setViewportView(lstVuelosDeFrecuencia);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblFrecuencias)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblIngresarMessage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblNombreCompleto)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblCompania))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblHoraPartida, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblHoraPartida1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(101, 101, 101)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblMinDuracion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblMin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cmbMinutoPartida, 0, 90, Short.MAX_VALUE)
                                    .addComponent(cmbMinutosDuracion, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(rbtnAM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(18, 18, 18)
                                        .addComponent(rbtnPm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(btnIngresar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(134, 134, 134))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(70, 70, 70)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblHsDuracion, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblHs, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cmbHoraPartida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmbHoraDuracion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbAeropOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbAeropDestino))
                                .addGap(51, 51, 51)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cmbAeropDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmbAeropOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(lblIngresarFrecuencia)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblDiaSemana, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(chkBxLunes)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(chkBxSabado)
                                        .addGap(33, 33, 33)
                                        .addComponent(chkBxDomingo))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(chkBxMartes)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(chkBxMiercoles)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(chkBxJueves)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(chkBxViernes)))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2)
                        .addContainerGap())))
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
                    .addComponent(chkBxLunes)
                    .addComponent(chkBxMartes)
                    .addComponent(chkBxMiercoles)
                    .addComponent(chkBxJueves)
                    .addComponent(chkBxViernes))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chkBxSabado)
                    .addComponent(chkBxDomingo))
                .addGap(29, 29, 29)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblIngresarMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblFrecuencias)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(54, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Valida crea e ingresa la frecuencia
    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
        String aeroOrigen = cmbAeropOrigen.getSelectedItem().toString();
        String aeroDestino = cmbAeropDestino.getSelectedItem().toString();
        ArrayList<DiaSemanaEnum> diasSeleccionados = getSelectedDiasSemana();
        String partidaHora = cmbHoraPartida.getSelectedItem().toString();
        String partidaMinutos = cmbMinutoPartida.getSelectedItem().toString();
        String duracionHora = cmbHoraDuracion.getSelectedItem().toString();
        String duracionMinutos = cmbMinutosDuracion.getSelectedItem().toString();
        String amPm = null;
        if (bgAmPm.getSelection() != null) {
            amPm = bgAmPm.getSelection().getActionCommand();
        }
        try {
            controlador.ValidaIngresaFrecuencia(aeroOrigen, aeroDestino, diasSeleccionados, partidaHora, partidaMinutos, duracionHora, duracionMinutos, amPm, uc.compania);
            lblIngresarMessage.setText("Se ingreso la frecuencia con exito.");
        } catch (utilities.ExceptionCompania x) {
            lblIngresarMessage.setText("Ha ocurrido un error: " + x.getMessage());
        }
    }//GEN-LAST:event_btnIngresarActionPerformed

    private void lstVisualizarFrecuenciasValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstVisualizarFrecuenciasValueChanged
        Object obj = lstVisualizarFrecuencias.getSelectedValue();
        if (obj != null && obj instanceof FrecuenciaDeVuelo) {
            fv = (FrecuenciaDeVuelo) obj;            
            actualizarVuelosPorFrecuencia();
        }
    }//GEN-LAST:event_lstVisualizarFrecuenciasValueChanged
    //Carga nombres de aeropuertos a comboBox
    private void getNombreAeropuertos() {
        List<Aeropuerto> aeropuertos =  controlador.getAeropuertos(); //LogicaAeropuerto.getInstancia().getAeropuertos();
        for (Aeropuerto a : aeropuertos) {
            cmbAeropDestino.addItem(a.nombre);
            cmbAeropOrigen.addItem(a.nombre);
        }
    }

    //Agrega valor a los checkboxes(dias de la semana)
    private void checkboxManager() {
        chkBxLunes.setActionCommand("Lunes");
        dias.add(chkBxLunes);
        chkBxMartes.setActionCommand("Martes");
        dias.add(chkBxMartes);
        chkBxMiercoles.setActionCommand("Miercoles");
        dias.add(chkBxMiercoles);
        chkBxJueves.setActionCommand("Jueves");
        dias.add(chkBxJueves);
        chkBxViernes.setActionCommand("Viernes");
        dias.add(chkBxViernes);
        chkBxSabado.setActionCommand("Sabado");
        dias.add(chkBxSabado);
        chkBxDomingo.setActionCommand("Domingo");
        dias.add(chkBxDomingo);
    }

    //Recorre las checboxes y checkea cuales estan seleccionadas.
    private ArrayList<DiaSemanaEnum> getSelectedDiasSemana() {
        ArrayList<DiaSemanaEnum> result = new ArrayList<>();
        for (javax.swing.JCheckBox box : dias) {
            if (box.isSelected()) {
                result.addAll(Utils.getDiaSemanaEnum(box.getActionCommand()));
            }
        }
        return result;
    }
   
    @Override
    public void actualizarFrecuencias() {
        lstVisualizarFrecuencias.setListData(controlador.getFrecuencias().toArray());
    }
    
    //@Override
    public void actualizarTiempoRestante() {
        lstVisualizarFrecuencias.setListData(controlador.getFrecuencias().toArray());
    }
    
    @Override
    public void actualizarVuelosPorFrecuencia(){
        lstVuelosDeFrecuencia.setListData(controlador.getVuelosString(fv).toArray());
    }

    ButtonGroup bgDiaSemana = new ButtonGroup();
    ButtonGroup bgAmPm = new ButtonGroup();
    FrecuenciaDeVuelo fv = null;
    UsuCompania uc = null;
    ArrayList<javax.swing.JCheckBox> dias = new ArrayList<>();
    ControladoraCompania controlador;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIngresar;
    private javax.swing.JCheckBox chkBxDomingo;
    private javax.swing.JCheckBox chkBxJueves;
    private javax.swing.JCheckBox chkBxLunes;
    private javax.swing.JCheckBox chkBxMartes;
    private javax.swing.JCheckBox chkBxMiercoles;
    private javax.swing.JCheckBox chkBxSabado;
    private javax.swing.JCheckBox chkBxViernes;
    private javax.swing.JComboBox<String> cmbAeropDestino;
    private javax.swing.JComboBox<String> cmbAeropOrigen;
    private javax.swing.JComboBox<String> cmbHoraDuracion;
    private javax.swing.JComboBox<String> cmbHoraPartida;
    private javax.swing.JComboBox<String> cmbMinutoPartida;
    private javax.swing.JComboBox<String> cmbMinutosDuracion;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
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
    private javax.swing.JList lstVuelosDeFrecuencia;
    private javax.swing.JRadioButton rbtnAM;
    private javax.swing.ButtonGroup rbtnGroupAmPm;
    private javax.swing.ButtonGroup rbtnGroupDiaSemana;
    private javax.swing.JRadioButton rbtnPm;
    // End of variables declaration//GEN-END:variables

}

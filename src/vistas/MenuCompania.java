/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;
import controladores.IVistaLogIn;
import modelo.Usuario;

/**
 *
 * @author dmoreno
 */
public class MenuCompania extends javax.swing.JFrame implements IVistaLogIn{


    public MenuCompania() {
        initComponents();
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnIngresarFrecuencia = new javax.swing.JButton();
        txtNombreUsuario = new javax.swing.JLabel();
        txtCompania = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listFrecuencias = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnIngresarFrecuencia.setText("Ingresar Frecuencia");

        txtNombreUsuario.setText("Nombre Completo");

        txtCompania.setText("Compañía");

        jScrollPane1.setViewportView(listFrecuencias);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtNombreUsuario)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 214, Short.MAX_VALUE)
                        .addComponent(txtCompania))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnIngresarFrecuencia)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(28, 28, 28))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombreUsuario)
                    .addComponent(txtCompania))
                .addGap(35, 35, 35)
                .addComponent(btnIngresarFrecuencia, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

  
  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIngresarFrecuencia;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> listFrecuencias;
    private javax.swing.JLabel txtCompania;
    private javax.swing.JLabel txtNombreUsuario;
    // End of variables declaration//GEN-END:variables

    @Override
    public void mostrarUsuario(Usuario u) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

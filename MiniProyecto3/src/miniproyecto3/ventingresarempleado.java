package miniproyecto3;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;


public class ventingresarempleado extends javax.swing.JFrame {
    
  
    public ventingresarempleado() {
        initComponents();
    }

     
    // Método privado para guardar los datos ingresados
    private void guardarDatos() {
        // Obtiene el texto de los campos de entrada de la interfaz gráfica
        String textoPrimernombre = primernombre.getText();
        String textoSegundonombre = segundonombre.getText();
        String textoPrimerap = primerap.getText();
        String textoSegundoap = segundoap.getText();
        String textoNumerodoc = numerodoc.getText();
        String textoFecha = fecha.getText();
        String textoSueldbasico = sueldbasico.getText();
        String seleccionBoxdocumento = (String) boxdocumento.getSelectedItem();
        String seleccionBoxriesgo = (String) boxriesgo.getSelectedItem();

        // Formatear la fecha en el formato "dd/MM/yyyy"
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date fechaFormateada = null;
        try {
            // Intenta parsear la fecha ingresada por el usuario
            fechaFormateada = dateFormat.parse(textoFecha);
        } catch (ParseException e) {
            // Manejo de error en caso de que la fecha sea inválida
            e.printStackTrace();
            // Muestra un mensaje de error al usuario indicando el formato correcto de la fecha
            JOptionPane.showMessageDialog(this, "Fecha inválida. Por favor ingrese una fecha en el formato dd/MM/yyyy.");
            return; // Sale del método en caso de error
        }

        // Formatea la fecha en un string para guardar
        String fechaString = dateFormat.format(fechaFormateada);

        // Intento de escritura de datos en un archivo
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/datos_tabla.txt", true))) {
            // Escribe los datos en el archivo separados por comas y añade una línea nueva
            writer.write(seleccionBoxdocumento + "," + textoNumerodoc + "," + textoPrimernombre + "," + textoSegundonombre + "," + textoPrimerap + "," + textoSegundoap + "," + textoSueldbasico + "," + seleccionBoxriesgo + "," + fechaString + ",activo");
            writer.newLine();
            // Imprime un mensaje en la consola confirmando que los datos se guardaron exitosamente
            System.out.println("Datos guardados exitosamente.");
        } catch (IOException ex) {
            // Manejo de error en caso de que haya un problema al escribir los datos en el archivo
            ex.printStackTrace();
            // Muestra un mensaje de error al usuario indicando que hubo un problema al guardar los datos
            JOptionPane.showMessageDialog(this, "Error al guardar los datos. Intente nuevamente.");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel1 = new javax.swing.JPanel();
        panel3 = new javax.swing.JPanel();
        boxdocumento = new javax.swing.JComboBox<>();
        numdoc = new javax.swing.JLabel();
        tipodoc = new javax.swing.JLabel();
        primernombre = new javax.swing.JTextField();
        numerodoc = new javax.swing.JTextField();
        primerap = new javax.swing.JTextField();
        segundonombre = new javax.swing.JTextField();
        segundoap = new javax.swing.JTextField();
        primernomb = new javax.swing.JLabel();
        segundonomb = new javax.swing.JLabel();
        priapellido = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        sueldbasico = new javax.swing.JTextField();
        boxriesgo = new javax.swing.JComboBox<>();
        primernomb1 = new javax.swing.JLabel();
        primernomb2 = new javax.swing.JLabel();
        primernomb3 = new javax.swing.JLabel();
        menu = new javax.swing.JButton();
        fecha = new javax.swing.JFormattedTextField();
        panel2 = new javax.swing.JPanel();
        titulo = new javax.swing.JLabel();
        botoningresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        panel1.setLayout(null);

        panel3.setBackground(new java.awt.Color(255, 153, 153));

        boxdocumento.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        boxdocumento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cedula de ciudadania", "Tarjeta de identidad", "Certificados excepcionales y de nacionalidad.", "Glosario de identificación." }));

        numdoc.setFont(new java.awt.Font("Showcard Gothic", 0, 14)); // NOI18N
        numdoc.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        numdoc.setText("NUMERO DE DOCUMENTO");

        tipodoc.setFont(new java.awt.Font("Showcard Gothic", 0, 14)); // NOI18N
        tipodoc.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tipodoc.setText("Tipo de documento");

        primernombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                primernombreActionPerformed(evt);
            }
        });

        primerap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                primerapActionPerformed(evt);
            }
        });

        primernomb.setFont(new java.awt.Font("Showcard Gothic", 0, 14)); // NOI18N
        primernomb.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        primernomb.setText("PrIMER NOMBRE");

        segundonomb.setFont(new java.awt.Font("Showcard Gothic", 0, 14)); // NOI18N
        segundonomb.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        segundonomb.setText("Segundo nombre");

        priapellido.setFont(new java.awt.Font("Showcard Gothic", 0, 14)); // NOI18N
        priapellido.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        priapellido.setText("primer apellido");

        jLabel6.setFont(new java.awt.Font("Showcard Gothic", 0, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("segundo apellido");

        boxriesgo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1 ", "2", "3", "4", "5" }));

        primernomb1.setFont(new java.awt.Font("Showcard Gothic", 0, 14)); // NOI18N
        primernomb1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        primernomb1.setText("fecha de vinculacion");

        primernomb2.setFont(new java.awt.Font("Showcard Gothic", 0, 14)); // NOI18N
        primernomb2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        primernomb2.setText("nivel de riesgo");

        primernomb3.setFont(new java.awt.Font("Showcard Gothic", 0, 14)); // NOI18N
        primernomb3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        primernomb3.setText("sueldo basico");

        menu.setFont(new java.awt.Font("Showcard Gothic", 0, 12)); // NOI18N
        menu.setText("Menu principal");
        menu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel3Layout = new javax.swing.GroupLayout(panel3);
        panel3.setLayout(panel3Layout);
        panel3Layout.setHorizontalGroup(
            panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel3Layout.createSequentialGroup()
                .addGroup(panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panel3Layout.createSequentialGroup()
                            .addGap(17, 17, 17)
                            .addComponent(boxdocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(panel3Layout.createSequentialGroup()
                            .addGap(32, 32, 32)
                            .addComponent(tipodoc))
                        .addGroup(panel3Layout.createSequentialGroup()
                            .addGap(56, 56, 56)
                            .addGroup(panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(primernomb, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(primernombre, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(panel3Layout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addGroup(panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(sueldbasico, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(primernomb3, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel3Layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addGroup(panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panel3Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(numerodoc, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(panel3Layout.createSequentialGroup()
                                .addComponent(numdoc)
                                .addContainerGap())
                            .addGroup(panel3Layout.createSequentialGroup()
                                .addGroup(panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(segundonombre)
                                    .addComponent(segundonomb, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel3Layout.createSequentialGroup()
                                        .addGap(97, 97, 97)
                                        .addComponent(priapellido)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel6)
                                        .addGap(63, 63, 63))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel3Layout.createSequentialGroup()
                                        .addGroup(panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(panel3Layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(menu, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(panel3Layout.createSequentialGroup()
                                                .addGap(53, 53, 53)
                                                .addComponent(primerap, javax.swing.GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
                                                .addGap(103, 103, 103)
                                                .addComponent(segundoap, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(39, 39, 39))))))
                    .addGroup(panel3Layout.createSequentialGroup()
                        .addGap(157, 157, 157)
                        .addGroup(panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(primernomb1)
                            .addGroup(panel3Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel3Layout.createSequentialGroup()
                                .addComponent(primernomb2, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(144, 144, 144))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel3Layout.createSequentialGroup()
                                .addComponent(boxriesgo, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(183, 183, 183))))))
        );
        panel3Layout.setVerticalGroup(
            panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel3Layout.createSequentialGroup()
                        .addGroup(panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tipodoc, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(numdoc, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(boxdocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(numerodoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(menu, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(segundonomb)
                    .addComponent(priapellido)
                    .addComponent(jLabel6)
                    .addComponent(primernomb, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(primerap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(primernombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(segundonombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(segundoap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(64, 64, 64)
                .addGroup(panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(primernomb1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(primernomb2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(primernomb3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(boxriesgo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sueldbasico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(185, Short.MAX_VALUE))
        );

        panel1.add(panel3);
        panel3.setBounds(0, 70, 1020, 460);

        panel2.setBackground(new java.awt.Color(153, 153, 153));

        titulo.setFont(new java.awt.Font("Showcard Gothic", 0, 24)); // NOI18N
        titulo.setText("Ingresar empleado");

        javax.swing.GroupLayout panel2Layout = new javax.swing.GroupLayout(panel2);
        panel2.setLayout(panel2Layout);
        panel2Layout.setHorizontalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addGap(378, 378, 378)
                .addComponent(titulo)
                .addContainerGap(401, Short.MAX_VALUE))
        );
        panel2Layout.setVerticalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(titulo)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        panel1.add(panel2);
        panel2.setBounds(0, 0, 1020, 70);

        botoningresar.setFont(new java.awt.Font("Showcard Gothic", 0, 14)); // NOI18N
        botoningresar.setText("ingresar");
        botoningresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botoningresarActionPerformed(evt);
            }
        });
        panel1.add(botoningresar);
        botoningresar.setBounds(440, 540, 120, 26);

        getContentPane().add(panel1);
        panel1.setBounds(0, 0, 1020, 580);

        pack();
    }// </editor-fold>//GEN-END:initComponents
 
    private void menuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuActionPerformed
        ventempleados vent= new ventempleados();
        vent.setTitle("Empleados");
        vent.setLocation(400,300);
        vent.setSize(930,622);
        vent.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_menuActionPerformed

    private void primerapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_primerapActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_primerapActionPerformed

    private void botoningresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botoningresarActionPerformed
        guardarDatos();
        JOptionPane.showMessageDialog(this, "Se ha ingresado un nuevo usuario");
    }//GEN-LAST:event_botoningresarActionPerformed

    private void primernombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_primernombreActionPerformed
        
    }//GEN-LAST:event_primernombreActionPerformed

    
    
    
    
    
    
    
    
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ventingresarempleado().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botoningresar;
    private javax.swing.JComboBox<String> boxdocumento;
    private javax.swing.JComboBox<String> boxriesgo;
    private javax.swing.JFormattedTextField fecha;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JButton menu;
    private javax.swing.JLabel numdoc;
    private javax.swing.JTextField numerodoc;
    private javax.swing.JPanel panel1;
    private javax.swing.JPanel panel2;
    private javax.swing.JPanel panel3;
    private javax.swing.JLabel priapellido;
    private javax.swing.JTextField primerap;
    private javax.swing.JLabel primernomb;
    private javax.swing.JLabel primernomb1;
    private javax.swing.JLabel primernomb2;
    private javax.swing.JLabel primernomb3;
    private javax.swing.JTextField primernombre;
    private javax.swing.JTextField segundoap;
    private javax.swing.JLabel segundonomb;
    private javax.swing.JTextField segundonombre;
    private javax.swing.JTextField sueldbasico;
    private javax.swing.JLabel tipodoc;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables
}

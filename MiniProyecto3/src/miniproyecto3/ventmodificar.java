
package miniproyecto3;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class ventmodificar extends javax.swing.JFrame {

  
    public ventmodificar() {
        initComponents();
        consultadoc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarEmpleado(consultadoc.getText());
            }
        });
    }

    private void buscarEmpleado(String numeroDocumento) {
    // Limpiar los campos de la GUI
    numerodoc.setText("");
    primernombre.setText("");
    segundonombre.setText("");
    primerap.setText("");
    segundoap.setText("");
    sueldbasico.setText("");
    fecha.setText("");
    boxdocumento.setSelectedIndex(-1);
    boxriesgo.setSelectedIndex(-1);

    // Crear un objeto File que representa el archivo donde se almacenan los datos de los empleados
    File file = new File("src/datos_tabla.txt");

    try (Scanner scanner = new Scanner(file)) {
        // Leer el archivo línea por línea
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.trim().isEmpty()) {
                continue; // Ignorar líneas vacías
            }
            // Dividir la línea en partes usando la coma como delimitador
            String[] data = line.split(",");
            if (data.length < 9) {
                continue; // Ignorar líneas mal formadas
            }

            // Comparar el número de documento con el proporcionado
            if (data[1].trim().equals(numeroDocumento.trim())) {
                System.out.println("Empleado encontrado:");

                // Asignar los valores encontrados a los campos de la GUI
                boxdocumento.setSelectedItem(data[0]);
                boxdocumento.setEnabled(false); // Deshabilitar el combo box de tipo de documento
                consultadoc.setText(data[1]);
                numerodoc.setText(data[1]);
                numerodoc.setEnabled(false); // Deshabilitar el campo de texto del número de documento
                primernombre.setText(data[2]);
                segundonombre.setText(data[3]);
                primerap.setText(data[4]);
                segundoap.setText(data[5]);
                sueldbasico.setText(data[6]);
                boxriesgo.setSelectedItem(data[7]);
                fecha.setText(data[8]);
                if (data.length > 9) { // Verificar si hay estado
                    festado.setText(data[9]);
                } else {
                    festado.setText(""); // Limpiar si no hay estado
                }

                return; // Terminar la búsqueda una vez encontrado el empleado
            }
        }

        // Si no se encuentra el empleado, imprimir mensaje en consola
        System.out.println("Empleado no encontrado");
        // Puedes mostrar un mensaje de error en tu GUI si lo prefieres

    } catch (FileNotFoundException ex) {
        ex.printStackTrace(); // Manejar el error si el archivo no se encuentra
    }
}
    
    
    
    
  private void modificarEmpleado() {
    // Obtener los nuevos datos de los campos de la GUI
    String numeroDocumento = numerodoc.getText();
    String nuevoPrimernombre = primernombre.getText();
    String nuevoSegundonombre = segundonombre.getText();
    String nuevoPrimerap = primerap.getText();
    String nuevoSegundoap = segundoap.getText();
    String nuevoSueldbasico = sueldbasico.getText();
    String nuevoNivelRiesgo = (String) boxriesgo.getSelectedItem();
    String nuevaFecha = fecha.getText();
    String nuevoestado = festado.getText();

    // Crear un objeto File que representa el archivo donde se almacenan los datos de los empleados
    File file = new File("src/datos_tabla.txt");

    try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
        StringBuilder sb = new StringBuilder();
        String line;
        // Leer el archivo línea por línea
        while ((line = reader.readLine()) != null) {
            String[] data = line.split(",");
            // Si el número de documento coincide, actualizar los datos
            if (data.length >= 9 && data[1].trim().equals(numeroDocumento.trim())) {
                // Actualizar los datos del empleado
                sb.append(data[0]).append(",") // Tipo de documento
                  .append(data[1]).append(",") // Número de documento
                  .append(nuevoPrimernombre).append(",")
                  .append(nuevoSegundonombre).append(",")
                  .append(nuevoPrimerap).append(",")
                  .append(nuevoSegundoap).append(",")
                  .append(nuevoSueldbasico).append(",")
                  .append(nuevoNivelRiesgo).append(",")
                  .append(nuevaFecha).append(",")
                  .append(nuevoestado).append("\n");
            } else {
                // Mantener los datos sin modificar
                sb.append(line).append("\n");
            }
        }

        // Escribir los datos actualizados al archivo
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write(sb.toString());
        }
    } catch (IOException ex) {
        ex.printStackTrace(); // Manejar el error en caso de problemas al leer o escribir el archivo
    }
}
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel1 = new javax.swing.JPanel();
        panel2 = new javax.swing.JPanel();
        titulo = new javax.swing.JLabel();
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
        apellido = new javax.swing.JLabel();
        fecha = new javax.swing.JTextField();
        sueldbasico = new javax.swing.JTextField();
        boxriesgo = new javax.swing.JComboBox<>();
        primernomb1 = new javax.swing.JLabel();
        primernomb2 = new javax.swing.JLabel();
        primernomb3 = new javax.swing.JLabel();
        menu = new javax.swing.JButton();
        estado = new javax.swing.JLabel();
        festado = new javax.swing.JTextField();
        documentocon = new javax.swing.JLabel();
        consultadoc = new javax.swing.JTextField();
        botonmodificar = new javax.swing.JButton();
        SI = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panel2.setBackground(new java.awt.Color(204, 204, 204));

        titulo.setFont(new java.awt.Font("Showcard Gothic", 0, 48)); // NOI18N
        titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo.setText("Modificar empleado");

        panel3.setBackground(new java.awt.Color(204, 255, 255));

        boxdocumento.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        boxdocumento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cedula de ciudadania", "Tarjeta de identidad", "Certificados excepcionales y de nacionalidad.", "Glosario de identificación." }));

        numdoc.setFont(new java.awt.Font("Showcard Gothic", 0, 14)); // NOI18N
        numdoc.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        numdoc.setText("NUMERO DE DOCUMENTO");

        tipodoc.setFont(new java.awt.Font("Showcard Gothic", 0, 14)); // NOI18N
        tipodoc.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tipodoc.setText("Tipo de documento");

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

        apellido.setFont(new java.awt.Font("Showcard Gothic", 0, 14)); // NOI18N
        apellido.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        apellido.setText("segundo apellido");

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

        estado.setFont(new java.awt.Font("Showcard Gothic", 0, 14)); // NOI18N
        estado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        estado.setText("estado");

        festado.setEditable(false);

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
                                .addGroup(panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(panel3Layout.createSequentialGroup()
                                        .addGroup(panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(panel3Layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 581, Short.MAX_VALUE)
                                                .addComponent(menu, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panel3Layout.createSequentialGroup()
                                                .addGap(86, 86, 86)
                                                .addComponent(primerap, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(segundoap, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(39, 39, 39))
                                    .addGroup(panel3Layout.createSequentialGroup()
                                        .addGap(150, 150, 150)
                                        .addComponent(priapellido)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(apellido)
                                        .addGap(63, 63, 63))))))
                    .addGroup(panel3Layout.createSequentialGroup()
                        .addGap(218, 218, 218)
                        .addGroup(panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(primernomb1)
                            .addGroup(panel3Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel3Layout.createSequentialGroup()
                                .addComponent(primernomb2, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(144, 144, 144))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel3Layout.createSequentialGroup()
                                .addComponent(boxriesgo, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(183, 183, 183))))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(estado)
                .addGap(39, 39, 39)
                .addComponent(festado, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(452, 452, 452))
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
                    .addComponent(apellido)
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
                    .addComponent(fecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boxriesgo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sueldbasico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(78, 78, 78)
                .addGroup(panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(estado, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(festado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(81, Short.MAX_VALUE))
        );

        documentocon.setFont(new java.awt.Font("Showcard Gothic", 0, 18)); // NOI18N
        documentocon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        documentocon.setText("Numero de documento");

        consultadoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultadocActionPerformed(evt);
            }
        });

        botonmodificar.setFont(new java.awt.Font("Showcard Gothic", 0, 12)); // NOI18N
        botonmodificar.setText("Modificar");
        botonmodificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonmodificarActionPerformed(evt);
            }
        });

        SI.setText("DARLE ENTER");

        javax.swing.GroupLayout panel2Layout = new javax.swing.GroupLayout(panel2);
        panel2.setLayout(panel2Layout);
        panel2Layout.setHorizontalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel2Layout.createSequentialGroup()
                        .addGap(302, 302, 302)
                        .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 552, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(panel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel2Layout.createSequentialGroup()
                        .addGap(135, 135, 135)
                        .addComponent(documentocon, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55)
                        .addComponent(consultadoc, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel2Layout.createSequentialGroup()
                        .addGap(529, 529, 529)
                        .addComponent(botonmodificar))
                    .addGroup(panel2Layout.createSequentialGroup()
                        .addGap(450, 450, 450)
                        .addComponent(SI)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panel2Layout.setVerticalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(SI)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(documentocon, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(consultadoc, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addComponent(panel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(botonmodificar)
                .addGap(36, 36, 36))
        );

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void primerapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_primerapActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_primerapActionPerformed

    private void menuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuActionPerformed
        ventempleados vent= new ventempleados();
        vent.setTitle("Empleados");
        vent.setLocation(400,300);
        vent.setSize(930,622);
        vent.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_menuActionPerformed

    private void botonmodificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonmodificarActionPerformed
        modificarEmpleado();
        JOptionPane.showMessageDialog(this, "Se ha modificado el usuario");
    }//GEN-LAST:event_botonmodificarActionPerformed

    private void consultadocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultadocActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_consultadocActionPerformed

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
            java.util.logging.Logger.getLogger(ventmodificar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ventmodificar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ventmodificar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ventmodificar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ventmodificar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel SI;
    private javax.swing.JLabel apellido;
    private javax.swing.JButton botonmodificar;
    private javax.swing.JComboBox<String> boxdocumento;
    private javax.swing.JComboBox<String> boxriesgo;
    private javax.swing.JTextField consultadoc;
    private javax.swing.JLabel documentocon;
    private javax.swing.JLabel estado;
    private javax.swing.JTextField fecha;
    private javax.swing.JTextField festado;
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

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
import java.util.Arrays;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class venteliminar extends javax.swing.JFrame {

    public venteliminar() {
        initComponents();
        consultadoc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarEmpleado(consultadoc.getText());
            }
        });
    }
    
    
    
    private void cambiarEstado(String numeroDocumento) {
    File archivo = new File("src/datos_tabla.txt");
    StringBuilder contenido = new StringBuilder();

    try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
        String linea;
        while ((linea = reader.readLine()) != null) {
            String[] data = linea.split(",");
            if (data.length >= 10 && data[1].trim().equals(numeroDocumento.trim())) {
                String nuevoEstado = data[9].equals("activo") ? "inactivo" : "activo";
                contenido.append(String.join(",", Arrays.copyOf(data, data.length - 1)) + "," + nuevoEstado);
            } else {
                contenido.append(linea);
            }
            contenido.append("\n");
        }
    } catch (IOException e) {
        e.printStackTrace();
    }

    try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo))) {
        writer.write(contenido.toString());
        System.out.println("Estado actualizado correctamente.");
    } catch (IOException e) {
        e.printStackTrace();
    }
}
    private void eliminarEmpleado(String numeroDocumento) {
    File archivo = new File("src/datos_tabla.txt");
    StringBuilder contenido = new StringBuilder();

    try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
        String linea;
        boolean encontrado = false;
        while ((linea = reader.readLine()) != null) {
            String[] data = linea.split(",");
            if (data.length >= 10 && !encontrado && data[1].trim().equals(numeroDocumento.trim())) {
                encontrado = true;
                System.out.println("Empleado eliminado: " + linea);
            } else {
                contenido.append(linea).append("\n");
            }
        }
        if (!encontrado) {
            System.out.println("Empleado no encontrado.");
        }
    } catch (IOException e) {
        e.printStackTrace();
    }

    try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo))) {
        writer.write(contenido.toString());
        System.out.println("Archivo actualizado correctamente.");
    } catch (IOException e) {
        e.printStackTrace();
    }
}
    private void buscarEmpleado(String numeroDocumento) {
        numerodoc.setText("");
        primernombre.setText("");
        segundonombre.setText("");
        primerap.setText("");
        segundoap.setText("");
        sueldbasico.setText("");
        fecha.setText("");
        boxdocumento.setSelectedIndex(-1); // Limpiar el combo box de tipo de documento

        File file = new File("src/datos_tabla.txt");

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] data = line.split(",");

                if (data.length >= 9 && data[1].trim().equals(numeroDocumento.trim())) {
                    System.out.println("Empleado encontrado:");

                    boxdocumento.setSelectedItem(data[0]);
                    boxdocumento.setEnabled(false); // Deshabilitar el combo box de tipo de documento
                    consultadoc.setText(data[1]);
                    numerodoc.setText(data[1]);
                    numerodoc.setEnabled(false);// Asignar el número de documento al campo numerodoc
                    consultadoc.setEditable(true); // Deshabilitar el campo de texto de número de documento
                    primernombre.setText(data[2]);
                    segundonombre.setText(data[3]);
                    primerap.setText(data[4]);
                    segundoap.setText(data[5]);
                    sueldbasico.setText(data[6]);
                    boxriesgo.setSelectedItem(data[7]);
                    boxriesgo.setEnabled(false);
                    fecha.setText(data[8]);
                    festado.setText(data[9]);

                    return; // Terminar la búsqueda una vez encontrado el empleado
                }
            }

            System.out.println("Empleado no encontrado");
            // Puedes mostrar un mensaje de error en tu GUI si lo prefieres

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
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
        jLabel6 = new javax.swing.JLabel();
        fecha = new javax.swing.JTextField();
        sueldbasico = new javax.swing.JTextField();
        boxriesgo = new javax.swing.JComboBox<>();
        primernomb1 = new javax.swing.JLabel();
        primernomb2 = new javax.swing.JLabel();
        primernomb3 = new javax.swing.JLabel();
        Menu = new javax.swing.JButton();
        estado = new javax.swing.JLabel();
        festado = new javax.swing.JTextField();
        documentocon = new javax.swing.JLabel();
        consultadoc = new javax.swing.JTextField();
        SI = new javax.swing.JLabel();
        botonactivar = new javax.swing.JButton();
        botoneliminar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panel2.setBackground(new java.awt.Color(0, 102, 102));

        titulo.setFont(new java.awt.Font("Showcard Gothic", 0, 48)); // NOI18N
        titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo.setText("eliminar o desactivar empleado");

        panel3.setBackground(new java.awt.Color(153, 153, 255));

        boxdocumento.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        boxdocumento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cedula de ciudadania", "Tarjeta de identidad", "Certificados excepcionales y de nacionalidad.", "Glosario de identificación." }));

        numdoc.setFont(new java.awt.Font("Showcard Gothic", 0, 14)); // NOI18N
        numdoc.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        numdoc.setText("NUMERO DE DOCUMENTO");

        tipodoc.setFont(new java.awt.Font("Showcard Gothic", 0, 14)); // NOI18N
        tipodoc.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tipodoc.setText("Tipo de documento");

        primernombre.setEditable(false);

        primerap.setEditable(false);
        primerap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                primerapActionPerformed(evt);
            }
        });

        segundonombre.setEditable(false);

        segundoap.setEditable(false);

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

        fecha.setEditable(false);

        sueldbasico.setEditable(false);

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

        Menu.setFont(new java.awt.Font("Showcard Gothic", 0, 12)); // NOI18N
        Menu.setText("Menu principal");
        Menu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuActionPerformed(evt);
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
                                                .addComponent(Menu, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panel3Layout.createSequentialGroup()
                                                .addGap(86, 86, 86)
                                                .addGroup(panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addGroup(panel3Layout.createSequentialGroup()
                                                        .addComponent(estado)
                                                        .addGap(39, 39, 39)
                                                        .addComponent(festado, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addComponent(primerap, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(segundoap, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(39, 39, 39))
                                    .addGroup(panel3Layout.createSequentialGroup()
                                        .addGap(150, 150, 150)
                                        .addComponent(priapellido)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel6)
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
                    .addComponent(Menu, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                    .addComponent(fecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boxriesgo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sueldbasico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(57, 57, 57)
                .addGroup(panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(estado, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(festado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(102, Short.MAX_VALUE))
        );

        documentocon.setFont(new java.awt.Font("Showcard Gothic", 0, 18)); // NOI18N
        documentocon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        documentocon.setText("Numero de documento");

        consultadoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultadocActionPerformed(evt);
            }
        });

        SI.setText("DARLE ENTER");

        botonactivar.setFont(new java.awt.Font("Showcard Gothic", 0, 14)); // NOI18N
        botonactivar.setText("activar/desactivar empleado");
        botonactivar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonactivarActionPerformed(evt);
            }
        });

        botoneliminar.setFont(new java.awt.Font("Showcard Gothic", 0, 14)); // NOI18N
        botoneliminar.setText("Eliminar empleado");
        botoneliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botoneliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel2Layout = new javax.swing.GroupLayout(panel2);
        panel2.setLayout(panel2Layout);
        panel2Layout.setHorizontalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(panel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel2Layout.createSequentialGroup()
                        .addGap(173, 173, 173)
                        .addComponent(titulo))
                    .addGroup(panel2Layout.createSequentialGroup()
                        .addGap(129, 129, 129)
                        .addComponent(documentocon, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(62, 62, 62)
                        .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(consultadoc, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panel2Layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addComponent(SI)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(botoneliminar)
                .addGap(110, 110, 110)
                .addComponent(botonactivar)
                .addGap(312, 312, 312))
        );
        panel2Layout.setVerticalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(documentocon, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panel2Layout.createSequentialGroup()
                        .addComponent(SI)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(consultadoc, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
                .addComponent(panel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonactivar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botoneliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
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
                .addComponent(panel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
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
        
    }//GEN-LAST:event_primerapActionPerformed

    private void MenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuActionPerformed
        ventempleados vent= new ventempleados();
        vent.setTitle("Empleados");
        vent.setLocation(400,300);
        vent.setSize(930,622);
        vent.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_MenuActionPerformed

    private void consultadocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultadocActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_consultadocActionPerformed

    private void botonactivarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonactivarActionPerformed
        JOptionPane.showMessageDialog(this, "El estado del empleado a cambiado");
     
        String numeroDocumento = consultadoc.getText();
        cambiarEstado(numeroDocumento);
        buscarEmpleado(numeroDocumento);
    }//GEN-LAST:event_botonactivarActionPerformed

    private void botoneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botoneliminarActionPerformed
      JOptionPane.showMessageDialog(this, "Se ha eliminado al empleado");
    
        String numeroDocumento = consultadoc.getText();
        eliminarEmpleado(numeroDocumento);
    }//GEN-LAST:event_botoneliminarActionPerformed

   
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new venteliminar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Menu;
    private javax.swing.JLabel SI;
    private javax.swing.JButton botonactivar;
    private javax.swing.JButton botoneliminar;
    private javax.swing.JComboBox<String> boxdocumento;
    private javax.swing.JComboBox<String> boxriesgo;
    private javax.swing.JTextField consultadoc;
    private javax.swing.JLabel documentocon;
    private javax.swing.JLabel estado;
    private javax.swing.JTextField fecha;
    private javax.swing.JTextField festado;
    private javax.swing.JLabel jLabel6;
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

    private void limpiarCampos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

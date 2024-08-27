
package miniproyecto3;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;


public class ventconsultarnomina extends javax.swing.JFrame {

    
    public ventconsultarnomina() {
       initComponents();
    }

        
            

        
    
    

    
    
    
    
    private void calcularNomina() {
    DefaultTableModel model = (DefaultTableModel) Tabla.getModel();
    model.setRowCount(0); // Limpiar la tabla antes de cargar los datos

    double totalSueldobasico = 0;
    double totalAuxtranspo = 0;
    double totalSalud = 0;
    double totalPension = 0;
    double totalSena = 0;
    double totalCajacomp = 0;

    String mesSeleccionado = (String) fechabox.getSelectedItem();
    int mesIndex = fechabox.getSelectedIndex() + 1; // Obtener el índice del mes seleccionado (1-12)

    try (BufferedReader reader = new BufferedReader(new FileReader("src/datos_tabla.txt"))) {
        String line;
        while ((line = reader.readLine()) != null) {
            String[] data = line.split(",");
            if (data.length >= 10 && !data[9].trim().equalsIgnoreCase("inactivo")) {
                // Limpiar los datos
                for (int i = 0; i < data.length; i++) {
                    data[i] = data[i].trim();
                }

                // Obtener los datos básicos del empleado
                String tipoDocumento = data[0];
                String numeroDocumento = data[1];
                String primerNombre = data[2];
                String segundoNombre = data[3];
                String primerApellido = data[4];
                String segundoApellido = data[5];
                double sueldoBasico = Double.parseDouble(data[6]);
                int nivelRiesgo = Integer.parseInt(data[7]);
                String fecha = data[8];
                String estado = data[9];

                // Filtrar por mes
                SimpleDateFormat formatoEntrada = new SimpleDateFormat("dd/MM/yyyy");
                Date fechaEmpleado;
                try {
                    fechaEmpleado = formatoEntrada.parse(fecha);
                } catch (ParseException e) {
                    e.printStackTrace();
                    continue;
                }

                SimpleDateFormat formatoMes = new SimpleDateFormat("MM");
                int mesEmpleado = Integer.parseInt(formatoMes.format(fechaEmpleado));

                if (mesEmpleado == mesIndex) {
                    // Calcular los valores
                    double auxTransporte = 162000;
                    double salud = sueldoBasico * 0.04;
                    double pension = sueldoBasico * 0.04;
                    double sena = sueldoBasico * 0.02;
                    double cajaCompensacion = sueldoBasico * 0.04;

                    // Calcular el porcentaje de riesgo
                    double riesgoPorcentaje = 0;
                    switch (nivelRiesgo) {
                        case 1:
                            riesgoPorcentaje = 0.00522;
                            break;
                        case 2:
                            riesgoPorcentaje = 0.01044;
                            break;
                        case 3:
                            riesgoPorcentaje = 0.02436;
                            break;
                        case 4:
                            riesgoPorcentaje = 0.04350;
                            break;
                        case 5:
                            riesgoPorcentaje = 0.06960;
                            break;
                    }
                    double riesgo = sueldoBasico * riesgoPorcentaje;

                    // Calcular el total
                    double total = sueldoBasico - auxTransporte - salud - pension - sena - cajaCompensacion + riesgo;

                    // Agregar los datos calculados a la tabla
                    model.addRow(new Object[]{
                            tipoDocumento, numeroDocumento, primerNombre, segundoNombre, primerApellido, segundoApellido, 
                            sueldoBasico, auxTransporte, salud, pension, sena, cajaCompensacion, riesgo, total
                    });

                    // Acumular los totales
                    totalSueldobasico += sueldoBasico;
                    totalAuxtranspo += auxTransporte;
                    totalSalud += salud;
                    totalPension += pension;
                    totalSena += sena;
                    totalCajacomp += cajaCompensacion;
                }
            }
        }
    } catch (IOException ex) {
        ex.printStackTrace();
    }

    // Actualizar los labels
    sueldobasico.setText(String.format("%.2f", totalSueldobasico));
    auxtranspo.setText(String.format("%.2f", totalAuxtranspo));
    salud4.setText(String.format("%.2f", totalSalud));
    pension.setText(String.format("%.2f", totalPension));
    sena.setText(String.format("%.2f", totalSena));
    cajacomp.setText(String.format("%.2f", totalCajacomp));
}
    

    

    private void abrirFileChooserYExportar() {
        JFileChooser fileChooser = new JFileChooser();
        int seleccion = fileChooser.showSaveDialog(this);
        if (seleccion == JFileChooser.APPROVE_OPTION) {
            File archivo = fileChooser.getSelectedFile();
            // Agregamos .txt al nombre del archivo si no tiene la extensión
            if (!archivo.getName().endsWith(".txt")) {
                archivo = new File(archivo.getAbsolutePath() + ".txt");
            }
            exportarATxt(archivo);
        }
    }

    private void exportarATxt(File archivo) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(archivo));
            for (int i = 0; i < Tabla.getRowCount(); i++) {
                for (int j = 0; j < Tabla.getColumnCount(); j++) {
                    writer.write(Tabla.getValueAt(i, j).toString());
                    writer.write("\t"); // Tabulador como separador
                }
                writer.newLine(); // Nueva línea después de cada fila
            }
            writer.close();
            JOptionPane.showMessageDialog(this, "Tabla exportada correctamente.");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error al exportar la tabla: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

     

    
    
 
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel1 = new javax.swing.JPanel();
        Scroll = new javax.swing.JScrollPane();
        Tabla = new javax.swing.JTable();
        fechabox = new javax.swing.JComboBox<>();
        Consultar = new javax.swing.JButton();
        titulo1 = new javax.swing.JLabel();
        titulo2 = new javax.swing.JLabel();
        titulo3 = new javax.swing.JLabel();
        titulo4 = new javax.swing.JLabel();
        titulo5 = new javax.swing.JLabel();
        titulo6 = new javax.swing.JLabel();
        titulo7 = new javax.swing.JLabel();
        cajacomp = new javax.swing.JLabel();
        sueldobasico = new javax.swing.JLabel();
        auxtranspo = new javax.swing.JLabel();
        salud4 = new javax.swing.JLabel();
        pension = new javax.swing.JLabel();
        sena = new javax.swing.JLabel();
        panel2 = new javax.swing.JPanel();
        titulo = new javax.swing.JLabel();
        menuu = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        panel1.setLayout(null);

        Tabla.setForeground(new java.awt.Color(51, 51, 51));
        Tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tipo documento", "Numero documento", "Primer nombre", "Segundo nombre", "Primer apellido", "Segundo apellido", "Sueldo basico", "Auxilio transporte", "Salud 4%", "Pension", "Sena", "Caja compensacion", "Riesgo", "Total"
            }
        ));
        Scroll.setViewportView(Tabla);

        panel1.add(Scroll);
        Scroll.setBounds(0, 110, 1150, 480);

        fechabox.setFont(new java.awt.Font("Showcard Gothic", 0, 18)); // NOI18N
        fechabox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre" }));
        fechabox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fechaboxActionPerformed(evt);
            }
        });
        panel1.add(fechabox);
        fechabox.setBounds(10, 610, 200, 50);

        Consultar.setFont(new java.awt.Font("Showcard Gothic", 0, 18)); // NOI18N
        Consultar.setText("consultar");
        Consultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConsultarActionPerformed(evt);
            }
        });
        panel1.add(Consultar);
        Consultar.setBounds(220, 610, 140, 50);

        titulo1.setFont(new java.awt.Font("Showcard Gothic", 0, 14)); // NOI18N
        titulo1.setText("Total Nomina:");
        panel1.add(titulo1);
        titulo1.setBounds(360, 660, 110, 30);

        titulo2.setFont(new java.awt.Font("Showcard Gothic", 0, 14)); // NOI18N
        titulo2.setText("salud 4%");
        panel1.add(titulo2);
        titulo2.setBounds(730, 620, 84, 20);

        titulo3.setFont(new java.awt.Font("Showcard Gothic", 0, 14)); // NOI18N
        titulo3.setText("caja compensacion");
        panel1.add(titulo3);
        titulo3.setBounds(990, 620, 150, 20);

        titulo4.setFont(new java.awt.Font("Showcard Gothic", 0, 14)); // NOI18N
        titulo4.setText("Auxilio transporte");
        panel1.add(titulo4);
        titulo4.setBounds(570, 620, 150, 19);

        titulo5.setFont(new java.awt.Font("Showcard Gothic", 0, 14)); // NOI18N
        titulo5.setText("Sueldo basico");
        panel1.add(titulo5);
        titulo5.setBounds(460, 620, 110, 20);

        titulo6.setFont(new java.awt.Font("Showcard Gothic", 0, 14)); // NOI18N
        titulo6.setText("pension");
        panel1.add(titulo6);
        titulo6.setBounds(820, 620, 58, 20);

        titulo7.setFont(new java.awt.Font("Showcard Gothic", 0, 14)); // NOI18N
        titulo7.setText("sena");
        panel1.add(titulo7);
        titulo7.setBounds(910, 620, 34, 20);
        panel1.add(cajacomp);
        cajacomp.setBounds(1020, 660, 90, 20);
        panel1.add(sueldobasico);
        sueldobasico.setBounds(480, 660, 70, 20);
        panel1.add(auxtranspo);
        auxtranspo.setBounds(600, 660, 70, 20);
        panel1.add(salud4);
        salud4.setBounds(730, 660, 90, 20);
        panel1.add(pension);
        pension.setBounds(820, 660, 70, 20);
        panel1.add(sena);
        sena.setBounds(910, 660, 70, 20);

        panel2.setLayout(null);

        titulo.setFont(new java.awt.Font("Showcard Gothic", 0, 36)); // NOI18N
        titulo.setForeground(new java.awt.Color(204, 204, 255));
        titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo.setText("reporte de la nomina");
        panel2.add(titulo);
        titulo.setBounds(340, 10, 430, 60);

        menuu.setFont(new java.awt.Font("Showcard Gothic", 0, 18)); // NOI18N
        menuu.setText("Menu principal");
        menuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuuActionPerformed(evt);
            }
        });
        panel2.add(menuu);
        menuu.setBounds(950, 10, 190, 80);

        panel1.add(panel2);
        panel2.setBounds(0, 10, 1160, 100);

        getContentPane().add(panel1);
        panel1.setBounds(0, 0, 1170, 782);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fechaboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fechaboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fechaboxActionPerformed

    private void ConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConsultarActionPerformed
        calcularNomina();
    }//GEN-LAST:event_ConsultarActionPerformed

    private void menuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuuActionPerformed
        ventnomina vent= new ventnomina();
        vent.setTitle("Menu");
        vent.setLocation(400,300);
        vent.setSize(860,660);
        vent.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_menuuActionPerformed

   
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
            java.util.logging.Logger.getLogger(ventconsultarnomina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ventconsultarnomina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ventconsultarnomina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ventconsultarnomina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ventconsultarnomina().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Consultar;
    private javax.swing.JScrollPane Scroll;
    private javax.swing.JTable Tabla;
    private javax.swing.JLabel auxtranspo;
    private javax.swing.JLabel cajacomp;
    private javax.swing.JComboBox<String> fechabox;
    private javax.swing.JButton menuu;
    private javax.swing.JPanel panel1;
    private javax.swing.JPanel panel2;
    private javax.swing.JLabel pension;
    private javax.swing.JLabel salud4;
    private javax.swing.JLabel sena;
    private javax.swing.JLabel sueldobasico;
    private javax.swing.JLabel titulo;
    private javax.swing.JLabel titulo1;
    private javax.swing.JLabel titulo2;
    private javax.swing.JLabel titulo3;
    private javax.swing.JLabel titulo4;
    private javax.swing.JLabel titulo5;
    private javax.swing.JLabel titulo6;
    private javax.swing.JLabel titulo7;
    // End of variables declaration//GEN-END:variables
}

package miniproyecto3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import javax.swing.table.DefaultTableModel;


public class ventconsultar extends javax.swing.JFrame {

    
    public ventconsultar() {
        initComponents();
    }

    private void cargarDatos() {
    DefaultTableModel model = (DefaultTableModel) Tabla.getModel();
    model.setRowCount(0); // Limpiar la tabla antes de cargar los datos

    HashSet<String> registrosUnicos = new HashSet<>(); // Para evitar duplicados

    try (BufferedReader reader = new BufferedReader(new FileReader("src/datos_tabla.txt"))) {
        String line;
        while ((line = reader.readLine()) != null) {
            if (!registrosUnicos.contains(line)) {
                registrosUnicos.add(line);
                String[] data = line.split(",");
                if (data.length >= 10 && !data[9].trim().equalsIgnoreCase("inactivo")) {
                    model.addRow(data);
                }
            }
        }
    } catch (IOException ex) {
        ex.printStackTrace();
    }
}

    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel1 = new javax.swing.JPanel();
        Scroll = new javax.swing.JScrollPane();
        Tabla = new javax.swing.JTable();
        panel2 = new javax.swing.JPanel();
        titulo = new javax.swing.JLabel();
        botonconsultar = new javax.swing.JButton();
        botonmenu = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panel1.setLayout(null);

        Tabla.setForeground(new java.awt.Color(51, 51, 51));
        Tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tipo documento", "Numero documento", "Primer nombre", "Segundo nombre", "Primer apellido", "Segundo apellido", "Sueldo basico", "Nivel de riesgo", "Fecha de ingreso"
            }
        ));
        Scroll.setViewportView(Tabla);

        panel1.add(Scroll);
        Scroll.setBounds(0, 110, 1170, 480);

        titulo.setFont(new java.awt.Font("Showcard Gothic", 0, 24)); // NOI18N
        titulo.setText("Consular empleados");

        botonconsultar.setFont(new java.awt.Font("Showcard Gothic", 0, 12)); // NOI18N
        botonconsultar.setText("Consultar");
        botonconsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonconsultarActionPerformed(evt);
            }
        });

        botonmenu.setFont(new java.awt.Font("Showcard Gothic", 0, 12)); // NOI18N
        botonmenu.setText("Menu");
        botonmenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonmenuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel2Layout = new javax.swing.GroupLayout(panel2);
        panel2.setLayout(panel2Layout);
        panel2Layout.setHorizontalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(titulo)
                .addGap(433, 433, 433))
            .addGroup(panel2Layout.createSequentialGroup()
                .addGap(446, 446, 446)
                .addComponent(botonconsultar)
                .addGap(108, 108, 108)
                .addComponent(botonmenu)
                .addContainerGap(435, Short.MAX_VALUE))
        );
        panel2Layout.setVerticalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonconsultar)
                    .addComponent(botonmenu))
                .addContainerGap())
        );

        panel1.add(panel2);
        panel2.setBounds(10, 0, 1160, 100);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1168, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, 602, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonmenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonmenuActionPerformed
        ventempleados vent= new ventempleados();
        vent.setTitle("Empleados");
        vent.setLocation(400,300);
        vent.setSize(930,622);
        vent.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_botonmenuActionPerformed

    private void botonconsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonconsultarActionPerformed
        cargarDatos();
    }//GEN-LAST:event_botonconsultarActionPerformed

    
    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ventconsultar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane Scroll;
    private javax.swing.JTable Tabla;
    private javax.swing.JButton botonconsultar;
    private javax.swing.JButton botonmenu;
    private javax.swing.JPanel panel1;
    private javax.swing.JPanel panel2;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables
}

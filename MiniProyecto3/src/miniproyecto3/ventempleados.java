package miniproyecto3;


public class ventempleados extends javax.swing.JFrame {

   
    public ventempleados() {
        initComponents();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel1 = new javax.swing.JPanel();
        titulo = new javax.swing.JLabel();
        panelbotones = new javax.swing.JPanel();
        botonmodificar = new javax.swing.JButton();
        botoneliminar = new javax.swing.JButton();
        botonconsultar = new javax.swing.JButton();
        botoningresar = new javax.swing.JButton();
        menuu = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        panel1.setBackground(new java.awt.Color(204, 204, 255));
        panel1.setLayout(null);

        titulo.setBackground(new java.awt.Color(255, 153, 153));
        titulo.setFont(new java.awt.Font("Showcard Gothic", 0, 36)); // NOI18N
        titulo.setForeground(new java.awt.Color(102, 102, 102));
        titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo.setText("empleados");
        panel1.add(titulo);
        titulo.setBounds(80, 20, 620, 80);

        panelbotones.setBackground(new java.awt.Color(0, 153, 153));

        botonmodificar.setFont(new java.awt.Font("Showcard Gothic", 0, 24)); // NOI18N
        botonmodificar.setText("MODIFICAR");
        botonmodificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonmodificarActionPerformed(evt);
            }
        });

        botoneliminar.setFont(new java.awt.Font("Showcard Gothic", 0, 24)); // NOI18N
        botoneliminar.setText("ELIMINAR");
        botoneliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botoneliminarActionPerformed(evt);
            }
        });

        botonconsultar.setFont(new java.awt.Font("Showcard Gothic", 0, 24)); // NOI18N
        botonconsultar.setText("CONSULTAR");
        botonconsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonconsultarActionPerformed(evt);
            }
        });

        botoningresar.setFont(new java.awt.Font("Showcard Gothic", 0, 24)); // NOI18N
        botoningresar.setText("INGRESAR");
        botoningresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botoningresarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelbotonesLayout = new javax.swing.GroupLayout(panelbotones);
        panelbotones.setLayout(panelbotonesLayout);
        panelbotonesLayout.setHorizontalGroup(
            panelbotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelbotonesLayout.createSequentialGroup()
                .addContainerGap(74, Short.MAX_VALUE)
                .addGroup(panelbotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelbotonesLayout.createSequentialGroup()
                        .addGroup(panelbotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(botoneliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(botonconsultar))
                        .addGap(61, 61, 61))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelbotonesLayout.createSequentialGroup()
                        .addGroup(panelbotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(botoningresar, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(botonmodificar))
                        .addGap(67, 67, 67))))
        );
        panelbotonesLayout.setVerticalGroup(
            panelbotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelbotonesLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(botoningresar)
                .addGap(45, 45, 45)
                .addComponent(botonmodificar)
                .addGap(46, 46, 46)
                .addComponent(botoneliminar)
                .addGap(37, 37, 37)
                .addComponent(botonconsultar)
                .addContainerGap(72, Short.MAX_VALUE))
        );

        panel1.add(panelbotones);
        panelbotones.setBounds(60, 160, 300, 380);

        menuu.setFont(new java.awt.Font("Showcard Gothic", 0, 18)); // NOI18N
        menuu.setText("Menu principal");
        menuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuuActionPerformed(evt);
            }
        });
        panel1.add(menuu);
        menuu.setBounds(550, 250, 190, 80);

        getContentPane().add(panel1);
        panel1.setBounds(0, 10, 820, 600);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botoneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botoneliminarActionPerformed
         venteliminar vent= new venteliminar();
        vent.setTitle("Eliminar");
        vent.setLocation(400,300);
        vent.setSize(1168, 800);
        vent.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_botoneliminarActionPerformed

    private void botoningresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botoningresarActionPerformed
        ventingresarempleado vent= new ventingresarempleado();
        vent.setTitle("Ingresar");
        vent.setLocation(400,300);
        vent.setSize(1017, 615);
        vent.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_botoningresarActionPerformed

    private void botonconsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonconsultarActionPerformed
        ventconsultar vent= new ventconsultar();
        vent.setTitle("Consultar");
        vent.setLocation(400,300);
        vent.setSize(1168, 602);
        vent.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_botonconsultarActionPerformed

    private void botonmodificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonmodificarActionPerformed
        ventmodificar vent= new ventmodificar();
        vent.setTitle("Modificar");
        vent.setLocation(400,300);
        vent.setSize(1168, 800);
        vent.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_botonmodificarActionPerformed

    private void menuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuuActionPerformed
        ventnomina vent= new ventnomina();
        vent.setTitle("Menu");
        vent.setLocation(400,300);
        vent.setSize(860,660);
        vent.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_menuuActionPerformed

   
    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ventempleados().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonconsultar;
    private javax.swing.JButton botoneliminar;
    private javax.swing.JButton botoningresar;
    private javax.swing.JButton botonmodificar;
    private javax.swing.JButton menuu;
    private javax.swing.JPanel panel1;
    private javax.swing.JPanel panelbotones;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables
}

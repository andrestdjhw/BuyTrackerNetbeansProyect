/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package com.mycompany.examengrupal2doparcial;

import java.awt.Image;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import javax.swing.ImageIcon;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author David Rubio
 */
public class FrmCredito extends javax.swing.JInternalFrame {
    
    DefaultTableModel modelo = new DefaultTableModel(
    new Object[]{"ClienteID", "FechaCredito", "MontoCredito", "FechaDebito", "MontoDebito", "Saldo"}, 
    0
);

private java.sql.Date validarFecha(String valor, String nombreCampo) {
   
    System.out.println("Valor recibido en " + nombreCampo + ": [" + valor + "]");
    try {
        java.time.LocalDate fecha = java.time.LocalDate.parse(
            valor.trim(),
            java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd")
        );
        return java.sql.Date.valueOf(fecha);
    } catch (java.time.format.DateTimeParseException e) {
        throw new IllegalArgumentException(
            nombreCampo + " debe estar en formato YYYY-MM-DD y ser una fecha válida"
        );
    }
}

    private BigDecimal validarDecimal(String valor, String nombreCampo) {
        try {
            return new BigDecimal(valor);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(nombreCampo + " debe ser un número decimal");
        }
    }
    
    private boolean validarTexto(JTextField campo, String nombreCampo) {
    if (campo.getText().trim().isEmpty()) {
        JOptionPane.showMessageDialog(null, "El campo " + nombreCampo + " es obligatorio.");
        campo.requestFocus();
        return false;
    }
    return true;
}
   
private int validarEntero(String valor, String nombreCampo) {
    try {
        return Integer.parseInt(valor.trim());
    } catch (NumberFormatException e) {
        throw new IllegalArgumentException(nombreCampo + " debe ser un número entero válido.");
    }
}

    public FrmCredito() {
        initComponents();
        cargarClientes();
        
        
        CB_calcular.addItem("Debito");
        CB_calcular.addItem("Credito");
        CB_calcular.addItem("Saldo");
        
   Actualizar.setToolTipText("Actualizar registro");
   btnagregar.setToolTipText("Agregar Registro");
   btneditar.setToolTipText("Editar Registro");
   btneliminar.setToolTipText("Eliminar Registro");
   Limpiar.setToolTipText("Limpiar campos");
   
   ImageIcon iconoLimpiar = new ImageIcon(getClass().getResource("/Images/Limpiar.png"));
Image imgLimpiar = iconoLimpiar.getImage().getScaledInstance(
    Limpiar.getPreferredSize().width,
    Limpiar.getPreferredSize().height,
    Image.SCALE_SMOOTH
);
Limpiar.setIcon(new ImageIcon(imgLimpiar));
Limpiar.setToolTipText("Limpiar campos");
   
    ImageIcon iconoOriginal = new ImageIcon(getClass().getResource("/Images/Actualizar.png"));

    
    int ancho = Actualizar.getPreferredSize().width;
    int alto = Actualizar.getPreferredSize().height;

    Image imagenEscalada = iconoOriginal.getImage().getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);

    // Asignar el icono escalado al botón
    Actualizar.setIcon(new ImageIcon(imagenEscalada));


Actualizar.setIcon(new ImageIcon(imagenEscalada));
        
     CB_BuscarPor.removeAllItems();  
     CB_BuscarPor.addItem("Buscar por Fecha Credito");
     CB_BuscarPor.addItem("Buscar por Fecha Debito");
     CB_BuscarPor.addItem("Buscar por ID cliente");
        
     try {
        javax.swing.text.MaskFormatter mask = new javax.swing.text.MaskFormatter("####-##-##");
        mask.setPlaceholderCharacter('_');
        JFormattedTextField campoFecha = new JFormattedTextField(mask);

        campoFecha.setColumns(20);
        Panel_Formato.setLayout(new java.awt.BorderLayout());
        Panel_Formato.add(campoFecha, java.awt.BorderLayout.CENTER);

        Panel_Formato.revalidate();
        Panel_Formato.repaint();
    } catch (java.text.ParseException ex) {
        // Solo mostramos si realmente falla la máscara
        JOptionPane.showMessageDialog(this, "Error en la máscara de fecha: " + ex.getMessage());
    }

    }
    
    
    
     private void cargarClientes() {
    DefaultTableModel modelo = new DefaultTableModel();
    modelo.addColumn("ClienteID");
    modelo.addColumn("FechaCredito");
    modelo.addColumn("MontoCredito");
    modelo.addColumn("FechaDebito");
     modelo.addColumn("MontoDebito");
      modelo.addColumn("Saldo");

    try {
        ClsConexion miConexion = new ClsConexion();
        Connection conexion = miConexion.conectar();

        String sql = "SELECT ClienteID,FechaCredito , MontoCredito, FechaDebito, MontoDebito, Saldo FROM Creditos";
        Statement st = conexion.createStatement();
        ResultSet rs = st.executeQuery(sql);

        while (rs.next()) {
            modelo.addRow(new Object[]{
                rs.getInt("ClienteID"),
                rs.getString("FechaCredito"),
                rs.getString("MontoCredito"),
                rs.getString("FechaDebito"),
                rs.getString("MontoDebito"),
                rs.getString("Saldo")
            });
        }

        Datos.setModel(modelo);

    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al cargar clientes: " + ex.getMessage());
    }
}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtsaldo = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtClienteID = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnagregar = new javax.swing.JButton();
        btneliminar = new javax.swing.JButton();
        btneditar = new javax.swing.JButton();
        Actualizar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtcredito = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        Datos = new javax.swing.JTable();
        txtdebito = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtfechacredito = new javax.swing.JFormattedTextField();
        txtfechadebito = new javax.swing.JFormattedTextField();
        CB_BuscarPor = new javax.swing.JComboBox<>();
        Panel_Formato = new javax.swing.JPanel();
        BTN_Buscar = new javax.swing.JButton();
        BTN_CargarTodos = new javax.swing.JButton();
        Limpiar = new javax.swing.JButton();
        CB_calcular = new javax.swing.JComboBox<>();
        TXT_clienteid = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        LBL_total = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        BTN_calcular = new javax.swing.JButton();
        Monto_total = new javax.swing.JButton();

        setClosable(true);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder("Datos de Credito")));

        txtsaldo.addActionListener(this::txtsaldoActionPerformed);

        jLabel8.setText("Saldo:");

        txtClienteID.addActionListener(this::txtClienteIDActionPerformed);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("CREDITO");

        btnagregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Guardar.png"))); // NOI18N
        btnagregar.addActionListener(this::btnagregarActionPerformed);

        btneliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Borrar.png"))); // NOI18N
        btneliminar.addActionListener(this::btneliminarActionPerformed);

        btneditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Modificar.png"))); // NOI18N
        btneditar.addActionListener(this::btneditarActionPerformed);

        Actualizar.addActionListener(this::ActualizarActionPerformed);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btneditar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btneliminar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                    .addComponent(btnagregar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Actualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(btnagregar)
                .addGap(45, 45, 45)
                .addComponent(btneditar)
                .addGap(39, 39, 39)
                .addComponent(btneliminar)
                .addGap(18, 18, 18)
                .addComponent(Actualizar, javax.swing.GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE))
        );

        jLabel2.setText("Cliente ID");

        jLabel3.setText("Fecha Credito:");

        jLabel4.setText("Credito:");

        jLabel5.setText("Fecha Debito:");

        Datos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(Datos);

        jLabel6.setText("Debito:");

        try {
            txtfechacredito.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####-##-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            txtfechadebito.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####-##-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtfechadebito.addActionListener(this::txtfechadebitoActionPerformed);

        CB_BuscarPor.addActionListener(this::CB_BuscarPorActionPerformed);

        javax.swing.GroupLayout Panel_FormatoLayout = new javax.swing.GroupLayout(Panel_Formato);
        Panel_Formato.setLayout(Panel_FormatoLayout);
        Panel_FormatoLayout.setHorizontalGroup(
            Panel_FormatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 75, Short.MAX_VALUE)
        );
        Panel_FormatoLayout.setVerticalGroup(
            Panel_FormatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 36, Short.MAX_VALUE)
        );

        BTN_Buscar.setText("Buscar");
        BTN_Buscar.addActionListener(this::BTN_BuscarActionPerformed);

        BTN_CargarTodos.setText("Mostrar Todos");
        BTN_CargarTodos.addActionListener(this::BTN_CargarTodosActionPerformed);

        Limpiar.setText("jButton1");
        Limpiar.addActionListener(this::LimpiarActionPerformed);

        TXT_clienteid.addActionListener(this::TXT_clienteidActionPerformed);

        jLabel7.setText("Cliente ID:");

        LBL_total.setForeground(new java.awt.Color(255, 0, 51));
        LBL_total.setText("ND");

        jLabel10.setText("Total:");

        BTN_calcular.setText("Calcular monto Individual");
        BTN_calcular.addActionListener(this::BTN_calcularActionPerformed);

        Monto_total.setText("Calcular Monto total");
        Monto_total.addActionListener(this::Monto_totalActionPerformed);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(112, 112, 112))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(Limpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(475, 475, 475)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(558, 558, 558))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(290, 290, 290)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txtClienteID)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CB_BuscarPor, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(Panel_Formato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(92, 92, 92)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(BTN_Buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(BTN_CargarTodos))))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(txtfechacredito, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtcredito, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(CB_calcular, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(38, 38, 38))
                            .addComponent(Monto_total, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TXT_clienteid, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BTN_calcular)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(LBL_total)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(67, 67, 67)
                        .addComponent(jLabel8))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtfechadebito, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(txtdebito, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(txtsaldo, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(372, 372, 372))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(111, 111, 111)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Limpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(54, 54, 54)
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(LBL_total)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(TXT_clienteid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(CB_calcular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(BTN_calcular)
                                    .addComponent(Monto_total))
                                .addGap(36, 36, 36)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(28, 28, 28))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel8))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtcredito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtdebito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtsaldo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtfechacredito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtfechadebito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(CB_BuscarPor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Panel_Formato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(65, 65, 65)
                                .addComponent(BTN_Buscar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BTN_CargarTodos)
                                .addGap(0, 6, Short.MAX_VALUE)))
                        .addGap(45, 45, 45)
                        .addComponent(jLabel2)
                        .addGap(5, 5, 5)
                        .addComponent(txtClienteID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtClienteIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtClienteIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtClienteIDActionPerformed

    private void btneditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditarActionPerformed
       
    int filaSeleccionada = Datos.getSelectedRow();
    if (filaSeleccionada == -1) {
        JOptionPane.showMessageDialog(this, "Debe seleccionar una fila para editar.");
        return;
    }

    try {
        
        int clienteId = (int) Datos.getValueAt(filaSeleccionada, 0);

        
        ClsConexion miConexion = new ClsConexion();
        Connection conexion = miConexion.conectar();
        Statement st = conexion.createStatement();

        String sql = "SELECT ClienteID, FechaCredito, MontoCredito, FechaDebito, MontoDebito, Saldo " +
                     "FROM Creditos WHERE ClienteID = " + clienteId;

        ResultSet rs = st.executeQuery(sql);

        if (rs.next()) {
            
            Actualizar_credito frmActualizar = new Actualizar_credito();

            
            frmActualizar.setDatos(
                rs.getInt("ClienteID"),
                rs.getDate("FechaCredito"),
                rs.getBigDecimal("MontoCredito"),
                rs.getDate("FechaDebito"),
                rs.getBigDecimal("MontoDebito"),
                rs.getBigDecimal("Saldo")
            );

           
            frmActualizar.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "No se encontró el crédito en la base de datos.");
        }

    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(this, "Error al consultar la base de datos: " + ex.getMessage());
    }
    }//GEN-LAST:event_btneditarActionPerformed

    private void btnagregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnagregarActionPerformed

        
        try {
        if (txtClienteID.getText().trim().isEmpty() ||
            txtfechacredito.getText().trim().isEmpty() ||
            txtcredito.getText().trim().isEmpty() ||
            txtfechadebito.getText().trim().isEmpty() ||
            txtdebito.getText().trim().isEmpty() ||
            txtsaldo.getText().trim().isEmpty()) {
            
            JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios.");
            return;
        }

        
        int clienteId = validarEntero(txtClienteID.getText(), "ClienteID");
        java.sql.Date fechaCredito = validarFecha(txtfechacredito.getText(), "FechaCredito");
        BigDecimal montoCredito = validarDecimal(txtcredito.getText(), "MontoCredito");
        java.sql.Date fechaDebito = validarFecha(txtfechadebito.getText(), "FechaDebito");
        BigDecimal montoDebito = validarDecimal(txtdebito.getText(), "MontoDebito");
        BigDecimal saldo = validarDecimal(txtsaldo.getText(), "Saldo");

        
        java.util.List<String> columnas = java.util.List.of(
            "ClienteID", "FechaCredito", "MontoCredito",
            "FechaDebito", "MontoDebito", "Saldo"
        );

        java.util.List<Object> valores = java.util.List.of(
            clienteId, fechaCredito, montoCredito,
            fechaDebito, montoDebito, saldo
        );

        ClsConexion miConexion = new ClsConexion();
        Connection conexion = miConexion.conectar();
        InsertHelper insert = new InsertHelper();

        boolean ok = insert.insertar(conexion, "Creditos", columnas, valores);
        JOptionPane.showMessageDialog(null, ok ?
            "Crédito insertado correctamente." :
            "No se pudo insertar el crédito.");

    } catch (IllegalArgumentException ex) {
        JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error en la base de datos: " + ex.getMessage());
    }
    }//GEN-LAST:event_btnagregarActionPerformed

    private void txtfechadebitoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfechadebitoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtfechadebitoActionPerformed

    private void txtsaldoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtsaldoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtsaldoActionPerformed

    private void CB_BuscarPorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CB_BuscarPorActionPerformed
   Panel_Formato.removeAll();
    String opcion = (String) CB_BuscarPor.getSelectedItem();

    if ("Buscar por Fecha Credito".equals(opcion) || "Buscar por Fecha Debito".equals(opcion)) {
        try {
            javax.swing.text.MaskFormatter mask = new javax.swing.text.MaskFormatter("####-##-##");
            mask.setPlaceholderCharacter('_');
            JFormattedTextField campoFecha = new JFormattedTextField(mask);
            campoFecha.setColumns(10);
            Panel_Formato.add(campoFecha);
        } catch (java.text.ParseException ex) {
            JOptionPane.showMessageDialog(this, "Error en la máscara de fecha: " + ex.getMessage());
        }
    } else if ("Buscar por ID cliente".equals(opcion)) {
        JTextField campoTexto = new JTextField(15);
        Panel_Formato.add(campoTexto);
    }

    Panel_Formato.revalidate();
    Panel_Formato.repaint();

    }//GEN-LAST:event_CB_BuscarPorActionPerformed

    private void BTN_BuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_BuscarActionPerformed
    try {
        DefaultTableModel modelo = new DefaultTableModel(
            new Object[]{"ClienteID", "FechaCredito", "MontoCredito", "FechaDebito", "MontoDebito", "Saldo"}, 0
        );

        String opcion = (String) CB_BuscarPor.getSelectedItem();
        java.awt.Component comp = Panel_Formato.getComponent(0);

        ClsConexion miConexion = new ClsConexion();
        Connection conexion = miConexion.conectar();
        Statement st = conexion.createStatement();
        ResultSet rs = null;

        if ("Buscar por Fecha Credito".equals(opcion) && comp instanceof JFormattedTextField) {
            JFormattedTextField campoFecha = (JFormattedTextField) comp;
            if (!validarTexto(campoFecha, "Fecha Credito")) return;

            java.sql.Date fecha = validarFecha(campoFecha.getText(), "FechaCredito");

            String sql = "SELECT ClienteID, FechaCredito, MontoCredito, FechaDebito, MontoDebito, Saldo " +
                         "FROM Creditos WHERE FechaCredito = '" + fecha + "'";
            rs = st.executeQuery(sql);

        } else if ("Buscar por Fecha Debito".equals(opcion) && comp instanceof JFormattedTextField) {
            JFormattedTextField campoFecha = (JFormattedTextField) comp;
            if (!validarTexto(campoFecha, "Fecha Debito")) return;

            java.sql.Date fecha = validarFecha(campoFecha.getText(), "FechaDebito");

            String sql = "SELECT ClienteID, FechaCredito, MontoCredito, FechaDebito, MontoDebito, Saldo " +
                         "FROM Creditos WHERE FechaDebito = '" + fecha + "'";
            rs = st.executeQuery(sql);

        } else if ("Buscar por ID cliente".equals(opcion) && comp instanceof JTextField) {
            JTextField campoTexto = (JTextField) comp;
            if (!validarTexto(campoTexto, "ClienteID")) return;

            int clienteId = validarEntero(campoTexto.getText(), "ClienteID");

            String sql = "SELECT ClienteID, FechaCredito, MontoCredito, FechaDebito, MontoDebito, Saldo " +
                         "FROM Creditos WHERE ClienteID = " + clienteId;
            rs = st.executeQuery(sql);
        }

       
        while (rs != null && rs.next()) {
            modelo.addRow(new Object[]{
                rs.getInt("ClienteID"),
                rs.getDate("FechaCredito"),
                rs.getBigDecimal("MontoCredito"),
                rs.getDate("FechaDebito"),
                rs.getBigDecimal("MontoDebito"),
                rs.getBigDecimal("Saldo")
            });
        }

        Datos.setModel(modelo);

        
        if (Datos.getRowCount() > 0) {
            Datos.setRowSelectionInterval(0, 0);
        } else {
            JOptionPane.showMessageDialog(this, "No se encontraron resultados.");
        }

    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(this, "Error en la base de datos: " + ex.getMessage());
    } catch (IllegalArgumentException ex) {
        JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
    } catch (Exception ex) {
        JOptionPane.showMessageDialog(this, "Error inesperado: " + ex.getMessage());
    }
    }//GEN-LAST:event_BTN_BuscarActionPerformed

    private void BTN_CargarTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_CargarTodosActionPerformed
      cargarClientes();        
    }//GEN-LAST:event_BTN_CargarTodosActionPerformed

    private void btneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarActionPerformed
 
    int filaSeleccionada = Datos.getSelectedRow();
    if (filaSeleccionada == -1) {
        JOptionPane.showMessageDialog(this, "Debe seleccionar una fila para eliminar.");
        return;
    }


    int opcion = JOptionPane.showConfirmDialog(
        this,
        "¿Está seguro que desea eliminar el registro seleccionado?",
        "Confirmar eliminación",
        JOptionPane.YES_NO_OPTION
    );

    if (opcion == JOptionPane.YES_OPTION) {
        try {
            
            int clienteId = (int) Datos.getValueAt(filaSeleccionada, 0);   
            String fecha = (String) Datos.getValueAt(filaSeleccionada, 1); 

            ClsConexion miConexion = new ClsConexion();
            Connection conexion = miConexion.conectar();
            Statement st = conexion.createStatement();

            
            String sql = "DELETE FROM Creditos WHERE ClienteID = " + clienteId +
                         " AND FechaCredito = '" + fecha + "'";

            int filas = st.executeUpdate(sql);

            JOptionPane.showMessageDialog(this,
                filas > 0 ? "Registro eliminado correctamente." : "No se pudo eliminar el registro.");

         
            cargarClientes();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error en la base de datos: " + ex.getMessage());
        }
    }
    }//GEN-LAST:event_btneliminarActionPerformed

    private void ActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ActualizarActionPerformed
      cargarClientes();        
    }//GEN-LAST:event_ActualizarActionPerformed

    private void LimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LimpiarActionPerformed
            int opcion = JOptionPane.showConfirmDialog(
        this,
        "¿Está seguro que desea Limpiar todos los campos?",
        "Confirmar limpieza",
        JOptionPane.YES_NO_OPTION
    );

    if (opcion == JOptionPane.YES_OPTION) {
        txtClienteID.setText("");
        txtfechacredito.setText("");
        txtcredito.setText("");
        txtfechadebito.setText("");
        txtdebito.setText("");
        txtsaldo.setText("");
    }
    }//GEN-LAST:event_LimpiarActionPerformed

    private void TXT_clienteidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TXT_clienteidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TXT_clienteidActionPerformed

    private void BTN_calcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_calcularActionPerformed
      
    String idTexto = TXT_clienteid.getText().trim();
    if (idTexto.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Debe ingresar un ID de cliente.");
        return;
    }

    
    int clienteId;
    try {
        clienteId = Integer.parseInt(idTexto);
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "El ID debe ser un número entero.");
        return;
    }

    String opcion = CB_calcular.getSelectedItem().toString();

    String campo = "";
    switch (opcion.toLowerCase()) {
        case "debito":
            campo = "MontoDebito";
            break;
        case "credito":
            campo = "MontoCredito";
            break;
        case "saldo":
            campo = "Saldo";
            break;
        default:
            JOptionPane.showMessageDialog(this, "Opción no válida.");
            return;
    }

    String sql = "SELECT COALESCE(SUM(" + campo + "),0) AS total FROM Creditos WHERE ClienteID = ?";

    // Ejecutar la consulta con PreparedStatement
    try {
        ClsConexion miConexion = new ClsConexion();
        Connection conexion = miConexion.conectar();
        PreparedStatement ps = conexion.prepareStatement(sql);
        ps.setInt(1, clienteId);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            double total = rs.getDouble("total");
            LBL_total.setText(String.valueOf(total));
        } else {
            JOptionPane.showMessageDialog(this, "El cliente no existe o no tiene registros.");
        }

    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(this, "Error en la base de datos: " + ex.getMessage());
    }
    }//GEN-LAST:event_BTN_calcularActionPerformed

    private void Monto_totalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Monto_totalActionPerformed
            String opcion = CB_calcular.getSelectedItem().toString();

    // Determinar el campo a sumar
    String campo = "";
    switch (opcion.toLowerCase()) {
        case "debito":
            campo = "MontoDebito";
            break;
        case "credito":
            campo = "MontoCredito";
            break;
        case "saldo":
            campo = "Saldo";
            break;
        default:
            JOptionPane.showMessageDialog(this, "Opción no válida.");
            return;
    }

    String sql = "SELECT COALESCE(SUM(" + campo + "),0) AS total FROM Creditos";

    try (Connection conexion = new ClsConexion().conectar();
         Statement st = conexion.createStatement();
         ResultSet rs = st.executeQuery(sql)) {

        if (rs.next()) {
            double total = rs.getDouble("total");
            LBL_total.setText(String.valueOf(total));
        } else {
            JOptionPane.showMessageDialog(this, "No se encontraron registros.");
        }

    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(this, "Error en la base de datos: " + ex.getMessage());
    }
    }//GEN-LAST:event_Monto_totalActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Actualizar;
    private javax.swing.JButton BTN_Buscar;
    private javax.swing.JButton BTN_CargarTodos;
    private javax.swing.JButton BTN_calcular;
    private javax.swing.JComboBox<String> CB_BuscarPor;
    private javax.swing.JComboBox<String> CB_calcular;
    private javax.swing.JTable Datos;
    private javax.swing.JLabel LBL_total;
    private javax.swing.JButton Limpiar;
    private javax.swing.JButton Monto_total;
    private javax.swing.JPanel Panel_Formato;
    private javax.swing.JTextField TXT_clienteid;
    private javax.swing.JButton btnagregar;
    private javax.swing.JButton btneditar;
    private javax.swing.JButton btneliminar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtClienteID;
    private javax.swing.JTextField txtcredito;
    private javax.swing.JTextField txtdebito;
    private javax.swing.JFormattedTextField txtfechacredito;
    private javax.swing.JFormattedTextField txtfechadebito;
    private javax.swing.JTextField txtsaldo;
    // End of variables declaration//GEN-END:variables
}

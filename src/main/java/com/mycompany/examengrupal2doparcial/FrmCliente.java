/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package com.mycompany.examengrupal2doparcial;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class FrmCliente extends javax.swing.JInternalFrame {

    static void Dispose() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public FrmCliente() {
        initComponents();
        cargarClientes();
        cargarTotalClientes();
        
        CB_Buscador.addItem("Buscar por Nombre");
        CB_Buscador.addItem("Buscar por Codigo");
    }
    
private int clienteId; 

public void setClienteId(int id) {
    this.clienteId = id;
} 

private void buscarPorNombre(String nombre) {
    DefaultTableModel modelo = new DefaultTableModel();
    modelo.addColumn("ClienteID");
    modelo.addColumn("Nombre");
    modelo.addColumn("Teléfono");
    modelo.addColumn("ViaContacto");

    try {
        ClsConexion miConexion = new ClsConexion();
        Connection conexion = miConexion.conectar();

        String sql = "SELECT ClienteID, Nombre, Telefono, ViaContacto FROM Clientes WHERE Nombre LIKE ?";
        PreparedStatement ps = conexion.prepareStatement(sql);
        ps.setString(1, "%" + nombre + "%");
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            modelo.addRow(new Object[]{
                rs.getInt("ClienteID"),
                rs.getString("Nombre"),
                rs.getString("Telefono"),
                rs.getString("ViaContacto")
            });
        }

        Datos.setModel(modelo);

    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(this, "Error al buscar cliente por nombre: " + ex.getMessage());
    }
}

private void buscarPorCodigo(int codigo) {
    DefaultTableModel modelo = new DefaultTableModel();
    modelo.addColumn("ClienteID");
    modelo.addColumn("Nombre");
    modelo.addColumn("Teléfono");
    modelo.addColumn("ViaContacto");

    try {
        ClsConexion miConexion = new ClsConexion();
        Connection conexion = miConexion.conectar();

        String sql = "SELECT ClienteID, Nombre, Telefono, ViaContacto FROM Clientes WHERE ClienteID = ?";
        PreparedStatement ps = conexion.prepareStatement(sql);
        ps.setInt(1, codigo);
        ResultSet rs = ps.executeQuery();

        boolean encontrado = false;
        while (rs.next()) {
            encontrado = true;
            modelo.addRow(new Object[]{
                rs.getInt("ClienteID"),
                rs.getString("Nombre"),
                rs.getString("Telefono"),
                rs.getString("ViaContacto")
            });
        }

        if (!encontrado) {
            JOptionPane.showMessageDialog(this, "No se encontró ningún cliente con el código: " + codigo);
        }

        Datos.setModel(modelo);

    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(this, "Error al buscar cliente por código: " + ex.getMessage());
    }
}


private void cargarTotalClientes() {
    try {
        ClsConexion miConexion = new ClsConexion();
        Connection conexion = miConexion.conectar();

        String sql = "SELECT COUNT(*) AS total FROM Clientes";
        Statement st = conexion.createStatement();
        ResultSet rs = st.executeQuery(sql);

        if (rs.next()) {
            int total = rs.getInt("total");
            Total_clientes.setText(String.valueOf(total));
        }

    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(this, "Error al contar clientes: " + ex.getMessage());
    }
    Total_clientes.setEditable(false);
}

    
    private void cargarClientes() {
    DefaultTableModel modelo = new DefaultTableModel();
    modelo.addColumn("ClienteID");
    modelo.addColumn("Nombre");
    modelo.addColumn("Teléfono");
    modelo.addColumn("ViaContacto");

    try {
        ClsConexion miConexion = new ClsConexion();
        Connection conexion = miConexion.conectar();

        String sql = "SELECT ClienteID, Nombre, Telefono, ViaContacto FROM Clientes";
        Statement st = conexion.createStatement();
        ResultSet rs = st.executeQuery(sql);

        while (rs.next()) {
            modelo.addRow(new Object[]{
                rs.getInt("ClienteID"),
                rs.getString("Nombre"),
                rs.getString("Telefono"),
                rs.getString("ViaContacto")
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

        Jpanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Datos = new javax.swing.JTable();
        btn_nuevoCliente = new javax.swing.JButton();
        btn_eliminarCl = new javax.swing.JButton();
        Actualizar = new javax.swing.JButton();
        BTN_Editar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        Total_clientes = new javax.swing.JTextField();
        TXT_Buscar = new javax.swing.JTextField();
        CB_Buscador = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        Cargar_todos = new javax.swing.JButton();

        setClosable(true);

        Jpanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos del cliente"));

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

        btn_nuevoCliente.setText("Nuevo Cliente");
        btn_nuevoCliente.addActionListener(this::btn_nuevoClienteActionPerformed);

        btn_eliminarCl.setText("Eliminar Cliente");
        btn_eliminarCl.addActionListener(this::btn_eliminarClActionPerformed);

        Actualizar.setText("Actualizar ");
        Actualizar.addActionListener(this::ActualizarActionPerformed);

        BTN_Editar.setText("Editar");
        BTN_Editar.addActionListener(this::BTN_EditarActionPerformed);

        jLabel1.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabel1.setText("Total Clientes:");

        Total_clientes.setBorder(null);

        CB_Buscador.addActionListener(this::CB_BuscadorActionPerformed);

        jButton1.setText("Buscar");
        jButton1.addActionListener(this::jButton1ActionPerformed);

        jLabel2.setForeground(new java.awt.Color(255, 0, 0));
        jLabel2.setText("(Porfavor, tomar en cuenta acento en nombres)");

        Cargar_todos.setText("Cargar todos");
        Cargar_todos.addActionListener(this::Cargar_todosActionPerformed);

        javax.swing.GroupLayout JpanelLayout = new javax.swing.GroupLayout(Jpanel);
        Jpanel.setLayout(JpanelLayout);
        JpanelLayout.setHorizontalGroup(
            JpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpanelLayout.createSequentialGroup()
                .addGroup(JpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JpanelLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(btn_nuevoCliente)
                        .addGap(18, 18, 18)
                        .addComponent(btn_eliminarCl)
                        .addGap(18, 18, 18)
                        .addComponent(Actualizar)
                        .addGap(18, 18, 18)
                        .addComponent(BTN_Editar)
                        .addGap(62, 62, 62)
                        .addComponent(CB_Buscador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(JpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TXT_Buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(JpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Cargar_todos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(JpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(JpanelLayout.createSequentialGroup()
                                .addGap(102, 102, 102)
                                .addComponent(Total_clientes, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JpanelLayout.createSequentialGroup()
                                .addGap(72, 72, 72)
                                .addComponent(jLabel1))))
                    .addGroup(JpanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1453, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        JpanelLayout.setVerticalGroup(
            JpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpanelLayout.createSequentialGroup()
                .addGroup(JpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JpanelLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(JpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_nuevoCliente)
                            .addComponent(btn_eliminarCl)
                            .addComponent(Actualizar)
                            .addComponent(BTN_Editar))
                        .addGap(18, 18, 18))
                    .addGroup(JpanelLayout.createSequentialGroup()
                        .addGap(0, 15, Short.MAX_VALUE)
                        .addGroup(JpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jButton1)
                                .addComponent(jLabel1))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(TXT_Buscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(CB_Buscador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(JpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(Cargar_todos)
                            .addComponent(Total_clientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 551, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Jpanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Jpanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_eliminarClActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminarClActionPerformed
         int fila = Datos.getSelectedRow();
    if (fila == -1) {
        JOptionPane.showMessageDialog(null, "Seleccione un cliente primero.");
        return;
    }

    
    int clienteId = Integer.parseInt(Datos.getValueAt(fila, 0).toString());

    // Mostrar confirmación
    int opcion = JOptionPane.showConfirmDialog(
        null,
        "¿Deseas eliminar este cliente?",
        "Confirmar eliminación",
        JOptionPane.YES_NO_OPTION
    );

    if (opcion == JOptionPane.YES_OPTION) {
        try {
            ClsConexion miConexion = new ClsConexion();
            Connection conexion = miConexion.conectar();

            String sql = "DELETE FROM Clientes WHERE ClienteID = ?";
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, clienteId);

            int filasAfectadas = ps.executeUpdate();
            if (filasAfectadas > 0) {
                DefaultTableModel modelo = (DefaultTableModel) Datos.getModel();
                modelo.removeRow(fila);
                JOptionPane.showMessageDialog(null, "Cliente eliminado correctamente.");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró el cliente en la base de datos.");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al eliminar cliente: " + ex.getMessage());
        }
    }
    }//GEN-LAST:event_btn_eliminarClActionPerformed

    private void btn_nuevoClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nuevoClienteActionPerformed
        Nuevo_cliente frmcliente = new Nuevo_cliente();
        frmcliente.setVisible(true);
    }//GEN-LAST:event_btn_nuevoClienteActionPerformed

    private void ActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ActualizarActionPerformed
        cargarClientes();
        cargarTotalClientes();
    }//GEN-LAST:event_ActualizarActionPerformed

    private void BTN_EditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_EditarActionPerformed
    int fila = Datos.getSelectedRow();

    if (fila == -1) {
        JOptionPane.showMessageDialog(this, "Debe seleccionar una fila antes de editar.");
        return;
    }

    int clienteId   = Integer.parseInt(Datos.getValueAt(fila, 0).toString());
    String nombre   = Datos.getValueAt(fila, 1).toString();
    String telefono = Datos.getValueAt(fila, 2).toString();
    String via      = Datos.getValueAt(fila, 3).toString();

    Actualizar_Cliente frm = new Actualizar_Cliente(clienteId, nombre, telefono, via);
    frm.setVisible(true);
    }//GEN-LAST:event_BTN_EditarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    String opcion = (String) CB_Buscador.getSelectedItem();
    String valor = TXT_Buscar.getText().trim();

    
    if (valor.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Debe ingresar un valor para buscar.");
        return;
    }

    if ("Buscar por Nombre".equals(opcion)) {
        buscarPorNombre(valor);
    } else if ("Buscar por Codigo".equals(opcion)) {
        try {
            int codigo = Integer.parseInt(valor); 
            buscarPorCodigo(codigo);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "El código debe ser un número válido.");
        }
    }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void CB_BuscadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CB_BuscadorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CB_BuscadorActionPerformed

    private void Cargar_todosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cargar_todosActionPerformed
       cargarClientes();
    }//GEN-LAST:event_Cargar_todosActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Actualizar;
    private javax.swing.JButton BTN_Editar;
    private javax.swing.JComboBox<String> CB_Buscador;
    private javax.swing.JButton Cargar_todos;
    private javax.swing.JTable Datos;
    private javax.swing.JPanel Jpanel;
    private javax.swing.JTextField TXT_Buscar;
    private javax.swing.JTextField Total_clientes;
    private javax.swing.JButton btn_eliminarCl;
    private javax.swing.JButton btn_nuevoCliente;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.examengrupal2doparcial;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class InsertHelper {

    public boolean insertar(Connection conexion, String tabla, List<String> columnas, List<Object> valores) throws SQLException {
        if (columnas.size() != valores.size()) {
            throw new IllegalArgumentException("Columnas y valores deben tener el mismo tamaño");
        }

        
        StringBuilder sql = new StringBuilder("INSERT INTO ");
        sql.append(tabla).append(" (");
        sql.append(String.join(", ", columnas));
        sql.append(") VALUES (");
        sql.append("?,".repeat(valores.size()));
        sql.setLength(sql.length() - 1); 
        sql.append(")");

        PreparedStatement ps = conexion.prepareStatement(sql.toString());

        for (int i = 0; i < valores.size(); i++) {
            ps.setObject(i + 1, valores.get(i));
        }

        int filas = ps.executeUpdate();
        return filas > 0;
    }
}

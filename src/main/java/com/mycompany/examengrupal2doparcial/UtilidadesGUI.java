/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.examengrupal2doparcial;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.lang.reflect.Field;
import javax.swing.*;

public class UtilidadesGUI {

//Esta funcion la cree para formularios grandes, para obtener el nombre(no valor) de las variables y procesarlas rapido
public class ListarCampos {
    public static void listarTextFields(Object objeto) {
        for (Field f : objeto.getClass().getDeclaredFields()) {
            if (JTextField.class.isAssignableFrom(f.getType())) {
                System.out.println("Variable: " + f.getName());
            }
        }
    }
}

}


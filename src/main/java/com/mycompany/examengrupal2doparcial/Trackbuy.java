package com.mycompany.examengrupal2doparcial;

import com.formdev.flatlaf.FlatDarkLaf;

/**
 *
 * @author David Rubio
 */
public class Trackbuy {

    public static void main(String[] args) {
        // Aplicar FlatDarkLaf antes de crear cualquier componente Swing.
        // Cambia a FlatLightLaf.setup() si prefieres tema claro.
        FlatDarkLaf.setup();

        System.out.println("Hello World!");
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run(){
                new FrmLogin().setVisible(true);
            }
        });
    }
}
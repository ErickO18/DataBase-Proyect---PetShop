package com.mycompany.petssystem;

import com.mycompany.petssystem.gui.Desktop;
import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;




public class PetsSystem {

    public static void main(String[] args){
        
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");

            Color fondoPrincipal = new Color(28, 28, 30); 
            Color fondoSecundario = new Color(45, 45, 48); 
            Color Amarillo = new Color(255, 215, 0);  
            Color oro = new Color(255, 235, 120); 

            UIManager.put("control", fondoPrincipal);
            UIManager.put("info", fondoPrincipal);
            UIManager.put("nimbusBase", fondoPrincipal);
            UIManager.put("nimbusLightBackground", fondoSecundario);
            UIManager.put("MenuBar.background", fondoPrincipal);
            UIManager.put("Menu.background", fondoPrincipal);

            UIManager.put("text", Amarillo); 
            UIManager.put("nimbusSelectedText", Color.BLACK); 
            UIManager.put("nimbusSelectionBackground", Amarillo); 
            UIManager.put("nimbusFocus", oro);

            UIManager.put("nimbusAlertYellow", oro);
            UIManager.put("nimbusDisabledText", new Color(90, 90, 95));
            UIManager.put("nimbusOrange", new Color(218, 165, 32));
            UIManager.put("nimbusRed", new Color(160, 60, 60));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
        SwingUtilities.invokeLater(() -> new Desktop().setVisible(true));
    }
}

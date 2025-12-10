package org.example.crud.gui;

import javax.swing.*;

public class MainFrame extends JFrame{
    private JPanel mainPanel;
    private JTextField titulo;
    private JTextField director;
    private JTextField anio;
    private JTextField id;
    private JButton btnGuardar;
    private JButton btnActualizar;
    private JButton bntEliminar;
    private JButton btnLimpiar;
    private JTable table1;

    public MainFrame() {
        setContentPane(mainPanel);
        setTitle("Netflix ESPE - Gestión de Películas");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

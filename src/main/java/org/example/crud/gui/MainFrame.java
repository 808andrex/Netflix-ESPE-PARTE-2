package org.example.crud.gui;

import javax.swing.*;

public class MainFrame extends JFrame{

    public MainFrame() {
        setContentPane(mianPanel);
        pack();
        setSize(500, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private JPanel mianPanel;
    private JTextField titulo;
    private JTextField director;
    private JTextField anio;
    private JTextField id;
    private JButton btnGuardar;
    private JButton btnActualizar;
    private JButton bntEliminar;
    private JButton btnLimpiar;
    private JTable table1;
}

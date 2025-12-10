package org.example.crud.gui;

import org.example.crud.dao.PeliculaDAO;
import org.example.crud.model.Pelicula;

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
    private PeliculaDAO peliculaDAO;

    public MainFrame() {
        setContentPane(mainPanel);
        setTitle("Netflix ESPE - Gestión de Películas");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.peliculaDAO = new PeliculaDAO();
        btnGuardar.addActionListener(e -> guardarPelicula());
    }

    private void guardarPelicula(){
        try{
            String tit = titulo.getText();
            String dir = director.getText();
            int anioInt = Integer.parseInt(anio.getText());

            Pelicula peli = new Pelicula(tit,dir,anioInt);

            titulo.setText("");
            director.setText("");
            anio.setText("");
        }catch(Exception ex){
            JOptionPane.showMessageDialog(this, "Error "+ex.getMessage());
        }
    }
}

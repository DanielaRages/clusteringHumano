package Interfaz;

//ANOTACIONES:
//CUANDO LOS DATOS LOS GUARDOS EN UNA TABLA, TENGO QUE IMPLEMENTAR TMB QUE ALMACENE ESO EN LA PARTE LOGICA (QUE CREE LA PERSONA)
//CUANDO DE CLICK EN GUARDAR QUE RESETEE LOS DATOS --- ya est�
//HACER CONTADOR, CUANDO LLEGUE A LA CANTIDAD GUARDADA DESEADA, DESHABILITAR EL BOTON Y HABILITAR VER GRAFO
//		ARREGLAR ESTO

import Logica.Grafo;
import Logica.Persona;
import Logica.Prim;

import java.lang.Object;
import java.awt.EventQueue;

import java.nio.charset.StandardCharsets;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import java.awt.Color;



@SuppressWarnings("serial")
public class cargaDePersonas extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNombre;
	JComboBox <String>comboBoxDeportes = new JComboBox<String>();
	JComboBox <String>comboBoxMusica = new JComboBox<String>();
	JComboBox <String>comboBoxEspectaculo = new JComboBox<String>();
	JComboBox <String>comboBoxCiencia = new JComboBox<String>();
	JButton btnGenerarGrafo = new JButton("Generar Grafo");
	JButton btnGuardar = new JButton("Guardar"); 
	String [] opciones;
	Object [] datosFilas;
	String nombre;
	int deporte;
	int musica;
	int espectaculo;
	int ciencia;
	private JTable table;
	int contador;
	private gruposFormados gruposFormados;


	public cargaDePersonas(Grafo grafo) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 250, 1050, 500); //ver despues de centrarlo bien
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Ingrese nombre y apellido:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(38, 56, 167, 27);
		contentPane.add(lblNewLabel);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(220, 58, 247, 27);
		contentPane.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Seleccione un valor del 1 al 5 para las siguientes caracteristicas:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(38, 108, 461, 40);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Interes por los deportes:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(38, 168, 148, 27);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Interes por la musica:");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2_1.setBounds(38, 217, 148, 27);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Interes por las noticias del espectaculo:");
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2_1_1.setBounds(38, 266, 220, 27);
		contentPane.add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_2_1_2 = new JLabel("Interes por la ciencia:");
		lblNewLabel_2_1_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2_1_2.setBounds(38, 318, 148, 27);
		contentPane.add(lblNewLabel_2_1_2);
		
		String [] opciones = new String[] {"1", "2", "3", "4", "5"};
		comboBoxDeportes.setBounds(426, 171, 41, 22);
		comboBoxDeportes.setModel(new DefaultComboBoxModel<String>(opciones));
		contentPane.add(comboBoxDeportes);
		
		comboBoxMusica.setBounds(426, 217, 41, 22);
		comboBoxMusica.setModel(new DefaultComboBoxModel<String>(opciones));
		contentPane.add(comboBoxMusica);
		
		comboBoxEspectaculo.setBounds(426, 266, 41, 22);
		comboBoxEspectaculo.setModel(new DefaultComboBoxModel<String>(opciones));
		contentPane.add(comboBoxEspectaculo);
		
		comboBoxCiencia.setBounds(426, 318, 41, 22);
		comboBoxCiencia.setModel(new DefaultComboBoxModel<String>(opciones));
		contentPane.add(comboBoxCiencia);
		
		btnGenerarGrafo.setBounds(699, 381, 135, 23);
		btnGenerarGrafo.setVisible(false);
		contentPane.add(btnGenerarGrafo);
		btnGenerarGrafo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				grafo.GenerarGrafo();
				Prim arbolG = new Prim(grafo);
				Grafo nuevoGrafo = arbolG.ArmarArbol(arbolG.ListaAristas(grafo));
				
				gruposFormados = new gruposFormados(nuevoGrafo);
				gruposFormados.setVisible(true);
			}
		});
			
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(498, 56, 514, 302);
		contentPane.add(scrollPane);
		
		table = new JTable(); //-------------------- TABLA
		table.setRowSelectionAllowed(false);
		scrollPane.setViewportView(table);
		table.getTableHeader().setReorderingAllowed(false) ; //desabilitar mover columnas
		
		DefaultTableModel modelo = new DefaultTableModel();
		
		modelo.addColumn("Nombre");
		modelo.addColumn("Deportes");
		modelo.addColumn("Musica");
		modelo.addColumn("Espectaculo");
		modelo.addColumn("Ciencia");
		
		table.setModel(modelo);
      
		btnGuardar.setBounds(220, 381, 89, 23);
		contentPane.add(btnGuardar);

		btnGuardar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (textFieldNombre.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "El campo no debe estar vac�o.");}
                else if (textFieldNombre.getText().length() <= 2){
                    JOptionPane.showMessageDialog(null, "Ingrese un nombre y apellido v�lidos. "); }
                else if (esDigito(textFieldNombre.getText())){
                    JOptionPane.showMessageDialog(null, "No debe de contener n�meros."); }
                else {
                    guardarDatos();
                    cargaPersonasAGrafo(modelo, grafo, btnGuardar, btnGenerarGrafo);
                    if (contador == grafo.getCantidadVertices()) {
                        btnGuardar.setVisible(false);
                        btnGenerarGrafo.setVisible(true);
                        textFieldNombre.setEditable(false);
                    }
                }
            }
        });
	}

		private void guardarDatos() {//guarda los datos para crear el objeto Persona
			nombre = textFieldNombre.getText();
			deporte = Integer.parseInt((String)comboBoxDeportes.getSelectedItem());
			musica = Integer.parseInt((String)comboBoxMusica.getSelectedItem());
			espectaculo = Integer.parseInt((String)comboBoxEspectaculo.getSelectedItem());
			ciencia = Integer.parseInt((String)comboBoxCiencia.getSelectedItem());		 	
		}

		
		private void cargarTabla(DefaultTableModel modelo) {
			
			datosFilas = new Object[5]; 
			datosFilas[0] = textFieldNombre.getText();
			datosFilas[1] = comboBoxDeportes.getSelectedItem();
			datosFilas[2] = comboBoxMusica.getSelectedItem();
			datosFilas[3] = comboBoxEspectaculo.getSelectedItem();
			datosFilas[4] = comboBoxCiencia.getSelectedItem();
			
			modelo.addRow(datosFilas);		
		}
		
		private void limpiarDatos() { //limpia los datos por afuera cada vez que se da al boton de guardar
			textFieldNombre.setText("");
			comboBoxDeportes.setSelectedIndex(0);
			comboBoxMusica.setSelectedIndex(0);
			comboBoxEspectaculo.setSelectedIndex(0);
			comboBoxCiencia.setSelectedIndex(0);		
		}
			
		private static boolean esDigito(String str) { //true = hay al menos un numero en el string
			for (int i = 0; i < str.length(); i++) {
				char c = str.charAt(i);
				if (Character.isDigit(c))
			 		return true;
	   }
		return false;
	}
		
		private void cargaPersonasAGrafo(DefaultTableModel modelo, Grafo grafo, JButton guardar, JButton btnGenerarGrafo) {
            Persona p = new Persona(nombre, deporte, musica, espectaculo, ciencia);
            if (grafo.personaRepetida(p)){
                JOptionPane.showMessageDialog(null, "No puede agregar personas con el mismo nombre y valores."); }
            else {
            grafo.agregarPersona(p);
            cargarTabla(modelo);
            limpiarDatos();
            contador++;
            }
    }

		
	
}

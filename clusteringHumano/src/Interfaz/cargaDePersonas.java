package Interfaz;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import Logica.Grafo;
import Logica.Persona;
import Logica.Prim;

@SuppressWarnings("serial")
public class cargaDePersonas extends JFrame {

	//VARIABLES
	private JPanel contentPane;
	private JTextField textFieldNombre;
	JComboBox <String>comboBoxDeportes;
	JComboBox <String>comboBoxMusica;
	JComboBox <String>comboBoxEspectaculo;
	JComboBox <String>comboBoxCiencia;
	JButton btnGenerarGrafo;
	JButton btnGuardar; 
	String [] opciones;
	Object [] datosFilas;
	String nombre;
	int contador;
	int deporte;
	int musica;
	int espectaculo;
	int ciencia;
	private gruposFormados gruposFormados;
	private JTable table;
	
	//INICIALIZA EL PANEL DONDE CARGA LAS PERSONAS
	public cargaDePersonas(Grafo grafo) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 250, 1050, 500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setLocationRelativeTo(null);
		
		comboBoxDeportes = new JComboBox<String>();
		comboBoxMusica = new JComboBox<String>();
		comboBoxEspectaculo = new JComboBox<String>();
		comboBoxCiencia = new JComboBox<String>();
		
		btnGenerarGrafo = new JButton("Generar Grafo");
		btnGuardar = new JButton("Guardar"); 
		
		JLabel ingresarNombre = new JLabel("Ingrese nombre y apellido:");
		ingresarNombre.setFont(new Font("Tahoma", Font.BOLD, 14));
		ingresarNombre.setBounds(38, 56, 204, 27);
		contentPane.add(ingresarNombre);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(262, 58, 205, 27);
		contentPane.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		JLabel seleccionarValor = new JLabel("Seleccione un valor del 1 al 5 para las siguientes características:");
		seleccionarValor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		seleccionarValor.setBounds(38, 112, 394, 36);
		contentPane.add(seleccionarValor);
		
		JLabel lblIntDep = new JLabel("Interés por los deportes:");
		lblIntDep.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblIntDep.setBounds(38, 168, 148, 27);
		contentPane.add(lblIntDep);
		
		JLabel lblIntMus = new JLabel("Interés por la música:");
		lblIntMus.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblIntMus.setBounds(38, 217, 148, 27);
		contentPane.add(lblIntMus);
		
		JLabel lblIntEsp = new JLabel("Interés por las noticias del espectáculo:");
		lblIntEsp.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblIntEsp.setBounds(38, 263, 256, 27);
		contentPane.add(lblIntEsp);
		
		JLabel lblIntCien = new JLabel("Interés por la ciencia:");
		lblIntCien.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblIntCien.setBounds(38, 315, 159, 27);
		contentPane.add(lblIntCien);
		
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
		
		//TABLA DE DATOS
		table = new JTable(); 
		table.setRowSelectionAllowed(false);
		scrollPane.setViewportView(table);
		table.getTableHeader().setReorderingAllowed(false) ; 
		
		DefaultTableModel modelo = new DefaultTableModel();
		
		modelo.addColumn("Nombre");
		modelo.addColumn("Deportes");
		modelo.addColumn("Música");
		modelo.addColumn("Espectáculo");
		modelo.addColumn("Ciencia");
		
		table.setModel(modelo);
      
		btnGuardar.setBounds(220, 381, 89, 23);
		contentPane.add(btnGuardar);

		btnGuardar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (textFieldNombre.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "El campo no debe estar vacío.");}
                else if (textFieldNombre.getText().length() <= 2){
                    JOptionPane.showMessageDialog(null, "Ingrese un nombre y apellido válidos."); }
                else if (esDigito(textFieldNombre.getText())){
                    JOptionPane.showMessageDialog(null, "No debe de contener números."); }
                else {
                    guardarDatos();
                    cargaPersonasAGrafo(modelo, grafo, btnGuardar, btnGenerarGrafo);
                    textFieldNombre.requestFocus();
                    if (contador == grafo.getCantidadVertices()) {
                        btnGuardar.setVisible(false);
                        btnGenerarGrafo.setVisible(true);
                        textFieldNombre.setEditable(false);
                        comboBoxDeportes.setEnabled(false);
                    	comboBoxMusica.setEnabled(false);
                    	comboBoxEspectaculo.setEnabled(false);
                    	comboBoxCiencia.setEnabled(false);
                    }
                }
            }
        });
	}
	
	//GUARDA LOS DATOS INGRESADOS
	private void guardarDatos() {
		nombre = textFieldNombre.getText();
		deporte = Integer.parseInt((String)comboBoxDeportes.getSelectedItem());
		musica = Integer.parseInt((String)comboBoxMusica.getSelectedItem());
		espectaculo = Integer.parseInt((String)comboBoxEspectaculo.getSelectedItem());
		ciencia = Integer.parseInt((String)comboBoxCiencia.getSelectedItem());		 	
	}

	//AÑADE LOS DATOS A LA TABLA
	private void cargarTabla(DefaultTableModel modelo) {
			
		datosFilas = new Object[5]; 
		datosFilas[0] = textFieldNombre.getText();
		datosFilas[1] = comboBoxDeportes.getSelectedItem();
		datosFilas[2] = comboBoxMusica.getSelectedItem();
		datosFilas[3] = comboBoxEspectaculo.getSelectedItem();
		datosFilas[4] = comboBoxCiencia.getSelectedItem();
		
		modelo.addRow(datosFilas);		
	}

	//LIMPIA LOS DATOS DE LOS COMPONENTES AL PRESIONAR GUARDAR
	private void limpiarDatos() { 
		textFieldNombre.setText("");
		comboBoxDeportes.setSelectedIndex(0);
		comboBoxMusica.setSelectedIndex(0);
		comboBoxEspectaculo.setSelectedIndex(0);
		comboBoxCiencia.setSelectedIndex(0);		
	}

	//VERIFICA SI HAY UN NÚMERO EN EL NOMBRE
	private static boolean esDigito(String str) { 
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (Character.isDigit(c))
		 		return true;
		}
		return false;
	}
		
	//GUARDA LA INFORMACIÓN EN EL GRAFO
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

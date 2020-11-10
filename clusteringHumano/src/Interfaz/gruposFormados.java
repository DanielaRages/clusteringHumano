package Interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Logica.Arista;
import Logica.BFS;
import Logica.Grafo;
import Logica.Persona;
import Logica.Prim;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Set;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JSeparator;
import javax.swing.JEditorPane;
import java.awt.Color;
import javax.swing.JTable;

@SuppressWarnings("serial")
public class gruposFormados extends JFrame {

	private JPanel contentPane;
	private JTable tablaGrupo1;
	private JTable tablaGrupo2;
	ArrayList<Persona> ListaPersonas1;
	ArrayList<Persona> ListaPersonas2;
	Object [] datosFinalesLista1;
	Object [] datosFinalesLista2;
	
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					gruposFormados frame = new gruposFormados(grafo);
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public gruposFormados(Grafo grafo) {
		
		//Se genera Arbol Generador Minimo
		Grafo nuevoGrafo = grafo;
		nuevoGrafo.eliminarAristaMax();
		Set<Integer> grupo1 = BFS.alcanzables(nuevoGrafo, nuevoGrafo.posPersona(nuevoGrafo.getAristaEliminar().getPersona1()));
		Set<Integer> grupo2 = BFS.alcanzables(nuevoGrafo, nuevoGrafo.posPersona(nuevoGrafo.getAristaEliminar().getPersona2()));
		
		ListaPersonas1 = nuevoGrafo.listaPersonas(grupo1);
		ListaPersonas2 = nuevoGrafo.listaPersonas(grupo2);
		

		
//----------------------------------------------------------------------------------------------------
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(680, 250, 600, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("GRUPO 1");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(60, 16, 159, 41);
		contentPane.add(lblNewLabel);
		
		JLabel lblGrupo = new JLabel("GRUPO 2");
		lblGrupo.setHorizontalAlignment(SwingConstants.CENTER);
		lblGrupo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblGrupo.setBounds(345, 16, 159, 41);
		contentPane.add(lblGrupo);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setForeground(Color.BLACK);
		separator.setBounds(296, 0, 2, 461);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.BLACK);
		separator_1.setBounds(0, 68, 584, 2);
		contentPane.add(separator_1);
		
		tablaGrupo1 = new JTable();
		tablaGrupo1.setBounds(10, 76, 280, 374);
		contentPane.add(tablaGrupo1);
		
		tablaGrupo2 = new JTable();
		tablaGrupo2.setBounds(296, 81, 288, 374);
		contentPane.add(tablaGrupo2);

		DefaultTableModel modeloTabla1 = new DefaultTableModel();
		//.addRow(datosFinalesLista1);
		//tablaGrupo1.setModel(modeloTabla1);
		
		DefaultTableModel modeloTabla2 = new DefaultTableModel();
		modeloTabla2.addRow(datosFinalesLista2);
		tablaGrupo2.setModel(modeloTabla2);
		
		imprimirDatos(ListaPersonas1, ListaPersonas2, modeloTabla1, modeloTabla2);
		
		//DefaultTableModel modeloTabla1 = new DefaultTableModel();
		//modelo.addRow(rowData); //añadir aca de forma horizontal los nombres de los grupos (para eso tendria que tener un array de object con los nombres)
		//tablaGrupo1.setModel(modelo);
	}
	
	private void imprimirDatos(ArrayList<Persona> p1, ArrayList<Persona> p2, DefaultTableModel modeloTabla1, DefaultTableModel modeloTabla2  ) {
		datosFinalesLista1 = new Object [1];
		datosFinalesLista2 = new Object[1];
		for (Persona p : p1) 
			//modeloTabla1(p.getNombre().toString());
		//	for (int i = 0; i < datosFinalesLista1.length; i++) {
				//modeloTabla1.add(p.getNombre().toString());
				datosFinalesLista1[0] = p.getNombre();	
				//modeloTabla1.addColumn(datosFinalesLista1);
				//modeloTabla1.addRow(datosFinalesLista1[i]);
				//modeloTabla1.addColumn(datosFinalesLista1);
				System.out.println("nombres l1: " + datosFinalesLista1[0]);
		//	}
			//	modeloTabla1.addColumn(datosFinalesLista1);
				modeloTabla1.addRow(datosFinalesLista1);
				tablaGrupo1.setModel(modeloTabla1);
		
		for (Persona p: p2) 
				datosFinalesLista2[0] = p.getNombre();	
				System.out.println("nombres l2: " + datosFinalesLista2[0]);
		
			//	modeloTabla1.addColumn(datosFinalesLista2);
				modeloTabla2.addRow(datosFinalesLista2);
				tablaGrupo2.setModel(modeloTabla2);
	}
}

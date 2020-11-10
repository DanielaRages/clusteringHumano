package Interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

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
	private ArrayList<Persona> grupo1;
	private ArrayList<Persona> grupo2;
	Prim arbolG;
	Grafo nuevoGrafo;
	BFS bfs;

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
		
		bfs = new BFS();
		arbolG = new Prim(grafo);	
		nuevoGrafo = arbolG.ArmarArbol(arbolG.ListaAristas(grafo));
		nuevoGrafo.eliminarAristaMax();
		
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
		
		DefaultTableModel modelo = new DefaultTableModel();
		//modelo.addRow(rowData); //añadir aca de forma horizontal los nombres de los grupos (para eso tendria que tener un array de object con los nombres)
		//tablaGrupo1.setModel(modelo);
		
		tablaGrupo2 = new JTable();
		tablaGrupo2.setBounds(296, 76, 280, 374);
		contentPane.add(tablaGrupo2);
	}
}

package Interfaz;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Logica.BFS;
import Logica.Grafo;
import Logica.Persona;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Set;
import javax.swing.DefaultListModel;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.JList;
import javax.swing.UIManager;

@SuppressWarnings("serial")
public class gruposFormados extends JFrame {

	private JPanel contentPane;
	ArrayList<Persona> ListaPersonas1;
	ArrayList<Persona> ListaPersonas2;


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
		
		JList<String> lista1 = new JList<String>(); //Lista para grupo 1
		lista1.setBackground(UIManager.getColor("Button.background"));
		lista1.setBounds(23, 95, 240, 344);
		contentPane.add(lista1);
		lista1.setModel(modelList(ListaPersonas1));
		
		JList<String> lista2 = new JList<String>(); //Lista para grupo 2
		lista2.setBackground(UIManager.getColor("Button.background"));
		lista2.setBounds(308, 95, 266, 344);
		contentPane.add(lista2);
		lista2.setModel(modelList(ListaPersonas2));
	}
	
	private DefaultListModel <String> modelList (ArrayList<Persona> array){
		 DefaultListModel <String> model = new DefaultListModel<>();
		 for (Persona p: array) {
			model.addElement(p.getNombre());
		 }
		 return model;
	}
	

}

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
import java.awt.SystemColor;

@SuppressWarnings("serial")
public class gruposFormados extends JFrame {

	//VARIABLES
	private JPanel contentPane;
	ArrayList<Persona> ListaPersonas1;
	ArrayList<Persona> ListaPersonas2;

	//CONSTRUYE LOS GRUPOS
	public gruposFormados(Grafo grafo) {
		
		//SE CREA EL ÁRBOL GENERADOR MÍNIMO
		Grafo nuevoGrafo = grafo;
		nuevoGrafo.eliminarAristaMax();
		Set<Integer> grupo1 = BFS.alcanzables(nuevoGrafo, nuevoGrafo.posPersona(nuevoGrafo.getAristaEliminar().getPersona1()));
		Set<Integer> grupo2 = BFS.alcanzables(nuevoGrafo, nuevoGrafo.posPersona(nuevoGrafo.getAristaEliminar().getPersona2()));
		
		ListaPersonas1 = nuevoGrafo.listaPersonas(grupo1);
		ListaPersonas2 = nuevoGrafo.listaPersonas(grupo2);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 160, 600, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblGrupo1 = new JLabel("GRUPO 1");
		lblGrupo1.setBackground(SystemColor.control);
		lblGrupo1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblGrupo1.setHorizontalAlignment(SwingConstants.CENTER);
		lblGrupo1.setBounds(60, 16, 159, 41);
		contentPane.add(lblGrupo1);
		
		JLabel lblGrupo2 = new JLabel("GRUPO 2");
		lblGrupo2.setHorizontalAlignment(SwingConstants.CENTER);
		lblGrupo2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblGrupo2.setBounds(345, 16, 159, 41);
		contentPane.add(lblGrupo2);
		
		JSeparator separadorVertical = new JSeparator();
		separadorVertical.setOrientation(SwingConstants.VERTICAL);
		separadorVertical.setForeground(Color.BLACK);
		separadorVertical.setBounds(296, 0, 2, 461);
		contentPane.add(separadorVertical);
		
		JSeparator separadorHorizontal = new JSeparator();
		separadorHorizontal.setForeground(Color.BLACK);
		separadorHorizontal.setBounds(0, 68, 584, 2);
		contentPane.add(separadorHorizontal);
		
		JList<String> lista1 = new JList<String>(); //LISTA GRUPO 1
		lista1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lista1.setBackground(UIManager.getColor("Button.background"));
		lista1.setBounds(23, 95, 240, 344);
		lista1.setFixedCellWidth(200);
		contentPane.add(lista1);
		lista1.setModel(modelList(ListaPersonas1));
		
		JList<String> lista2 = new JList<String>(); //LISTA GRUPO2
		lista2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lista2.setBackground(UIManager.getColor("Button.background"));
		lista2.setBounds(308, 95, 266, 344);
		lista2.setFixedCellWidth(200);
		contentPane.add(lista2);
		lista2.setModel(modelList(ListaPersonas2));
	}
	
	//DEVUELVE UN ARREGLO CON LOS NOMBRES DE LOS INTEGRANTES DE LOS GRUPOS
	private DefaultListModel <String> modelList (ArrayList<Persona> array){
		 DefaultListModel <String> model = new DefaultListModel<>();
		 for (Persona p: array) {
			model.addElement(p.getNombre());
		 }
		 return model;
	}
}

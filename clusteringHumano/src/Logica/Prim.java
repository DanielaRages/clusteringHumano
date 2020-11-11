package Logica;

import java.util.ArrayList;

public class Prim {
	
	//VARIABLES
	private Grafo grafoNuevo; 
	private ArrayList<Persona> vertices;
	private ArrayList<Arista> aristas;
	
	//CONSTRUYE UN GRAFO NUEVO, EL ÁRBOL GENERADOR MÍNIMO
	public Prim(Grafo g) {
		
		grafoNuevo = new Grafo(g.tamanio());
		vertices = new ArrayList<>();
		aristas = new ArrayList<>();
		vertices.add(g.getListaVertices().get(0));
	}
	
	//AGREGA LAS ARISTAS DEL GRAFO ORIGINAL A UNA LISTA
	public ArrayList<Arista> ListaAristas(Grafo g) {
		
		int i = 1;
		
		while(i < g.tamanio()) {
			
			Arista aristaNueva = aristasMenorPeso(g);
			vertices.add(aristaNueva.getPersona2());
			aristas.add(aristaNueva);
			i++;
		}
		return aristas;
	}
	
	//GENERA EL ÁRBOL
	public Grafo ArmarArbol(ArrayList<Arista> lista) {
		
		for (int i = 0; i < grafoNuevo.getCantidadVertices(); i++) {
			grafoNuevo.agregarPersona(vertices.get(i));
		}
		for (int i = 0; i < lista.size(); i++) {
			grafoNuevo.agregarArista(aristas.get(i).getPersona1(),aristas.get(i).getPersona2());
		}
		return grafoNuevo;
	}

	//DEVUELVE LA ARISTA DE MENOR PESO DEL GRAFO
	public Arista aristasMenorPeso(Grafo g) 
	{
		Arista aristaNueva = null;
		int peso = -1;
		
		for (int i = 0; i < vertices.size(); i++) {
			for (int j = 0; j < g.tamanio(); j++) {
				if(!vertices.get(i).equals(g.getListaVertices().get(j)) && 
				   g.existeArista(vertices.get(i), g.getListaVertices().get(j)) && 
				   !vertices.contains(g.getListaVertices().get(j)))	{
					
					if(vertices.get(i).calcularSimilaridad(g.getListaVertices().get(j)) < peso || peso == -1) {
						aristaNueva = new Arista(vertices.get(i),g.getListaVertices().get(j)); 
						peso = aristaNueva.getPeso();									    
					}																	   
				}
				
			}
			
		}
		return aristaNueva;
	}
	
}

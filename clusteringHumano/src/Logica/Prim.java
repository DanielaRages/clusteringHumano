package Logica;

import java.util.ArrayList;

public class Prim {
	
	private Grafo grafoNuevo;
	private ArrayList<Persona> vertices;
	//private ArrayList<Aristas> aristas; La comente porque no lo uso. Mas tarde lo vemos y nos fijamos si esta bien o no :3
	
	
	public Prim(Grafo g) 
	{
		grafoNuevo = new Grafo(g.tamanio());
		vertices = new ArrayList<>();
		//aristas = new ArrayList<>();
		vertices.add(g.getVertices().get(0));
	}
	
	public Grafo generarArbolMin(Grafo g) 
	{
		int i = 0;
		while(i < g.tamanio()-1 ) 
		{
			Arista aristaNueva = aristasMenorPeso(g);
			grafoNuevo.agregarArista(aristaNueva.getPersona1(), aristaNueva.getPersona2());
			vertices.add(aristaNueva.getPersona2());
			
		}
		
		return grafoNuevo;
		
	}

	
	public Arista aristasMenorPeso(Grafo g) 
	{
		Arista aristaNueva = null;
		int peso = -1;
		for (int i = 0; i < vertices.size(); i++) {
			for (int j = 0; j < g.tamanio(); j++) {
				if(!vertices.get(i).equals(g.getVertices().get(j)) && 
				   g.existeArista(vertices.get(i), g.getVertices().get(j)) && 
				   !vertices.contains(g.getVertices().get(j))) 
				{
					if(vertices.get(i).calcularSimilaridad(g.getVertices().get(j)) < peso || peso == -1) 
					{
						//peso = vertices.get(i).calcularSimilaridad(g.getVertices().get(j)); Esto lo puedo calcular antes o cuando creo la arista 
						aristaNueva = new Arista(vertices.get(i),g.getVertices().get(j)); // ya tengo el peso calculado por eso creo la arista y
						peso = aristaNueva.getPeso();									   // abajo solo tengo que pasarle a peso lo que tiene la 
					}																	   // nueva arista creada
				}
				
			}
			
		}
		
		return aristaNueva;
		
	}
	

	

}


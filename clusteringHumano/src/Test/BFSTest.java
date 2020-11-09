package Test;


import java.util.Set;

import org.junit.jupiter.api.Test;

import Logica.BFS;
import Logica.Grafo;
import Logica.Persona;

public class BFSTest {

	
	
	@Test
	public void alcanzablesTest()
	{
		Grafo g = inicializarEjemplo();
		Set<Integer> alcanzables = BFS.alcanzables(g, 2);
		int[] esperado = {2,3,4};
		
		Assert.iguales(esperado, alcanzables);
	}


	private Grafo inicializarEjemplo() 
	{
		Persona p1 = new Persona("Lean",5,4,2,4);
		Persona p2 = new Persona("Marcos",2,3,1,5);
		Persona p3 = new Persona("Mel",3,5,3,4);
		Persona p4 = new Persona("Dani",4,4,3,3);
		Persona p5 = new Persona("Enzo",5,5,3,5);
		Grafo g = new Grafo(5);
		g.agregarPersona(p1);
		g.agregarPersona(p2);
		g.agregarPersona(p3);
		g.agregarPersona(p4);
		g.agregarPersona(p5);
		g.agregarArista(p1, p2);
		g.agregarArista(p4, p5);
		g.agregarArista(p3, p4);
		return g;
	}

}
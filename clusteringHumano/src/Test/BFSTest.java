package Test;


import static org.junit.Assert.*;

import java.util.Set;

import org.junit.Test;

import Logica.BFS;
import Logica.Grafo;
import Logica.Persona;

public class BFSTest 

{
	@Test (expected=IllegalArgumentException.class)
	public void testNull() 
	{
		BFS.esConexo(null);
	}
	
	@Test
	public void testVacio()
	{
		Grafo g = new Grafo(0);
		assertTrue(BFS.esConexo(g));
	}
	
	@Test
	public void testNoConexo()
	{
		Grafo g = inicializarEjemplo();
		assertFalse(BFS.esConexo(g));
	}

	@Test
	public void testConexo()
	{
		Grafo g = inicializarEjemplo();
		g.agregarArista(g.getListaVertices().get(3),g.getListaVertices().get(4));
		assertTrue(BFS.esConexo(g));
	}
	
	@Test
	public void alcanzablesTest()
	{
		Grafo g = inicializarEjemplo();
		Set<Integer> alcanzables = BFS.alcanzables(g, 0);
		
		int[] esperado = {0, 1, 2, 3};
		Assert.iguales(esperado, alcanzables);
	}
	
	@Test
	public void alcanzablesTodosTest()
	{
		Grafo g = inicializarEjemplo();
		g.agregarArista(g.getListaVertices().get(3),g.getListaVertices().get(4));
		
		Set<Integer> alcanzables = BFS.alcanzables(g, 0);
		
		int[] esperado = {0, 1, 2, 3, 4};
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
		g.agregarArista(p1, p3);
		g.agregarArista(p3, p4);
		return g;
	}


}
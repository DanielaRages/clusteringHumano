package Test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import Logica.Arista;
import Logica.BFS;
import Logica.Grafo;
import Logica.Persona;
import Logica.Prim;

public class PrimTest {
	
	Persona p1 = new Persona("Santi",2,5,2,3);
	Persona p2 = new Persona("Lean",5,3,2,3);
	Persona p3 = new Persona("DaniBlue",1,5,3,3);
	Persona p4 = new Persona("Enzo",5,5,2,5);
	Persona p5 = new Persona("Mel",1,5,3,4);
	Persona p6 = new Persona("Elias",3,3,1,3);
	
	
	@Test
	public void AristaMenorEsperadaTest()
	{
		Grafo grafo = new Grafo(3);
		grafo.agregarPersona(p1);
		grafo.agregarPersona(p2);
		grafo.agregarPersona(p3);
		grafo.GenerarGrafo();
		Prim p = new Prim(grafo);
		assertTrue(grafo.AristasIguales(p.aristasMenorPeso(grafo),new Arista(p2,p3)));
		
	}
	
	@Test
	public void GenerarArbolMinTest() 
	{
		Grafo grafo = new Grafo(6);
		grafo.agregarPersona(p1);
		grafo.agregarPersona(p2);
		grafo.agregarPersona(p3);
		grafo.agregarPersona(p4);
		grafo.agregarPersona(p5);
		grafo.agregarPersona(p6);
	
		grafo.GenerarGrafo();
		
		Prim p = new Prim(grafo);
		Grafo g = p.ArmarArbol(p.ListaAristas(grafo));
		assertTrue(BFS.esConexo(g));
		
	}

}

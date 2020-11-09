package Test;

import static org.junit.Assert.*;

import java.util.Set;

import org.junit.Test;

import Logica.Grafo;
import Logica.Persona;

public class GrafoTest {
	
	Persona p1 = new Persona("Lean",5,4,2,4);
	Persona p2 = new Persona("Marcos",2,3,1,5);
	Persona p3 = new Persona("Mel",3,5,3,4);
	Persona p4 = new Persona("Dani",4,4,3,3);
	Persona p5 = new Persona("Enzo",5,5,3,5);
	Persona p6 = new Persona("Santi",3,5,2,4);
	
	
	
	@Test(expected = IllegalArgumentException.class)
	public void primerVerticeExcedidoTest()

	{
		Grafo grafo = new Grafo(5);
		grafo.agregarPersona(p1);
		grafo.agregarPersona(p2);
		grafo.agregarPersona(p3);
		grafo.agregarPersona(p4);
		grafo.agregarPersona(p5);
		grafo.agregarArista(p6, p1);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void segundoVerticeExcedidoTest()

	{
		Grafo grafo = new Grafo(5);
		grafo.agregarPersona(p1);
		grafo.agregarPersona(p2);
		grafo.agregarPersona(p3);
		grafo.agregarPersona(p4);
		grafo.agregarPersona(p5);
		grafo.agregarArista(p1, p6);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void eliminarAristaNoExistenteTest()

	{
		Grafo grafo = new Grafo(5);
		grafo.agregarPersona(p1);
		grafo.agregarPersona(p2);
		grafo.agregarPersona(p3);
		grafo.agregarPersona(p4);
		grafo.agregarPersona(p5);
		grafo.eliminarArista(p6, p1);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void agregarLoopTest()

	{
		Grafo grafo = new Grafo(5);
		grafo.agregarPersona(p1);
		grafo.agregarPersona(p2);
		grafo.agregarPersona(p3);
		grafo.agregarPersona(p4);
		grafo.agregarPersona(p5);
		grafo.agregarArista(p1, p1);
	}
	
	
	@Test
	public void agregarPersonaTest()
	{
		Grafo grafo = new Grafo(5);
		grafo.agregarPersona(p1);
		assertTrue( grafo.getListaVertices().contains(p1));
	}
	
	@Test
	public void aristaInexistenteTest()
	{
		Grafo grafo = new Grafo(5);
		grafo.agregarPersona(p1);
		grafo.agregarPersona(p2);
		grafo.agregarPersona(p3);
		grafo.agregarPersona(p4);
		grafo.agregarPersona(p5);
		grafo.agregarArista(p1, p2);
		assertFalse( grafo.existeArista(p1, p4));
	}
	
	@Test
	public void agregarAristaDosVecesTest()
	{
		Grafo grafo = new Grafo(5);
		grafo.agregarPersona(p1);
		grafo.agregarPersona(p2);
		grafo.agregarPersona(p3);
		grafo.agregarPersona(p4);
		grafo.agregarPersona(p5);
		grafo.agregarArista(p1, p2);
		grafo.agregarArista(p1, p2);
		assertTrue( grafo.existeArista(p1, p2) );
	}
	
	
	@Test
	public void eliminarAristaExistenteTest()
	{
		Grafo grafo = new Grafo(5);
		grafo.agregarPersona(p1);
		grafo.agregarPersona(p2);
		grafo.agregarPersona(p3);
		grafo.agregarPersona(p4);
		grafo.agregarPersona(p5);
		grafo.agregarArista(p1, p2);
		grafo.eliminarArista(p1, p2);
		assertFalse( grafo.existeArista(p1, p2) );

	}
	
	@Test
	public void eliminarAristaInexistenteTest()
	{
		Grafo grafo = new Grafo(5);
		grafo.agregarPersona(p1);
		grafo.agregarPersona(p2);
		grafo.agregarPersona(p3);
		grafo.agregarPersona(p4);
		grafo.agregarPersona(p5);
		grafo.eliminarArista(p1, p2);
		assertFalse( grafo.existeArista(p1, p2) );

	}
	
	@Test
	public void eliminarAristaDosVecesTest()
	{
		Grafo grafo = new Grafo(5);
		grafo.agregarPersona(p1);
		grafo.agregarPersona(p2);
		grafo.agregarPersona(p3);
		grafo.agregarPersona(p4);
		grafo.agregarPersona(p5);
		grafo.agregarArista(p1, p2);
		grafo.eliminarArista(p1, p2);
		grafo.eliminarArista(p1, p2);
		assertFalse( grafo.existeArista(p1, p2) );
	}
	
	@Test
	public void eliminarAristaMaxTest() 
	{
		Grafo grafo = new Grafo(3);
		grafo.agregarPersona(p1);
		grafo.agregarPersona(p2);
		grafo.agregarPersona(p3);
		grafo.GenerarGrafo();
		grafo.eliminarAristaMax();
		assertTrue( grafo.existeArista(p2, p3) );
		
	}
	
	@Test
	public void tamanioTest() 
	{
		Grafo grafo = new Grafo(3);
		grafo.agregarPersona(p1);
		grafo.agregarPersona(p2);
		grafo.agregarPersona(p3);
		
		assertTrue( grafo.tamanio()==3 );
		
	
	}
	
	@Test
	public void PosPersonaTest() 
	{
		Grafo grafo = new Grafo(5);
		grafo.agregarPersona(p1);
		grafo.agregarPersona(p2);
		grafo.agregarPersona(p3);
		grafo.agregarPersona(p4);
		grafo.agregarPersona(p5);
		assertTrue( grafo.posPersona(p4)==3 );
		
	
	}
	
	
	@Test
	public void VecinosTest() 
	{
		Grafo grafo = new Grafo(5);
		grafo.agregarPersona(p1);
		grafo.agregarPersona(p2);
		grafo.agregarPersona(p3);
		grafo.agregarPersona(p4);
		grafo.agregarPersona(p5);
		grafo.GenerarGrafo();
		int[] esperado = {1,2,3,4};
		Set<Integer> alcanzables = grafo.vecinos(0);
		
		Assert.iguales(esperado, alcanzables);
	}

		

}

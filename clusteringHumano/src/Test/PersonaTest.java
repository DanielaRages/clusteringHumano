package Test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import Logica.Persona;

public class PersonaTest {
	
	@Test
	public void indiceSimilaridadTest() {
		Persona p1 = new Persona ("Roberto", 2, 1, 5, 2);
		Persona p2 = new Persona ("Karen", 2, 1, 2, 4);
		assertEquals(5, p1.calcularSimilaridad(p2));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void nombreVacioTest() 
	{
		Persona p1 = new Persona(" ",2, 1, 5, 2);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void nombreNullTest() 
	{
		Persona p1 = new Persona(null,2, 1, 5, 2);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void nombreLetraEspacioTest() 
	{
		Persona p1 = new Persona("a ",2, 1, 5, 2);
	}
	
}

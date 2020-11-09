package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Logica.Persona;

class PersonaTest {
	
	@Test
	public void indiceSimilaridadTest() {
		Persona p1 = new Persona ("Roberto", 2, 1, 5, 2);
		Persona p2 = new Persona ("Karen", 2, 1, 2, 4);
		assertEquals(5, p1.calcularSimilaridad(p2));
	}

	
	
}

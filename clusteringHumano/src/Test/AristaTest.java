package Test;



import org.junit.Test;

import Logica.Arista;
import Logica.Persona;

public class AristaTest {

    @Test
	public void creacionArista() {
        Persona p1 = new Persona("Sofia", 1, 2, 3, 4);
        Persona p2 = new Persona("Juan", 2, 3, 2, 1);
        Arista a = new Arista(p1, p2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void creacionAristaErronea() {
        Persona p1 = new Persona("", 1, 2, 3, 4);
        Persona p2 = new Persona("Juan", 2, 3, 2, 1);
        Arista a = new Arista(p1, p2);
    }

}

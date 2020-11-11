package Logica;

public class Arista {
	
	//VARIABLES
	private Persona persona1;
    private Persona persona2;
    private Integer peso;

    //CONSTRUYE UNA ARISTA
	public Arista (Persona p1, Persona p2){
        this.persona1 = p1;
        this.persona2 = p2;
        this.peso = p1.calcularSimilaridad(p2);
    }
    
    //SOBRESCRIBE EL MÉTODO EQUALS
    @Override
	public boolean equals(Object obj) {
    	if(this.getClass() != obj.getClass()) {return false;}
    	
    	Arista otro = (Arista) obj;
	    	
    	if(this.getPersona1().equals(otro.getPersona1()) &&
	       this.getPersona2().equals(otro.getPersona2()) &&
	       this.getPeso() == otro.getPeso()) {return true;}
    	
    	else {return false;}

	}

    //GETTERS
	public Persona getPersona1() {return persona1;}

	public Persona getPersona2() {return persona2;}

	public Integer getPeso() {return peso;}
}

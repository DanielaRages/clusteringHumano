package Logica;

public class Arista {
	private Persona persona1;
    private Persona persona2;
    private Integer peso;

    public Arista (Persona p1, Persona p2){
        this.persona1 = p1;
        this.persona2 = p2;
        this.peso = p1.calcularSimilaridad(p2);
    }
    
    
    public boolean equals(Object obj) 
	   {
		   if(this.getClass() != obj.getClass()) 
			   {
			   return false;
			   }
	    	Arista otro = (Arista) obj;
	    	
	    	if		(this.getPersona1().equals(otro.getPersona1()) &&
	    			this.getPersona2().equals(otro.getPersona2()) &&
	    			this.getPeso() == otro.getPeso()) 	   
	    		{
	    		return true;
	    		}
	    	else 
	    	{
	    		return false;
	    	}

	   }

	public Persona getPersona1() {
		return persona1;
	}

	public Persona getPersona2() {
		return persona2;
	}

	public Integer getPeso() {
		return peso;
	}
}

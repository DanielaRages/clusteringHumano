package Logica;

public class Persona {
	private String nombre;
	private int deportes;
	private int musica;
	private int espectaculo;
	private int ciencia;
	
	public Persona(String n, int d,int m, int e,int c) 
	{
		this.nombre = n;
		this.deportes = d;
		this.musica = m;
		this.espectaculo = e;
		this.ciencia = c;
	}
	
	   public int calcularSimilaridad (Persona p) {
	        int deportes;
	        int musica;
	        int espectaculo;
	        int ciencia;
	       
	        deportes = Math.abs(this.getDeportes() - p.getDeportes());
	        musica = Math.abs(this.getMusica() - p.getMusica());
	        espectaculo = Math.abs(this.getEspectaculo() - p.getEspectaculo());
	        ciencia = Math.abs(this.getCiencia() - p.getCiencia()); 		   ;
	        
	        return (deportes + musica + espectaculo + ciencia) ;
	    }
	   
	   @Override
	   public boolean equals(Object obj) 
	   {
		   if(this.getClass() != obj.getClass()) 
			   {
			   return false;
			   }
	    	Persona otro = (Persona) obj;
	    	
	    	if		(this.getNombre() == otro.getNombre() &&
	    			this.getDeportes() == otro.getDeportes() &&
	    			this.getMusica() == otro.getMusica() &&
	    			this.getEspectaculo() == otro.getEspectaculo() &&
	    			this.getCiencia() == otro.getCiencia()) 	   
	    		{
	    		return true;
	    		}
	    	else 
	    	{
	    		return false;
	    	}

	   }

	public String getNombre() {
		return nombre;
	}

	public int getDeportes() {
		return deportes;
	}

	public int getMusica() {
		return musica;
	}

	public int getEspectaculo() {
		return espectaculo;
	}

	public int getCiencia() {
		return ciencia;
	}


}

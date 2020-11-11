package Logica;

public class Persona {
	
	//VARIABLES
	private String nombre;
	private int deportes;
	private int musica;
	private int espectaculo;
	private int ciencia;
	
	//CONSTRUYE LA PERSONA
	public Persona(String n, int d,int m, int e,int c){
		if(n==null) {
			throw new IllegalArgumentException ("No debe de estar vacio");
		} 
		if(n.isBlank() || n.length() <= 2 ) {
			throw new IllegalArgumentException ("Debe asignar el nombre y apellido de la persona.");
		}
	     
	    this.nombre = n;
		this.deportes = d;
		this.musica = m;
		this.espectaculo = e;
		this.ciencia = c;
	}

	//CALCULA EL ÍNDICE DE SIMILARIDAD
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
	   
	//SOBRESCRIBE EL MÉTODO EQUALS
	@Override
	public boolean equals(Object obj){
		
		if(this.getClass() != obj.getClass()) {return false;}
	   
    	Persona otro = (Persona) obj;
    	
    	if(this.getNombre().equals(otro.getNombre()) &&
			this.getDeportes() == otro.getDeportes() &&
			this.getMusica() == otro.getMusica() &&
			this.getEspectaculo() == otro.getEspectaculo() &&
			this.getCiencia() == otro.getCiencia()) 
    		
    	{return true;}
    	
    	else {return false;}
   }

	//GETTERS
	public String getNombre() {return nombre;}

	public int getDeportes() {return deportes;}

	public int getMusica() {return musica;}

	public int getEspectaculo() {return espectaculo;}

	public int getCiencia() {return ciencia;}
}
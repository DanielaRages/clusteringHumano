package Logica;

import java.util.ArrayList;



public class Grafo 
{
	
	private ArrayList<Persona> vertices;
	private ArrayList<Arista> aristas;
	
	
	public Grafo(int cantP) 
	{
		this.vertices = new ArrayList<>(cantP);
		this.aristas = new ArrayList<>();
		
	}
	
	public void agregarPersona(Persona p) 
	{
		vertices.add(p);
	}
	
	public void GenerarGrafo() 
	{
		for (int i = 0; i < vertices.size(); i++) {
			for (int j = 0; j < vertices.size(); j++) {
				agregarArista(vertices.get(i), vertices.get(j));
			}
		}
	}
	
	public void agregarArista(Persona p1,Persona p2) 
	{
		agregarAristaLista(new Arista(p1,p2));
	}
	

    private void agregarAristaLista(Arista a) 
    {
    	if(!(a.getPersona1().equals(a.getPersona2()))) 
    	{
    		aristas.add(a);    		
    	}
    }
	
	public void eliminarArista (Persona p1, Persona p2) 
	{
		if(existeArista(p1, p2)) 
		{
			eliminarArista(new Arista(p1,p2));
			eliminarArista(new Arista(p2,p1));
		}
    }
	
	private void eliminarArista (Arista arista) {
    		
		for(int i = 0; i < aristas.size(); i++) {
    		if(aristas.get(i).equals(arista)) 
    		{
    			aristas.remove(i);
    		}
    			
    	}
    }
	
	public boolean existeArista (Persona n , Persona m) { 
        return existeArista(new Arista(n,m));
    }
	
	private boolean existeArista (Arista a) {
    	for (int i = 0; i < aristas.size(); i++) {
    		if ((aristas.get(i).getPersona1().equals(a.getPersona1()) || aristas.get(i).getPersona1().equals(a.getPersona2())) &&
    				(aristas.get(i).getPersona2().equals(a.getPersona1()) || aristas.get(i).getPersona2().equals(a.getPersona2()))){
    			return true;
    		}
    	}
    	return false;
    }
	
	
	public void eliminarAristaMax() 
	{
		int aristaMax = 0;
		Arista aristaEliminar = null;
		for (int i = 0; i < aristas.size(); i++) {
			if(aristas.get(i).getPeso()>aristaMax) 
			{
				aristaMax = aristas.get(i).getPeso();
				aristaEliminar = aristas.get(i);
			}
			
		}
		eliminarArista(aristaEliminar);
		
	}
	
	public int tamanio() 
	{
		return vertices.size();
	}
	
	

	public ArrayList<Persona> getVertices() {
		return vertices;
	}

	public ArrayList<Arista> getAristas() {
		return aristas;
	}
	


	
}

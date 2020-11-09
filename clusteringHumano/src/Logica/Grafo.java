package Logica;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;



public class Grafo 
{
	
	private ArrayList<Persona> listaVertices;
	private ArrayList<Arista> aristas;
	private int vertices;
	
	
	public Grafo(int cantP) 
	{
		this.listaVertices = new ArrayList<>(cantP);
		this.aristas = new ArrayList<>();
		this.vertices = cantP;
		
	}
	
	public void agregarPersona(Persona p) 
	{
		listaVertices.add(p);
	}
	
	public void GenerarGrafo() 
	{
		for (int i = 0; i < listaVertices.size(); i++) {
			for (int j = 0; j < listaVertices.size(); j++) {
				agregarArista(listaVertices.get(i), listaVertices.get(j));
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
		return listaVertices.size();
	}
	
	

	public ArrayList<Persona> getListaVertices() {
		return listaVertices;
	}

	public ArrayList<Arista> getAristas() {
		return aristas;
	}
	
	public int posPersona(Persona p) 
	{
		int cont = 0;
		while(!p.equals(listaVertices.get(cont))) 
		{
			cont++;
		}
		return cont;
	}
	
	public int getVertices() 
	{
		return vertices;
	}
	
	
	public Set<Integer> vecinos(int v)
	{
		Set<Integer> ret = new HashSet<Integer>();
		for (int i = 0; i < aristas.size(); i++) {
			if(aristas.get(i).getPersona1().equals(listaVertices.get(v)))
			{ 
				ret.add(posPersona(aristas.get(i).getPersona2()));					
			}
			if(aristas.get(i).getPersona2().equals(listaVertices.get(v)))
			{
				ret.add(posPersona(aristas.get(i).getPersona1()));
									 
			}
		}
		return ret;
	}


	
}

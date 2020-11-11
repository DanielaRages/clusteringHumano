package Logica;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Grafo {
	
	//VARIABLES
	private ArrayList<Persona> listaVertices;
	private ArrayList<Arista> aristas;
	private int vertices;
	private Arista aristaEliminar;
	
	//CONSTRUYE UN GRAFO
	public Grafo(int cantP)	{
		
		this.listaVertices = new ArrayList<>(cantP);
		this.aristas = new ArrayList<>();
		this.vertices = cantP;
			
	}

//VÉRTICES
	//AGREGA UNA PERSONA A LA LISTA DE VÉRTICES
	public void agregarPersona(Persona p){
		
		if(listaVertices.size()!=vertices) {listaVertices.add(p);}
		
		else {throw new IllegalArgumentException("No puede agregar mas personas");}
	}
	
	//DEVUELVE UNA LISTA DE PERSONAS SEGÚN LAS POSICIONES ESPECIFICADAS
	public ArrayList<Persona> listaPersonas(Set<Integer> listaPos){
		
		ArrayList<Persona> ret = new ArrayList<>();
		for(Integer p1 : listaPos) {
			ret.add(listaVertices.get(p1));
		}
		return ret;
	}
	
	//DEVUELVE LOS VECINOS DE UN VÉRTICE
	public Set<Integer> vecinos(int v){
		
		Set<Integer> ret = new HashSet<Integer>();
		
		for (int i = 0; i < aristas.size(); i++) {
			if(aristas.get(i).getPersona1().equals(listaVertices.get(v))){ 
				ret.add(posPersona(aristas.get(i).getPersona2()));					
			}
			if(aristas.get(i).getPersona2().equals(listaVertices.get(v))){
				ret.add(posPersona(aristas.get(i).getPersona1()));				 
			}
		}
		return ret;
	}
	
	//VERIFICA SI LA PERSONA ESPECIFICADA YA ESTÁ EN LA LISTA DE VÉRTICES
	public boolean personaRepetida(Persona p) {
		
		for(Persona p1 : listaVertices) {
			if(p.equals(p1)) {return true;}
		}
		return false;
	}
	
//ARISTAS	
	//AGREGA UNA ARISTA A LA LISTA 
	public void agregarArista(Persona p1,Persona p2){
		
		if(!listaVertices.contains(p1))
			throw new IllegalArgumentException("No esta en la lista: " + p1.getNombre());
		if(!listaVertices.contains(p2))
			throw new IllegalArgumentException("No esta en la lista: " + p2.getNombre());
		
		agregarAristaLista(new Arista(p1,p2));
	}
	
	//VERIFICA QUE LAS PERSONAS SEAN DISTINTAS PARA AGREGAR UNA ARISTA
    private void agregarAristaLista(Arista a){
    	
    	if(a.getPersona1().equals(a.getPersona2()))
			throw new IllegalArgumentException("No se permite Loop con: " + a.getPersona1().getNombre());
		if(a.getPersona2().equals(a.getPersona1()))
			throw new IllegalArgumentException("No se permite Loop con: " + a.getPersona2().getNombre());
    		
		aristas.add(a);    		
    }
	
    //ELIMINA UNA ARISTA ENTRE DOS PERSONAS
	public void eliminarArista (Persona p1, Persona p2) {
		
		if(existeArista(p1, p2)) {
			eliminarArista(new Arista(p1,p2));
			eliminarArista(new Arista(p2,p1));
		}
		else {
			if(!listaVertices.contains(p1))
				throw new IllegalArgumentException("No esta en la lista: " + p1.getNombre());
			if(!listaVertices.contains(p2))
				throw new IllegalArgumentException("No esta en la lista: " + p2.getNombre());
		}
    }
	
	//BUSCA EN LA LISTA DE ARISTAS PARA ELIMINAR LA ESPECIFICADA
	private void eliminarArista (Arista arista) {
    		
		for(int i = 0; i < aristas.size(); i++) {
    		if(aristas.get(i).equals(arista)) {	aristas.remove(i);}	
    	}
    }
	
	//VERIFICA SI EXISTE UNA ARISTA ENTRE DOS PERSONAS
	public boolean existeArista (Persona p1 , Persona p2) { 
		if(!listaVertices.contains(p1))
			throw new IllegalArgumentException("No esta en la lista: " + p1.getNombre());
		if(!listaVertices.contains(p2))
			throw new IllegalArgumentException("No esta en la lista: " + p2.getNombre());
		
		return existeArista(new Arista(p1,p2));
    }
	
	//BUSCA EN LA LISTA DE ARISTAS SI EXISTE LA ESPECIFICADA
	private boolean existeArista (Arista a) {
    	for (int i = 0; i < aristas.size(); i++) {
    		if ((aristas.get(i).getPersona1().equals(a.getPersona1()) || aristas.get(i).getPersona1().equals(a.getPersona2())) &&
    			(aristas.get(i).getPersona2().equals(a.getPersona1()) || aristas.get(i).getPersona2().equals(a.getPersona2()))){
    			return true;
    		}
    	}
    	return false;
    }
	
	//VERIFICA SI DOS ARISTAS SON IGUALES
	public boolean AristasIguales(Arista a1,Arista a2){
		
		if((a1.getPersona1().equals(a2.getPersona1())) || 
				a1.getPersona1().equals(a2.getPersona2()) && 
				(a1.getPersona2().equals(a2.getPersona1())) ||
				a1.getPersona2().equals(a2.getPersona2())) 
		{return true;}
		
		else {return false;}
	}
	
	//ELIMINA LA PRIMER ARISTA QUE ENCUENTRA, EN CASO DE QUE TODAS TENGAN EL MISMO PESO
	public void eliminarAristaMax() {
		
		int aristaMax = -1;
		aristaEliminar = null;
		for (int i = 0; i < aristas.size(); i++) {
			if(aristas.get(i).getPeso() > aristaMax || aristaMax == -1) {
				aristaMax = aristas.get(i).getPeso();
				aristaEliminar = aristas.get(i);
			}	
		} 
		eliminarArista(aristaEliminar.getPersona1(),aristaEliminar.getPersona2());	
	}
	
	//GENERA EL GRAFO CON LOS VÉRTICES Y LAS ARISTAS AÑADIDAS
	public void GenerarGrafo(){
		
		for (int i = 0; i < listaVertices.size(); i++) {
			for (int j = 0; j < listaVertices.size(); j++) {
				if(!listaVertices.get(i).equals(listaVertices.get(j))) {
					agregarArista(listaVertices.get(i), listaVertices.get(j));
				}
				
			}
		}
	}
	
	//GETTERS
	public int posPersona(Persona p) {return listaVertices.indexOf(p);}
	
	public int getCantidadVertices() {return vertices;}
	
	public Arista getAristaEliminar() {return aristaEliminar;}
	
	public int tamanio() {return listaVertices.size();}
 
	public ArrayList<Persona> getListaVertices() {return listaVertices;}
 
	public ArrayList<Arista> getAristas() {return aristas;}
	
}

package Logica;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class BFS 
{
	//VARIABLES
	private static ArrayList<Integer> L;
	private static boolean[] marcados;
	
	//VERIFICA SI EL GRAFO DADO ES CONEXO
	public static boolean esConexo(Grafo g) {
		if (g==null)
			throw new IllegalArgumentException("Se intento consultar con un grafo null!" );
		
		if (g.getCantidadVertices() == 0) {return true;}
		
		return alcanzables(g, 0).size() == g.getCantidadVertices();
	}

	//DEVUELVE UNA LISTA DE ENTEROS QUE REPRESENTA LOS VÉRTICES ALCANZABLES DESDE UNO ESPECÍFICO
	public static Set<Integer> alcanzables(Grafo g, int origen)	{
		
		Set<Integer> ret = new HashSet<Integer>();
		inicializar(g, origen);
		
		while (L.size() >0)	{
			
			int i =	L.get(0);
			marcados[i] = true;
			ret.add(i);
			agregarVecinosPendientes(g, i);
			L.remove(0);			
		}
		return ret;
	}

	//ESPECIFICA EL ORIGEN DESDE DONDE SE RECORRERÁ EL GRAFO
	private static void inicializar(Grafo g, int origen) {
		L = new ArrayList<Integer>();	
		L.add(origen);
		marcados = new boolean[g.getCantidadVertices()];
	}

	//AGREGA LOS VECINOS DE UN VÉRTICE ESPECIFICADO
	private static void agregarVecinosPendientes(Grafo g, int i) {
		for (int vertice : g.vecinos(i))
			if (marcados[vertice] == false && L.contains(vertice) == false)
				L.add(vertice);
	}

}
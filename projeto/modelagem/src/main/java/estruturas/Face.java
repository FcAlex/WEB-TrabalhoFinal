package estruturas;

import java.util.ArrayList;
import java.util.List;

public class Face {
	List<Aresta> arestas;

	public Face(List<Aresta> arestas) {
		super();
		this.arestas = arestas;
	}
	
	public Face() {
		this.arestas = new ArrayList<>();
	}

	public List<Aresta> getArestas() {
		return arestas;
	}

	public void setArestas(List<Aresta> arestas) {
		this.arestas = arestas;
	}

	@Override
	public String toString() {
		return "Face [arestas=" + arestas + "]";
	}

	public static Face create(Aresta ... arestas) {
		ArrayList<Aresta> ar = new ArrayList<>();
		for (Aresta aresta : arestas) {
			ar.add(aresta);
		}
		return new Face(ar);
	}
	
	
}

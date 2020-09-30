package estruturas;

import java.util.ArrayList;
import java.util.List;

public class Malha {
	private final List<Vertices> vertices;
	private final List<Aresta> arestas;
	private final List<Face> faces;
	
	public Malha() {
		this.vertices = new ArrayList<Vertices>();
		this.arestas = new ArrayList<Aresta>();
		this.faces = new ArrayList<Face>();
	}

	public void addVertice(Vertices vertex) {
		vertices.add(vertex);
	}
	
	public void addAresta(Aresta aresta) {
		if(vertices.contains(aresta.vert1) && vertices.contains(aresta.vert2) && !constainsAresta(aresta))
			arestas.add(aresta);
	}
	
	private boolean constainsAresta(Aresta aresta) {
		for (Aresta ar : arestas) {
			if(ar.equals(aresta)) return true;
		}
		
		return false;
	}

	public void addFace(Face face) {
		if(arestas.containsAll(face.arestas))
			faces.add(face);
	}

	public List<Aresta> getArestas() {
		return arestas;
	}
	
	public List<Vertices> getVertices() {
		return vertices;
	}

	public static Malha mergeMalha(Malha malha, Malha malha2) {
		Malha res = new Malha();
		
		res.vertices.addAll(malha.vertices);
		res.vertices.addAll(malha2.vertices);
		
		res.arestas.addAll(malha.arestas);
		res.arestas.addAll(malha2.arestas);
		
		res.faces.addAll(malha.faces);
		res.faces.addAll(malha2.faces);
		
		return res;
	}

	public List<Face> getFaces() {
		return faces;
	}
	
}

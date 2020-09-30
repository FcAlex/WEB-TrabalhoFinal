package br.ufc.modelagem;

import java.io.PrintWriter;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.joml.Vector4f;

import estruturas.Aresta;
import estruturas.Face;
import estruturas.Objeto;
import estruturas.Vertices;

public class Cena {
	List<Objeto> objetos;
	
	public Cena() {
		this.objetos = new ArrayList<>();
	}
	
	private Objeto drawTriangleObject(Vertices v1, Vertices v2, Vertices v3) {
		Objeto obj = new Objeto("Triangulo");
		obj.addVertices(v1, v2, v3);
		obj.addArestas(Aresta.create(v1, v2), Aresta.create(v2, v3), Aresta.create(v1, v3));
		obj.addFaces(new Face(obj.arestas()));
		
		return obj;
	}
	
	public void drawTriangle(Vertices v1, Vertices v2, Vertices v3) {
		addObjeto(drawTriangleObject(v1, v2, v3));
	}
	
	private Objeto drawSquareObject(Vertices centro, float raio) {
		Float x = centro.getVertice().x, y = centro.getVertice().y, z = centro.getVertice().z, w = centro.getVertice().w;
		
		Vertices v1 = new Vertices(new Vector4f(x, y, z, w));
		Vertices v2 = new Vertices(new Vector4f(x+raio, y, z, w));
		Vertices v3 = new Vertices(new Vector4f(x+raio, y+raio, z, w));
		Vertices v4 = new Vertices(new Vector4f(x, y+raio, z, w));
		
		return drawSquareByVertices(v1, v2, v3, v4);
		
	}
	
	public void drawSquare(Vertices centro, float raio) {
		addObjeto(drawSquareObject(centro, raio));
	}
	
	private Objeto drawTetraedroObject(Vertices v1, Vertices v2, Vertices v3, Vertices v4) {
		Objeto obj = new Objeto("Tetraedro");
		
		obj.addVertices(v1, v2, v3, v4);
		Aresta a1 = Aresta.create(v1, v2), a2 = Aresta.create(v2, v3), a3 = Aresta.create(v1, v3),
				a4 = Aresta.create(v1, v4), a5 = Aresta.create(v2, v4), a6 = Aresta.create(v3, v4);
		obj.addArestas(a1, a2, a3, a4, a5, a6);
		obj.addFaces(Face.create(a1, a2, a3), Face.create(a1, a5, a4), Face.create(a2, a6, a5), Face.create(a3, a4, a6));
		
		System.out.println(obj.faces().size());
		
		return obj;
	}
	
	public void drawTetraedro(Vertices v1, Vertices v2, Vertices v3, Vertices v4) {
		addObjeto(drawTetraedroObject(v1, v2, v3, v4));
	}
	
	private Objeto drawCubeObject(Vertices centro, float raio) {
		Objeto obj = new Objeto("Cubo");
		Float x = centro.getVertice().x, y = centro.getVertice().y, z = centro.getVertice().z, w = centro.getVertice().w;
		
		Vertices v1 = new Vertices(new Vector4f(x, y, z-raio, w));
		Vertices v2 = new Vertices(new Vector4f(x-raio, y, z-raio, w));
		Vertices v3 = new Vertices(new Vector4f(x-raio, y, z, w));
		Vertices v4 = new Vertices(new Vector4f(x, y, z, w));
		
		obj = drawSquareByVertices(v1, v2, v3, v4);
		
		v1 = new Vertices(new Vector4f(x, y-raio, z, w));
		v2 = new Vertices(new Vector4f(x-raio, y-raio, z, w));
		v3 = new Vertices(new Vector4f(x-raio, y-raio, z-raio, w));
		v4 = new Vertices(new Vector4f(x, y-raio, z-raio, w));

		obj.mergeObjetos(drawSquareByVertices(v1, v2, v3, v4), "");
		
		v1 = new Vertices(new Vector4f(x, y, z, w));
		v2 = new Vertices(new Vector4f(x-raio, y, z, w));
		v3 = new Vertices(new Vector4f(x-raio, y-raio, z, w));
		v4 = new Vertices(new Vector4f(x, y-raio, z, w));

		obj.mergeObjetos(drawSquareByVertices(v1, v2, v3, v4), "");
		
		v1 = new Vertices(new Vector4f(x, y-raio, z-raio, w));
		v2 = new Vertices(new Vector4f(x-raio, y-raio, z-raio, w));
		v3 = new Vertices(new Vector4f(x-raio, y, z-raio, w));
		v4 = new Vertices(new Vector4f(x, y, z-raio, w));

		obj.mergeObjetos(drawSquareByVertices(v1, v2, v3, v4), "");
		
		v1 = new Vertices(new Vector4f(x-raio, y, z, w));
		v2 = new Vertices(new Vector4f(x-raio, y, z-raio, w));
		v3 = new Vertices(new Vector4f(x-raio, y-raio, z-raio, w));
		v4 = new Vertices(new Vector4f(x-raio, y-raio, z, w));

		obj.mergeObjetos(drawSquareByVertices(v1, v2, v3, v4), "");
		
		v1 = new Vertices(new Vector4f(x, y, z-raio, w));
		v2 = new Vertices(new Vector4f(x, y, z, w));
		v3 = new Vertices(new Vector4f(x, y-raio, z, w));
		v4 = new Vertices(new Vector4f(x, y-raio, z-raio, w));

		obj.mergeObjetos(drawSquareByVertices(v1, v2, v3, v4), "");
		
		return obj;
	}

	private Objeto drawSquareByVertices(Vertices v1, Vertices v2, Vertices v3, Vertices v4) {
		Objeto obj = new Objeto("Quadrado");
		
		obj.addVertices(v1, v2, v3, v4);
		obj.addArestas(Aresta.create(v1, v2), Aresta.create(v2, v3), Aresta.create(v3, v4), Aresta.create(v4,  v1));
		obj.addFaces(new Face(obj.arestas()));
		
		return obj;
	}

	public void drawCube(Vertices centro, float raio) {
		addObjeto(drawCubeObject(centro, raio));
	}
	
	public void addObjeto(Objeto obj) {
		objetos.add(obj);
	}
	
	public void reader(String path) {
		
	}
	
	public void writer(PrintWriter out) {
		
	}
	
}

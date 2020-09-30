package estruturas;

import java.util.List;

import org.joml.Matrix3f;
import org.joml.Matrix4f;
import org.joml.Matrix4x3f;
import org.joml.Vector3f;
import org.joml.Vector4f;

public class Objeto {
	public String nome;
	Malha malha;
	
	public Objeto(String nome) {
		this.nome = nome;
		this.malha = new Malha();
	}
	
	public void addVertices(Vertices... vertices) {
		for (Vertices vertex : vertices) {
			malha.addVertice(vertex);
		}
	}
	
	public void addArestas(Aresta... arestas) {
		for (Aresta aresta: arestas) {
			malha.addAresta(aresta);
		}
	}
	
	public void addFaces(Face... faces) {
		for (Face face: faces) {
			malha.addFace(face);
		}
	}
	
	public List<Aresta> arestas() {
		return malha.getArestas();
	}
	
	public void mergeObjetos(Objeto obj, String nvNome) {
		malha = Malha.mergeMalha(this.malha, obj.malha);
		this.nome = nvNome;
	}
	
	public void translate(Vector4f vetor) {
		Matrix4f matrix = new Matrix4f();
		matrix.setColumn(3, vetor);
		
		update(matrix);
	}
	
	public void scale(Vector3f vetor) {
		Matrix4f matrix = new Matrix4f();
		matrix.set(0, 0, vetor.x);
		matrix.set(1, 1, vetor.y);
		matrix.set(2, 2, vetor.z);
		matrix.set(3, 3, 1); // valor do vetor.w
		
		update(matrix);
	}
	
	public void rotate(Eixo ex, float ang) {
		Vector3f col0 = new Vector3f();
		Vector3f col1 = new Vector3f();
		Vector3f col2 = new Vector3f();
		Vector3f col3 = new Vector3f(1,1,1);
		
		if(ex.equals(Eixo.X)) {
			col0.set(1, 0, 0);
			col1.set(0, Math.cos(Math.toRadians(ang)), Math.sin(Math.toRadians(ang)));
			col2.set(1, -Math.sin(Math.toRadians(ang)), Math.cos(Math.toRadians(ang)));
		} else if(ex.equals(Eixo.Y)) {
			col0.set(Math.cos(Math.toRadians(ang)), 0, -Math.sin(Math.toRadians(ang)));
			col1.set(0, 1, 0);
			col2.set(Math.sin(Math.toRadians(ang)), 0, Math.cos(Math.toRadians(ang)));
		} else if(ex.equals(Eixo.Z)) {
			col0.set(Math.cos(Math.toRadians(ang)), Math.sin(Math.toRadians(ang)), 0);
			col1.set(-Math.sin(Math.toRadians(ang)), Math.cos(Math.toRadians(ang)), 0);
			col2.set(0, 0, 1);
		} else return;
		
		Matrix4x3f matrix = new Matrix4x3f(col0, col1, col2, col3);
		
		update(matrix);
	}
	
	public void shear(float hxy, float hxz, float hyx, float hyz, float hzx, float hzy) {
		Matrix4f matrix = new Matrix4f();
		matrix.set(0, 1, hxy);
		matrix.set(0, 2, hxz);
		matrix.set(1, 0, hyx);
		matrix.set(1, 2, hyz);
		matrix.set(2, 0, hzx);
		matrix.set(2, 1, hzy);
		
		update(matrix);
	}

	private void update(Matrix4f matrix) {
		for (Face face : malha.getFaces()) {
			for (Aresta aresta : face.arestas) {
				aresta.vert1.vertice.mul(matrix);
				aresta.vert2.vertice.mul(matrix);
			}
		}
	}
	
	private void update(Matrix4x3f matrix) {
		for (Face face : malha.getFaces()) {
			for (Aresta aresta : face.arestas) {
				aresta.vert1.vertice.mul(matrix);
				aresta.vert2.vertice.mul(matrix);
			}
		}
	}

	public List<Face> faces() {
		return malha.getFaces();
	}
	
	public Malha getMalha() {
		return malha;
	}

}

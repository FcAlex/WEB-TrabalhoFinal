package estruturas;

import org.joml.*;

public class Vertices {
	Vector4f vertice;

	public Vertices(Vector4f vertice) {
		super();
		this.vertice = vertice;
	}

	public Vector4f getVertice() {
		return vertice;
	}

	public void setVertice(Vector4f vertice) {
		this.vertice = vertice;
	}

	@Override
	public String toString() {
		return vertice.toString();
	}

	public float x() {
		return vertice.x;
	}
	
	public float y() {
		return vertice.y;
	}
	
	public float z() {
		return vertice.z;
	}

	public static Vertices create(int x, int y, int z, int w) {
		return new Vertices(new Vector4f(x,y,z,w));
	}
	
	@Override
	public boolean equals(Object obj) {
		Vertices vert = (Vertices) obj;
		return vert.vertice.equals(vertice.x, vertice.y, vertice.z, vertice.w);
	}
	
}

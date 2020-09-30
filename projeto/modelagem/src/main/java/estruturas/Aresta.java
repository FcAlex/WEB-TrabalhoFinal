package estruturas;

public class Aresta {
	Vertices vert1;
	Vertices vert2;
	
	public Aresta(Vertices vert1, Vertices vert2) {
		super();
		this.vert1 = vert1;
		this.vert2 = vert2;
	}

	@Override
	public String toString() {
		return "Aresta [vert1=" + vert1 + ", vert2=" + vert2 + "]";
	}
	
	public static Aresta create(Vertices vert1, Vertices vert2) {
		return new Aresta(vert1, vert2);
	}

	public Vertices getVert1() {
		return vert1;
	}

	public Vertices getVert2() {
		return vert2;
	}
	
	@Override
	public boolean equals(Object obj) {
		Aresta ar = (Aresta) obj;
		return ar.vert1.equals(vert1) && ar.vert2.equals(vert2);
	}
	
	
}

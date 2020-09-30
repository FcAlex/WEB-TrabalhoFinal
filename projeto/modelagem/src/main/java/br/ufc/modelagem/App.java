package br.ufc.modelagem;

import estruturas.Vertices;

public class App  {
    public static void main( String[] args ) {
    	Cena c1 = new Cena();
    	
//    	c1.drawTriangle(Vertices.create(0, 0, 0, 0), Vertices.create(0, 50, 0,0), Vertices.create(50, 0, 0,0));
//    	c1.drawTriangle(Vertices.create(-20, -30, 0), Vertices.create(0, -30, 0), Vertices.create(-20, -5, 0));
    	
//    	c1.drawSquare(Vertices.create(-25, -25, 0, 0), 50);
//    	c1.drawSquare(Vertices.create(-50, -50, 0, 0), 50);
//    	vec4(-1.0, -1.0, -1.0, 1.0), // base bottom-left point
//    	vec4( 0.0, 1.0, -1.0, 1.0), // base top point
//    	vec4( 1.0, -1.0, -1.0, 1.0), // base right point
//    	vec4( 0.0, 0.0, 1.0, 1.0)}; // tip point
//    	c1.drawTetraedro(Vertices.create(-50, -50, -50, 0), Vertices.create(0, 50, -50, 0), 
//    			Vertices.create(0, 50, -50, 0), Vertices.create(0, 0, 50, 0));
    	
//    	c1.drawCube(Vertices.create(0, 0, 0, 0), 50);
    	c1.drawTetraedro(Vertices.create(0, 0, 0, 0), Vertices.create(0, 50, 0, 0), 
    			Vertices.create(25, -50, -25, 0), Vertices.create(25, 0, 50, 0));
    
    	Renderer r = new Renderer(c1);
    	
    	r.animation();
    }
}

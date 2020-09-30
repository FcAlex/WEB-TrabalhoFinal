package br.ufc.modelagem;

import javax.swing.JFrame;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.glu.GLU;
import com.jogamp.opengl.util.FPSAnimator;

import estruturas.Aresta;
import estruturas.Face;
import estruturas.Objeto;
import estruturas.Vertices;
   
public class Renderer implements GLEventListener {
   private GLU glu = new GLU();
   public Cena cena; 
   private float rotation = 0.0f;
   
   public Renderer(Cena cena) {
	   this.cena = cena;
   }	
   
   @Override
   public void display( GLAutoDrawable drawable ) {
	   final GL2 gl = drawable.getGL().getGL2();  
	   gl.glClear(GL2.GL_COLOR_BUFFER_BIT | GL2.GL_DEPTH_BUFFER_BIT );  
	   gl.glLoadIdentity();  
	   gl.glTranslatef(0f, 0f, -2.0f);
	   gl.glRotatef(rotation, 1.0f, 1.0f, 1.0f);   
      
	   Vertices v1, v2;
	   for (Objeto objeto : cena.objetos) {
		   for (Face face : objeto.faces()) {
			   for (Aresta aresta : face.getArestas()) {
				   v1 = aresta.getVert1();
				   v2 = aresta.getVert2();
				   gl.glBegin(GL2.GL_LINES);
				   gl.glVertex3f(v2.x()/100f, v2.y()/100f, v2.z()/100f);
				   gl.glVertex3f(v1.x()/100f, v1.y()/100f, v1.z()/100f);
				   gl.glEnd();
			   }
		   }
	   }
      
      gl.glFlush();
      
      rotation -= .5f;
   }
   
   @Override
   public void dispose( GLAutoDrawable arg0 ) {
      //method body
   }
   
   @Override
   public void init( GLAutoDrawable arg0 ) {
      // method body
   }
   
   @Override
   public void reshape( GLAutoDrawable drawable, int x, int y, int width, int height ) {
	
	// TODO Auto-generated method stub
	  final GL2 gl = drawable.getGL().getGL2();
	  if(height <= 0)
	     height = 1;
			
	  final float h = ( float ) width / ( float ) height;
	  gl.glViewport( 0, 0, width, height );
	  gl.glMatrixMode( GL2.GL_PROJECTION );
	  gl.glLoadIdentity();
		
	  glu.gluPerspective( 45.0f, h, 1.0, 20.0 );
	  gl.glMatrixMode( GL2.GL_MODELVIEW );
	  gl.glLoadIdentity();
   }
   
   public void render() {
	
      //getting the capabilities object of GL2 profile
      final GLProfile profile = GLProfile.get( GLProfile.GL2 );
      GLCapabilities capabilities = new GLCapabilities(profile);
          
      // The canvas
      final GLCanvas glcanvas = new GLCanvas(capabilities);
      
      glcanvas.addGLEventListener(this);
      glcanvas.setSize(400, 400);
       
      //creating frame
      final JFrame frame = new JFrame ("Renderer");
          
      //adding canvas to it
      frame.getContentPane().add(glcanvas);
      frame.setSize(frame.getContentPane().getPreferredSize() );
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);
   }//end of main
   
   public void animation() {
	   final GLProfile profile = GLProfile.get( GLProfile.GL2 );
	   GLCapabilities capabilities = new GLCapabilities( profile );
  
  // The canvas
	   final GLCanvas glcanvas = new GLCanvas( capabilities );
	
	   glcanvas.addGLEventListener(this);
	   glcanvas.setSize( 400, 400 );
	
	   final JFrame frame = new JFrame ( " Multicolored cube" );
	   frame.getContentPane().add( glcanvas );
	   frame.setSize( frame.getContentPane().getPreferredSize() );
	   frame.setVisible(true);
	   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	   final FPSAnimator animator = new FPSAnimator(glcanvas, 300,true);
	
	   animator.start();
   }
   
	
}//end of class
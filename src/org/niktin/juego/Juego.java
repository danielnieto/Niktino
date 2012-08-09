package org.niktin.juego;

import org.niktin.utilidades.Rectangulo;
import org.niktin.recursos.Texto;
import org.niktin.utilidades.Punto;
import org.niktin.utilidades.Utilidades;
import org.lwjgl.openal.AL;
import org.niktin.entrada.Raton;
import java.util.logging.Level;
import java.util.logging.Logger;


import org.niktin.recursos.Vacio;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.niktin.recursos.Recurso;
import static org.lwjgl.opengl.GL11.*;



public class Juego{

private boolean malla = false;
public int contador=0;
private Image buffer;
private Graphics2D gb;
private static int anchura,altura,contadorFPS;
private Color colorDeFondo = Color.BLACK;
public static ArrayList<Recurso> recursos;
private int cuadrosPorSegundo;
private BufferStrategy estrategia;
private boolean sincronizacion=true;
private boolean sincronizacionVertical=false;
private static float posicionVistaX=0, posicionVistaY=0;
private long ultimoFPS;
private int fps, fpsARegresar;
public static Rectangulo pantalla;




public Juego(int anchura,int altura, int fps){
    Juego.anchura = anchura;
    Juego.altura = altura;
    
    pantalla = new Rectangulo(0,0,anchura, altura);
    
    cuadrosPorSegundo = fps;
    ultimoFPS = Utilidades.obtenerTiempo();


    recursos = new ArrayList();
   
    Utilidades.obtenerTiempo();
        try {
            inicializar();
        } catch (LWJGLException ex) {
            Logger.getLogger(Juego.class.getName()).log(Level.SEVERE, null, ex);
        }
      
}

public void actualizar(){

        Display.update();
      
        glLoadIdentity();

        glClearColor(colorDeFondo.getRed(), colorDeFondo.getGreen(), colorDeFondo.getBlue(),0.0f);
        glClear(GL_COLOR_BUFFER_BIT);
        glColor3f(1.0f, 1.0f, 1.0f);
        glOrtho(0.0, anchura, 0.0, altura, 0, 1);

       

        if(sincronizacion){
        Display.sync(cuadrosPorSegundo);
        }


        Display.setVSyncEnabled(sincronizacionVertical);


       for(Recurso item:recursos){
           item.ejecutar();
           if(item.obtenerArrastre()){
                item.trasladarGlobal(Raton.obtenerDX(),0);
                item.trasladarGlobal(0,Raton.obtenerDY());
            }
            if(item.dentroDeLaPantalla()){
                dibujarRecurso(item);
            }
                        
        }

       
        if(Display.isCloseRequested()){

            Display.destroy();

            AL.destroy();
            System.exit(0);
        }
        
}

public void asignarMallaVisible(boolean visible){
    malla=visible;
}

public boolean obtenerMallaVisible(){
return malla;
}

public void asignarColorDeFondo(Color color){
    colorDeFondo = color;
}

public Color obtenerColorDeFondo(){
    return colorDeFondo;
}

public static void agregarRecurso(Recurso recurso,double posicionX,double posicionY){

    if(!recursos.contains(recurso)){
        recurso.asignarX(posicionX);
        recurso.asignarY(posicionY);

        recursos.add(recurso);
    }
}

public static void borrarRecursos(){
    recursos.clear();
}

public static void removerRecurso(Recurso recursoARemover){
     if(recursos.contains(recursoARemover)){
        recursos.remove(recursoARemover);
    }
}

public static float obtenerPosicionVistaX(){
    return posicionVistaX;
}

public static float obtenerPosicionVistaY(){
    return posicionVistaY;
}

public static void asignarPosicionVistaX(float nuevaX){
    posicionVistaX = nuevaX;
    pantalla.cambiarPuntos(0-nuevaX, pantalla.p1.y, anchura-nuevaX , pantalla.p3.y);
}

public static void asignarPosicionVistaY(float nuevaY){
    posicionVistaY = nuevaY;
    pantalla.cambiarPuntos(pantalla.p1.x, 0-nuevaY, pantalla.p3.x, altura-nuevaY);
}

    private void dibujarRecurso(Recurso recurso) {

    if(recurso instanceof Vacio==false && recurso instanceof Texto == false){

        Punto p1=recurso.obtenerP1(),p2=recurso.obtenerP2(),p3=recurso.obtenerP3(),p4=recurso.obtenerP4();
        glPushMatrix();
        glColor3f(recurso.obtenerMascaraColorRojo(),recurso.obtenerMascaraColorVerde(),recurso.obtenerMascaraColorAzul());
        
        recurso.obtenerImagen().vincular();
        
       if(recurso.esEstatico()==false){
            glTranslatef(posicionVistaX, posicionVistaY, 0);
        }
     
        glBegin(GL_QUADS);

        glTexCoord2d(recurso.mapeoFotograma1a,recurso.mapeoFotograma1b);//01
        glVertex2d(p1.x,p1.y);
        glTexCoord2d(recurso.mapeoFotograma2a,recurso.mapeoFotograma2b);//11
        glVertex2d(p2.x,p2.y);
        glTexCoord2d(recurso.mapeoFotograma3a,recurso.mapeoFotograma3b);//10
        glVertex2d(p3.x,p3.y);
        glTexCoord2d(recurso.mapeoFotograma4a,recurso.mapeoFotograma4b);//00
        glVertex2d(p4.x,p4.y);
    
        glEnd();

        glPopMatrix();

}else if(recurso instanceof Texto == true){
        ((Texto)recurso).render();

}
    
       
    }

    private void inicializar() throws LWJGLException {
    
    Display.setDisplayMode(new DisplayMode(anchura,altura));
    
    Display.create();
    

    glViewport(0,0,anchura,altura);
    glMatrixMode(GL_MODELVIEW);
  
   
    glEnable(GL_TEXTURE_2D); 
 
    glEnable(GL_BLEND);
    glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
  
    asignarSincronizacion(true);
 
    }

    public static int obtenerAltura(){

        return altura;
    }

    public static int obtenerAnchura(){
        return anchura;
    }

public void asignarSincronizacion(boolean sincronizacion){
    this.sincronizacion = sincronizacion;
}

public void asignarSincronizacionVertical(boolean sincronizacionVertical){
    this.sincronizacionVertical = sincronizacionVertical;
}


public void asignarTitulo(String titulo){

    Display.setTitle(titulo);
}

public int obtenerCuadrosPorSegundo() {
		if (Utilidades.obtenerTiempo() - ultimoFPS > 1000) {
			fpsARegresar = fps;
                        fps = 0;
			ultimoFPS += 1000;

		}
		fps++;

                return fpsARegresar;
	}

public Punto obtenerCentro(){

    return  new Punto(pantalla.p3.x/2, pantalla.p3.y/2);

}




}

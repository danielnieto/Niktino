/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.niktin.recursos;


import java.awt.geom.Line2D;
import java.io.FileInputStream;
import java.util.ArrayList;
import org.niktin.entrada.Raton;
import org.niktin.juego.Juego;
import org.niktin.utilidades.Punto;

import org.niktin.utilidades.Utilidades;

public class Recurso{
    protected Textura imagenDelRecurso;
    protected double anchura=0,altura=0;
    protected boolean trasladando=false,esHijo=false;
    protected double x=0f,y=0f,x2=0f, y2=0f;
    protected ArrayList<Recurso> hijos;
    protected double angulo=0d;
    protected double xRotacion=0f;
    protected double yRotacion=0f;
    protected double xEscalacion=0f;
    protected double yEscalacion=0f;
    protected double factorYEscalacion=1f;
    protected double factorXEscalacion=1f;
    protected double anchuraOriginal,alturaOriginal;
    protected Punto p1,p2,p3,p4;
    private boolean arrastre;
    private int fotogramaActualX=1;
    private int fotogramaActualY=1;
    private int numeroDeFotogramasX=1;
    private int numeroDeFotogramasY=1;
    private long tiempoFotograma = Utilidades.obtenerTiempo();
    private float mascaraColorRojo = 1f;
    private float mascaraColorVerde = 1f;
    private float mascaraColorAzul = 1f;
    protected FileInputStream FISTextura;
    private boolean cargado=false;
    private boolean esEstatico;
    protected double mapeoCoordenadaX=0;
    protected double mapeoCoordenadaY = 0;
    public double mapeoFotograma1a,mapeoFotograma1b, mapeoFotograma2a, mapeoFotograma2b, mapeoFotograma3a, mapeoFotograma3b, mapeoFotograma4a, mapeoFotograma4b;



    public Recurso(){}


    public Recurso(String ruta,int numX, int numY){
      
         
            Textura textura = new Textura(ruta);
            cargado=true;

            numeroDeFotogramasX = numX;
            numeroDeFotogramasY = numY;


            imagenDelRecurso = textura;

            hijos = new ArrayList();

            anchura = (int) textura.obtenerAnchuraDeImagen()/numX;
            altura = (int) textura.obtenerAlturaDeImagen()/numY;

            anchuraOriginal = anchura;
            alturaOriginal = altura;

         p1 = new Punto(0,0);
         p2 = new Punto(anchura,0);
         p3 = new Punto(anchura,altura);
         p4 = new Punto(0,altura);

        mapeoCoordenadaX = (double) ((double)imagenDelRecurso.obtenerAnchuraDeImagen()/(double)imagenDelRecurso.obtenerAnchuraDeTextura());
        mapeoCoordenadaY = (double)((double) imagenDelRecurso.obtenerAlturaDeImagen()/(double)imagenDelRecurso.obtenerAlturaDeTextura());

        mapeoFotograma1a = 0;
        mapeoFotograma1b = (double)((double)mapeoCoordenadaY/(double)numeroDeFotogramasY);
        mapeoFotograma2a = ((double)mapeoCoordenadaX/(double)numeroDeFotogramasX);
        mapeoFotograma2b = (double)((double)mapeoCoordenadaY/(double)numeroDeFotogramasY);
        mapeoFotograma3a = ((double)mapeoCoordenadaX/(double)numeroDeFotogramasX);
        mapeoFotograma3b = 0;
        mapeoFotograma4a = 0;
        mapeoFotograma4b = 0;


    }

    public Recurso(Textura textura,int numX, int numY){

         cargado=true;

         numeroDeFotogramasX = numX;
         numeroDeFotogramasY = numY;


         imagenDelRecurso = textura;

         hijos = new ArrayList();

         anchura = (int) textura.obtenerAnchuraDeImagen()/numX;
         altura = (int) textura.obtenerAlturaDeImagen()/numY;

         anchuraOriginal = anchura;
         alturaOriginal = altura;

         p1 = new Punto(0,0);
         p2 = new Punto(anchura,0);
         p3 = new Punto(anchura,altura);
         p4 = new Punto(0,altura);

         mapeoCoordenadaX = (double) ((double)imagenDelRecurso.obtenerAnchuraDeImagen()/(double)imagenDelRecurso.obtenerAnchuraDeTextura());
        mapeoCoordenadaY = (double)((double) imagenDelRecurso.obtenerAlturaDeImagen()/(double)imagenDelRecurso.obtenerAlturaDeTextura());

        mapeoFotograma1a = 0;
        mapeoFotograma1b = (double)((double)mapeoCoordenadaY/(double)numeroDeFotogramasY);
        mapeoFotograma2a = ((double)mapeoCoordenadaX/(double)numeroDeFotogramasX);
        mapeoFotograma2b = (double)((double)mapeoCoordenadaY/(double)numeroDeFotogramasY);
        mapeoFotograma3a = ((double)mapeoCoordenadaX/(double)numeroDeFotogramasX);
        mapeoFotograma3b = 0;
        mapeoFotograma4a = 0;
        mapeoFotograma4b = 0;

    }

    public Recurso(Textura textura){

         
         cargado=true;

         imagenDelRecurso = textura;

         hijos = new ArrayList();

         anchura = (int) textura.obtenerAnchuraDeImagen();
         altura = (int)  textura.obtenerAlturaDeImagen();

         anchuraOriginal = anchura;
         alturaOriginal = altura;

         p1 = new Punto(0,0);
         p2 = new Punto(anchura,0);
         p3 = new Punto(anchura,altura);
         p4 = new Punto(0,altura);

         mapeoCoordenadaX = (double) ((double)imagenDelRecurso.obtenerAnchuraDeImagen()/(double)imagenDelRecurso.obtenerAnchuraDeTextura());
        mapeoCoordenadaY = (double)((double) imagenDelRecurso.obtenerAlturaDeImagen()/(double)imagenDelRecurso.obtenerAlturaDeTextura());

        mapeoFotograma1a = 0;
        mapeoFotograma1b = (double)((double)mapeoCoordenadaY/(double)numeroDeFotogramasY);
        mapeoFotograma2a = ((double)mapeoCoordenadaX/(double)numeroDeFotogramasX);
        mapeoFotograma2b = (double)((double)mapeoCoordenadaY/(double)numeroDeFotogramasY);
        mapeoFotograma3a = ((double)mapeoCoordenadaX/(double)numeroDeFotogramasX);
        mapeoFotograma3b = 0;
        mapeoFotograma4a = 0;
        mapeoFotograma4b = 0;

    }

    public Recurso(String ruta){

                
            Textura textura = new Textura(ruta);
            cargado=true;
                    

         imagenDelRecurso = textura;

         hijos = new ArrayList();

        anchura = (int) textura.obtenerAnchuraDeImagen();
         altura = (int) textura.obtenerAlturaDeImagen();

         anchuraOriginal = anchura;
         alturaOriginal = altura;

         p1 = new Punto(0,0);
         p2 = new Punto(anchura,0);
         p3 = new Punto(anchura,altura);
         p4 = new Punto(0,altura);
         
       
        mapeoCoordenadaX = (double) ((double)imagenDelRecurso.obtenerAnchuraDeImagen()/(double)imagenDelRecurso.obtenerAnchuraDeTextura());
        mapeoCoordenadaY = (double)((double) imagenDelRecurso.obtenerAlturaDeImagen()/(double)imagenDelRecurso.obtenerAlturaDeTextura());


        mapeoFotograma1a = 0;
        mapeoFotograma1b = (double)((double)mapeoCoordenadaY/(double)numeroDeFotogramasY);
        mapeoFotograma2a = ((double)mapeoCoordenadaX/(double)numeroDeFotogramasX);
        mapeoFotograma2b = (double)((double)mapeoCoordenadaY/(double)numeroDeFotogramasY);
        mapeoFotograma3a = ((double)mapeoCoordenadaX/(double)numeroDeFotogramasX);
        mapeoFotograma3b = 0;
        mapeoFotograma4a = 0;
        mapeoFotograma4b = 0;
    }


public Textura obtenerImagen(){
    return imagenDelRecurso;
}

public void asignarImagen(Textura imagen){
    imagenDelRecurso = imagen;
    anchura = (int) imagen.obtenerAnchuraDeImagen();
    altura = (int) imagen.obtenerAlturaDeImagen();

    mapeoCoordenadaX = (double) ((double)imagenDelRecurso.obtenerAnchuraDeImagen()/(double)imagenDelRecurso.obtenerAnchuraDeTextura());
    mapeoCoordenadaY = (double)((double) imagenDelRecurso.obtenerAlturaDeImagen()/(double)imagenDelRecurso.obtenerAlturaDeTextura());
}

public double obtenerAnchura(){
    return anchura;
}

public void asignarAnchura(double ancho){
    anchura = ancho;
}

public double obtenerAltura(){
    return altura;
}

public void asignarAltura(double alto){
    anchura = alto;
}

public boolean colisionaCon(Recurso recurso){

    if(colisionaLadoDerechoDeObjetivo(recurso)){
        return true;
    }else if(colisionaLadoIzquierdoDeObjetivo(recurso)){
        return true;
    }else if(colisionaLadoSuperiorDeObjetivo(recurso)){
        return true;
    }else if(colisionaLadoInferiorDeObjetivo(recurso)){
        return true;
    }else{
      return false;
    }
}

public boolean colisionaConAlguno(){

    for(Recurso item:Juego.recursos){
            if(!item.equals(this)&&colisionaCon(item)){
                return true;
            }
     }

    return false;

}

    public boolean colisionaLadoDerechoDeObjetivo(Recurso objetivo) {

       if(Line2D.linesIntersect(p1.x, p1.y, p2.x,p2.y, objetivo.p2.x, objetivo.p2.y,objetivo.p3.x,objetivo.p3.y)){
        return true;
       }else if(Line2D.linesIntersect(p2.x, p2.y, p3.x,p3.y, objetivo.p2.x, objetivo.p2.y,objetivo.p3.x,objetivo.p3.y)){
        return true;
       }else if(Line2D.linesIntersect(p3.x, p3.y, p4.x,p4.y, objetivo.p2.x, objetivo.p2.y,objetivo.p3.x,objetivo.p3.y)){
        return true;
       }else if(Line2D.linesIntersect(p4.x, p4.y, p1.x,p1.y, objetivo.p2.x, objetivo.p2.y,objetivo.p3.x,objetivo.p3.y)){
        return true;
       }


        return false;
    }

    public boolean colisionaLadoIzquierdoDeObjetivo(Recurso objetivo) {
     
        if(Line2D.linesIntersect(p1.x, p1.y, p2.x,p2.y, objetivo.p1.x, objetivo.p1.y,objetivo.p4.x,objetivo.p4.y)){
        return true;
       }else if(Line2D.linesIntersect(p2.x, p2.y, p3.x,p3.y, objetivo.p1.x, objetivo.p1.y,objetivo.p4.x,objetivo.p4.y)){
        return true;
       }else if(Line2D.linesIntersect(p3.x, p3.y, p4.x,p4.y, objetivo.p1.x, objetivo.p1.y,objetivo.p4.x,objetivo.p4.y)){
        return true;
       }else if(Line2D.linesIntersect(p4.x, p4.y, p1.x,p1.y, objetivo.p1.x, objetivo.p1.y,objetivo.p4.x,objetivo.p4.y)){
        return true;
       }

        return false;
    }

        public boolean colisionaLadoSuperiorDeObjetivo(Recurso objetivo) {


       if(Line2D.linesIntersect(p1.x, p1.y, p2.x,p2.y, objetivo.p3.x, objetivo.p3.y,objetivo.p4.x,objetivo.p4.y)){
        return true;
       }else if(Line2D.linesIntersect(p2.x, p2.y, p3.x,p3.y, objetivo.p3.x, objetivo.p3.y,objetivo.p4.x,objetivo.p4.y)){
        return true;
       }else if(Line2D.linesIntersect(p3.x, p3.y, p4.x,p4.y, objetivo.p3.x, objetivo.p3.y,objetivo.p4.x,objetivo.p4.y)){
        return true;
       }else if(Line2D.linesIntersect(p4.x, p4.y, p1.x,p1.y, objetivo.p3.x, objetivo.p3.y,objetivo.p4.x,objetivo.p4.y)){
        return true;
       }

        return false;
    }

     public boolean colisionaLadoInferiorDeObjetivo(Recurso objetivo) {

         if(Line2D.linesIntersect(p1.x, p1.y, p2.x,p2.y, objetivo.p1.x, objetivo.p1.y,objetivo.p2.x,objetivo.p2.y)){
        return true;
       }else if(Line2D.linesIntersect(p2.x, p2.y, p3.x,p3.y, objetivo.p1.x, objetivo.p1.y,objetivo.p2.x,objetivo.p2.y)){
        return true;
       }else if(Line2D.linesIntersect(p3.x, p3.y, p4.x,p4.y, objetivo.p1.x, objetivo.p1.y,objetivo.p2.x,objetivo.p2.y)){
        return true;
       }else if(Line2D.linesIntersect(p4.x, p4.y, p1.x,p1.y, objetivo.p1.x, objetivo.p1.y,objetivo.p2.x,objetivo.p2.y)){
        return true;
       }

        return false;
    }
     
     public boolean colisionaLadoDerechoDePantalla() {

       if(Line2D.linesIntersect(p1.x, p1.y, p2.x,p2.y, Juego.pantalla.p2.x, Juego.pantalla.p2.y,Juego.pantalla.p3.x,Juego.pantalla.p3.y)){
        return true;
       }else if(Line2D.linesIntersect(p2.x, p2.y, p3.x,p3.y, Juego.pantalla.p2.x, Juego.pantalla.p2.y,Juego.pantalla.p3.x,Juego.pantalla.p3.y)){
        return true;
       }else if(Line2D.linesIntersect(p3.x, p3.y, p4.x,p4.y, Juego.pantalla.p2.x, Juego.pantalla.p2.y,Juego.pantalla.p3.x,Juego.pantalla.p3.y)){
        return true;
       }else if(Line2D.linesIntersect(p4.x, p4.y, p1.x,p1.y, Juego.pantalla.p2.x, Juego.pantalla.p2.y,Juego.pantalla.p3.x,Juego.pantalla.p3.y)){
        return true;
       }


        return false;
    }

    public boolean colisionaLadoIzquierdoDePantalla() {
     
        if(Line2D.linesIntersect(p1.x, p1.y, p2.x,p2.y, Juego.pantalla.p1.x, Juego.pantalla.p1.y,Juego.pantalla.p4.x,Juego.pantalla.p4.y)){
        return true;
       }else if(Line2D.linesIntersect(p2.x, p2.y, p3.x,p3.y, Juego.pantalla.p1.x, Juego.pantalla.p1.y,Juego.pantalla.p4.x,Juego.pantalla.p4.y)){
        return true;
       }else if(Line2D.linesIntersect(p3.x, p3.y, p4.x,p4.y, Juego.pantalla.p1.x, Juego.pantalla.p1.y,Juego.pantalla.p4.x,Juego.pantalla.p4.y)){
        return true;
       }else if(Line2D.linesIntersect(p4.x, p4.y, p1.x,p1.y, Juego.pantalla.p1.x, Juego.pantalla.p1.y,Juego.pantalla.p4.x,Juego.pantalla.p4.y)){
        return true;
       }

        return false;
    }

     public boolean colisionaLadoSuperiorDePantalla() {


       if(Line2D.linesIntersect(p1.x, p1.y, p2.x,p2.y, Juego.pantalla.p3.x, Juego.pantalla.p3.y,Juego.pantalla.p4.x,Juego.pantalla.p4.y)){
        return true;
       }else if(Line2D.linesIntersect(p2.x, p2.y, p3.x,p3.y, Juego.pantalla.p3.x, Juego.pantalla.p3.y,Juego.pantalla.p4.x,Juego.pantalla.p4.y)){
        return true;
       }else if(Line2D.linesIntersect(p3.x, p3.y, p4.x,p4.y, Juego.pantalla.p3.x, Juego.pantalla.p3.y,Juego.pantalla.p4.x,Juego.pantalla.p4.y)){
        return true;
       }else if(Line2D.linesIntersect(p4.x, p4.y, p1.x,p1.y, Juego.pantalla.p3.x, Juego.pantalla.p3.y,Juego.pantalla.p4.x,Juego.pantalla.p4.y)){
        return true;
       }

        return false;
    }

     public boolean colisionaLadoInferiorDePantalla() {

         if(Line2D.linesIntersect(p1.x, p1.y, p2.x,p2.y, Juego.pantalla.p1.x, Juego.pantalla.p1.y,Juego.pantalla.p2.x,Juego.pantalla.p2.y)){
        return true;
       }else if(Line2D.linesIntersect(p2.x, p2.y, p3.x,p3.y, Juego.pantalla.p1.x, Juego.pantalla.p1.y,Juego.pantalla.p2.x,Juego.pantalla.p2.y)){
        return true;
       }else if(Line2D.linesIntersect(p3.x, p3.y, p4.x,p4.y, Juego.pantalla.p1.x, Juego.pantalla.p1.y,Juego.pantalla.p2.x,Juego.pantalla.p2.y)){
        return true;
       }else if(Line2D.linesIntersect(p4.x, p4.y, p1.x,p1.y, Juego.pantalla.p1.x, Juego.pantalla.p1.y,Juego.pantalla.p2.x,Juego.pantalla.p2.y)){
        return true;
       }

        return false;
    }
     
     public boolean colisionaConLimitesDePantalla(){
         if(colisionaLadoSuperiorDePantalla()){
             return true;
         }
     
         if(colisionaLadoInferiorDePantalla()){
             return true;
         }
         
         if(colisionaLadoIzquierdoDePantalla()){
             return true;
         }
         
         if(colisionaLadoDerechoDePantalla()){
             return true;
         }
         
         return false;
     }

     public void agregarHijo(Recurso hijo){
         if(!hijos.contains(hijo)){
              hijos.add(hijo);
              hijo.esHijo=true;
         }
     }

     public void removerHijo(Recurso hijo){
         if(hijos.contains(hijo)){
              hijos.remove(hijo);
              hijo.asignarX(hijo.obtenerX());
              hijo.asignarY(hijo.obtenerY());
              hijo.esHijo=false;
         }
     }


public void asignarX(double posicionX){
    double dx = posicionX-x;
    x = posicionX;
    p1.x += dx;
    p2.x += dx;
    p3.x += dx;
    p4.x += dx;

    if(!hijos.isEmpty()){
        for(Recurso hijo:hijos){
            hijo.asignarX(hijo.obtenerX()+dx);
        }
    }
}

public double obtenerX(){
    return x;
}

public Punto obtenerP1(){
    return p1;
}

public Punto obtenerP2(){
    return p2;
}

public Punto obtenerP3(){
    return p3;
}

public Punto obtenerP4(){
    return p4;
}

public void asignarY(double posicionY){
    double dy = posicionY-y;
    y = posicionY;
    p1.y += dy;
    p2.y += dy;
    p3.y += dy;
    p4.y += dy;

    if(!hijos.isEmpty()){
        for(Recurso hijo:hijos){
            hijo.asignarY(hijo.obtenerY()+dy);
        }
    }
}

public double obtenerY(){
    return y;
}

public void rotarAgregado(double angulo, double x, double y){     
     
    this.angulo += (double) angulo;
    xRotacion = (double) x;
    yRotacion = (double) y;

    double tmpX = p1.x;
    double tmpY = p1.y;

    p1.x =  (x + (tmpX - x) * Math.cos(angulo) - (tmpY - y) * Math.sin(angulo));
    p1.y =  (y + (tmpX - x) * Math.sin(angulo) + (tmpY - y) * Math.cos(angulo));

    tmpX = p2.x;
    tmpY = p2.y;

    p2.x = (x + (tmpX - x) * Math.cos(angulo) - (tmpY - y) * Math.sin(angulo));
    p2.y =  (y + (tmpX - x) * Math.sin(angulo) + (tmpY - y) * Math.cos(angulo));

    tmpX = p3.x;
    tmpY = p3.y;

    p3.x = (x + (tmpX - x) * Math.cos(angulo) - (tmpY - y) * Math.sin(angulo));
    p3.y = (y + (tmpX - x) * Math.sin(angulo) + (tmpY - y) * Math.cos(angulo));

    tmpX = p4.x;
    tmpY = p4.y;

    p4.x =  (x + (tmpX - x) * Math.cos(angulo) - (tmpY - y) * Math.sin(angulo));
    p4.y =  (y + (tmpX - x) * Math.sin(angulo) + (tmpY - y) * Math.cos(angulo));


    this.x = p1.x;
    this.y = p1.y;

    if(!hijos.isEmpty()){
        for(Recurso hijo:hijos){
            hijo.rotarAgregado(angulo,x,y);
        }
    }
}


public void rotar(double angulo, double x, double y){
    
    
    rotarAgregado(this.angulo*-1,x,y);
    this.angulo = (double) angulo;
   
    
    xRotacion = (float) x;
    yRotacion = (float) y;

    double tmpX = p1.x;
    double tmpY = p1.y;


    p1.x =  (x + (tmpX - x) * Math.cos(angulo) - (tmpY - y) * Math.sin(angulo));
    p1.y =  (y + (tmpX - x) * Math.sin(angulo) + (tmpY - y) * Math.cos(angulo));

    tmpX = p2.x;
    tmpY = p2.y;

    p2.x = (x + (tmpX - x) * Math.cos(angulo) - (tmpY - y) * Math.sin(angulo));
    p2.y =  (y + (tmpX - x) * Math.sin(angulo) + (tmpY - y) * Math.cos(angulo));

    tmpX = p3.x;
    tmpY = p3.y;

    p3.x = (x + (tmpX - x) * Math.cos(angulo) - (tmpY - y) * Math.sin(angulo));
    p3.y = (y + (tmpX - x) * Math.sin(angulo) + (tmpY - y) * Math.cos(angulo));

    tmpX = p4.x;
    tmpY = p4.y;

    p4.x =  (x + (tmpX - x) * Math.cos(angulo) - (tmpY - y) * Math.sin(angulo));
    p4.y =  (y + (tmpX - x) * Math.sin(angulo) + (tmpY - y) * Math.cos(angulo));

    this.x = p1.x;
    this.y = p1.y;

    if(!hijos.isEmpty()){
        for(Recurso hijo:hijos){
            hijo.rotarAgregado(angulo,x,y);
        }
    }
}

public void rotar(double angulo){
    rotar(angulo, obtenerCentro().x, obtenerCentro().y);
}

public Punto rot(Punto p, double angulo, double x, double y){
           
    double tmpX = p.x;
    double tmpY = p.y;


    p.x =  (x + (tmpX - x) * Math.cos(angulo) - (tmpY - y) * Math.sin(angulo));
    p.y =  (y + (tmpX - x) * Math.sin(angulo) + (tmpY - y) * Math.cos(angulo));

    return p;
}

public void rotarAgregado(double angulo){
         
    this.angulo += angulo;

    double tmpX = p1.x;
    double tmpY = p1.y;

    p1.x = (float) (tmpX * Math.cos(angulo) - tmpY * Math.sin(angulo));
    p1.y = (float) (tmpX * Math.sin(angulo) + tmpY * Math.cos(angulo));

    tmpX = p2.x;
    tmpY = p2.y;

    p2.x = (float) (tmpX * Math.cos(angulo) - tmpY * Math.sin(angulo));
    p2.y = (float) (tmpX * Math.sin(angulo) + tmpY * Math.cos(angulo));

    tmpX = p3.x;
    tmpY = p3.y;

    p3.x = (float) (tmpX * Math.cos(angulo) - tmpY * Math.sin(angulo));
    p3.y = (float) (tmpX * Math.sin(angulo) + tmpY * Math.cos(angulo));

    tmpX = p4.x;
    tmpY = p4.y;

    p4.x = (float) (tmpX * Math.cos(angulo) - tmpY * Math.sin(angulo));
    p4.y = (float) (tmpX * Math.sin(angulo) + tmpY * Math.cos(angulo));

    this.x = p1.x;
    this.y = p1.y;

    if(!hijos.isEmpty()){
        for(Recurso hijo:hijos){
            hijo.rotarAgregado(angulo);
        }
    }
}

public void escalarGlobal(double factorX, double factorY, double pivoteX, double pivoteY){
    factorXEscalacion = factorX;
    factorYEscalacion = factorY;
    anchura *=factorX;
    altura *= factorY;

    xEscalacion =  pivoteX;
    yEscalacion =  pivoteY;

    double tmpX = p1.x;
    double tmpY = p1.y;

    p1.x = pivoteX + factorX*(tmpX-pivoteX);
    p1.y = pivoteY + factorY*(tmpY-pivoteY);

    tmpX = p2.x;
    tmpY = p2.y;

    p2.x = pivoteX + factorX*(tmpX-pivoteX);
    p2.y = pivoteY + factorY*(tmpY-pivoteY);

    tmpX = p3.x;
    tmpY = p3.y;

    p3.x = pivoteX + factorX*(tmpX-pivoteX);
    p3.y = pivoteY + factorY*(tmpY-pivoteY);

    tmpX = p4.x;
    tmpY = p4.y;

    p4.x = pivoteX + factorX*(tmpX-pivoteX);
    p4.y = pivoteY + factorY*(tmpY-pivoteY);

    this.x = p1.x;
    this.y = p1.y;
}

public void escalarLocal(double factorX, double factorY, double pivoteX, double pivoteY){
    double angulo = this.angulo;
    
    rotarAgregado(angulo*-1,xRotacion,yRotacion);
       
    
    factorXEscalacion = factorX;
    factorYEscalacion = factorY;
    anchura *=factorX;
    altura *= factorY;

              
    xEscalacion =  pivoteX;
    yEscalacion =  pivoteY;

    double tmpX = p1.x;
    double tmpY = p1.y;
   
    p1.x = pivoteX + factorX*(tmpX-pivoteX);
    p1.y = pivoteY + factorY*(tmpY-pivoteY);
       

    tmpX = p2.x;
    tmpY = p2.y;
      

    p2.x = pivoteX + factorX*(tmpX-pivoteX);
    p2.y = pivoteY + factorY*(tmpY-pivoteY);

    tmpX = p3.x;
    tmpY = p3.y;

    p3.x = pivoteX + factorX*(tmpX-pivoteX);
    p3.y = pivoteY + factorY*(tmpY-pivoteY);

    tmpX = p4.x;
    tmpY = p4.y;

       
    p4.x = pivoteX + factorX*(tmpX-pivoteX);
    p4.y = pivoteY + factorY*(tmpY-pivoteY);

   rotarAgregado(angulo,xRotacion,yRotacion);
  
    this.x = p1.x;
    this.y = p1.y;
    
    
}

public void trasladarLocal(double x, double y){

    double originalX=x, originalY=y;
    double tmpX = xRotacion + x;
    double tmpY = yRotacion + y;


    x =  (xRotacion + (tmpX - xRotacion) * Math.cos(angulo) - (tmpY - yRotacion) * Math.sin(angulo));
    y =  (yRotacion + (tmpX - xRotacion) * Math.sin(angulo) + (tmpY - yRotacion) * Math.cos(angulo));

    x=x-xRotacion;
    y=y-yRotacion;

    xRotacion+=x;
    yRotacion+=y;
        
    p1.x +=x;
    p1.y += y;

    p2.x +=x;
    p2.y += y;

    p3.x +=x;
    p3.y += y;

    p4.x +=x;
    p4.y += y;
    
    this.x = p1.x;
    this.y = p1.y;

        if(!hijos.isEmpty()){
        for(Recurso hijo:hijos){
                        
            if(hijo instanceof Texto){
                hijo.trasladarLocal(x,y);
            }else{
                hijo.trasladarLocal(originalX,originalY);
            }
        }
        }
   
}

public void trasladarGlobal(double x, double y){

    p1.x +=x;
    p1.y += y;

    p2.x +=x;
    p2.y += y;

    p3.x +=x;
    p3.y += y;

    p4.x +=x;
    p4.y += y;
    
    this.x = p1.x;
    this.y = p1.y;
    
     if(!hijos.isEmpty()){
        for(Recurso hijo:hijos){
            hijo.trasladarGlobal(x,y);
        }
        }

}

public void escalarPadreEHijos(double factorX, double factorY, double pivoteX, double pivoteY){
      factorXEscalacion = factorX;
    factorYEscalacion = factorY;
    anchura *=factorX;
    altura *= factorY;

    xEscalacion = (float) pivoteX;
    yEscalacion = (float) pivoteY;

    double tmpX = p1.x;
    double tmpY = p1.y;

    p1.x = pivoteX + factorX*(tmpX-pivoteX);
    p1.y = pivoteY + factorY*(tmpY-pivoteY);

    tmpX = p2.x;
    tmpY = p2.y;

    p2.x = pivoteX + factorX*(tmpX-pivoteX);
    p2.y = pivoteY + factorY*(tmpY-pivoteY);

    tmpX = p3.x;
    tmpY = p3.y;

    p3.x = pivoteX + factorX*(tmpX-pivoteX);
    p3.y = pivoteY + factorY*(tmpY-pivoteY);

    tmpX = p4.x;
    tmpY = p4.y;

    p4.x = pivoteX + factorX*(tmpX-pivoteX);
    p4.y = pivoteY + factorY*(tmpY-pivoteY);

    this.x = p1.x;
    this.y = p1.y;

     if(!hijos.isEmpty()){
        for(Recurso hijo:hijos){
            hijo.escalarLocal(factorX,factorY,pivoteX,pivoteY);
        }
    }
}

public void escalar(double factorX, double factorY){
    factorXEscalacion = factorX;
    factorYEscalacion = factorY;
    anchura *= factorX;
    altura *= factorY;
    
    p1.x*= factorX;
    p2.x*= factorX;
    p3.x*= factorX;
    p4.x*= factorX;

    p1.y*= factorY;
    p2.y*= factorY;
    p3.y*= factorY;
    p4.y*= factorY;

    this.x = p1.x;
    this.y = p1.y;
}

public void escalarPadreEHijos(double factorX, double factorY){
    factorXEscalacion = factorX;
    factorYEscalacion = factorY;
    anchura *= factorX;
    altura *= factorY;

    p1.x*= factorX;
    p2.x*= factorX;
    p3.x*= factorX;
    p4.x*= factorX;

    p1.y*= factorY;
    p2.y*= factorY;
    p3.y*= factorY;
    p4.y*= factorY;

   this.x = p1.x;
   this.y = p1.y;
    
    if(!hijos.isEmpty()){
        for(Recurso hijo:hijos){
            hijo.escalar(factorX,factorY);
        }
    }
}

public double obtenerAnguloDeRotacion(){
    return angulo;
}

public void asignarAnguloDeRotacion(double angulo){
    this.angulo = angulo;
}

public double obtenerPivoteXParaRotacion(){
    return xRotacion;
}

public double obtenerPivoteYParaRotacion(){
    return yRotacion;
}

public void asignarPivoteXParaRotacion(double nuevoPivoteX){
    xRotacion  = nuevoPivoteX;
}

public void asignarPivoteYParaRotacion(double nuevoPivoteY){
    yRotacion  = nuevoPivoteY;
}

public double obtenerPivoteXParaEscalacion(){
    return xEscalacion;

}

public double obtenerPivoteYParaEscalacion(){
    return yEscalacion;

}

public double obtenerFactorXDeEscalacion(){

    return factorXEscalacion;
}

public double obtenerFactorYDeEscalacion(){

    return factorYEscalacion;
}

public double obtenerAnchuraOriginal(){
    return anchuraOriginal;
}

public double obtenerAlturaOriginal(){
    return alturaOriginal;
}

public Punto obtenerCentro(){

     
    Punto centro;

    centro = new Punto((double)((double)p1.x+(double)p3.x)/(double)2.0,(double)((double)p1.y+(double)p3.y)/(double)2.0);
    
    return centro;
}

public boolean ratonSobreObjeto(){
    
     return this.contienePunto(new Punto(Raton.obtenerX()-Juego.obtenerPosicionVistaX(),Raton.obtenerY()-Juego.obtenerPosicionVistaY()));
    
}

public void comienzaArrastre(){
    arrastre = true;
}

public void finalizaArrastre(){
    arrastre = false;
}

public boolean obtenerArrastre(){
    return arrastre;
}

public int obtenerNumeroDeFotogramasX(){
    return numeroDeFotogramasX;
}

public int obtenerNumeroDeFotogramasY(){
    return numeroDeFotogramasY;
}

public int obtenerFotogramaActualX(){
    return fotogramaActualX;
}

public int obtenerFotogramaActualY(){
    return fotogramaActualY;
}

public int obtenerFotogramaActual(){
        int fotogramaActual = ((fotogramaActualY-1)*numeroDeFotogramasX)+fotogramaActualX;

    return fotogramaActual;
}

public void asignarFotogramaActual(int fotograma){
    int ultimoFotograma = numeroDeFotogramasX*numeroDeFotogramasY;
    
    if(fotograma>ultimoFotograma){
        fotograma=ultimoFotograma;
    }

    if(fotograma<1){
        fotograma=1;
    }
    
    fotogramaActualY = (int) Math.ceil((double)fotograma/(double)numeroDeFotogramasX);
    fotogramaActualX =  fotograma - (fotogramaActualY-1)*(numeroDeFotogramasX);

      mapeoFotograma1a = (double)((double)mapeoCoordenadaX/(double)numeroDeFotogramasX)*((double)obtenerFotogramaActualX()-1);
        mapeoFotograma1b = (double)((double)mapeoCoordenadaY/(double)numeroDeFotogramasY)*(double)obtenerFotogramaActualY();
        mapeoFotograma2a = ((double)mapeoCoordenadaX/(double)numeroDeFotogramasX)*(double)obtenerFotogramaActualX();
        mapeoFotograma2b = (double)((double)mapeoCoordenadaY/(double)numeroDeFotogramasY)*(double)obtenerFotogramaActualY();
        mapeoFotograma3a = ((double)mapeoCoordenadaX/(double)numeroDeFotogramasX)*(double)obtenerFotogramaActualX();
        mapeoFotograma3b = (double)((double)mapeoCoordenadaY/(double)numeroDeFotogramasY)*((double)obtenerFotogramaActualY()-1);
        mapeoFotograma4a = ((double)mapeoCoordenadaX/(double)numeroDeFotogramasX)*((double)obtenerFotogramaActualX()-1);
        mapeoFotograma4b = (double)((double)mapeoCoordenadaY/(double)numeroDeFotogramasY)*((double)obtenerFotogramaActualY()-1);

}

public void fotogramaSiguiente(){
    asignarFotogramaActual(obtenerFotogramaActual()+1);

}

public void fotogramaSiguiente(long milisegundosAEsperar){
    long tiempoActual = Utilidades.obtenerTiempo();

    if(tiempoActual-tiempoFotograma>milisegundosAEsperar){
        asignarFotogramaActual(obtenerFotogramaActual()+1);
        tiempoFotograma=tiempoActual;
    }

}

public void fotogramaSiguiente(long milisegundosAEsperar, int ultimo){
    long tiempoActual = Utilidades.obtenerTiempo();
    if(obtenerFotogramaActual()!=ultimo){

    if(tiempoActual-tiempoFotograma>milisegundosAEsperar){
        asignarFotogramaActual(obtenerFotogramaActual()+1);
        tiempoFotograma=tiempoActual;
    }

    }

}

public void fotogramaAnterior(long milisegundosAEsperar){
    long tiempoActual = Utilidades.obtenerTiempo();

    if(tiempoActual-tiempoFotograma>milisegundosAEsperar){
        asignarFotogramaActual(obtenerFotogramaActual()-1);
        tiempoFotograma=tiempoActual;
    }

}

public void fotogramaAnterior(){

        asignarFotogramaActual(obtenerFotogramaActual()-1);

}

public void fotogramaAnterior(long milisegundosAEsperar,int primero){
    long tiempoActual = Utilidades.obtenerTiempo();


    if(obtenerFotogramaActual()!=primero){
    if(tiempoActual-tiempoFotograma>milisegundosAEsperar){
        asignarFotogramaActual(obtenerFotogramaActual()-1);
        tiempoFotograma=tiempoActual;
    }
    }
}

public int fotogramasTotales(){
    return numeroDeFotogramasX*numeroDeFotogramasY;
}

public void aplicarMascaraDeColor(float rojo, float verde, float azul){
    mascaraColorRojo = rojo<=1?rojo:1;
    mascaraColorVerde = verde<=1?verde:1;
    mascaraColorAzul = azul<=1?azul:1;

    if (mascaraColorRojo<0) mascaraColorRojo=0;
    if (mascaraColorVerde<0) mascaraColorVerde=0;
    if (mascaraColorAzul<0) mascaraColorAzul=0;

}

public float obtenerMascaraColorRojo(){
    return mascaraColorRojo;
}

public float obtenerMascaraColorVerde(){
    return mascaraColorVerde;
}

public float obtenerMascaraColorAzul(){
    return mascaraColorAzul;
}

public boolean cargaCompleta(){

    return cargado;
}

    public void esEstatico(boolean esEstatico) {
        this.esEstatico = esEstatico;
    }

    public boolean esEstatico(){
        return esEstatico;
    }

    public ArrayList<Recurso> obtenerHijos(){
        return hijos;
    }
    
    public void ejecutar(){}


    public boolean dentroDeLaPantalla() {
      
        if(this.anchura>=Juego.obtenerAnchura()||this.altura>=Juego.obtenerAltura()){
        
            if(this.contienePunto(Juego.pantalla.p1)||this.contienePunto(Juego.pantalla.p2)||this.contienePunto(Juego.pantalla.p3)||this.contienePunto(Juego.pantalla.p4)){
            
                return true;
            }
        
        }
        
        
        if(colisionaLadoDerechoDePantalla()){
            return true;
        }else if(colisionaLadoIzquierdoDePantalla()){
            return true;
        }else if(colisionaLadoSuperiorDePantalla()){
            return true;
        }else if(colisionaLadoInferiorDePantalla()){
            return true;
        }else if(Juego.pantalla.contienePunto(obtenerCentro())){
            return true;
        }else{
            return false;
        }
                
        
    }
    
    public boolean contienePunto(Punto p){
    boolean contenido = false;
    
   
    if(p.x>=p1.x&&p.x<=p3.x){
        if(p.y>=p1.y&&p.y<=p3.y){
            contenido = true;          
        }
    }
    
    return contenido;
}


}

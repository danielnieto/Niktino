/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.niktin.utilidades;


/**
 *
 * @author danielnieto
 */


public class Rectangulo{
    
public Punto p1,p2,p3,p4;    


public Rectangulo(int x1,int y1, int x2, int y2){
    
    p1 = new Punto(x1,y1);
    p2 = new Punto(x2,y1);
    p3 = new Punto(x2,y2);
    p4 = new Punto(x1,y2);
  
}

public Rectangulo(double x1,double y1, double x2, double y2){
    
    p1 = new Punto(x1,y1);
    p2 = new Punto(x2,y1);
    p3 = new Punto(x2,y2);
    p4 = new Punto(x1,y2);
    
     
}

public void cambiarPuntos(double x1,double y1, double x2, double y2){
    
    p1 = new Punto(x1,y1);
    p2 = new Punto(x2,y1);
    p3 = new Punto(x2,y2);
    p4 = new Punto(x1,y2);

}

public void cambiarPuntos(int x1,int y1,int x2, int y2){
    
    p1 = new Punto(x1,y1);
    p2 = new Punto(x2,y1);
    p3 = new Punto(x2,y2);
    p4 = new Punto(x1,y2);
    

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

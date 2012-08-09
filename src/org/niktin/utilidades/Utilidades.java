
package org.niktin.utilidades;

import java.util.ArrayList;
import java.util.Collections;
import org.lwjgl.Sys;

/**
 *
 * @author Daniel
 */
public class Utilidades {

    public ArrayList<Punto> calcularPuntosEnArista(double x1, double y1, double x2, double y2){

         ArrayList<Punto> arista = new ArrayList();
         boolean inverso = false;
         double dx, dy, x, y, xf, p, c1, c2, in,yf;
         dx= Math.abs(x2-x1);
         dy= Math.abs(y2-y1);
         p=(2*dy)-dx;
         c1=2*dy;
         c2=2*(dy-dx);


         if(dx>=dy){
            if(x1>x2)
            {
               x=x2;
               y=y2;
               xf=x1;
                inverso=true;
            }

            else{
               x=x1;
               y=y1;
               xf=x2;

            }
            if(y2<y1){
               in= -1;            
            }
            else{
               in=1;
               
            }

            arista.add(new Punto(x,y));

            while (x<xf)
            {
               x=x+1;
               if(p<0)
               { p=p+c1;}
               else{
                  if(x2>x1){
                     y=y+in;
                  }
                  else{
                     y=y-in;
                  }
                  p=p+c2;
               }
                arista.add(new Punto(x,y));
            }

         }
         else{
            p=(2*dx)-dy;
            c1=2*dx;
            c2=2*(dx-dy);

            if(y1>y2)
            {
               x=x2;
               y=y2;
               yf=y1;
               inverso=true;
            }

            else{
               x=x1;
               y=y1;
               yf=y2;
            }
            if(x2<x1){
               in=-1;
               
            }
            else{
               in=1;
               
            }
                arista.add(new Punto(x,y));

            while (y<yf)
            {
               y=y+1;
               if(p<0)
               { p=p+c1;}
               else{

                  if(y2>y1){
                     x=x+in;
                  }
                  else{
                     x=x-in;
                  }
                  p=p+c2;
               }
               arista.add(new Punto(x,y));
            }

      }

         if(inverso){
           Collections.reverse(arista);

         }

         

         return arista;
    }


    public static long obtenerTiempo() {
	    return (Sys.getTime() * 1000) / Sys.getTimerResolution();
            }

public static int aleatorio(int max,int min){
    return (int)(Math.random()*(max-min))+min;
}

public static double aleatorio(double max,double min){
    return (Math.random()*(max-min))+min;
}








}

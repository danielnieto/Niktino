/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.niktin.recursos;

import java.util.ArrayList;
import org.niktin.utilidades.Punto;

/**
 *
 * @author Daniel
 */

public class Vacio extends Recurso{


    public Vacio(float anchura, float altura) {
        super.anchura = anchura;
        super.altura = altura;
        super.hijos = new ArrayList();

        super.anchuraOriginal = anchura;
        super.alturaOriginal = altura;


         p1 = new Punto(0,0);
         p2 = new Punto(anchura,0);
         p3 = new Punto(anchura,altura);
         p4 = new Punto(0,altura);

    }

     public Vacio(double anchura, double altura) {
        super.anchura = anchura;
        super.altura = altura;
        super.hijos = new ArrayList();

        super.anchuraOriginal = anchura;
        super.alturaOriginal = altura;


         p1 = new Punto(0,0);
         p2 = new Punto(anchura,0);
         p3 = new Punto(anchura,altura);
         p4 = new Punto(0,altura);

    }

}

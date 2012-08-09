/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.niktin.entrada;

import org.lwjgl.input.Mouse;
import org.niktin.utilidades.Utilidades;


/**
 *
 * @author Daniel
 */
public class Raton {

    public static final int BOTON_IZQUIERDO = 0;
    public static final int BOTON_DERECHO = 1;
    public static final int BOTON_CENTRAL = 2;
    public static final int RUEDA_GIRA_ARRIBA=1;
    public static final int RUEDA_GIRA_ABAJO=-1;
    public static final int RUEDA_NO_GIRA=0;
    private static int xAnterior=0,yAnterior=0;
    private static int dx=0;
    private static int dy=0;
    private static long tiempoAnterior=0;
 




    public static int obtenerX(){
        xAnterior=Mouse.getX();
        yAnterior=Mouse.getY();
        return Mouse.getX();
    }



    public static int obtenerY(){
        xAnterior=Mouse.getX();
        yAnterior=Mouse.getY();
        return Mouse.getY();
    }

    public static void asignarPosicionDeCursor(int x, int y){

        Mouse.setCursorPosition(x, y);
    }
    
    public static void asignarPosicionDeCursor(double x, double y){

        Mouse.setCursorPosition((int)x,(int)y);
    }

    public static boolean estaDentroDeLaPantalla(){
        return Mouse.isInsideWindow();
    }

    public static boolean botonPresionado(int boton){
       xAnterior=Mouse.getX();
       yAnterior=Mouse.getY();
        
        return Mouse.isButtonDown(boton);
    }

    public static void asignarMouseOculto(boolean visible){
        Mouse.setGrabbed(visible);
    }

    public static int obtenerRotacionDeRueda(){
        xAnterior=Mouse.getX();
        yAnterior=Mouse.getY();
        int rueda=Mouse.getDWheel();
        int rotacion=0;
        if(rueda<0){
            rotacion=-1;
        }else if(rueda>0){
            rotacion=1;
        }
        return rotacion;
    }

    public static int obtenerDX(){
        if(xAnterior==0){ 
            xAnterior=Mouse.getX();
        }
        int xActual = Mouse.getX();     
        dx = xActual-xAnterior;
        xAnterior = xActual;
        return dx;
    }

    public static int obtenerDY(){
       if(yAnterior==0){
           yAnterior=Mouse.getY();
       }
       int yActual = Mouse.getY();
        dy = yActual-yAnterior;
        yAnterior = yActual;
        
        return dy;
    }

    public static long obtenerIntervalo(){
    long tiempoActual = Utilidades.obtenerTiempo();
    long intervalo = tiempoActual - tiempoAnterior;
    tiempoAnterior = tiempoActual;

    return intervalo;

    }



 

     
    }

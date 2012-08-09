/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.niktin.recursos;

import org.niktin.juego.Juego;
import java.awt.Color;
import org.newdawn.slick.font.effects.ColorEffect;
import static org.lwjgl.opengl.GL11.*;

/**
 *
 * @author danielnieto
 */
public class Texto extends Recurso{
    
    Fuente fuente;
    String contenido;
    int tamano;
    boolean italica=false,negrita=false;
    Color color = java.awt.Color.WHITE;
    String texto;
    double x=0;
    public double y=0;
    private double y2=0;
    
    public Texto(Fuente f, String texto){
        this.fuente = f;
        this.texto = texto;
        fuente.uFont.getEffects().add(new ColorEffect(Color.GREEN));
    
    }
    
    public void render(){
        
        glPushMatrix();
        glLoadIdentity();
        glOrtho(0, Juego.obtenerAnchura(), Juego.obtenerAltura(), 0, 1, -1);
                             
        fuente.uFont.drawString((int)x, (int)y2, texto);

        glLoadIdentity();
        
   
        glPopMatrix(); 
    
    }

    public void asignarTexto(String texto){
        this.texto = texto;
    }

    
    @Override
    public void asignarX(double x){
        this.x = x;
    }

    
    @Override
    public void asignarY(double y){
        this.y2 =  Juego.obtenerAltura() - y - fuente.uFont.getLineHeight();
        this.y = y;        
    }

    public String obtenerTexto(){
        return texto;
    }

    @Override
    public double obtenerX(){
        return x;
    }

    @Override
    public double obtenerY(){
        return y;
    }

    public int obtenerAnchura(String texto){
        return fuente.uFont.getWidth(texto);
    }

    public int obtenerAltura(String texto){
        return fuente.uFont.getHeight(texto);
    }
    
    @Override 
   public void escalarPadreEHijos(double factorX, double factorY){}
    
    @Override
    public void escalar(double factorX, double factorY){}
    
    @Override
    public void escalarGlobal(double factorX, double factorY, double pivoteX, double pivoteY){}
    
    @Override
    public void escalarLocal(double factorX, double factorY, double pivoteX, double pivoteY){}
    
    @Override
    public void rotarAgregado(double angulo){}
    
    @Override
    public void rotar(double angulo, double x, double y){}
    
    @Override
    public void rotarAgregado(double angulo, double x, double y){}
    
    @Override
    public boolean dentroDeLaPantalla() {
        //POR HACER
        return true;
    }
    
    @Override
    public void trasladarLocal(double x, double y){
        asignarX(obtenerX()+x);
        asignarY(obtenerY()+y);
    
    }
    
    @Override
    public void trasladarGlobal(double x, double y){
        asignarX(obtenerX()+x);
        asignarY(obtenerY()+y);
    
    }
    
    @Override
    public void agregarHijo(Recurso hijo){
        throw new RuntimeException("Un texto no puede tener hijos.");
    
    }
    
}

package org.niktin.recursos;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.openal.Audio;
import org.newdawn.slick.openal.AudioLoader;
import org.niktin.utilidades.Utilidades;

/**
 *
 * @author Daniel
 */


public class Sonido {
    
    private Audio sonido;
    private static long tiempoAnterior=0;
    private boolean cargado=false;

    public Sonido(String ruta){
        try {
            sonido = AudioLoader.getAudio("WAV", new FileInputStream(ruta));
            cargado=true;
        } catch (IOException ex) {
            Logger.getLogger(Sonido.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void reproducirComoEfecto(float velocidad, float volumen, boolean repetir){

        sonido.playAsSoundEffect(velocidad, volumen, repetir);
    }
    
    public void reproducirComoEfecto(){

        sonido.playAsSoundEffect(1f, 1f, false);
    }
    
    public void reproducirComoEfecto(boolean repetir){

        sonido.playAsSoundEffect(1f, 1f, repetir);
        
    }
    
    public void reproducirComoMusica(){

        sonido.playAsMusic(1f, 1f, false);
    }
    
    public void reproducirComoMusica(float velocidad, float volumen, boolean repetir){

        sonido.playAsMusic(velocidad, volumen, repetir);
    }
    
    public void reproducirComoMusica(boolean repetir){

        sonido.playAsMusic(1f, 1f, repetir);
    }

    public boolean estaSonando(){
        return sonido.isPlaying();
    }

    public void parar(){
        sonido.stop();
    }

    public static long obtenerIntervalo(){
        long tiempoActual = Utilidades.obtenerTiempo();
        long intervalo = tiempoActual - tiempoAnterior;
        tiempoAnterior = tiempoActual;

    return intervalo;

    }

    public boolean cargaCompleta(){

        return cargado;
    }

}

package org.niktin.recursos;

import org.newdawn.slick.font.effects.ColorEffect;
import java.awt.Color;
import java.awt.Font;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.UnicodeFont;


/**
 *
 * @author Daniel
 */
public class Fuente extends Recurso{
        protected UnicodeFont uFont;
         
        public Fuente(String fuente, int tamano, Color color) throws SlickException{
                                        
        uFont = new UnicodeFont(fuente,24,false,false);
        uFont.addGlyphs(32,127);
        uFont.addGlyphs("ñ");
        uFont.addGlyphs("Ñ");
        uFont.addGlyphs("á");
        uFont.addGlyphs("é");
        uFont.addGlyphs("í");
        uFont.addGlyphs("ó");
        uFont.addGlyphs("ú");
        uFont.getEffects().add(new ColorEffect(color));
        uFont.loadGlyphs();

    }

        
        public Fuente(String fuente, int tamano, Color color, boolean negrita, boolean italica) throws SlickException{
                                        
        uFont = new UnicodeFont(fuente,tamano,negrita,italica);
        uFont.addGlyphs(32,127);
        uFont.addGlyphs("ñ");
        uFont.addGlyphs("Ñ");
        uFont.addGlyphs("á");
        uFont.addGlyphs("é");
        uFont.addGlyphs("í");
        uFont.addGlyphs("ó");
        uFont.addGlyphs("ú");
        uFont.getEffects().add(new ColorEffect(color));
        uFont.loadGlyphs();

    }
        
        public Fuente(String fuente, int tamano) throws SlickException{
                                        
        uFont = new UnicodeFont(fuente,tamano,false,false);
        uFont.addGlyphs(32,127);
        uFont.addGlyphs("ñ");
        uFont.addGlyphs("Ñ");
        uFont.addGlyphs("á");
        uFont.addGlyphs("é");
        uFont.addGlyphs("í");
        uFont.addGlyphs("ó");
        uFont.addGlyphs("ú");       
        uFont.getEffects().add(new ColorEffect(Color.white));
        uFont.loadGlyphs();
        

    }
        
               
        public Fuente(Font fuente,Color color) throws SlickException{                                      
        uFont = new UnicodeFont(fuente,fuente.getSize(),fuente.isBold(),fuente.isItalic());
        uFont.addGlyphs(32,127);
        uFont.addGlyphs("ñ");
        uFont.addGlyphs("Ñ");
        uFont.addGlyphs("á");
        uFont.addGlyphs("é");
        uFont.addGlyphs("í");
        uFont.addGlyphs("ó");
        uFont.addGlyphs("ú");
        uFont.getEffects().add(new ColorEffect(color));
        uFont.loadGlyphs();

    }
}

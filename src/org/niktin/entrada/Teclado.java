/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.niktin.entrada;
import org.lwjgl.input.Keyboard;
import org.niktin.utilidades.Utilidades;


public class Teclado {
        private static long tiempoAnterior=0;

    	public static final int TECLA_NINGUNA            = 0x00;

	public static final int TECLA_ESCAPE          = 0x01;
	public static final int TECLA_1               = 0x02;
	public static final int TECLA_2               = 0x03;
	public static final int TECLA_3               = 0x04;
	public static final int TECLA_4               = 0x05;
	public static final int TECLA_5               = 0x06;
	public static final int TECLA_6               = 0x07;
	public static final int TECLA_7               = 0x08;
	public static final int TECLA_8               = 0x09;
	public static final int TECLA_9               = 0x0A;
	public static final int TECLA_0               = 0x0B;
	public static final int TECLA_RESTA           = 0x0C; /* - on main keyboard */
	public static final int TECLA_IGUAL          = 0x0D;
	public static final int TECLA_ATRAS            = 0x0E; /* backspace */
	public static final int TECLA_TABULADOR            = 0x0F;
	public static final int TECLA_Q               = 0x10;
	public static final int TECLA_W               = 0x11;
	public static final int TECLA_E               = 0x12;
	public static final int TECLA_R               = 0x13;
	public static final int TECLA_T               = 0x14;
	public static final int TECLA_Y               = 0x15;
	public static final int TECLA_U               = 0x16;
	public static final int TECLA_I               = 0x17;
	public static final int TECLA_O               = 0x18;
	public static final int TECLA_P               = 0x19;
	public static final int TECLA_PARENTESIS_CUADRADO_IZQ        = 0x1A;
	public static final int TECLA_PARENTESIS_CUADRADO_DER        = 0x1B;
	public static final int TECLA_ENTER          = 0x1C; /* Enter on main keyboard */
	public static final int TECLA_CONTROL_IZQ        = 0x1D;
	public static final int TECLA_A               = 0x1E;
	public static final int TECLA_S               = 0x1F;
	public static final int TECLA_D               = 0x20;
	public static final int TECLA_F               = 0x21;
	public static final int TECLA_G               = 0x22;
	public static final int TECLA_H               = 0x23;
	public static final int TECLA_J               = 0x24;
	public static final int TECLA_K               = 0x25;
	public static final int TECLA_L               = 0x26;
	public static final int TECLA_PUNTO_Y_COMA       = 0x27;
	public static final int TECLA_APOSTROFE      = 0x28;
	public static final int TECLA_ACENTO         = 0x29; /* accent grave */
	public static final int TECLA_SHIFT_IZQ          = 0x2A;
	public static final int TECLA_DIAGONAL_INVERTIDA       = 0x2B;
	public static final int TECLA_Z               = 0x2C;
	public static final int TECLA_X               = 0x2D;
	public static final int TECLA_C               = 0x2E;
	public static final int TECLA_V               = 0x2F;
	public static final int TECLA_B               = 0x30;
	public static final int TECLA_N               = 0x31;
	public static final int TECLA_M               = 0x32;
	public static final int TECLA_COMA           = 0x33;
	public static final int TECLA_PUNTO          = 0x34; /* . on main keyboard */
	public static final int TECLA_DIAGONAL           = 0x35; /* / on main keyboard */
	public static final int TECLA_SHIFT_DER          = 0x36;
	public static final int TECLA_TECLADO_NUMERICO_MULTIPLICACION        = 0x37; /* * on numeric keypad */
	public static final int TECLA_ALT_IZQ           = 0x38; /* left Alt */
	public static final int TECLA_ESPACIO          = 0x39;
	public static final int TECLA_MAYSCULA         = 0x3A;
	public static final int TECLA_F1              = 0x3B;
	public static final int TECLA_F2              = 0x3C;
	public static final int TECLA_F3              = 0x3D;
	public static final int TECLA_F4              = 0x3E;
	public static final int TECLA_F5              = 0x3F;
	public static final int TECLA_F6              = 0x40;
	public static final int TECLA_F7              = 0x41;
	public static final int TECLA_F8              = 0x42;
	public static final int TECLA_F9              = 0x43;
	public static final int TECLA_F10             = 0x44;
	public static final int TECLA_BLOQ_NUM         = 0x45;
	public static final int TECLA_SCROLL          = 0x46; /* Scroll Lock */
	public static final int TECLA_TECLADO_NUMERICO_7         = 0x47;
	public static final int TECLA_TECLADO_NUMERICO_8         = 0x48;
	public static final int TECLA_TECLADO_NUMERICO_9         = 0x49;
	public static final int TECLA_TECLADO_NUMERICO_RESTA        = 0x4A; /* - on numeric keypad */
	public static final int TECLA_TECLADO_NUMERICO_4         = 0x4B;
	public static final int TECLA_TECLADO_NUMERICO_5         = 0x4C;
	public static final int TECLA_TECLADO_NUMERICO_6         = 0x4D;
	public static final int TECLA_TECLADO_NUMERICO_SUMA             = 0x4E; /* + on numeric keypad */
	public static final int TECLA_TECLADO_NUMERICO_1         = 0x4F;
	public static final int TECLA_TECLADO_NUMERICO_2         = 0x50;
	public static final int TECLA_TECLADO_NUMERICO_3         = 0x51;
	public static final int TECLA_TECLADO_NUMERICO_0         = 0x52;
	public static final int TECLA_TECLADO_NUMERICO_PUNTO         = 0x53; /* . on numeric keypad */
	public static final int TECLA_F11             = 0x57;
	public static final int TECLA_F12             = 0x58;
	public static final int TECLA_F13             = 0x64; /*                     (NEC PC98) */
	public static final int TECLA_F14             = 0x65; /*                     (NEC PC98) */
	public static final int TECLA_F15             = 0x66; /*                     (NEC PC98) */
	public static final int TECLA_TECLADO_NUMERICO_IGUAL    = 0x8D; /* = on numeric keypad (NEC PC98) */
	public static final int TECLA_ARROBA              = 0x91; /*                     (NEC PC98) */
	public static final int TECLA_DOS_PUNTOS           = 0x92; /*                     (NEC PC98) */
	public static final int TECLA_GUION_BAJO       = 0x93; /*                     (NEC PC98) */
	public static final int TECLA_PARAR            = 0x95; /*                     (NEC PC98) */
	public static final int TECLA_TECLADO_NUMERICO_ENTER     = 0x9C; /* Enter on numeric keypad */
	public static final int TECLA_CONTROL_DER        = 0x9D;
	public static final int TECLA_TECLADO_NUMERICO_COMA     = 0xB3; /* , on numeric keypad (NEC PC98) */
	public static final int TECLA_TECLADO_NUMERICO_DIVISION          = 0xB5; /* / on numeric keypad */
	public static final int TECLA_PET_SIS           = 0xB7;
	public static final int TECLA_ALT_DER           = 0xB8; /* right Alt */
	public static final int TECLA_PAUSA           = 0xC5; /* Pause */
	public static final int TECLA_INICIO            = 0xC7; /* Home on arrow keypad */
	public static final int TECLA_ARRIBA              = 0xC8; /* UpArrow on arrow keypad */
	public static final int TECLA_RE_PAG           = 0xC9; /* PgUp on arrow keypad */
	public static final int TECLA_IZQUIERDA            = 0xCB; /* LeftArrow on arrow keypad */
	public static final int TECLA_DERECHA           = 0xCD; /* RightArrow on arrow keypad */
	public static final int TECLA_FIN             = 0xCF; /* End on arrow keypad */
	public static final int TECLA_ABAJO            = 0xD0; /* DownArrow on arrow keypad */
	public static final int TECLA_AV_PAG            = 0xD1; /* PgDn on arrow keypad */
	public static final int TECLA_INSERTAR          = 0xD2; /* Insert on arrow keypad */
	public static final int TECLA_SUPRIMIR          = 0xD3; /* Delete on arrow keypad */
	public static final int TECLA_SUPER_IZQ            = 0xDB; /* Left Windows/Option key */
        public static final int TECLA_SUPER_DER            = 0xDC; /* Right Windows/Option key */

 public static boolean teclaPresionada(int tecla){
     Keyboard.enableRepeatEvents(true);
    return Keyboard.isKeyDown(tecla);
}

     public static long obtenerIntervalo(){
        long tiempoActual = Utilidades.obtenerTiempo();
        long intervalo = tiempoActual - tiempoAnterior;
        tiempoAnterior = tiempoActual;

    return intervalo;

    }

}


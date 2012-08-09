{\rtf1\ansi\ansicpg1252\cocoartf1187
{\fonttbl\f0\fswiss\fcharset0 Helvetica;}
{\colortbl;\red255\green255\blue255;}
\margl1440\margr1440\vieww10800\viewh8400\viewkind0
\pard\tx566\tx1133\tx1700\tx2267\tx2834\tx3401\tx3968\tx4535\tx5102\tx5669\tx6236\tx6803\pardirnatural

\f0\fs24 \cf0 This is a 2d Game Engine written in Java with OpenGL acceleration using LWJGL library for this purpose. \
\
------------------------\
\
HOW TO USE IT\
\
-To create a game using this Game Engine, you must implement an instance of Juego class like this\
\
Juego nuevoJuego = new Juego(1024,768,60);\
\
This sentence creates the instance of the game (there can only be one at the time), showing a window 1024 px wide and 768 px tall, the last parameter indicates the desired Frames Per Second (FPS) at which the game will run.\
\
-To add a resource (sprite) onto the game, you need to create an instance of Recurso:\
\
Recurso nuevoRecurso = new Recurso("images/myImage1.jpg");\
\
At this point, you have successfully created a resource based on the path you've given as the source image, this can be a Jpeg, Png, or a Gif, next thing to do is to add it to the game by writing the following code:\
\
nuevoJuego.agregarRecurso(nuevoRecurso,0,0);\
\
with this code, you're telling the game to add nuevoRecurso resource at the given position, in this case is 0,0 which is the bottom-left corner of the screen.\
\
-At last but not least, you might want to create the Game Loop, from this method you'll refresh the game and execute all the logic behind your game, there is quite a few of standard Game Loops but i'll show you the easier:\
\
 private static void loopPrincipal() \{\
        while(true)\{\
        \
                  nuevoJuego.actualizar();\
               \
        \}\
    \}\
\
This snippet will work as a game loop, you will need to call it right before the initialization of your game. You may also want to add all the logic inside that loop, be careful though to call "actualizar" method at the end of the loop, otherwise your game may not detect peripherall inputs.}
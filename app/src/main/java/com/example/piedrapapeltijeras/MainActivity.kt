package com.example.piedrapapeltijeras

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.OnBackPressedCallback

class MainActivity : AppCompatActivity() {
    private lateinit var imagenJugador1: ImageView
    private lateinit var imagenJugador2: ImageView
    private lateinit var puntajeJugador1: TextView
    private lateinit var puntajeJugador2: TextView
    private lateinit var ganadorTexto: TextView

    private lateinit var botonPiedra: Button
    private lateinit var botonPapel: Button
    private lateinit var botonTijeras: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imagenJugador1 = findViewById(R.id.imagenJugador1)
        imagenJugador2 = findViewById(R.id.imagenJugador2)
        puntajeJugador1 = findViewById(R.id.pantallaPuntajeJugador1)
        puntajeJugador2 = findViewById(R.id.pantallaPuntajeJugador2)
        ganadorTexto = findViewById(R.id.ganadorTexto)

        botonPiedra = findViewById(R.id.botonPiedra)
        botonPapel = findViewById(R.id.botonPapel)
        botonTijeras = findViewById(R.id.botonTijeras)

        val imagenesFichas = arrayOf(R.drawable.rock, R.drawable.paper, R.drawable.scissors)
        val imagenesJugadores = arrayOf(imagenJugador1, imagenJugador2)
        val puntajeJugadores = arrayOf(puntajeJugador1, puntajeJugador2)

        val jugador1 = Jugador1(imagenesFichas, imagenesJugadores, puntajeJugadores, ganadorTexto)
        val jugador2 = Maquina(imagenesFichas, imagenesJugadores, puntajeJugadores, ganadorTexto, this)

        val jugadores = arrayOf(jugador1, jugador2)
        Jugadores.setJugadores(jugadores)
        Jugadores.setJugadoresJuego(arrayOf("JUGADOR", "MAQUINA"))
        Jugadores.setJugar(false)

        var bandera = Jugadores.convertirBooleano(Jugadores.getTurno())
        jugadores[bandera].inicializarJuego()

        botonPiedra.setOnClickListener {
            if(Jugadores.getJugar() && !Jugadores.getTurnoMaquina()){
                bandera = Jugadores.convertirBooleano(Jugadores.getTurno())
                jugadores[bandera].movimientoJugador("0")
            }
        }

        botonPapel.setOnClickListener {
            if(Jugadores.getJugar() && !Jugadores.getTurnoMaquina()){
                bandera = Jugadores.convertirBooleano(Jugadores.getTurno())
                jugadores[bandera].movimientoJugador("1")
            }
        }

        botonTijeras.setOnClickListener {
            if(Jugadores.getJugar() && !Jugadores.getTurnoMaquina()){
                bandera = Jugadores.convertirBooleano(Jugadores.getTurno())
                jugadores[bandera].movimientoJugador("2")
            }
        }

        onBackPressedDispatcher.addCallback(this, object: OnBackPressedCallback(true){
            override fun handleOnBackPressed() {
                startActivity(Intent(this@MainActivity, MenuActivity::class.java))
                finish()
            }

        })
    }
}
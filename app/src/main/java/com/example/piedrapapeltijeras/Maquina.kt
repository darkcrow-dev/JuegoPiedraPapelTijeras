package com.example.piedrapapeltijeras

import android.content.Context
import android.widget.ImageView
import android.widget.TextView
import kotlin.random.Random
import kotlin.random.nextInt

class Maquina(private var imagenesFichas: Array<Int>, private var turnoFicha: Array<ImageView>,
              private var puntajeJugadores: Array<TextView>, private var ganadorTexto: TextView,
              private var contexto: Context): Jugadores {

    private var jugadoresJuegoTexto = Jugadores.getJugadoresJuego()

    override fun movimientoJugador(ficha: String) {
        val movimiento = Random.nextInt(0..2)
        val bandera = Jugadores.convertirBooleano(Jugadores.getTurno())
        val banderaInvertida = Jugadores.convertirBooleano(!Jugadores.getTurno())

        Jugadores.setMovimiento(bandera, movimiento.toString())
        turnoFicha[bandera].setImageResource(imagenesFichas[movimiento])

        val ganador = Jugadores.getGanador()
        ganador.revisarGanador(Jugadores.getMovimientos())

        val resultado = ganador.resultado
        ganadorTexto.text = resultado

        val puntaje = Jugadores.getPuntajes()
        puntajeJugadores[banderaInvertida].text = puntaje.toString()
        puntajeJugadores[bandera].text = puntaje.toString()

        if(puntaje[banderaInvertida] == 5){
            return ganador.declararGanador(jugadoresJuegoTexto[banderaInvertida], contexto)
        }
        else if(puntaje[bandera] == 5){
            return ganador.declararGanador(jugadoresJuegoTexto[banderaInvertida], contexto)
        }

        val turno = !Jugadores.getTurno()
        Jugadores.setTurno(turno)
        Jugadores.setTurnoMaquina(false)
    }
}
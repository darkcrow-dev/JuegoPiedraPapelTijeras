package com.example.piedrapapeltijeras

import android.content.Context
import android.widget.ImageView
import android.widget.TextView
import kotlin.random.Random
import kotlin.random.nextInt

class Maquina(private var imagenesFichas: Array<Int>, private var turnoFicha: Array<ImageView>,
              private var puntajeJugadores: Array<TextView>, private var ganadorTexto: TextView,
              private var contexto: Context): Jugadores {

    override fun movimientoJugador(ficha: String) {
        val movimiento = Random.nextInt(0..2)
        val bandera = Jugadores.convertirBooleano(Jugadores.getTurno())
        val banderaInvertida = Jugadores.convertirBooleano(!Jugadores.getTurno())

        Jugadores.setMovimiento(bandera, movimiento.toString())
        turnoFicha[bandera].setImageResource(imagenesFichas[movimiento])

        val ganador = Jugadores.getGanador()
        val resultado = ganador.revisarGanador(Jugadores.getMovimientos())

        ganadorTexto.text = resultado

        val puntaje = Jugadores.getPuntajes()
        val jugadoresJuegoTexto = Jugadores.getJugadoresJuego()
        puntajeJugadores[banderaInvertida].text = "${jugadoresJuegoTexto[banderaInvertida]}: ${puntaje[banderaInvertida]}"
        puntajeJugadores[bandera].text = "${jugadoresJuegoTexto[bandera]}: ${puntaje[bandera]}"

        if(puntaje[banderaInvertida] == 5){
            return ganador.declararGanador(jugadoresJuegoTexto[banderaInvertida], contexto)
        }
        else if(puntaje[bandera] == 5){
            return ganador.declararGanador(jugadoresJuegoTexto[bandera], contexto)
        }

        val turno = !Jugadores.getTurno()
        Jugadores.setTurno(turno)
        Jugadores.setTurnoMaquina(false)
    }
}
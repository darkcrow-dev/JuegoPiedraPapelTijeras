package com.example.piedrapapeltijeras

import android.widget.ImageView
import android.widget.TextView

class Jugador1(private var imagenesFichas: Array<Int>, private var turnoFicha: Array<ImageView>,
               private var puntajeJugadores: Array<TextView>, private var ganadorTexto: TextView): Jugadores {

    private var jugadoresJuegoTexto = Jugadores.getJugadoresJuego()

    override fun movimientoJugador(ficha: String) {
        val bandera = Jugadores.convertirBooleano(Jugadores.getTurno())

        Jugadores.setMovimiento(bandera, ficha)
        turnoFicha[bandera].setImageResource(imagenesFichas[ficha.toInt()])

        val turno = !Jugadores.getTurno()
        Jugadores.setTurno(turno)
        turnoJuego(turno)
    }

    private fun turnoJuego(turno: Boolean){
        val bandera = Jugadores.convertirBooleano(turno)

        if(jugadoresJuegoTexto[bandera] == "MAQUINA"){
            val jugadoresJuego = Jugadores.getJugadores()
            Jugadores.setTurnoMaquina(true)
            jugadoresJuego[bandera].movimientoJugador("")
        }
    }

    override fun inicializarJuego(contador: Int) {
        if(contador > 1){
            Jugadores.setJugar(true)
            Jugadores.setTurnoMaquina(false)
            ganadorTexto.text = ""
            return
        }

        turnoFicha[contador].setImageResource(R.color.transparent)

        jugadoresJuegoTexto = Jugadores.getJugadoresJuego()
        Jugadores.setPuntaje(contador, 0)
        val textoPuntajes = Jugadores.getPuntajes()

        val texto = "${jugadoresJuegoTexto[contador]}: ${textoPuntajes[contador]}"
        puntajeJugadores[contador].text = texto
    }

    override fun terminarJuego() {
        val texto = "JUEGO TERMINADO"
        ganadorTexto.text = texto
        Jugadores.setJugar(false)
    }
}
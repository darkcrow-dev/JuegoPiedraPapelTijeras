package com.example.piedrapapeltijeras

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.Window
import android.widget.Button
import android.widget.TextView

class Ganador: Jugadores {
    fun revisarGanador(movimientos: Array<String>): String {
        val texto: String
        val ganadorRonda = movimientos[0].toInt() - movimientos[1].toInt()
        val puntajes = Jugadores.getPuntajes()
        val bandera = Jugadores.convertirBooleano(Jugadores.getTurno())
        val banderaInvertida = Jugadores.convertirBooleano(!Jugadores.getTurno())
        val jugadoresJuegoTexto = Jugadores.getJugadoresJuego()

        when (ganadorRonda) {
            -2, 1 -> {
                texto = "GANADOR ${jugadoresJuegoTexto[banderaInvertida]}"
                Jugadores.setPuntaje(banderaInvertida, puntajes[banderaInvertida] + 1)
                return texto
            }
            -1, 2 -> {
                texto = "GANADOR ${jugadoresJuegoTexto[bandera]}"
                Jugadores.setPuntaje(bandera, puntajes[bandera] + 1)
                return texto
            }
            else -> {
                texto = "EMPATE"
                return texto
            }
        }
    }

    fun declararGanador(string: String, contexto: Context){
        val dialogo = Dialog(contexto)
        dialogo.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialogo.setCancelable(false)
        dialogo.setCanceledOnTouchOutside(false)
        dialogo.setContentView(R.layout.winner_dialog)
        dialogo.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        val botonAfirmativo: Button = dialogo.findViewById(R.id.botonAfirmativo)
        val botonNegativo: Button = dialogo.findViewById(R.id.botonNegativo)
        val mensajeGanador: TextView = dialogo.findViewById(R.id.mensajeGanador)

        val jugadoresJuego = Jugadores.getJugadores()
        val banderaInvertida = Jugadores.convertirBooleano(!Jugadores.getTurno())
        mensajeGanador.text = string

        botonAfirmativo.setOnClickListener {
            jugadoresJuego[banderaInvertida].inicializarJuego()
            dialogo.dismiss()
        }

        botonNegativo.setOnClickListener {
            jugadoresJuego[banderaInvertida].terminarJuego()
            dialogo.dismiss()
        }

        dialogo.show()
    }
}
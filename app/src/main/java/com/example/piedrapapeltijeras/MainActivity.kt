package com.example.piedrapapeltijeras

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import kotlin.random.Random
import kotlin.random.nextInt

class MainActivity : AppCompatActivity() {
    private lateinit var imagenHumano: ImageView
    private lateinit var imagenMaquina: ImageView
    private lateinit var botonPiedra: Button
    private lateinit var botonPapel: Button
    private lateinit var botonTijeras: Button
    private lateinit var pantallaPuntajeHumano: TextView
    private lateinit var pantallaPuntajeMaquina: TextView
    private lateinit var ganadorTexto: TextView

    private var arrayOpcionesMaquina = arrayOf(R.drawable.paper, R.drawable.rock, R.drawable.scissors)
    private var arrayGanador = arrayOf("MAQUINA GANA", "EMPATE", "JUGADOR GANA", "JUEGO TERMINADO")
    private var opcionesMaquina = 0

    private var puntajeHumano = 0
    private var puntajeMaquina = 0
    private var jugar = false

    private lateinit var texto: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imagenHumano = findViewById(R.id.imagenHumano)
        imagenMaquina = findViewById(R.id.imagenMaquina)

        botonPiedra = findViewById(R.id.piedraBoton)
        botonPapel = findViewById(R.id.papelBoton)
        botonTijeras = findViewById(R.id.tijerasBoton)

        pantallaPuntajeHumano = findViewById(R.id.pantallaPuntajeHumano)
        pantallaPuntajeMaquina = findViewById(R.id.pantallaPuntajeMaquina)
        ganadorTexto = findViewById(R.id.ganador)

        inicializar()

        botonPiedra.setOnClickListener {
            if(jugar){
                opcionesMaquina = Random.nextInt(0..2)
                imagenMaquina.setImageResource(arrayOpcionesMaquina[opcionesMaquina])
                imagenHumano.setImageResource(R.drawable.rock)

                imagenHumano.visibility = View.VISIBLE
                imagenMaquina.visibility = View.VISIBLE

                when(opcionesMaquina){
                    0 -> {
                        ganadorTexto.text = arrayGanador[0]
                        puntajeMaquina += 1
                        texto = "MAQUINA: $puntajeMaquina"
                        pantallaPuntajeMaquina.text = texto
                    }
                    1 -> {
                        ganadorTexto.text = arrayGanador[1]
                    }
                    2 -> {
                        ganadorTexto.text = arrayGanador[2]
                        puntajeHumano += 1
                        texto = "JUGADOR: $puntajeHumano"
                        pantallaPuntajeHumano.text = texto
                    }
                }

                revisarGanador(puntajeHumano, puntajeMaquina)
            }
        }

        botonPapel.setOnClickListener {
            if(jugar){
                opcionesMaquina = Random.nextInt(0..2)
                imagenMaquina.setImageResource(arrayOpcionesMaquina[opcionesMaquina])
                imagenHumano.setImageResource(R.drawable.paper)

                imagenHumano.visibility = View.VISIBLE
                imagenMaquina.visibility = View.VISIBLE

                when (opcionesMaquina){
                    0 -> {
                        ganadorTexto.text = arrayGanador[1]
                    }
                    1 -> {
                        ganadorTexto.text = arrayGanador[2]
                        puntajeHumano += 1
                        texto = "JUGADOR: $puntajeHumano"
                        pantallaPuntajeHumano.text = texto
                    }
                    2 -> {
                        ganadorTexto.text = arrayGanador[0]
                        puntajeMaquina += 1
                        texto = "MAQUINA: $puntajeMaquina"
                        pantallaPuntajeMaquina.text = texto
                    }
                }

                revisarGanador(puntajeHumano, puntajeMaquina)
            }
        }

        botonTijeras.setOnClickListener {
            if(jugar){
                opcionesMaquina = Random.nextInt(0..2)
                imagenMaquina.setImageResource(arrayOpcionesMaquina[opcionesMaquina])
                imagenHumano.setImageResource(R.drawable.scissors)

                imagenHumano.visibility = View.VISIBLE
                imagenMaquina.visibility = View.VISIBLE

                when (opcionesMaquina){
                    0 -> {
                        ganadorTexto.text = arrayGanador[2]
                        puntajeHumano += 1
                        texto = "JUGADOR: $puntajeHumano"
                        pantallaPuntajeHumano.text = texto
                    }
                    1 -> {
                        ganadorTexto.text = arrayGanador[0]
                        puntajeMaquina += 1
                        texto = "MAQUINA: $puntajeMaquina"
                        pantallaPuntajeMaquina.text = texto
                    }
                    2 -> {
                        ganadorTexto.text = arrayGanador[1]
                    }
                }

                revisarGanador(puntajeHumano, puntajeMaquina)
            }
        }
    }

    private fun revisarGanador(jugador: Int, oponente: Int){
        if(jugador == 5){
            declararGanador("JUGADOR")
        }
        else if(oponente == 5){
            declararGanador("MAQUINA")
        }
    }

    private fun declararGanador(string: String){
        val dialogo = Dialog(this)
        dialogo.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialogo.setCancelable(false)
        dialogo.setCanceledOnTouchOutside(false)
        dialogo.setContentView(R.layout.winner_dialog)
        dialogo.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        val botonAfirmativo: Button = dialogo.findViewById(R.id.botonAfirmativo)
        val botonNegativo: Button = dialogo.findViewById(R.id.botonNegativo)
        val mensajeGanador: TextView = dialogo.findViewById(R.id.mensajeGanador)

        mensajeGanador.text = string

        botonAfirmativo.setOnClickListener {
            inicializar()
            dialogo.dismiss()
        }

        botonNegativo.setOnClickListener {
            jugar = false
            ganadorTexto.text = arrayGanador[3]
            dialogo.dismiss()
        }

        dialogo.show()
    }

    private fun inicializar(){
        jugar = true
        puntajeHumano = 0
        puntajeMaquina = 0

        texto = "JUGADOR: $puntajeHumano"
        pantallaPuntajeHumano.text = texto

        texto = "MAQUINA: $puntajeMaquina"
        pantallaPuntajeMaquina.text = texto

        ganadorTexto.text = ""

        imagenHumano.visibility = View.INVISIBLE
        imagenMaquina.visibility = View.INVISIBLE
    }
}
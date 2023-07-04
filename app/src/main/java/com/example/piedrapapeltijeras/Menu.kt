package com.example.piedrapapeltijeras

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.Button
import android.widget.TextView

class Menu : AppCompatActivity() {
    private lateinit var botonJugar: Button
    private lateinit var botonInformacion: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        botonJugar = findViewById(R.id.botonJugar)
        botonInformacion = findViewById(R.id.botonInformacion)

        botonJugar.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }

        botonInformacion.setOnClickListener {
            informacion()
        }
    }

    private fun informacion(){
        val dialogo = Dialog(this)
        dialogo.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialogo.setCancelable(true)
        dialogo.setCanceledOnTouchOutside(false)
        dialogo.setContentView(R.layout.information_dialog)
        dialogo.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        val botonCorrecto: Button = dialogo.findViewById(R.id.botonCorrecto)
        val textoInformacion: TextView = dialogo.findViewById(R.id.textoInformacion)

        val texto = "Compite contra la maquina en este juego de piedra, papel o tijeras y demuestra quien es el mejor obteniendo 5 puntos antes que el oponente."

        textoInformacion.text = texto

        botonCorrecto.setOnClickListener {
            dialogo.dismiss()
        }

        dialogo.show()
    }
}
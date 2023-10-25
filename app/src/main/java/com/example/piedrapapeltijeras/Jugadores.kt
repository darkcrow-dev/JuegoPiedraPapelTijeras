package com.example.piedrapapeltijeras

interface Jugadores {
    companion object{
        private var puntajes = arrayOf(0, 0)
        private var jugar = true
        private var turnoJuego = false
        private var turnoMaquina = false
        private var jugadoresJuego = arrayOf("", "")
        private var movimientos = arrayOf("", "")
        private var fichas = arrayOf("Piedra", "Papel", "Tijeras")
        private lateinit var jugadores: Array<Jugadores>
        private var ganador = Ganador()

        fun getTurno(): Boolean{
            return turnoJuego
        }

        fun setTurno(booleano: Boolean){
            turnoJuego = booleano
        }

        fun getTurnoMaquina(): Boolean{
            return turnoMaquina
        }

        fun setTurnoMaquina(booleano: Boolean){
            turnoMaquina = booleano
        }

        fun getJugar(): Boolean{
            return jugar
        }

        fun setJugar(booleano: Boolean){
            jugar = booleano
        }

        fun getJugadoresJuego(): Array<String> {
            return jugadoresJuego
        }

        fun setJugadoresJuego(arrayString: Array<String>){
            jugadoresJuego = arrayString
        }

        fun getJugadores(): Array<Jugadores> {
            return jugadores
        }

        fun setJugadores(arrayJugadores: Array<Jugadores>){
            jugadores = arrayJugadores
        }

        fun getPuntajes(): Array<Int>{
            return puntajes
        }

        fun setPuntaje(turno: Int, puntaje: Int){
            puntajes[turno] = puntaje
        }

        fun getMovimientos(): Array<String>{
            return movimientos
        }

        fun setMovimiento(turno: Int, movimiento: String){
            movimientos[turno] = movimiento
        }

        fun getFichas(): Array<String>{
            return fichas
        }

        fun convertirBooleano(booleano: Boolean): Int{
            var bandera = 0

            if(booleano){
                bandera = 1
            }

            return bandera
        }

        fun getGanador(): Ganador {
            return ganador
        }
    }

    fun movimientoJugador(ficha: String){
    }

    fun inicializarJuego(contador: Int) {
    }

    fun terminarJuego(){
    }
}
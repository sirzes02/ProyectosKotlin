package mundo

class Album(var nombre: String, var genero: String, var fechaLanzamiento: String, var foto: String) {

    var miCancion: MutableList<Cancion> = arrayListOf()
    var contadorCancion: Int = 0

    fun miCancion(i: Int): Cancion {
        return miCancion[i]
    }

    fun crearCancion(nombre: String, duracion: String) {
        miCancion.add(contadorCancion, Cancion(nombre, duracion))
        contadorCancion++
    }
}

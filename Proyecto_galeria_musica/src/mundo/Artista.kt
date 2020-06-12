package mundo

class Artista(var nombre: String, var fechaNacimiento: String, var fechaDebout: String, var activo: Boolean, var foto: String) {

    var miAlbum: MutableList<Album> = arrayListOf()
    var contadorAlbum: Int = 0

    fun miAlbum(i: Int): Album {
        return miAlbum[i]
    }

    fun crearAlbum(nombre: String, genero: String, fechaLanzamiento: String, foto: String) {
        miAlbum.add(contadorAlbum, Album(nombre, genero, fechaLanzamiento, foto))
        contadorAlbum++
    }

    fun crearCancion(j: Int, nombre: String, duracion: String) {
        miAlbum[j].crearCancion(nombre, duracion)
    }
}

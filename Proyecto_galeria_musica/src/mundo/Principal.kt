package mundo

import java.io.BufferedReader
import java.io.File
import java.io.PrintWriter

class Principal {
    var miArtista: MutableList<Artista> = arrayListOf()
    var contadorArtista: Int = 0

    init {
        leerArchivo()
    }

    fun leerArchivo() {
        val file: File? = File("./data/entrada.txt")

        if (file!!.exists()) {
            val br: BufferedReader = file.bufferedReader()

            val cantArtistas: Short = (br.readLine()).toShort()

            for (i: Int in 0 until cantArtistas) {
                var nombre: String = br.readLine()
                val fechaNacimiento: String = br.readLine()
                val fechaDebut: String = br.readLine()
                val activo: Boolean = br.readLine().toInt() == 0
                var foto: String = br.readLine()

                crearArtista(nombre, fechaNacimiento, fechaDebut, activo, foto)

                val cantAlbum: Short = br.readLine().toShort()

                for (j: Int in 0 until cantAlbum) {
                    nombre = br.readLine()
                    val genero: String = br.readLine()
                    val fechaLanzamiento: String = br.readLine()
                    foto = br.readLine()

                    crearAlbum(i, nombre, genero, fechaLanzamiento, foto)

                    val cantCancion: Short = br.readLine().toShort()

                    for (k: Int in 0 until cantCancion) {
                        nombre = br.readLine()
                        val duracion: String = br.readLine()

                        crearCancion(i, j, nombre, duracion)
                    }
                }
            }
            br.close()
        }
    }

    fun escribirArchivo() {
        val file: File? = File("./data/salida.txt")

        if (file!!.exists()) {
            val pw: PrintWriter = file.printWriter()

            pw.println(contadorArtista)

            for (i: Int in 0 until contadorArtista) {
                pw.println(miArtista[i].nombre)
                pw.println(miArtista[i].fechaNacimiento)
                pw.println(miArtista[i].fechaDebout)
                pw.println(if (miArtista[i].activo) 0 else 1)
                pw.println(miArtista[i].foto)

                pw.println(miArtista[i].contadorAlbum)
                for (j: Int in 0 until miArtista[i].contadorAlbum) {
                    pw.println(miArtista[i].miAlbum(j).nombre)
                    pw.println(miArtista[i].miAlbum(j).genero)
                    pw.println(miArtista[i].miAlbum(j).fechaLanzamiento)
                    pw.println(miArtista[i].miAlbum(j).foto)
                    pw.println(miArtista[i].miAlbum(j).contadorCancion)
                    for (k in 0 until miArtista[i].miAlbum(j).contadorCancion) {
                        pw.println(miArtista[i].miAlbum(j).miCancion(k).nombre)
                        pw.println(miArtista[i].miAlbum(j).miCancion(k).duracion)
                    }
                }
            }

            pw.close()
        } else {
            file.createNewFile()
            escribirArchivo()
        }
    }

    fun getMiArtista(i: Int): Artista {
        return miArtista[i]
    }

    fun crearArtista(nombre: String, fechaLanzamiento: String, fechaBebout: String, activo: Boolean, foto: String) {
        miArtista.add(contadorArtista, Artista(nombre, fechaLanzamiento, fechaBebout, activo, foto))
        contadorArtista++
    }

    fun crearAlbum(i: Int, nombre: String, genero: String, fechaLanzamiento: String, foto: String) {
        miArtista[i].crearAlbum(nombre, genero, fechaLanzamiento, foto)
    }

    fun crearCancion(i: Int, j: Int, nombre: String, duracion: String) {
        miArtista[i].crearCancion(j, nombre, duracion)
    }

}

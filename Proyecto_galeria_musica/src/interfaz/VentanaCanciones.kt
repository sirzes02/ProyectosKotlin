package interfaz

import mundo.Principal
import java.awt.BorderLayout
import java.awt.event.ActionEvent
import java.awt.event.ActionListener
import javax.swing.JButton
import javax.swing.JDialog

class VentanaCanciones(private val indexArtista: Int, private val indexAlbum: Int) : JDialog(), ActionListener {

    private var indexCancion: Int = 0
    private var miPrincipal: Principal
    private val miCentroCancion: CentroCancion

    init {
        miPrincipal = Principal()
        title = "Album: " + miPrincipal.getMiArtista(indexArtista).miAlbum(indexAlbum).nombre + " - Artista: " + miPrincipal.getMiArtista(indexArtista).nombre
        layout = BorderLayout()
        setSize(600, 200)
        isResizable = false
        isVisible = true

        add(Titulo("Canciones"), BorderLayout.NORTH)

        val atras = JButton("<-")
        atras.addActionListener(this)
        add(atras, BorderLayout.WEST)

        val adelante = JButton("->")
        adelante.addActionListener(this)
        add(adelante, BorderLayout.EAST)

        miCentroCancion = CentroCancion(miPrincipal.getMiArtista(indexArtista).miAlbum(indexAlbum).miCancion(0).nombre, miPrincipal.getMiArtista(indexArtista).miAlbum(indexAlbum).miCancion(0).duracion)
        add(miCentroCancion, BorderLayout.CENTER)

        val crear = JButton("Nuevo")
        crear.addActionListener(this)
        add(crear, BorderLayout.SOUTH)
    }

    override fun actionPerformed(p0: ActionEvent) {
        if ((p0.source as JButton).actionCommand == "->" && indexCancion < miPrincipal.getMiArtista(indexArtista).miAlbum(indexAlbum).contadorCancion - 1) {
            indexCancion++
            miCentroCancion.set(miPrincipal.getMiArtista(indexArtista).miAlbum(indexAlbum).miCancion(indexCancion).nombre, miPrincipal.getMiArtista(indexArtista).miAlbum(indexAlbum).miCancion(indexCancion).duracion)
        } else if ((p0.source as JButton).actionCommand == "<-" && indexAlbum > 0) {
            indexCancion--
            miCentroCancion.set(miPrincipal.getMiArtista(indexArtista).miAlbum(indexAlbum).miCancion(indexCancion).nombre, miPrincipal.getMiArtista(indexArtista).miAlbum(indexAlbum).miCancion(indexCancion).duracion)
        } else if ((p0.source as JButton).actionCommand == "Nuevo") {
            CrearCancion(indexArtista, indexAlbum)
        }
        miPrincipal = Principal()
    }
}
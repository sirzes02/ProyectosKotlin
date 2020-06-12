package interfaz

import mundo.Principal
import java.awt.BorderLayout
import java.awt.event.ActionEvent
import java.awt.event.ActionListener
import javax.swing.JButton
import javax.swing.JDialog

class VentanaAlbumes(private val indexArtista: Int) : JDialog(), ActionListener {
    private var indexAlbum: Int = 0
    private var miPrincipal: Principal
    private val miCentro: Centro
    private val miSurAlbum: SurAlbum

    init {
        miPrincipal = Principal()
        title = "Artista: " + miPrincipal.getMiArtista(indexArtista).nombre
        layout = BorderLayout()
        setSize(600, 450)
        isResizable = false
        isVisible = true

        add(Titulo("Albumes"), BorderLayout.NORTH)

        val atras = JButton("<-")
        atras.addActionListener(this)
        add(atras, BorderLayout.WEST)

        val adelante = JButton("->")
        adelante.addActionListener(this)
        add(adelante, BorderLayout.EAST)

        miCentro = Centro(miPrincipal.getMiArtista(indexArtista).miAlbum(0).foto, miPrincipal.getMiArtista(indexArtista).miAlbum(0).nombre)
        add(miCentro, BorderLayout.CENTER)

        miSurAlbum = SurAlbum(indexArtista, indexAlbum)
        add(miSurAlbum, BorderLayout.SOUTH)
    }

    override fun actionPerformed(p0: ActionEvent) {
        if ((p0.source as JButton).actionCommand == "->" && indexAlbum < miPrincipal.getMiArtista(indexArtista).contadorAlbum - 1) {
            indexAlbum++
            miCentro.setImage(miPrincipal.getMiArtista(indexArtista).miAlbum(indexAlbum).foto, miPrincipal.getMiArtista(indexArtista).miAlbum(indexAlbum).nombre)
            miSurAlbum.setArtMas()
        } else if ((p0.source as JButton).actionCommand == "<-" && indexAlbum > 0) {
            indexAlbum--
            miCentro.setImage(miPrincipal.getMiArtista(indexArtista).miAlbum(indexAlbum).foto, miPrincipal.getMiArtista(indexArtista).miAlbum(indexAlbum).nombre)
            miSurAlbum.setArtMenos()
        }
        miPrincipal = Principal()
    }
}
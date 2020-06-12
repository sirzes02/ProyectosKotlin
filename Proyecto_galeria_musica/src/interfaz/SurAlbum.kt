package interfaz

import java.awt.BorderLayout
import java.awt.event.ActionEvent
import java.awt.event.ActionListener
import javax.swing.JButton
import javax.swing.JPanel

class SurAlbum(private var indexArtista: Int, private var indexAlbum: Int) : JPanel(), ActionListener {

    init {
        layout = BorderLayout()
        val ingresar = JButton("Agregar")
        ingresar.addActionListener(this)
        add(ingresar, BorderLayout.EAST)
        val verEditar = JButton("Ver / Editar")
        verEditar.addActionListener(this)
        add(verEditar, BorderLayout.WEST)
    }

    override fun actionPerformed(p0: ActionEvent) {
        if ((p0.source as JButton).actionCommand == "Agregar")
            CrearAlbum(indexArtista)
        else
            VentanaCanciones(indexArtista, indexAlbum)
    }

    fun setArtMas() {
        indexAlbum++
    }

    fun setArtMenos() {
        indexAlbum--
    }
}
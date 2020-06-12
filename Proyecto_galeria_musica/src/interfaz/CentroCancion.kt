package interfaz

import java.awt.GridLayout
import javax.swing.JLabel
import javax.swing.JPanel

class CentroCancion(nombre: String, duracion: String) : JPanel() {

    private val nombre: JLabel
    private val duracion: JLabel

    init {
        layout = GridLayout(2, 2)

        add(JLabel("Nombre:"))
        this.nombre = JLabel("Nombre: $nombre.")
        add(this.nombre)

        add(JLabel("Duracion:"))
        this.duracion = JLabel("duracion: $duracion.")
        add(this.duracion)
    }

    fun set(nombre: String?, duracion: String?) {
        this.nombre.text = nombre
        this.duracion.text = duracion
    }
}
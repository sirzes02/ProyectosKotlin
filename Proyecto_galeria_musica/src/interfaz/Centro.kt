package interfaz

import java.awt.BorderLayout
import java.io.File
import javax.swing.ImageIcon
import javax.swing.JLabel
import javax.swing.JPanel

class Centro(foto: String, nombre: String) : JPanel() {

    val nombreArtista: JLabel
    val img: JLabel

    init {
        layout = BorderLayout()

        img = JLabel(ImageIcon(if (File(foto).exists()) foto else "./img/404.jpg"))
        nombreArtista = JLabel("Nombre: $nombre.")

        add(nombreArtista, BorderLayout.SOUTH)
        add(img, BorderLayout.CENTER)
    }

    fun setImage(foto: String, nombre: String) {
        img.icon = ImageIcon(if (File(foto).exists()) foto else "./img/404.jpg")
        nombreArtista.text = "Nombre: $nombre."
    }

}
package interfaz

import mundo.Principal
import java.awt.GridLayout
import java.awt.event.ActionEvent
import java.awt.event.ActionListener
import javax.swing.JDialog
import javax.swing.JTextField
import javax.swing.JLabel
import javax.swing.JButton
import javax.swing.JOptionPane

class CrearCancion(private val indexArtista: Int, private val indexAlbum: Int) : JDialog(), ActionListener {

    private val nombre: JTextField
    private val duracion: JTextField

    init {
        title = "Crear nueva cancion"
        isResizable = false
        setSize(300, 150)
        layout = GridLayout(3, 2)
        isVisible = true

        this.add(JLabel("Nombre"))
        nombre = JTextField("")
        add(nombre)

        this.add(JLabel("Duracion"))
        duracion = JTextField("")
        add(duracion)

        val enviar = JButton("Crear")
        enviar.addActionListener(this)
        add(enviar)

        val limpiar = JButton("Limpiar")
        limpiar.addActionListener(this)
        add(limpiar)
    }

    override fun actionPerformed(p0: ActionEvent) {
        if ((p0.source as JButton).actionCommand == "Crear") {
            if (nombre.text != "" && duracion.text != "") {
                val miPrincipal = Principal()
                miPrincipal.getMiArtista(indexArtista).miAlbum(indexAlbum).crearCancion(nombre.text, duracion.text)
                miPrincipal.escribirArchivo()
                JOptionPane.showMessageDialog(null, "Cancion creada Correctamente", "Correcto", JOptionPane.INFORMATION_MESSAGE)
                dispose()
            } else
                JOptionPane.showMessageDialog(null, "Error, debe llenar lo necesario", "Error", JOptionPane.ERROR_MESSAGE)
        } else {
            nombre.text = ""
            duracion.text = ""
        }
    }
}
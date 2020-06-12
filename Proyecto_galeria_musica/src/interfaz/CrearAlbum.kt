package interfaz

import mundo.Principal
import java.awt.GridLayout
import java.awt.event.ActionEvent
import java.awt.event.ActionListener
import javax.swing.*

class CrearAlbum(private val indexArtista: Int) : JDialog(), ActionListener {

    private val nombre: JTextField
    private val genero: JTextField
    private val fecha: JTextField
    private val foto: JTextField

    init {
        title = "Crear nuevo album"
        isResizable = false
        setSize(300, 250)
        isVisible = true
        layout = GridLayout(5, 2)

        add(JLabel("Nombre"))
        nombre = JTextField("")
        add(nombre)

        add(JLabel("Genero"))
        genero = JTextField("")
        add(genero)

        add(JLabel("Fecha Lanzamiento"))
        fecha = JTextField("")
        add(fecha)

        add(JLabel("Foto"))
        foto = JTextField("")
        add(foto)

        val enviar = JButton("Crear")
        enviar.addActionListener(this)
        add(enviar)

        val limpiar = JButton("Limpiar")
        limpiar.addActionListener(this)
        add(limpiar)
    }

    override fun actionPerformed(p0: ActionEvent) {
        if ((p0.source as JButton).actionCommand == "Crear") {
            if (nombre.text != "" && genero.text != "" && fecha.text != "") {
                val miPrincipal = Principal()
                miPrincipal.getMiArtista(indexArtista).crearAlbum(nombre.text, genero.text, fecha.text, foto.text)
                miPrincipal.escribirArchivo()
                JOptionPane.showMessageDialog(null, "Album creado Correctamente", "Correcto", JOptionPane.INFORMATION_MESSAGE)
                dispose()
            } else
                JOptionPane.showMessageDialog(null, "Error, debe llenar lo necesario", "Error", JOptionPane.ERROR_MESSAGE)
        } else {
            nombre.text = ""
            genero.text = ""
            fecha.text = ""
            foto.text = ""
        }
    }
}
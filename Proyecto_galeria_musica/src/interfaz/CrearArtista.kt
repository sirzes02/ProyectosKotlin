package interfaz

import mundo.Principal
import java.awt.GridLayout
import java.awt.event.ActionEvent
import java.awt.event.ActionListener
import javax.swing.*

class CrearArtista : JDialog(), ActionListener {
    val nombre: JTextField
    val fechaN: JTextField
    val fechaD: JTextField
    val foto: JTextField
    val act: JCheckBox

    init {
        title = "Crear nuevo artista"
        isResizable = false
        setSize(300, 300)
        layout = GridLayout(6, 2)
        isVisible = true

        add(JLabel("Nombre"))
        nombre = JTextField("")
        add(nombre)

        add(JLabel("Fecha de Nacimiento"))
        fechaN = JTextField("")
        add(fechaN)

        add(JLabel("Fecha de Debout"))
        fechaD = JTextField("")
        add(fechaD)

        add(JLabel())
        act = JCheckBox("Activo")
        add(act)

        add(JLabel("Foto"))
        foto = JTextField("")
        add(foto)

        val enviar = JButton("crear")
        enviar.addActionListener(this)
        add(enviar)

        val limpiar = JButton("Limpiar")
        limpiar.addActionListener(this)
        add(limpiar)
    }

    override fun actionPerformed(p0: ActionEvent?) {
        if ((p0?.source as JButton).actionCommand == "Crear") {
            if (nombre.text != "" && fechaD.text != "" && fechaN.text != "") {
                val miPrincipal = Principal()
                miPrincipal.crearArtista(nombre.text, fechaN.text, fechaD.text, act.isSelected, foto.text)
                miPrincipal.escribirArchivo()
                JOptionPane.showMessageDialog(null, "Artista creado Correctamente", "Correcto", JOptionPane.INFORMATION_MESSAGE)
                dispose()
            } else
                JOptionPane.showMessageDialog(null, "Error, debe llenar lo necesario", "Error", JOptionPane.ERROR_MESSAGE)
        } else {
            nombre.text = ""
            fechaN.text = ""
            fechaD.text = ""
            act.isSelected = false
            foto.text = ""
        }
    }
}
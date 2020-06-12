package interfaz

import mundo.Principal
import java.awt.BorderLayout
import java.awt.event.ActionEvent
import java.awt.event.ActionListener
import java.awt.event.WindowEvent
import java.awt.event.WindowListener
import javax.swing.JButton
import javax.swing.JFrame
import javax.swing.JOptionPane

class VentanaPrincipal : JFrame(), ActionListener, WindowListener {

    private var miPrincipal: Principal = Principal()
    private val miCentro: Centro
    private val miSur: Sur
    private var contArtista: Int = 0

    init {
        addWindowListener(this)
        title = "Proyecto"
        layout = BorderLayout()
        defaultCloseOperation = EXIT_ON_CLOSE
        setSize(600, 450)
        isResizable = false
        isVisible = true

        add(Titulo("Artistas"), BorderLayout.NORTH)

        val atras = JButton("<-")
        atras.addActionListener(this)
        add(atras, BorderLayout.WEST)

        val adelante = JButton("->")
        adelante.addActionListener(this)
        add(adelante, BorderLayout.EAST)

        miSur = Sur(contArtista)
        add(miSur, BorderLayout.SOUTH)

        miCentro = Centro(miPrincipal.getMiArtista(0).foto, miPrincipal.getMiArtista(0).nombre)
        add(miCentro, BorderLayout.CENTER)
    }

    override fun actionPerformed(p0: ActionEvent?) {
        if ((p0?.source as JButton).actionCommand == "->" && contArtista < miPrincipal.contadorArtista - 1) {
            contArtista++
            miSur.setArtMas()
            miCentro.setImage(miPrincipal.getMiArtista(contArtista).foto, miPrincipal.getMiArtista(contArtista).nombre)
        } else if ((p0.source as JButton).actionCommand == "<-" && contArtista > 0) {
            contArtista--
            miSur.setArtMenos()
            miCentro.setImage(miPrincipal.getMiArtista(contArtista).foto, miPrincipal.getMiArtista(contArtista).nombre)
        }
        miPrincipal = Principal()
    }

    override fun windowIconified(p0: WindowEvent?) {}

    override fun windowDeiconified(p0: WindowEvent?) {}

    override fun windowClosing(p0: WindowEvent?) {
        JOptionPane.showMessageDialog(null, "Muchas gracias por usar!")
        miPrincipal.escribirArchivo()
    }

    override fun windowClosed(p0: WindowEvent?) {}

    override fun windowActivated(p0: WindowEvent?) {}

    override fun windowDeactivated(p0: WindowEvent?) {}

    override fun windowOpened(p0: WindowEvent?) {}
}

fun main() {
    VentanaPrincipal()
}

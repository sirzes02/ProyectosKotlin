package interfaz

import javax.swing.JLabel
import javax.swing.JPanel

class Titulo(titulo: String) : JPanel() {
    init {
        add(JLabel(titulo))
    }
}
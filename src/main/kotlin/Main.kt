import ui.StudyFlowWindow
import javax.swing.SwingUtilities
import com.formdev.flatlaf.FlatDarkLaf

fun main() {

    FlatDarkLaf.setup()

    SwingUtilities.invokeLater {
        StudyFlowWindow().isVisible = true
    }
}git
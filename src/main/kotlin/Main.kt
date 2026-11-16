import ui.StudyFlowWindow
import javax.swing.SwingUtilities

fun main() {
    SwingUtilities.invokeLater {
        StudyFlowWindow().isVisible = true
    }
}
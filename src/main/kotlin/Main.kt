import ui.StudyFlowWindow
import javax.swing.SwingUtilities
import com.formdev.flatlaf.FlatDarkLaf

fun main() {

    //Applies dark theme
    FlatDarkLaf.setup()

    //Disables FlatLaf native libraries
    System.setProperty("flatlaf.useNativeLibrary", "false")

    SwingUtilities.invokeLater {
        StudyFlowWindow().isVisible = true
    }
}
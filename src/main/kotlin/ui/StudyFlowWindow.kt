package ui

import javax.swing.JFrame //Represent app window
import javax.swing.JLabel //Displays text inside the window
import javax.swing.SwingConstants
import javax.swing.WindowConstants

class StudyFlowWindow : JFrame("StudyFlow") {

    init {
        defaultCloseOperation = EXIT_ON_CLOSE
        setSize(900, 600)
        setLocationRelativeTo(null)

        val welcomeLabel = JLabel(
            "Welcome to the StudyFlow Application!",
            SwingConstants.CENTER
        )

        add(welcomeLabel)
    }
}

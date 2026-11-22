package ui

import java.awt.BorderLayout
import java.awt.Color
import java.awt.Component
import java.awt.Dimension
import java.awt.Font
import javax.swing.*

class StudyFlowWindow : JFrame("StudyFlow") {

    //Apps color scheme
    private val darkPurple = Color(48, 20, 83)
    private val buttonPurple = Color(96, 55, 153)
    private val white = Color(255,255, 255)


    private val pageTitle = JLabel(
        "Welcome to StudyFlow!",
        SwingConstants.CENTER
    )

    init {
        defaultCloseOperation = EXIT_ON_CLOSE
        setSize(950, 600)
        setLocationRelativeTo(null)
        layout = BorderLayout()

        //Sidebar
        val sidebar = JPanel()
        sidebar.layout = BoxLayout(sidebar, BoxLayout.Y_AXIS)
        sidebar.preferredSize = Dimension(220, 0)
        sidebar.background = darkPurple
        sidebar.border = BorderFactory.createEmptyBorder(20, 20, 20, 20)

        //Sidebar title
        val title = JLabel("StudyFlow")
        title.font = Font("SansSerif", Font.BOLD, 26)
        title.foreground = white
        title.alignmentX = Component.LEFT_ALIGNMENT

        sidebar.add(title)
        sidebar.add(Box.createVerticalStrut(30))

        //Navigation buttons
        val dashboardButton = JButton("Dashboard")
        val tasksButton = JButton("Tasks")
        val modulesButton = JButton("Modules")

        for(button in listOf(
            dashboardButton,
            tasksButton,
            modulesButton
        )) {
            button.background = buttonPurple
            button.foreground = white
            button.maximumSize = Dimension(Int.MAX_VALUE, 45)
            button.alignmentX = Component.LEFT_ALIGNMENT

            sidebar.add(button)
            sidebar.add(Box.createVerticalStrut(10))
        }

        //Main content area
        val contentPanel = JPanel(BorderLayout())
        contentPanel.background = white

        pageTitle.font = Font("SansSerif", Font.BOLD, 28
        )
        pageTitle.foreground = darkPurple

        contentPanel.add(pageTitle, BorderLayout.CENTER)

        //Button actions
        dashboardButton.addActionListener {
            pageTitle.text = "Welcome to StudyFlow"
        }

        tasksButton.addActionListener {
            pageTitle.text = "Tasks - coming soon!"
        }

        modulesButton.addActionListener {
            pageTitle.text = "Modules - coming soon!"
        }

        //Add panels to the window
        add(sidebar, BorderLayout.WEST)
        add(contentPanel, BorderLayout.CENTER)
    }
}
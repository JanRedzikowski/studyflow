package ui

import java.awt.BorderLayout
import java.awt.Color
import java.awt.Component
import java.awt.Dimension
import java.awt.Font
import java.awt.GridLayout
import javax.swing.*

class StudyFlowWindow : JFrame("StudyFlow") {

    //Apps color scheme
    private val darkPurple = Color(48, 20, 83)
    private val buttonPurple = Color(96, 55, 153)
    private val white = Color(255,255, 255)
    private val subTitlePurple = Color(116, 104, 135)
    private val cardWhite = Color(247, 243, 252)
    private val upcomingPurple = Color(116, 104, 135)

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

        //Welcome heading
        pageTitle.font = Font("SansSerif", Font.BOLD, 28)
        pageTitle.foreground = darkPurple
        pageTitle.horizontalAlignment = SwingConstants.LEFT

        //Dashboard container
        val dashboardPanel = JPanel()
        dashboardPanel.layout = BoxLayout(
            dashboardPanel,
            BoxLayout.Y_AXIS
        )
        dashboardPanel.background = white

        //Dashboard subtitle
        val subtitle = JLabel("Here is your study overview.")
        font = Font("SansSerif", Font.PLAIN, 15)
        subtitle.foreground = subTitlePurple
        subtitle.alignmentX = Component.LEFT_ALIGNMENT

        dashboardPanel.add(Box.createVerticalStrut(20))
        dashboardPanel.add(subtitle)
        dashboardPanel.add(Box.createVerticalStrut(25))

        //Statistics cards
        val statsPanel = JPanel(GridLayout(1, 3, 15, 0))
        statsPanel.background = white
        statsPanel.maximumSize = Dimension(Int.MAX_VALUE, 120)
        statsPanel.alignmentX = Component.LEFT_ALIGNMENT

        val statistics = listOf(
            "Total Tasks" to "0",
            "Completed" to "0",
            "Pending" to "0"
        )

        for ((name, value) in statistics) {
            val card = JPanel(BorderLayout())
            card.background = cardWhite
            card.border = BorderFactory.createEmptyBorder(20, 20, 20, 20)
            card.putClientProperty("FlatLaf.style", "arc: 30")
            val cardTitle = JLabel(name)
            cardTitle.foreground = darkPurple
            cardTitle.font = Font("SansSerif", Font.PLAIN, 14)

            val cardValue = JLabel(value)
            cardValue.foreground = buttonPurple
            cardValue.font = Font("SansSerif", Font.BOLD, 32)

            card.add(cardTitle, BorderLayout.NORTH)
            card.add(cardValue, BorderLayout.CENTER)

            statsPanel.add(card)
        }

        dashboardPanel.add(statsPanel)
        dashboardPanel.add(Box.createVerticalStrut(25))


        //Upcoming tasks section
        val upcomingPanel = JPanel(BorderLayout(0, 12))
        upcomingPanel.background = cardWhite
        upcomingPanel.border = BorderFactory.createEmptyBorder(20, 20, 20, 20)
        upcomingPanel.maximumSize = Dimension(Int.MAX_VALUE, 100)
        upcomingPanel.alignmentX = Component.LEFT_ALIGNMENT
        upcomingPanel.putClientProperty("FlatLaf.style", "arc: 30")

        val upcomingTitle = JLabel("Upcoming Tasks")
        upcomingTitle.font = Font("SansSerif", Font.BOLD, 18)
        upcomingTitle.foreground = darkPurple

        val upcomingMessage = JLabel("No tasks yet. Your upcoming study tasks will appear here.")
        upcomingMessage.foreground = upcomingPurple

        upcomingPanel.add(upcomingTitle, BorderLayout.NORTH)
        upcomingPanel.add(upcomingMessage, BorderLayout.CENTER)

        dashboardPanel.add(upcomingPanel)
        contentPanel.add(dashboardPanel, BorderLayout.CENTER)


        //Button/Navigation actions
        dashboardButton.addActionListener {
            pageTitle.text = "Welcome to StudyFlow"
            dashboardPanel.isVisible = true
        }

        tasksButton.addActionListener {
            pageTitle.text = "Tasks - coming soon!"
            dashboardPanel.isVisible = false
        }

        modulesButton.addActionListener {
            pageTitle.text = "Modules - coming soon!"
            dashboardPanel.isVisible = false
        }

        //Add panels to the window
        add(sidebar, BorderLayout.WEST)
        add(contentPanel, BorderLayout.CENTER)
    }
}
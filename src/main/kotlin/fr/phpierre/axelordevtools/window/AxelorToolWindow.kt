package fr.phpierre.axelordevtools.window

import com.intellij.openapi.project.Project
import com.intellij.openapi.wm.ToolWindow
import com.intellij.openapi.wm.ToolWindowFactory
import com.intellij.ui.content.ContentFactory
import com.intellij.ui.content.ContentManager

class AxelorToolWindow(private val contentFactory: ContentFactory) : ToolWindowFactory {

    override fun createToolWindowContent(project: Project, toolWindow: ToolWindow) {
        val contentManager: ContentManager = toolWindow.contentManager
        val content = contentFactory.createContent(AxelorGeneralWindow(project).panel, "", false)
        contentManager.addContent(content)
    }
}

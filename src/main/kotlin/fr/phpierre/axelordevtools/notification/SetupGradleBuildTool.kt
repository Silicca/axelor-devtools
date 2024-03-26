package fr.phpierre.axelordevtools.notification

import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.options.ShowSettingsUtil
import com.intellij.openapi.project.DumbAware
import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.ui.EditorNotificationPanel
import fr.phpierre.axelordevtools.MyBundle
import org.jetbrains.plugins.gradle.service.settings.GradleConfigurable
import org.jetbrains.plugins.gradle.settings.GradleProjectSettings
import org.jetbrains.plugins.gradle.settings.TestRunner


class SetupGradleBuildTool(project: Project) : SetupGradleEditorNotificationProvider(project), DumbAware {
    override val VirtualFile.disablingKey: String get() = "axelor.gradle.build.tool"

    override fun createNotificationPanel(file: VirtualFile, project: Project): EditorNotificationPanel? {
        val delegateBuild = GradleProjectSettings.isDelegatedBuildEnabled(project, project.basePath)
        val testRunner = GradleProjectSettings.getTestRunner(project, project.basePath)
        if(!delegateBuild && testRunner == TestRunner.PLATFORM) {
            return null
        }

        val panel = EditorNotificationPanel()
        panel.text = MyBundle.message("gradle.build.tool.need.to.be.configured")
        panel.createActionLabel(MyBundle.message("gradle.build.tool.configure")) {
            ApplicationManager.getApplication().invokeLater {
                ShowSettingsUtil.getInstance().showSettingsDialog(project, GradleConfigurable::class.java)
            }
        }
        return panel
    }
}

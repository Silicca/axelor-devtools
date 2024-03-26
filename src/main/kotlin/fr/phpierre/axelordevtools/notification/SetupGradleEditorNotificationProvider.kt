package fr.phpierre.axelordevtools.notification

import com.intellij.openapi.fileEditor.FileEditor
import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.ui.EditorNotificationPanel
import com.intellij.ui.EditorNotificationProvider
import java.util.function.Function
import javax.swing.JComponent

abstract class SetupGradleEditorNotificationProvider(protected val project: Project): EditorNotificationProvider {

    protected abstract val VirtualFile.disablingKey: String

    override fun collectNotificationData(
            project: Project,
            file: VirtualFile
    ): Function<in FileEditor, out JComponent?> {
        return Function { createNotificationPanel(file, project) }
    }

    abstract fun createNotificationPanel(file: VirtualFile, project: Project): EditorNotificationPanel?
}

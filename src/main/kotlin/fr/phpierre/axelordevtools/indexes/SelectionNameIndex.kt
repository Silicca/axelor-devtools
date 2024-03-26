package fr.phpierre.axelordevtools.indexes

import com.intellij.ide.highlighter.XmlFileType
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.util.indexing.*
import com.intellij.util.io.DataExternalizer
import com.intellij.util.io.EnumeratorStringDescriptor
import com.intellij.util.io.KeyDescriptor
import fr.phpierre.axelordevtools.util.UnitDataExternalizer
import fr.phpierre.axelordevtools.util.XmlUtil

class SelectionNameIndex : FileBasedIndexExtension<String, Unit?>() {

    companion object {
        val KEY =
            ID.create<String, Unit?>("axelor.selections.name")
    }

    override fun getName(): ID<String, Unit?> {
        return KEY
    }

    override fun getIndexer(): DataIndexer<String, Unit?, FileContent> {
        return DataIndexer { inputData: FileContent ->
            val psiFile = inputData.psiFile
            val map: MutableMap<String, Unit?> = HashMap()
            val sets: Set<String> =
                XmlUtil.indexSelectionName(psiFile)
            for (name in sets) {
                map[name] = null
            }
            map
        }
    }

    override fun getKeyDescriptor(): KeyDescriptor<String> {
        return EnumeratorStringDescriptor()
    }

    override fun getValueExternalizer(): DataExternalizer<Unit?> {
        return UnitDataExternalizer.INSTANCE
    }

    override fun getVersion(): Int {
        return 0
    }

    override fun getInputFilter(): FileBasedIndex.InputFilter {
        return FileBasedIndex.InputFilter { virtualFile: VirtualFile ->
            virtualFile.fileType === XmlFileType.INSTANCE && virtualFile.parent.name == "views"
        }
    }

    override fun dependsOnFileContent(): Boolean {
        return true
    }
}

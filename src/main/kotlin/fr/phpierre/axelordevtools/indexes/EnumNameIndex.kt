package fr.phpierre.axelordevtools.indexes

import com.intellij.openapi.vfs.VirtualFile
import com.intellij.util.indexing.*
import com.intellij.util.io.DataExternalizer
import com.intellij.util.io.EnumeratorStringDescriptor
import com.intellij.util.io.KeyDescriptor
import fr.phpierre.axelordevtools.util.AxelorFile
import fr.phpierre.axelordevtools.util.UnitDataExternalizer
import fr.phpierre.axelordevtools.util.XmlUtil

class EnumNameIndex : FileBasedIndexExtension<String, Unit?>() {

    companion object {
        val KEY =
                ID.create<String, Unit?>("axelor.enum.name")
    }

    override fun getName(): ID<String, Unit?> {
        return KEY
    }

    override fun getIndexer(): DataIndexer<String, Unit?, FileContent> {
        return DataIndexer { inputData: FileContent ->
            val psiFile = inputData.psiFile
            val map: MutableMap<String, Unit?> = HashMap()
            val sets: Set<String> = XmlUtil.indexAxelorEnumName(psiFile)
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
            AxelorFile.isDomain(virtualFile)
        }
    }

    override fun dependsOnFileContent(): Boolean {
        return true
    }
}

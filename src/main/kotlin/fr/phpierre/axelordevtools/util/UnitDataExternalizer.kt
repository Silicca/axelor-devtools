package fr.phpierre.axelordevtools.util

import com.intellij.util.io.DataExternalizer
import java.io.DataInput
import java.io.DataOutput
import java.io.IOException

class UnitDataExternalizer : DataExternalizer<Unit?> {
    @Throws(IOException::class)
    override fun save(out: DataOutput, value: Unit?) {
        //return nothing
    }

    @Throws(IOException::class)
    override fun read(`in`: DataInput): Unit? {
        return null
    }

    companion object {
        val INSTANCE: UnitDataExternalizer = UnitDataExternalizer()
    }
}

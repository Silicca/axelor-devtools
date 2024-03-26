package fr.phpierre.axelordevtools.references.xml.condition

import com.intellij.patterns.PatternCondition
import com.intellij.psi.PsiElement
import com.intellij.psi.xml.XmlAttributeValue
import com.intellij.util.ProcessingContext
import org.jetbrains.annotations.NotNull


class DumbFieldCondition(@NotNull vararg keys: String) :

    PatternCondition<PsiElement>(keys[0]) {
    override fun accepts(
        @NotNull element: PsiElement,
        context: ProcessingContext
    ): Boolean {
        // Dummy fields can't target a field in a domain.
        return !(element is XmlAttributeValue && element.value.startsWith("$"))
    }
}

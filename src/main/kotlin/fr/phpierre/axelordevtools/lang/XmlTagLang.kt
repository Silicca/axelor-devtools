package fr.phpierre.axelordevtools.lang

import fr.phpierre.axelordevtools.objects.xml.action.*
import fr.phpierre.axelordevtools.objects.xml.view.MetaFormView
import fr.phpierre.axelordevtools.objects.xml.view.MetaGridView
import fr.phpierre.axelordevtools.objects.xml.widget.*
import fr.phpierre.axelordevtools.objects.xml.domain.Integer as XMLInteger

class XmlTagLang {
    companion object {

        const val axelorViewGridType = "grid"
        const val axelorViewFormType = "form"
        const val axelorViewTreeType = "tree"
        const val axelorViewChartType = "chart"
        const val axelorViewCalendarType = "calendar"
        const val axelorViewKanbanType = "kanban"
        const val axelorViewCardsType = "cards"
        const val axelorViewCustomType = "custom"
        const val axelorViewGanttType = "gantt"
        const val axelorViewDashboardType = "dashboard"

        const val axelorActionViewType = "action-view"
        const val axelorActionAttrsType = "action-attrs"
        const val axelorActionRecordType = "action-record"

        val viewType = setOf(
            axelorViewGridType,
            axelorViewFormType,
            axelorViewTreeType,
            axelorViewChartType,
            axelorViewCalendarType,
            axelorViewKanbanType,
            axelorViewCardsType,
            axelorViewCustomType,
            axelorViewGanttType,
            axelorViewDashboardType)

        val actionType = setOf(
            axelorActionViewType,
            axelorActionAttrsType,
            axelorActionRecordType,
            "action-method",
            "action-script",
            "action-validate",
            "action-condition",
            "action-group",
            "action-import",
            "action-export",
            "action-ws"
        )

        val actionEvents = setOf("onNew", "onLoad", "onLoad", "onSave", "onDelete", "onChange", "onSelect", "onClick", "onTabSelect")

        // Xml tag which can target view
        val viewReferences = mapOf(
            "field" to Field::class.java,
            "panel-include" to PanelInclude::class.java,
            "panel-related" to PanelRelated::class.java,
            "view" to ActionView::class.java,
        )

        // Xml tag which can target action
        val actionReferences = mapOf(
            "grid" to MetaGridView::class.java,
            "form" to MetaFormView::class.java,
            "field" to Field::class.java,
            "button" to Button::class.java,
            "panel-dashlet" to PanelDashlet::class.java,
            "action" to Action::class.java,
            "node" to TreeViewNode::class.java,
            "item" to MenuItem::class.java
        )

        val selectionReferences = mapOf(
            "field" to Field::class.java,
            "integer" to XMLInteger::class.java
        )
    }
}
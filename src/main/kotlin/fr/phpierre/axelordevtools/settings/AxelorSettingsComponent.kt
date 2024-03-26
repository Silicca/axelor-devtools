package fr.phpierre.axelordevtools.settings

import com.intellij.ui.CollectionListModel
import com.intellij.ui.components.JBLabel
import com.intellij.ui.components.JBList
import com.intellij.ui.components.JBTextField
import com.intellij.util.ui.FormBuilder
import javax.swing.JCheckBox
import javax.swing.JList
import javax.swing.JPanel

class AxelorSettingsComponent {

    var panel: JPanel
    var erpUrl: JBTextField = JBTextField()
    val erpUsername: JBTextField = JBTextField()
    val erpPassword: JBTextField = JBTextField()
    var aopVersion: JList<Double> = JBList()
    var hotReloadActivated: JCheckBox = JCheckBox()
    //val useTomcatHost: JButton = JButton("Use Tomcat config")

    init {

        val fieldsCollection: CollectionListModel<Double> = CollectionListModel()
        fieldsCollection.add(5.1)
        fieldsCollection.add(5.2)
        fieldsCollection.add(5.3)
        fieldsCollection.add(5.4)
        aopVersion = JBList(fieldsCollection)

        /*useTomcatHost.addActionListener {
            val t = ApplicationServersManager.getInstance().applicationServers.get(0)
            val u = TomcatConfiguration.getInstance()
            val v = TomcatIntegration.getInstance()
            print("ok")
        }*/

        panel = FormBuilder.createFormBuilder()
                .addLabeledComponent(JBLabel("Axelor ERP url"), erpUrl)
                //.addComponent(useTomcatHost)
                .addLabeledComponent(JBLabel("Axelor ERP username"), erpUsername)
                .addLabeledComponent(JBLabel("Axelor ERP password"), erpPassword)
                .addLabeledComponent(JBLabel("Axelor AOP version"), aopVersion)
                .addLabeledComponent(JBLabel("Activate Axelor views hot reload"), hotReloadActivated)
                .panel
    }
}

package fr.phpierre.axelordevtools.http.scenario

import fr.phpierre.axelordevtools.http.AxelorResponseBody

fun interface HttpScenario<T> {
    fun execute(): AxelorResponseBody<T>
}

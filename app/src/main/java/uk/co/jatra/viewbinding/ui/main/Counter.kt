package uk.co.jatra.viewbinding.ui.main

import javax.inject.Inject

class Counter @Inject constructor() {
    private var count: Int = 0

    fun increment(): Int {
        return ++count
    }
}
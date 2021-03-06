package com.nadji.moviecatalogue.utils

import androidx.test.espresso.idling.CountingIdlingResource

object EspressoIdlingResource {
    private val RESOURCE: String? = "GLOBAL"
    val idlingResource = CountingIdlingResource(RESOURCE)

    fun increment() = idlingResource.increment()
    fun decrement() = idlingResource.decrement()
}
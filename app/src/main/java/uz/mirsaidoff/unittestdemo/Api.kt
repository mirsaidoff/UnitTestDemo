package uz.mirsaidoff.unittestdemo

import kotlinx.coroutines.delay

interface Api {
    suspend fun genCars(personName: String): List<Car>
}

package uz.mirsaidoff.unittestdemo

interface PersonCarsRepo {
    suspend fun fetchPersonCars(personName: String): List<Car>
}

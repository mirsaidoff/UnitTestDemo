package uz.mirsaidoff.unittestdemo

class PersonCarsRepoImpl(private val api: Api) : PersonCarsRepo {

    override suspend fun fetchPersonCars(personName: String): List<Car> {
        return api.genCars(personName).filter {
            it.color == "Red"
        }
    }
}


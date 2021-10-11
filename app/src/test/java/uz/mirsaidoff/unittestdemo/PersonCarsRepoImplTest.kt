package uz.mirsaidoff.unittestdemo

import junit.framework.Assert.assertEquals
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Test
import org.mockito.BDDMockito.anyString
import org.mockito.BDDMockito.given
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class PersonCarsRepoImplTest {

    @Mock
    lateinit var api: Api

    lateinit var repo: PersonCarsRepo

    companion object {
        val redCar = Car(123, "Red", "")
        val fakeCars = listOf(
            Car(111, "Blue", ""),
            redCar,
            Car(144, "Green", ""),
        )

        val anotherFakeCarsWithNoRedCar = listOf(
            Car(111, "Blue", ""),
            Car(144, "Green", ""),
        )
    }

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
        repo = PersonCarsRepoImpl(api)
    }

    @Test
    fun test1() = runBlockingTest {
        given(api.genCars(anyString())).willReturn(fakeCars)
        val expectedResult = listOf(redCar)
        assertEquals(
            repo.fetchPersonCars("").toString(), expectedResult.toString()
        )
    }

    @Test
    fun test2() = runBlockingTest {
        given(api.genCars(anyString())).willReturn(anotherFakeCarsWithNoRedCar)
        val expectedResult = emptyList<Car>()
        assertEquals(
            repo.fetchPersonCars("").toString(), expectedResult.toString()
        )
    }
}
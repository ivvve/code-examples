package io.github.ivvve.multids

import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@SpringBootTest
class MultipleDatasourceApplicationTests {

    @Test
    fun contextLoads() {
    }

}

@Service
//@Transactional
class PersonService(
    private val personRepository: PersonRepository
) {
    fun changeName(personId: Long, newName: String) {
        val person = this.personRepository.findById(personId)
            .orElseThrow { throw RuntimeException("Person not found") }

        person.name = newName
    }
}


class Person(
    var name: String
) {

}
interface PersonRepository : JpaRepository<Person, Long>
package de.maaanu.springdataldaptest

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import javax.naming.Name

@SpringBootApplication
class SpringDataLdapTestApplication : CommandLineRunner {

    @Autowired lateinit var userRepositoryry: UserRepository
    @Autowired lateinit var addressRepository: AddressRepository

    override fun run(vararg args: String?) {
        println(userRepositoryry.findAll())
        val walter = Person()
        walter.fullName = "Walter White"
        walter.uid = "heisenberg"
        walter.lastname = "White"
        userRepositoryry.save(walter)
        println(userRepositoryry.findByLastnameStartsWith("W"))

        createAddress()
    }

    fun createAddress() {
        val address = Address()
        address.id = Name()
        address.state = "HH"
        address.street = "Balindamm 3"
        addressRepository.save(address)
        println(address)
    }
}

fun main(args: Array<String>) {
    runApplication<SpringDataLdapTestApplication>(*args)
}

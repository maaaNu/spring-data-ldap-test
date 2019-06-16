package de.maaanu.springdataldaptest

import org.springframework.data.repository.CrudRepository
import javax.naming.Name

interface UserRepository : CrudRepository<Person, Name> {
    fun findByLastnameStartsWith(prefix: String): List<Person>
}

interface AddressRepository : CrudRepository<Address, Name> {

}

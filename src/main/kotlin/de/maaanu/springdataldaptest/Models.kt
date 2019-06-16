package de.maaanu.springdataldaptest

import org.springframework.ldap.odm.annotations.Attribute
import org.springframework.ldap.odm.annotations.Entry
import org.springframework.ldap.odm.annotations.Id
import javax.naming.Name
import org.springframework.ldap.odm.annotations.DnAttribute


@Entry(
        base = "ou=people,dc=springframework,dc=org",
        objectClasses = ["inetOrgPerson"]
)
class Person {
    @Id var id: Name? = null
    @DnAttribute(value = "uid", index = 3) var uid: String? = null
    @Attribute(name = "cn") var fullName: String? = null
    @Attribute(name = "sn") var lastname: String? = null
    @Attribute var address: Name? = null
    private val userPassword: String? = null

    override fun toString(): String {
        return "Person(id=$id, uid=$uid, fullName=$fullName, lastname=$lastname, userPassword=$userPassword)"
    }
}

@Entry(
        base = "ou=address,dc=springframework,dc=org",
        objectClasses = [" organizationalPerson"]
)
class Address {
    @Id var id: Name? = null
    @Attribute(name = "street") var street: String? = null
    @Attribute(name = "st") var state: String? = null
    @Attribute var person: Name? = null
    override fun toString(): String {
        return "Address(id=$id, street=$street, state=$state, person=$person)"
    }


}

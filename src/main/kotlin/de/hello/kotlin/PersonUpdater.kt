/**
 *    @author Stefan Gohlke
 */
package de.hello.kotlin
class PersonUpdater {
    fun savePerson(id: Int?, lastName: String?, firstName: String?, age: Int?): Person {
        return Person(id ?: 1, lastName ?: "UNKNOWN", firstName ?: "UNKNOWN", age ?: 999)
    }
}
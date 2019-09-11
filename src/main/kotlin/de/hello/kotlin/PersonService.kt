/**
 *    @author Stefan Gohlke
 */
package de.hello.kotlin

class PersonService {
    fun person(id: Int?, lastName: String?, firstName: String?, age: Int?): List<Person> =
            PersonStorage.personList.filter { person: Person ->
                (lastName == null || lastName.equals(person.lastName))
                        && (firstName == null || firstName.equals(person.firstName))
                        && (age == null || age == person.age)
                        && (id == null || id == person.id)
            }
}

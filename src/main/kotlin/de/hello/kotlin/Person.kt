package de.hello.kotlin

import com.expediagroup.graphql.federation.directives.FieldSet
import com.expediagroup.graphql.federation.directives.KeyDirective

@KeyDirective(fields = FieldSet("id"))
data class Person(val id: Int, val lastName: String = "UNKNOWN", val firstName:String = "UNKNOWN", val age:Int = 999) {}
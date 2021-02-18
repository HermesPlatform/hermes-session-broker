package models

import org.hibernate.id.CompositeNestedGeneratedValueGenerator.GenerationPlan

import java.util.Date
import javax.persistence.{Entity, GeneratedValue, GenerationType, Id}

@Entity(name = "User")
class User(
      var username: String,
      var passwordHash: String,
      var dateCreated: Date,
      var currentIp: String){
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  var id: Long = _
}
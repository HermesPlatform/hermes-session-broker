package models

import org.hibernate.id.CompositeNestedGeneratedValueGenerator.GenerationPlan

import java.util.Date
import javax.persistence.{Entity, GeneratedValue, GenerationType, Id, OneToMany}

@Entity(name = "Session")
class Session(
      var hostId: User,
      var playerId: User,
      var gameId: Long, // TODO: change type from Long to Game
      var dateStarted: Date,
      var hostUri: String){
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  var id: Long = _
}
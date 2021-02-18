package models

import java.util.Date
import javax.persistence.{Entity, GeneratedValue, GenerationType, Id, JoinColumn, ManyToOne, OneToMany, Table}

@Entity
@Table(name="sessions")
class HostSession(
      var playerId: User,
      var gameId: Long, // TODO: change type from Long to Game
      var dateStarted: Date,
      var hostUri: String){
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  var sessionId: Long = _

  @ManyToOne
  @JoinColumn(name = "hostId", nullable = false)
  var host: User = _
}
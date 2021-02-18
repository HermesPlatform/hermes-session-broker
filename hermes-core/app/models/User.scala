package models

import java.util.Date
import javax.persistence.{Entity, GeneratedValue, GenerationType, Id, OneToMany, Table}
import models.HostSession

@Entity
@Table(name="users")
class User(
      var username: String,
      var passwordHash: String,
      var dateCreated: Date,
      var currentIp: String){
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  var userId: Long = _;

//  @OneToMany(mappedBy = "host")
//  var sessions : Set[HostSession] = _;
}
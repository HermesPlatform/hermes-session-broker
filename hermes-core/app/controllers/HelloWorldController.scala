package controllers

import models.User
import org.hibernate.ogm.cfg.{OgmConfiguration, OgmProperties}
import play.api.libs.json.Json
import play.api.mvc.{Action, AnyContent, BaseController, ControllerComponents}
import services.CacheManager

import java.util.Date
import javax.inject.{Inject, Singleton}
import javax.persistence.{EntityManagerFactory, Persistence}

@Singleton
class HelloWorldController @Inject()(val controllerComponents: ControllerComponents, val cacheManager: CacheManager)
extends BaseController {
  val entityManagerFactory: EntityManagerFactory = Persistence.createEntityManagerFactory("hermes-jpa");

  def getAll(): Action[AnyContent] = Action {
    val user: User = new User("PICH", "13jasdjio12", new Date(), "1.1.1.1")
    cacheManager.persistUser(entityManagerFactory, user);
    Ok(Json.toJson("HI"))
  }
}

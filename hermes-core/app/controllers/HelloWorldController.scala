package controllers

import play.api.libs.json.Json
import play.api.mvc.{Action, AnyContent, BaseController, ControllerComponents}
import services.CacheManager

import javax.inject.{Inject, Singleton}

@Singleton
class HelloWorldController @Inject()(val controllerComponents: ControllerComponents, val cacheManager: CacheManager)
extends BaseController {
  def getAll(): Action[AnyContent] = Action {
    cacheManager
    Ok(Json.toJson("HI"))
  }
}

package controllers

import play.api.libs.json.Json
import play.api.mvc.{Action, AnyContent, BaseController, ControllerComponents}

import javax.inject.{Inject, Singleton}

@Singleton
class HelloWorldController @Inject()(val controllerComponents: ControllerComponents)
extends BaseController {
  def getAll(): Action[AnyContent] = Action {
    Ok(Json.toJson(controllerComponents.toString))
  }
}

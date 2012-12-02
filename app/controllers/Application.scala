package controllers

import play.api._
import play.api.mvc._
import models.Contact

object Application extends Controller {
  
  def index = Action {
    Redirect(routes.Application.contacts)
  }

  def contacts = Action {
  	Ok(views.html.index(Contact.all()))
  }

  def deleteContact (id:Int) = TODO
  
}
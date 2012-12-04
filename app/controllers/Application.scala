package controllers

import play.api._
import play.api.mvc._
import play.api.data._
import play.api.data.Forms._
import models.Contact

object Application extends Controller {
  
  val contactsForm: Form[Contact] = Form(
  	mapping(
  	"fname" -> text,
  	"lname" -> text,
    "email" -> text,
  	"title" -> text,
  	"location" -> text
  	)(Contact.apply)(Contact.unapply)  
  )

  def index = Action {
    Redirect(routes.Application.contacts)
  }

  def contacts = Action {
  	Ok(views.html.index(Contact.all(), contactsForm))
  }

  def newContact = Action { implicit request =>
  	contactsForm.bindFromRequest.fold(
  		errors => BadRequest(views.html.index(Contact.all(), errors)),
  		contact => {
        Contact.create(contact.fname, contact.lname, contact.email, contact.title, contact.location)
  			Redirect(routes.Application.contacts)
  		}
  	)
  }

  def deleteContact (fname:String) = TODO
  
}
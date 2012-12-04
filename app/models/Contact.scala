package models

import org.anormcypher._
import scala.collection.mutable.ListBuffer
import play.Logger

case class Contact(fname:String, lname:String, email:String, title:String, location:String)

object Contact {

	def all(): List[Contact] = {
		var contacts = new ListBuffer[Contact]
		contacts.toList
	}

	def create(fname:String, lname:String, email:String, title:String, location:String) {
		Logger.info("Creating Contact...")
		Logger.info("First Name: " + fname)
		Logger.info("Last Name: " + lname)
		Logger.info("Email: " + email)
		Logger.info("Title: " + title)
		Logger.info("Location: " + location)

		val result = Cypher("""
			create (contact {firstName:{fnameParam}, lastName:{lnameParam}, email:{emailParam}, title:{titleParam}, location:{locationParam} });
			""").on("fnameParam" -> fname, "lnameParam" -> lname, "emailParam" -> email,
					"titleParam" -> title, "locationParam" -> location).execute()

		Logger.info("Created Contact: " + result)
	}

}
package models

import scala.collection.mutable.ListBuffer

case class Contact(id:Int, fname:String, lname:String, title:String, location:String)

object Contact {

	def all(): List[Contact] = {
		var contacts = new ListBuffer[Contact]
		contacts.toList
	}

}
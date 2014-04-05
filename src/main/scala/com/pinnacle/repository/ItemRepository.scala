package com.pinnacle.repository

import com.pinnacle.domain.Item
import com.mongodb.casbah.{MongoCollection, MongoClient}

class ItemRepository(mongoClient: MongoClient = MongoClient()) {

  implicit val db = mongoClient("auction")

  def get(id: Long): Option[Item] = id match {
    case 123 => Some(Item(id, "Monty Python and the search for the holy grail", 0.69, "GBP", "Must have item"))
    case _ => None
  }

  def findOne(): Option[Item] = {
    val itemsColl = db("items")
    val result: Option[MongoCollection#T] = itemsColl.findOne()
    result.map(obj => Item(obj.get("_id").asInstanceOf[Double].toLong, obj.get("name").asInstanceOf[String],
      obj.get("startPrice").asInstanceOf[Number], obj.get("currency").asInstanceOf[String], obj.get("description").asInstanceOf[String]))
  }
}

package com.pinnacle.servlet

import org.scalatra.{NotFound, Ok, ScalatraServlet}
import org.scalatra.scalate.ScalateSupport
import grizzled.slf4j.Logger
import org.json4s.{DefaultFormats, Formats}
import org.scalatra.json._

import com.pinnacle.repository.ItemRepository

class AuctionServlet extends ScalatraServlet with ScalateSupport with JacksonJsonSupport {

  val logger = Logger(classOf[AuctionServlet])

  protected implicit val jsonFormats: Formats = DefaultFormats
  val itemRepo = new ItemRepository()

  before() {
    contentType = formats("json")
  }
  get("/items/:id") {
    contentType = "application/json"
    itemRepo.get(params("id").toLong) match {
      case Some(item) => Ok(item)
      case None => NotFound(s"Item with id: ${params("id")} not found")
    }
  }
}

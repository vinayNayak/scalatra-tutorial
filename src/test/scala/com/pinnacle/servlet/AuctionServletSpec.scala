package com.pinnacle.servlet

import org.scalatra.test.specs2.ScalatraSpec

class AuctionServletSpec extends ScalatraSpec {

  addServlet(classOf[AuctionServlet], "/auction/*")

  val ITEMS_URL = "/auction/items/123"

  def is =
    "Calling an unknown url on the API" ^
      "returns status 404" ! (statusCode("/unknown") == 404) ^
      end ^
      br ^
      s"Calling a GET on $ITEMS_URL should" ^
      "return status 200" ! (statusCode(ITEMS_URL) == 200) ^
      end

  def statusCode(url: String): Int = {
    get(url) {
      println(response.body)
      status
    }
  }
}

package com.pinnacle.servlet

import org.scalatra.test.specs2.ScalatraSpec

class AuctionServletSpec extends ScalatraSpec {

  addServlet(classOf[AuctionServlet], "/auction")

  def is =
    "Calling an unknown url on the API" ^
      "returns status 404" ! (statusCode("/unknown") == 404) ^
      end

  def statusCode(url: String): Int = {
    get(url) {
      status
    }
  }
}

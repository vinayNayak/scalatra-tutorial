package com.pinnacle.servlet

import org.scalatra.ScalatraServlet

class MainServlet extends ScalatraServlet {

  get("/") {
    "Hello World"
  }

  get("/:name") {
    val name = params.getOrElse("name", "World")
    s"Hello $name"
  }
}

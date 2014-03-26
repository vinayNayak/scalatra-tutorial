package com.pinnacle.domain

case class Item(id: Long, name: String, startPrice: Number, currency: String, description: String)

case class Bid(id: Option[Long], itemId: Number, minimum: Number, maximum: Number, currency: String, bidder: String, date: Long)



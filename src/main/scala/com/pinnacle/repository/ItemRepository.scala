package com.pinnacle.repository

import com.pinnacle.domain.Item

class ItemRepository {
  def get(id: Long): Option[Item] = id match {
    case 123 => Some(Item(id, "Monty Python and the search for the holy grail", 0.69, "GBP", "Must have item"))
    case _ => None
  }
}

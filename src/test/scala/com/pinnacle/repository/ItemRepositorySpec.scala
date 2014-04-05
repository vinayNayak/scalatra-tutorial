package com.pinnacle.repository

import com.pinnacle.UnitSpec
import com.pinnacle.domain.Item

class ItemRepositorySpec extends UnitSpec {

  val repo: ItemRepository = new ItemRepository()

  before {}

  "Get By Id" should "return an item for id 123" in {
    val expected = Item(123, "Monty Python and the search for the holy grail", 0.69, "GBP", "Must have item")
    repo.get(123) should be(Some(expected))
  }

  it should "return None if the item is not present" in {
    repo.get(-1) should be === None
  }

  "Find One" should "return an item" in {
    val expected = Item(123, "Monty Python and the search for the holy grail", 0.69, "GBP", "Must have item")
    repo.findOne() should be === Some(expected)
  }
}

package knoldus

import org.scalatest.funsuite.AnyFunSuite
class SearchDirTest extends AnyFunSuite {

  val obj1= new SearchDir("./src")
  test("If the path is given"){
    assert(obj1.content == List("()"))
  }

  val obj2 = new SearchDir("./nsrc")
  test("If wrong path is given") {
    assert(obj2.content == List("Invalid path"))
  }

  val obj3= new SearchDir("")
  test("If path is not given") {
    assert(obj3.content == List("Invalid path"))
  }
}
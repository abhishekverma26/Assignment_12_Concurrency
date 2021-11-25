package knoldus

import java.nio.file.{FileSystems, Files}
import scala.concurrent.{Await, Future}
import scala.concurrent.duration.DurationInt
import scala.concurrent.ExecutionContext.Implicits.global
import scala.jdk.CollectionConverters.IteratorHasAsScala
import scala.language.postfixOps

class SearchDir(path:String) {

  def contentSearch(path: String): Future[List[String]] = Future {
    Thread.sleep(1000)
    val temp = FileSystems.getDefault.getPath(path)

    if(temp.toFile.isDirectory || temp.toFile.exists()) {
      List(Files.walk(temp).iterator().asScala.foreach(println).toString)
    }

    else List("Invalid path")

  }

  val content: List[String] = Await.result(contentSearch(path), 2 second)

}
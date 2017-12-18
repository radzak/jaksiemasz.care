package company

import scala.collection.mutable.{ListBuffer => ListB}

case class CollectiveReport(manager: BaseEmployee with Manager[Employee]) extends Report {
  val firstName: String = manager.firstName
  val lastName: String = manager.lastName

  private val reports: ListB[Report] = manager.subordinates.map(_.reportWork()).to[ListB]
//  lepiej taki tasiemiec czy takie coś jak poniżej? czy wgl jakoś inaczej zebrać raporty ze wszystkich podwładnych?
//  private val reports: ListB[Report] = {
//    val r = ListB[Report]()
//    for (sub <- manager.subordinates) {
//      r += sub.reportWork()
//    }
//    r
//  }

  def getReports: List[Report] = {
    reports.toList
  }

  def add(report: Report): Unit = {
    reports += report
  }

  def print(): Unit = {
    val repr =
      s"""Collective Report by $firstName $lastName
         |${"-" * 40}
         |${reports.mkString("Team Members Reports:\n", ",\n", "")}""".stripMargin
    println(repr)
  }

}

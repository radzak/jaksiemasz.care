package company

import scala.collection.mutable.{ListBuffer => ListB}

abstract class BaseEmployee(firstName: String,
                            lastName: String,
                            role: Role
                           ) extends Employee {

  // https://stackoverflow.com/questions/2712877/difference-between-array-and-list-in-scala
  protected val tasks: ListB[Task] = ListB[Task]()
  def getTasks: List[Task] = {
    tasks.toList
  }
}

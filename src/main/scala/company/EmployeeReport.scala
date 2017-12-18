package company

case class EmployeeReport(employee: Employee) extends Report {
  val tasks: List[Task] = employee.getTasks

  override def toString: String = {
    s"EmployeeRaport of $employee: ${tasks.mkString("[", ", ", "]")}"
  }
}

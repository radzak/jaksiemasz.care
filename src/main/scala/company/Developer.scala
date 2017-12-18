package company


case class Developer(firstName: String,
                     lastName: String,
                     role: Role
                    ) extends BaseEmployee (firstName, lastName, role) {

  override def assign(task: Task): Unit = {
    tasks += task
  }

  override def reportWork(): EmployeeReport = {
    EmployeeReport(this)
  }
}

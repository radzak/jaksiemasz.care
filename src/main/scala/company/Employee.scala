package company

trait Employee {
  def firstName: String
  def lastName: String
  def getTasks: List[Task]
  def assign(task: Task): Unit
  def reportWork(): Report
}

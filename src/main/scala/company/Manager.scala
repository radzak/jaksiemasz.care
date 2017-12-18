package company

trait Manager[A] {
  def canHire: Boolean  // defy czy vale?
  def subordinates: scala.collection.mutable.Set[A]  // TODO: Make it an arbitrary data structure
  def hire(employee: A): Unit
  def fire(employee: A): Unit
}

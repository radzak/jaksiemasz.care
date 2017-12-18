package company

import company.exceptions.ManagerException

import scala.collection.mutable.{Set => MSet}

//https://stackoverflow.com/questions/13828926/scala-abstract-class-constructor-parameter-vs-trait-val-members
case class TeamManager(firstName: String,
                        lastName: String,
                        role: Role,
                        subordinatesLimit: Int
                      ) extends BaseEmployee (firstName, lastName, role) with Manager[Employee] {

  // czy tak jest okej? miał być konstruktor w BaseEmployee (abstract), więc chyba tak musi to wyglądać

    override val subordinates: MSet[Employee] = MSet[Employee]()  // TODO: Set private

  // w tym przypadku lepsze coś mutable czy immutable?

/*
 *  W tasku było napisane:
 *  "Pracownicy są trzymani w odpowiedniej strukturze danych o rozmiarze określonym w konstruktorze".
 *  Dlaczego ma być użyta struktura o z góry określonym rozmiarze, wybrałem jedno z tych:
 *
 *  private val subordinates = new scala.collection.mutable.ArrayBuffer[BaseEmployee]()
 *  override def canHire: Boolean = subordinates.length < subordinatesLimit
 *
 *  private val subordinates = scala.collection.mutable.Set[BaseEmployee]()
 *  override def canHire: Boolean = subordinates.size < subordinatesLimit
 *
 *  Bo w tym przypadku z fixed rozmiarem jest potem więcej roboty z dodawaniem i usuwaniem pracowników :d
 *  var subordinatesNumber = 0
 *  private val subordinates = new Array[BaseEmployee](subordinatesLimit)
 */

  override def canHire: Boolean = subordinates.size < subordinatesLimit

  override def hire(employee: Employee): Unit = {
    if (canHire)
      subordinates.add(employee)
    else
      throw ManagerException("You can't hire more employees. Limit already reached.")
  }

  override def fire(employee: Employee): Unit = {
    subordinates.remove(employee)
  }

  override def assign(task: Task): Unit = {
    if (subordinates.nonEmpty){
      val subordinate = subordinates.minBy(_.getTasks.length)
      subordinate.assign(task)
    }
    else
      throw ManagerException("You have no subordinates to assign a task to.")
  }

  override def reportWork(): CollectiveReport = {
    CollectiveReport(this)
  }
}

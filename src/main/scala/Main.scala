//import faker.RandomPersonFactory
import company._

object Main extends App {
//  task 0
//  for (person <- RandomPersonFactory(20))
//    println(person)

//  task 1
  val task = Task("Sprzątnąć garaż xD")

  val manager = TeamManager("James", "Bond", new Role(), 5)
  val dev1 = Developer("Radek", "Krzak", new Role())
  val dev2 = Developer("Jan", "Kowalski", new Role())
  manager.hire(dev1)
  manager.hire(dev2)

  manager.assign(task)
  manager.assign(task)
  manager.assign(task)

  val managerReport = manager.reportWork()
  managerReport.print()
}

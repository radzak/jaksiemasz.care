package company

import company.exceptions.ManagerException

import org.junit.runner.RunWith
import org.scalatest.FlatSpec
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class TeamManagerSpec extends FlatSpec {
  "Team Manager" should "produce ManagerException when subordinates limit is exceeded" in {
    assertThrows[ManagerException] {
      val manager = TeamManager("James", "Bond", new Role(), 0)
      val dev = Developer("Radek", "Krzak", new Role())
      manager.hire(dev)
    }
  }

  it should "produce ManagerException when assigning task with no subordinates hired" in {
    assertThrows[ManagerException] {
      val task = Task("Test Task")
      val manager = TeamManager("James", "Bond", new Role(), 5)
      manager.assign(task)
    }
  }
}

package faker

import scala.collection.mutable.ListBuffer
import scala.io.Source
import scala.util.Random


trait FileReader {
  def readlines(path: String): List[String] = {
    val data = new ListBuffer[String]()

    val file = Source.fromFile(path)
    for (line <- file.getLines) {
      data += line
    }
    file.close

    data.toList
  }
}


object RandomPersonFactory extends FileReader {
  private val randomNames = readlines("src/main/scala/faker/names.txt")
  private val randomSurnames = readlines("src/main/scala/faker/surnames.txt")

  def apply(number: Int): List[Person] = {
    val people = new ListBuffer[Person]()

    1 to number foreach { _ => people += generateRandomPerson() }

    people.toList.sortBy(p => (p.name, p.surname, p.email))
  }

  def generateRandomPerson(): Person = {
    val randomName =  randomNames(Random.nextInt(randomNames.size))
    val randomSurname =  randomSurnames(Random.nextInt(randomSurnames.size))
    val randomEmail = generateEmail(randomName, randomSurname)

    new Person(randomName, randomSurname, randomEmail)
  }

  def generateEmail(name: String, surname: String): String = {
    val domains = List("hotmail.com", "gmail.com", "aol.com", "mail.com" , "mail.kz", "yahoo.com")
    s"$name.$surname@${domains(Random.nextInt(domains.size))}"
  }
}

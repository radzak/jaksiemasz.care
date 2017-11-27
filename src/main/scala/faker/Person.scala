package faker

class Person(
              val name: String,
              val surname: String,
              val email: String) {

  val emailRegex = """^[a-zA-Z0-9\.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$"""
  require(name.matches("[A-Z][a-z]+"), "Wrong name!")
  require(surname.matches("[A-Z][a-z]+"), "Wrong surname!")
  require(email.matches(emailRegex), "Wrong email!")

  override def toString: String = s"Person<$name $surname, email: $email>"

}

package faker

class Person(
              private var _name: String,
              private var _surname: String,
              private var _email: String) {
  name = _name
  surname = _surname
  email = _email

  def name: String = _name
  def name_= (newName: String): Unit = {
    require(newName.matches("[A-Z][a-z]+"), "Wrong name!")
    _name = newName
  }

  def surname: String = _surname
  def surname_= (newSurname: String): Unit = {
    require(newSurname.matches("[A-Z][a-z]+"), "Wrong surname!")
    _surname = newSurname
  }

  def email: String = _email
  def email_= (newEmail: String): Unit = {
    val emailRegex = """^[a-zA-Z0-9\.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$"""
    require(newEmail.matches(emailRegex), "Wrong email!")
    _email = email
  }

  override def toString: String = s"Person<$name $surname, email: $email>"

}

import faker.RandomPersonFactory


object Main extends App {
  for (person <- RandomPersonFactory(20))
    println(person)
}

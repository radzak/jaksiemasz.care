package faker

import org.junit.runner.RunWith
import org.scalatest.FlatSpec
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class PersonSpec extends FlatSpec {
  "Person" should "produce IllegalArgumentException when instantiated with invalid name" in {
    assertThrows[IllegalArgumentException] {
      new Person("12James", "Haney", "JamesJHaney@rhyta.com")
    }
  }

  it should "produce IllegalArgumentException when instantiated with invalid surname" in {
    assertThrows[IllegalArgumentException] {
      new Person("Kenneth", "@Tucker#", "KennethCTucker@dayrep.com")
    }
  }

  it should "produce IllegalArgumentException when instantiated with invalid email" in {
    assertThrows[IllegalArgumentException] {
      new Person("Kenneth", "@Tucker#", "KennethCTucker@dayrep.com")
    }
  }
}

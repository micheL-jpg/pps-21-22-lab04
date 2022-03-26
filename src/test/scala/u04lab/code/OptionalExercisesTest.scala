package u04lab.code

import org.junit.*
import org.junit.Assert.*

class OptionalExercisesTest {

  import List.*

  val l: List[Int] = Cons(10, Cons(20, Cons(30, Nil())))

  @Test def testFactory(): Unit =
    assertEquals(l, List(10, 20, 30))

  @Test def testExtractorWithSameTeachers(): Unit =
    val cPPS = Course("PPS", "Viroli")
    val cPCD = Course("PCD", "Viroli")
    val cSDR = Course("SDR", "Viroli")
    val courses = List(cPPS, cPCD, cSDR)
    var checkString = ""

    courses match
      case sameTeacher(t) => checkString = s"courses have same teacher $t"
      case _ => checkString = s"courses have different teachers"

      assertEquals("courses have same teacher Viroli", checkString)

  @Test def testExtractorWithDifferentTeachers(): Unit =
    val cPPS = Course("PPS", "Viroli")
    val cPCD = Course("PCD", "Ricci")
    val cSDR = Course("SDR", "D'Angelo")
    val courses = List(cPPS, cPCD, cSDR)
    var checkString = ""

    courses match
      case sameTeacher(t) => checkString = s"courses have same teacher $t"
      case _ => checkString = s"courses have different teachers"

    assertEquals("courses have different teachers", checkString)
}

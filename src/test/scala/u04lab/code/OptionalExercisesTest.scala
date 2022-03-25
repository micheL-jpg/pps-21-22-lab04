package u04lab.code

import org.junit.*
import org.junit.Assert.*

class OptionalExercisesTest {

  import List.*

  val l: List[Int] = Cons(10, Cons(20, Cons(30, Nil())))

  @Test def testFactory(): Unit =
    assertEquals(l, List(10, 20, 30))

}

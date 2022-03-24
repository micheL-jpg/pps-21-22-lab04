package u04lab.polyglot.a01b
import scala.jdk.javaapi.OptionConverters
import u04lab.polyglot.OptionToOptional
import u04lab.code.Option
import u04lab.code.Option.*
import u04lab.code.List
import u04lab.code.List.*
import u04lab.code.Stream
import u04lab.code.Stream.*

import java.util.Random

/** solution and descriptions at https://bitbucket.org/mviroli/oop2019-esami/src/master/a01b/sol2/ */
class LogicsImpl(private val size: Int, private val mines: Int) extends Logics:

  val minesList: List[(Int, Int)] =
    val r = new Random()
    Stream.toList(Stream.take(Stream.iterate((r.nextInt(size), r.nextInt(size)))(_ => (r.nextInt(size), r.nextInt(size))))(mines))

  var selected: List[(Int, Int)] = Nil()

  private def neighbours(x: Int, y: Int): Int =
    val l1 = Stream.toList(Stream.take(Stream.iterate(x - 1)(x => x + 1))(3))
    val l2 = List.flatMap(l1)(x => List.map(Stream.toList(Stream.take(Stream.iterate(y - 1)(y => y + 1))(3)))(yy => (x, yy)))
    List.length(List.filter(l2)(p => List.contains(minesList, p)))

  def hit(x: Int, y: Int): java.util.Optional[Integer] = (x, y) match
    case (x, y) if List.contains(minesList, (x, y)) => OptionToOptional(None())
    case (x, y) =>
      selected = List.append(selected, Cons((x,y), Nil()))
      OptionToOptional(Some(neighbours(x, y)))

  def won: Boolean = List.length(minesList) + List.length(selected) == size * size

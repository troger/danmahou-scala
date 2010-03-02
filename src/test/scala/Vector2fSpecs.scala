import fr.arnk.danmahou.util.{MathUtil, Vector2f}
import org.specs.Specification

/**
 * @author <a href="mailto:throger@gmail.com">Thomas Roger</a>
 */

class Vector2fSpecs extends Specification {
  
  "an empty Vector2f" should {
    val v = Vector2f(0, 0)
    "have x and y set to 0" in {
      v.x must_== 0
      v.y must_== 0
    }

    "equals Vector2f.Zero" in {
      v must_== Vector2f.Zero
    }
  }

  "an unit Vector2f" should {
    val v = new Vector2f(1, 1)
    "have x and y set to 1" in {
      v.x must_== 1
      v.y must_== 1
    }

    "equals Vector2f.Unit" in {
      v must_== Vector2f.Unit
    }
  }

  "a Vector2f" should {
    "provide a + operator adding 2 Vector2f" in {
      val v1 = Vector2f(5, 5)
      val v2 = Vector2f(10, 15)
      val v = v1 + v2
      v.x must_== 15
      v.y must_== 20
      v must_== Vector2f(15, 20)
    }

    "provide a - operator subtracting 2 Vector2f" in {
      val v1 = Vector2f(20, 15)
      val v2 = Vector2f(10, 15)
      val v = v1 - v2
      v.x must_== 10
      v.y must_== 0
      v must_== Vector2f(10, 0)
    }

    "provide a length method" in {
      val v = Vector2f(20, 15)
      v.length must_== MathUtil.sqrt(20 * 20 + 15 * 15)

    }

    "provide a lengthSquared method" in {
      val v = Vector2f(20, 15)
      v.lengthSquared must_== 20 * 20 + 15 * 15
    }
  }

  "Vector2f object" should {
    "provide an implicit def from Tuple[Int, Int] to Vector2f" in {
      val v1 = Vector2f(10, 10)
      val v = v1 + (5, 5)
      v.x must_== 15
      v.y must_== 15
      v must_== Vector2f(15, 15)
    }

    "provide an implicit def from Tuple[Float, Float] to Vector2f" in {
      val v1 = Vector2f(100, 100)
      val v = v1 + (10f, 10f)
      v.x must_== 110
      v.y must_== 110
      v must_== Vector2f(110, 110)
    }
  }

}

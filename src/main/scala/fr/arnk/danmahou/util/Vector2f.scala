package fr.arnk.danmahou.util

/**
 * @author <a href="mailto:throger@gmail.com">Thomas Roger</a>
 */

case class Vector2f(val x: Float, val y: Float) {

  def +(v: Vector2f): Vector2f = Vector2f(x + v.x, y + v.y)
  def -(v: Vector2f): Vector2f = Vector2f(x - v.x, y - v.y)

  def length = MathUtil.sqrt(x * x + y * y)
  def lengthSquared = x * x + y * y

  override def toString = "Vector2f(x: " + x + ", y: " + y + ")"

}

object Vector2f {

  implicit def tupleFloat2vector2f(t: Tuple2[Float, Float]): Vector2f = Vector2f(t._1, t._2)
  implicit def tupleInt2vector2f(t: Tuple2[Int, Int]): Vector2f = Vector2f(t._1, t._2)

  val Zero = Vector2f(0, 0)
  val Unit = Vector2f(1, 1)
  val UnitX = Vector2f(1, 0)
  val UnitY = Vector2f(0, 1)

}

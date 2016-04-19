/**
  * Created by geoff on 4/13/16.
  */
import scala.util.matching.Regex
import scala.xml._

class StrokeTransformer extends scala.xml.transform.RewriteRule {
  def transform(n: Node, m: Double): Node = n match {
    case elem @ Node(_, _, Attribute("stroke-width", _, _), _, _, child @ _*) =>
      val el = updateStroke(elem, m)
      el.copy(child = child map (c => transform(c, m)))
    case elem @ Node(_, _, _, _, child @ _*) =>
      elem.asInstanceOf[Elem].copy(child = child map(c => transform(c, m)))
    case other => other
  }

  val unitsPattern: Regex = """(\d*\.?\d*)(\w*)""".r


  def separateUnits(n: Node): Tuple2[Double, String] =
    n.text match {
      case unitsPattern(values, units) => new Tuple2(values.toDouble, units)
      //case x => x
    }

  def calculateValue(t: Tuple2[Double, String], m: Double): String = {
    s"${t._1 * m}${t._2}"
  }

  def multiplyStrokeVal(m: Double, n: Node): String = {
    calculateValue(separateUnits(n), m)
  }

  def updateStroke(n: Node, m: Double): Elem = {
    n.asInstanceOf[Elem] % Attribute("stroke-width", Text(multiplyStrokeVal(m, n.attribute("stroke-width").get.head)), Null)
  }

}
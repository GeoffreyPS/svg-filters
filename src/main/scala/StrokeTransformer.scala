/**
  * Created by geoff on 4/13/16.
  */
import scala.util.matching.Regex
import scala.xml._

class StrokeTransformer(factor: Double) extends scala.xml.transform.RewriteRule {
  override def transform(n: Node): Node = n match {
    case elem @ Elem(_, _, Attribute("stroke-width", _, _), _, _, child @ _*) =>
      val el = updateStroke(elem, factor)
      el.copy(child = child map transform)
    case elem @ Elem(_, _, _, _, child @ _*) =>
      elem.asInstanceOf[Elem].copy(child = child map transform)
    case other => other
  }

  val unitsPattern: Regex = """(\d*\.?\d*)(\w*)""".r

  private def separateUnits(n: Node): Tuple2[Double, String] =
    n.text match {
      case unitsPattern(values, units) => new Tuple2(values.toDouble, units)
      //case x => x
    }

  private def calculateValue(t: Tuple2[Double, String], m: Double): String = {
    s"${t._1 * m}${t._2}"
  }

  private def multiplyStrokeVal(m: Double, n: Node): String = {
    calculateValue(separateUnits(n), m)
  }

  private def updateStroke(n: Node, m: Double): Elem = {
    n.asInstanceOf[Elem] % Attribute("stroke-width", Text(multiplyStrokeVal(m, n.attribute("stroke-width").get.head)), Null)
  }

}
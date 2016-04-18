/**
  * Created by geoff on 4/13/16.
  */
import scala.util.matching.Regex
import scala.xml._

class StrokeTransformer extends scala.xml.transform.RewriteRule {
  override def transform(n: Node, m: Double): Seq[Node] = n match {
    case elem @ Elem(_, _, Attribute("stroke-width"), _, _, child @ _*) =>
        elem.asInstanceOf[Elem] % Attribute(None, key: "stroke-width", Text(multiplyStrokeVal(m, elem.attribute("stroke-width"))) , Null) copy(child = child map transform)
    case elem @ Elem(_, _, _, _, child @ _*) =>
      elem.asInstanceOf[Elem].copy(child = child map transform)
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
}



def updateBar(node: Node): Node = node match {
  case elem @ Elem(_, "bar", _, _, child @ _*) =>
    elem.asInstanceOf[Elem] % Attribute(None, "newKey", Text("newValue"), Null) copy(child = child map updateBar)
  case elem @ Elem(_, _, _, _, child @ _*) =>
    elem.asInstanceOf[Elem].copy(child = child map updateBar)
  case other => other
}
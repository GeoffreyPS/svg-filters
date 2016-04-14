/**
  * Created by geoff on 4/13/16.
  */
import scala.xml._

class StrokeTransformer extends scala.xml.transform.RewriteRule {
  override def transform(n: Node): Seq[Node] = n match {
    case e@Elem(_, _, attribute("stroke-width"), _, _, child@_*) =>
  }

  val unitsPattern = """(\d*\.?\d*)(\w*)""".r

  def separateUnits(n: Node): Tuple2[Double, String] =
    n.text match {
      case unitsPattern(values, units) => new Tuple2(values.toDouble, units)
      //case x => x
    }

}
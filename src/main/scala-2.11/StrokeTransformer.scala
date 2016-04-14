/**
  * Created by geoff on 4/13/16.
  */
import scala.xml._

class StrokeTransformer extends scala.xml.transform.RewriteRule {
  override def transform(n: Node): Seq[Node] = n match{
    case e @ Elem(_, _, attribute("stroke-width"), _, _, child @ _*) =>
  }

  val unitsPattern = """(\d*\.*\d*)(\w*)""".r

}
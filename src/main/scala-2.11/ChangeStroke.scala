/**
  * Created by Geoff on 4/3/16.
  */
import scala.xml._

class ChangeStroke extends RewriteRule {
  override def transform(n: Node): Seq[Node] = n match {
    case e: Elem if e.attribute("stroke-width") => {

    }
    case elem: Elem copy (child = elem.child flatMap (this transform))
    case other => other
   }
}

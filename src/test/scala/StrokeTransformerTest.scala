/**
  * Test suite for StrokeTransformer
  */
import org.scalatest._
import scala.xml.transform.RuleTransformer

class StrokeTransformerTest extends FlatSpec with Matchers {

  val originalXML: scala.xml.Node = <g stroke-width="0.15mm" stroke="#FFFF00">233.11</g>

  "StrokeTransformer" should "multiply stroke-width by given factor" in {
    val rule = new RuleTransformer(new StrokeTransformer(4))
    val transformedXML = rule.transform(originalXML)
    val newStrokeWidth = transformedXML \ "@stroke-width"

    assert(newStrokeWidth.text == "0.6mm")
  }

}

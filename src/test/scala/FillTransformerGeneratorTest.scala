/**
  * Created by geoff on 4/29/16.
  */

import org.scalatest._

class FillTransformerGeneratorTest extends FlatSpec with Matchers{

  "FillTransformerGenerator" should "instantiate FillTransformer when given a non-namespaced attribute" in {
    val (color, attribute, idSet) = ("#FFFF99", "id", Set("2", "4"))
    val rule = FillTransformerGenerator(color, attribute, idSet)

    assert(rule.isInstanceOf[FillTransformer])
  }

  "FillTransformerGenerator" should "instantiate NamespacedFillTransformer when given a namespaced attribute" in {
    val (color, attribute, idSet) = ("#FFFF99", "ss:lid", Set("2", "4"))
    val rule = FillTransformerGenerator(color, attribute, idSet)

    assert(rule.isInstanceOf[NamespacedFillTransformer])
  }

}

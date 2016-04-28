import scala.util.matching.Regex

/**
  * Created by geoff on 4/28/16.
  */
object FillTransformerGenerator {

  val namespacePattern: Regex = """(\w*)(:)(\w*)""".r

  def apply(color: String, attribute: String, set: Set[String]) = {
    val (namespace, attr) = resolveNamespace(attribute)
    if (namespace.isEmpty)
      new FillTransformer(color, attr, set)
    else
      new NamespacedFillTransformer(color, namespace, attr, set)
  }

  def resolveNamespace(a: String): Tuple2[String, String] =
    a match {
      case namespacePattern(ns, _, at) => new Tuple2(ns, at)
      case other => new Tuple2("", other)
    }

}

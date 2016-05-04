/**
  * Created by Geoff on 5/2/16.
  */
object Main extends App {
  val start = System.nanoTime()
  val strokeFactor = 1.5
  val fillColor = "#FFFF99"
  val targetAttribute = "ss:lid"
  val attributeValues = Set("76", "85", "77")

  val stroker = new StrokeTransformer(strokeFactor)
  val filler = FillTransformerGenerator(fillColor, targetAttribute, attributeValues)

  val rule = new scala.xml.transform.RuleTransformer(stroker, filler)

  val url = "https://997eaee7450d5da75091-88387ec3e1bbe6f03980edb1f1a8b155.ssl.cf1.rackcdn.com/e8a5dbf220c10d5ad6bfc63910e98d8592557ca5c7bbb2bd6afe060e9eafe92f/e8a5dbf220c10d5ad6bfc63910e98d8592557ca5c7bbb2bd6afe060e9eafe92f.svg"
  val parser = svgParser.fromURL(url, false, rule)
  val doc = parser.document()
  val newSVG = doc.docElem

  scala.xml.XML.save("product.svg", newSVG)
  val end = System.nanoTime()
  println("Finished!")
  println(s"Time taken: ${(end - start)/1.0e9} sec")

}

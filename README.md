# svg-transformers
Rewrite rules for SVG using [Scala's XML API](http://www.scala-lang.org/api/2.11.8/scala-xml/?_ga=1.30378239.1508293342.1462394059#scala.xml.package) for conversion in mapping applications.

This project is still under development and may change drastically between commits. At this point, this is for demonstration purposes only.

### Capabilities
Currently this project can:
- Increase the size of stroke-weights globally by a given factor
- Add a fill to `<g>` tags that have direct children who possess a user-specified attribute and user-specified values.
    - Attribute can be prefixed/namespaced (eg: `namespace:id="4"`) or unprefixed/namespaced (eg: `id="4"`)
- Accept an SVG from a specified filepath or a URL
- Process the SVG in a streaming fashion

### To-Do
- Optimize for performance
- Make a fully command-line accessible application
- Translate zoom levels of a map to stroke-increase factors
- Write more robust tests for edge cases instead of basic sanity checks.
- Write documentation

### Installation
1. Clone this repository locally with `git clone https://github.com/GeoffreyPS/svg-filters `
2. If you are missing javac, install Oracle or OpenJDK.
3. If you are missing `sbt` [install sbt](http://www.scala-sbt.org/release/docs/Setup.html)
4. Run `sbt build` within your cloned directory

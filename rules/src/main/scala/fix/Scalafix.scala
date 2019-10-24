package fix

import scalafix.v1._
import scala.meta._

class Scalafix extends SemanticRule("Scalafix") {

  override def fix(implicit doc: SemanticDocument): Patch = {
    Rule1(doc.tree).asPatch
  }

}

object Rule1 {

  def apply(tree: Tree)(implicit doc: SemanticDocument): List[Patch] = {
    tree.collect {
     case  Term.Apply(
             Term.Select(Term.Name("Stream"), Term.Name("resource")),
             List(bec)
           ) =>
        println(bec.symbol.structure)
        Patch.empty
    }
  }

}

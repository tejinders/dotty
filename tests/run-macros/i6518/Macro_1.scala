import scala.quoted._

object Macros {

  inline def test(): String = ${ testImpl }

  private def testImpl(using Quotes) : Expr[String] = {
    import quotes.reflect._
    val classSym = TypeRepr.of[Function1].classSymbol.get
    classSym.declaredMethod("apply")
    classSym.declaredMethods
    classSym.memberMethod("apply")
    Expr(classSym.memberMethods.map(_.name).sorted.mkString("\n"))
  }

}

import scala.quoted._
def oops(using Quotes) = {
  val q = '{ class Foo { val x = 3; ${ val v = 'x; '{} }  }}
}

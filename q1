object q1 {
  class Rational(n: Int, d: Int) {
    require(d != 0, "Denominator must be nonzero")

    private val gcdValue: Int = gcd(n.abs, d.abs)
    val numer: Int = n / gcdValue
    val denom: Int = d / gcdValue

    private def gcd(a: Int, b: Int): Int = {
      if (b == 0) a else gcd(b, a % b)
    }

    def neg: Rational = new Rational(-numer, denom)

    override def toString: String = s"$numer / $denom"
  }

  def main(args: Array[String]): Unit = {
    println("Enter the numerator of the rational number:")
    val numerInput = scala.io.StdIn.readInt()

    println("Enter the denominator of the rational number:")
    val denomInput = scala.io.StdIn.readInt()

    val x = new Rational(numerInput, denomInput)
    val negX = x.neg

    println(s"x: $x")
    println(s"Negation of x: $negX")
  }
}

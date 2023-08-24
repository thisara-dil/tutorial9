object q2{
  class Rational(n: Int, d: Int) {
    require(d != 0, "Denominator must be nonzero")

    private val gcdValue: Int = gcd(n.abs, d.abs)
    val numer: Int = n / gcdValue
    val denom: Int = d / gcdValue

    private def gcd(a: Int, b: Int): Int = {
      if (b == 0) a else gcd(b, a % b)
    }

    def sub(that: Rational): Rational = {
      new Rational(
        numer * that.denom - that.numer * denom,
        denom * that.denom
      )
    }

    override def toString: String = s"$numer / $denom"
  }

  def main(args: Array[String]): Unit = {
    val x = new Rational(3, 4)
    val y = new Rational(5, 8)
    val z = new Rational(2, 7)

    val result = x.sub(y).sub(z)

    println(s"x: $x")
    println(s"y: $y")
    println(s"z: $z")
    println(s"Result of x - y - z: $result")
  }
}

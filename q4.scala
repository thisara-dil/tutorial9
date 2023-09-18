object q4 {

  case class Account(accountNumber: String, balance: Double)

  def accountsWithNegativeBalances(accounts: List[Account]): List[Account] = {
    accounts.filter(_.balance < 0)
  }

  def calculateTotalBalance(accounts: List[Account]): Double = accounts.map(_.balance).sum

  def applyInterest(accounts: List[Account]): List[Account] = {
    accounts.map(acc => {
      val rate = if (acc.balance >= 0) 0.05 else 0.1
      val interest = acc.balance * rate
      Account(acc.accountNumber, acc.balance + interest)
    })
  }

  def main(args: Array[String]): Unit = {
    val accounts = List(
      Account("0089775564", 1000),
      Account("0089775564", -500),
      Account("1023456789", 200),
      Account("9876543210", -100)
    )

    println("List of Accounts with negative balances:")
    val negativeBalances = accountsWithNegativeBalances(accounts)
    negativeBalances.foreach(acc => println(s"${acc.accountNumber}: ${acc.balance}"))

    val totalBalance = calculateTotalBalance(accounts)
    println(s"Total balance of all accounts: $totalBalance")

    println("Final balances of all accounts after applying interest:")
    val finalBalances = applyInterest(accounts)
    finalBalances.foreach(acc => println(s"${acc.accountNumber}: ${acc.balance}"))
  }
}


object q4{

  case class Account(accountNumber: String, balance: Double)

  def accountsWithNegativeBalances(accounts: List[Account]): List[Account] = {
    accounts.filter(_.balance < 0)
  }

  def calculateTotalBalance(accounts: List[Account]): Double = {
    accounts.map(_.balance).sum
  }

  def applyInterest(accounts: List[Account]): List[Account] = {
    accounts.map(account => {
      val interestRate = if (account.balance >= 0) 0.05 else 0.1
      val interest = account.balance * interestRate
      Account(account.accountNumber, account.balance + interest)
    })
  }

  val accounts = List(
    Account("A123", 1000),
    Account("B456", -500),
    Account("C789", 200),
    Account("D012", -100)
  )

  println("List of Accounts with negative balances:")
  val negativeBalances = accountsWithNegativeBalances(accounts)
  negativeBalances.foreach(account => println(s"${account.accountNumber}: ${account.balance}"))

  val totalBalance = calculateTotalBalance(accounts)
  println(s"Total balance of all accounts: $totalBalance")

  println("Final balances of all accounts after applying interest:")
  val finalBalances = applyInterest(accounts)
  finalBalances.foreach(account => println(s"${account.accountNumber}: ${account.balance}"))
}

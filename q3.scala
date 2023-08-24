object q3 {
  class Account(val accountId: Int, var balance: Double) {
    def deposit(amount: Double): Unit = {
      if (amount > 0) {
        balance += amount
        println(s"Deposited $amount to Account $accountId. New balance: $balance")
      } else {
        println("Deposit amount must be greater than zero.")
      }
    }

    def withdraw(amount: Double): Unit = {
      if (amount > 0 && amount <= balance) {
        balance -= amount
        println(s"Withdrew $amount from Account $accountId. New balance: $balance")
      } else {
        println("Invalid withdrawal amount or insufficient balance.")
      }
    }

    def transfer(toAccount: Account, amount: Double): Unit = {
      if (amount > 0 && amount <= balance) {
        balance -= amount
        toAccount.balance += amount
        println(s"Transferred $amount from Account $accountId to Account ${toAccount.accountId}.")
        println(s"New balance in Account $accountId: $balance")
        println(s"New balance in Account ${toAccount.accountId}: ${toAccount.balance}")
      } else {
        println("Invalid transfer amount or insufficient balance.")
      }
    }
  }

  def main(args: Array[String]): Unit = {
    val account1 = new Account(1, 1000.0)
    val account2 = new Account(2, 1500.0)

    println("Initial balances:")
    println(s"Account ${account1.accountId}: ${account1.balance}")
    println(s"Account ${account2.accountId}: ${account2.balance}")

    account1.deposit(500.0)
    account2.withdraw(200.0)
    account1.transfer(account2, 300.0)
  }

}

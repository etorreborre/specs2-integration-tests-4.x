package user.integration.database

case class Database(var isStarted: Boolean = false) {

  def start: Database = {
    println("Start database!")
    this.isStarted = true
    this
  }

  def shutdown: Database = {
    println("Shutdown database!")
    this.isStarted = false
    this
  }
}

object db extends Database

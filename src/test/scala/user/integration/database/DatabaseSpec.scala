package user.integration.database

import org.specs2._

class DatabaseSpec extends Specification { def is = s2"""
  the database is accessible $e1
  the database is still accessible $e2
"""

  def e1 = db.isStarted.pp("use the database in DatabaseSpec")
  def e2 = db.isStarted.pp("use the database in DatabaseSpec")

}

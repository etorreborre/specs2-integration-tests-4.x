package user.integration.remote

import org.specs2._
import user.integration.database._

class RemoteServiceSpec extends Specification { def is = s2"""
  the database is accessible when testing a remote service $e1
  the database is still accessible when testing a remote service $e2
"""

  def e1 = db.isStarted.pp("use the database in RemoteServiceSpec")
  def e2 = db.isStarted.pp("use the database in RemoteServiceSpec")
}

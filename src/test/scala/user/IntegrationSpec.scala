package user

import org.specs2._
import org.specs2.specification.core._
import org.specs2.control._
import org.specs2.io._
import runner._
import user.integration.database._

class IntegrationSpec extends Specification { def is = sequential ^ s2"""
  ${step(db.start)}

  Integration specifications
  $integration

  ${step(db.shutdown)}
"""

  def integration =
    Fragments.foreach(specifications) { specification =>
s2"""
  ${specification.is.header.name} ${specification.is.fragments}
  $p
"""
  }

  val specifications: List[SpecificationStructure] = SpecificationsFinder.findSpecifications(
    // change this pattern if the specifications must be found in specific directories, or with specific names
    glob = "**/*.scala",
    // this pattern detects the name of a specification class inside a scala file
    pattern = "(.*Spec)\\s*extends\\s*.*",
    // this additional filter can be used to filter specifications names
    // in this case we avoid infinite recursive execution
    filter = { (name: String) => !name.endsWith("IntegrationSpec") },
    // this is the base directory where specifications must be searched
    basePath = DirectoryPath.unsafe(new java.io.File("src/test/scala").getAbsolutePath),
    verbose = true).runOption.getOrElse(Nil)

}

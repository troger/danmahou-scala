import sbt._

class DanmahouProject(info: ProjectInfo) extends DefaultProject(info) {
  val slickVersion = "270"
  val phys2dVersion = "060408"
  val specsVersion = "1.6.2"

  val mavenRepository = DefaultMavenRepository
  val slickRepository = "slickRepository" at "http://slick.cokeandcode.com/mavenrepo"
  val bs2Repository = "bs2Repository" at "http://b2s-repo.googlecode.com/svn/trunk/mvn-repo"
  val scalaReleasesRepository = "scalaToolsRepository" at "http://scala-tools.org/repo-releases"
  val scalaSnapshotsRepository = "scalaToolsRepository" at "http://scala-tools.org/repo-snapshots"

  val slick = "slick" % "slick" % slickVersion
  // Problem getting phys2d as transitive dependency
  override def ivyXML =
    <dependencies>
      <dependency org="slick" name="slick" rev={slickVersion}>
          <exclude module="phys2d"/>
      </dependency>
    </dependencies>
  val phys2d = "phys2d" % "phys2d" % phys2dVersion from ("http://b2s-repo.googlecode.com/svn/trunk/mvn-repo/phys2d/phys2d/060408/phys2d-" + phys2dVersion + ".jar")

  val specs = "org.scala-tools.testing" % "specs" % specsVersion

}

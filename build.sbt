name := "scalafxml-demo"

organization := "org.edla"

version := "0.1-SNAPSHOT"

scalaVersion := "2.10.3"

scalacOptions ++= Seq("-unchecked", "-deprecation", "-feature", "-optimize")

scalacOptions in (Compile, doc) ++= Seq("-diagrams","-implicits")

org.scalastyle.sbt.ScalastylePlugin.Settings

libraryDependencies ++= Seq(
  "org.scalafx" % "scalafxml-core_2.10" % "0.1",
  "org.scalafx" %% "scalafx" % "8.0.0-R4",
  "junit" % "junit" % "4.11" % "test",
  "org.specs2" %% "specs2" % "2.3.7" % "test",
  "org.scalatest" % "scalatest_2.10" % "2.0" % "test"
)

addCompilerPlugin("org.scalamacros" % "paradise" % "2.0.0-M1" cross CrossVersion.full)

fork := true

seq(CoverallsPlugin.singleProject: _*)

licenses := Seq("GNU GPL v3" -> url("http://www.gnu.org/licenses/gpl.html"))

homepage := Some(url("http://github.com/newca12/scalafxml-demo"))

pomIncludeRepository := { _ => false }

pomExtra := (
    <scm>
        <url>git@github.com:newca12/scalafxml-demo.git</url>
        <connection>scm:git:git@github.com:newca12/scalafxml-demo.git</connection>
    </scm>
    <developers>
        <developer>
            <id>newca12</id>
            <name>Olivier ROLAND</name>
            <url>http://www.edla.org</url>
        </developer>
    </developers>
    <contributors> </contributors>
    <properties>
        <encoding>UTF-8</encoding>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    </properties>
	<build>
		<sourceDirectory>src/main/scala</sourceDirectory>
		<testSourceDirectory>src/test/scala</testSourceDirectory>
		<plugins>
			<plugin>
				<groupId>org.apache.maven.plugins</groupId>
				<artifactId>maven-compiler-plugin</artifactId>
				<version>3.1</version>
				<configuration>
					<source>1.8</source>
					<target>1.8</target>
				</configuration>
			</plugin>
			<plugin>
				<groupId>net.alchim31.maven</groupId>
				<artifactId>scala-maven-plugin</artifactId>
				<version>3.1.6</version>
				<executions>
					<execution>
						<id>compile</id>
						<goals>
							<goal>compile</goal>
							<goal>testCompile</goal>
						</goals>
					</execution>
				</executions>
			</plugin>
			<plugin>
				<groupId>org.apache.maven.plugins</groupId>
				<artifactId>maven-surefire-plugin</artifactId>
				<version>2.16</version>
				<configuration>
					<includes>
						<include>**/*Suite.class</include>
						<include>**/*Test.class</include>
						<include>**/*Tests.class</include>
						<include>**/*Spec.class</include>
						<include>**/*Specs.class</include>
					</includes>
				</configuration>
			</plugin>
		</plugins>
	</build>
	<reporting>
		<plugins>
			<plugin>
				<groupId>net.alchim31.maven</groupId>
				<artifactId>scala-maven-plugin</artifactId>
				<version>3.1.6</version>
			</plugin>
		</plugins>
	</reporting>
)
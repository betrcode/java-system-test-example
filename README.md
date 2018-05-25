System tests example using Java and RestAssured
===============================================

This is some example code of how you can create system tests to test a REST service.

The purpose of these system tests are to test a deployed system, or a dockerized system.
This can be needed to check that you have configured and wired things correctly.

We drive the system tests with good old _JUnit_. There is not always need for a more abstract BDD framework.

We use the _RestAssured_ framework which I like to use to test HTTP REST services.

To load configuration from a Yaml files, we use _SnakeYaml_ which requires very little code to get a structured
yml file into a Java object.

## Deployed system vs Dockerized system
A "deployed system" is a system which is deployed to real machines, virtual or directly on metal, preferrably using the same provisioning as you do on your production environment.

A "dockerized system" is a system where all of the services in the system are started as Docker containers, usually using Docker Compose and often in the same machine.

## How to run tests

When you are coding, you want to run the tests from IntelliJ. 
To make it work, you need to specify which config file the tests should use.
Edit the run configuration of the `ExampleTest` and add `-DconfigFile=./config/example-config.yml` to _VM Options_.

You can also run the tests using Gradle command line: 
`./gradlew clean build -DconfigFile=config/example-config.yml`

When you run the tests in a Continuous Delivery pipeline, you probably want to
run them from a published artifact (a jar in this case). Here's an example of how to do that:
`java -DconfigFile="config/example-config.yml" -cp system-tests.jar org.junit.runner.JUnitCore se.bettercode.systemtest.suite.FirstTestSuite`

## How to build jar
`./gradlew clean jar`

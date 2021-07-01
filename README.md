#How to run tests: 

`mvn test`

Will run all the tests under /reqresTests
##REST API tests

###cucumberTest
Package /cucumberTest contains:
-features
-runners
-steps

Inside runner we can specify the tag which we want to run, there is "@regression" tag set up by default and that 
tag is inside feature files.
###reqresTest
There are two different test classes:
-GetUsersTest
-PostRegistrationTest

####Plugins

#####Cucumber
I have used Cucumber to provide BDD tests. I am using Scenario Outline for parameterized Scenario
#####Lombok
I have used Lombok plugin to reduce boilerplate code for data objects. Using Lombok annotations I can generate getters, setters, data model etc. Some features can be found here: https://projectlombok.org/features/all
#####Owner
That plugin helps in working with properties. I used it in backend module Here is more information: http://owner.aeonbits.org/docs/usage/


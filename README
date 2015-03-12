
## Introduction

This is a command line client application that talks to a backend REST service (cloud server) which performs CRUD operations around the server inventory.


## System requirements

You just need maven 3.2 and java 7 or above. As any other standard maven project you generate the artifact by running _mvn clean install_

## Running the application

The artifact produced by maven is an executable jar, so you can run the application using _java -jar_.

*hector@Iscariot ~/IdeaProjects/dd-client $java -jar ./target/dd-client-1.0.jar*

Will print the list of available commands

##### Load servers
This command will create the servers contained in the xml file passed as a parameter. The format of the xml has been slightly changed
so I can specify more than one server,  so the servers xml element has been introduced.
Here you can find a sample file https://github.com/hmoneoju/dd-client/tree/master/src/test/resources/servers.xml

*hector@Iscariot ~/IdeaProjects/dd-client/target $ java -jar dd-client-1.0.jar load --file /home/hector/IdeaProjects/dd-client/src/test/resources/servers.xml*
##### Count servers
*hector@Iscariot ~/IdeaProjects/dd-client/target $ java -jar dd-client-1.0.jar count*
##### List servers
*hector@Iscariot ~/IdeaProjects/dd-client/target $ java -jar dd-client-1.0.jar list*
##### Update server
*hector@Iscariot ~/IdeaProjects/dd-client/target $ java -jar dd-client-1.0.jar update --id 1 --name "Name changed"*
##### Delete server
*hector@Iscariot ~/IdeaProjects/dd-client/target $ java -jar dd-client-1.0.jar delete --id 1*

## Technical design

The client is a Spring Boot application which relies on Spring 4. I have chosen SpringBoot because its ease of use when creating
projects from scratch and Spring because of all of the functionality you get for free.

I have followed the command pattern design. For the command definition/parsing I use the jCommander library which in an elegant way
(through annotations) you can define the format of your commands by using annotations you can define the command.
The list of available commands are registered as a Sprig bean the CommandLineController consumes. The controller is a command coordinator.

Communication with the backend is encapsulated through the CloudServerClient facade that the commands talk tp.
CloudServerRestClient implements this interface and talks to the backend through Rest/Json calls. By introducing a facade we could
easily change the communication protocol between client and server by just adding a new class implementation and autowiring this new
class to the commands, guaranteeing the Open-Close principle. The Rest implementation uses Spring Rest Template for performing
the HTTP actions and Jackson as the Json parser.

From the testing perspective, I have added jUnit test to verify each command is calling the proper backend action. Mockito has been used
to mock the backend communication.


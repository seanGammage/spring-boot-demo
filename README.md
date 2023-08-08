# spring-boot-demo
Small SpringBoot Task Management API

## Initializing SpringBoot Project
Spring Initializer [Spring Initializer](https://start.spring.io/)
- Language should be `Java`
- Project should be `Maven`
- Project metadata; you can leave as is or change to however you want
- Packaging: `War`, but won't matter for this
- Java: `17`
- If you want, you can click the `Add Dependecies` button to add dependencies we will use such as `Lombok`. But, I reccommend just copy and pasting from the `pom.xml` file within this project as it has the propper version numbers
- Then just click `Generate` and your SpringBoot project will be downloaded, and you can save it to wherever youd like

## Application.yml or properties
- Under the resources folder lies the `application.yml` or `application.properties` file. Either can be used. They serve the same purpose, but have different syntax. Today, yml files are more often used so we will stick with that for this class. The reason being is that it is easier to read for us
- `YML` which can also be `YAML` is used to setup some of the projects like the database connection, and more
- In my example here, I set `server.port=8082`. This is not necessary. Automatically, Spring will try and run your app on port 8080. I had something else running on port 8080 at the time, so had to specify a different port to use. You can change the port to anything youd like (up to 9999)
- Don't worry too much now about the `spring.application / datasource / jpa`. Just know its creating a database connection

## Running the application (VS Code)
- You can go to `Application.java` and click the `run` button above your main method
- You can go to the top of your VSCODE and click `Run -> Run Without Debugging`
- You can click the little `Play` button you may see in the top right of your VSCODE
- Go to your browser, type `http://localhost:8080/api/tasks` to preform an HTTP `GET` Request. If everything works you should see an empty array returned `[]`
- From the browser, you will only be allowed to perform `GET` requests. If you want to use `POSTS` and `PUTS` you will need to setup Postman. You can google around to find documentation for setting up Postman, but we will cover it in class as well.

## Issues you may run into
- If you stop the application (there will be a stop button in the top right corner), your database will be blown out
- Sometimes you may run into an issue where it appears your changes are not taking into effect. You may need to do the following
  - MAC: Hold `command + shift + P`, Windows: Hold `ctrl + shift + P`. Type `Java Clean Java Language WorkSpace` then `Reload and delete`
 
## Resources
- [Spring Initializer](https://start.spring.io/)
- [Baeldung - Learn SpringBoot](https://www.baeldung.com/spring-boot)
- [Baeldung - Spring Beans](https://www.baeldung.com/spring-bean)
- [Baeldung - Dependendy Injection](https://www.baeldung.com/spring-dependency-injection#:~:text=Dependency%20Injection%20is%20a%20fundamental,managing%20components%20onto%20the%20container)
- [JPA Java Persistance API](https://www.tutorialspoint.com/jpa/jpa_introduction.htm)
  

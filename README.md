# T-NUTs

![Technical-Nuts](http://blog.balajeetm.com/assets/2017-02-21/t-nuts.png)
Hi Unjars (short for unjargoners),<br>
Welcome aboard!<br>
Hope you are coming over from one of my [technical-nuts](http://blog.balajeetm.com/blog/2017/02/21/technical-nuts/) in my [blog](http://blog.balajeetm.com/).

For people who are what a technical nut is..<br>
Well, a t-nut is a short hand for a technical-nut. Any exiciting problem which requires a logical approach.<br>
For the details jump over to [t-nut](http://blog.balajeetm.com/blog/2017/02/21/technical-nuts/) and [cracking a t-nut](http://blog.balajeetm.com/blog/2017/03/08/cracking-a-tnut/)

## What's this repo?

This repo hosts the solutions for few programming t-nuts we encounter and address in my [blog](http://blog.balajeetm.com/)<br>
The solutions hosted in the repo are shown below. Please hop on to the below links for details on their usage
* [Singly Linked List Reversal in Pockets](/src/main/java/com/balajeetm/tnut/controller)

## How to use this repo

This repo contains a [maven](http://blog.balajeetm.com/blog/2017/02/14/why-maven/) based [spring boot](https://projects.spring.io/spring-boot/) and [json-mystique](http://github.balajeetm.com/json-mystique) oriented web application with embedded servlet container.<br>

All you need to do is pull the project into to your IDE (Eclipse, [STS](https://spring.io/tools/sts), IntelliJ) and you are good to go.<br>
I'll explain how to get rolling if you use [STS](https://spring.io/tools/sts) as your IDE

## Steps to get rolling

* **Import the Project**<br>

Once you open STS, and choose a workspace, you should see package explorer as your left pane as shown below.<br>
If you do not see package explorer, just choose "Window" on the STS menu and say "Show View" and choose Package Explorer.
![Package Explorer](/assets/packageexplorer.png)

On the package explorer, right click and say "Import"<br>
![Import Project](/assets/import.png)

Alternatively, you can say "File"->"Import" directly in your STS menu options.

Remember to import the project as a maven project<br>
![Import Maven Project](/assets/mavenproject.png)

* **Run the application using Spring Boot DashBoard**<br>
Once the project the imported, choose the spring boot dashboard as shown below and click on run as shown below.
The [T-Nut](http://blog.balajeetm.com/blog/2017/02/21/technical-nuts/) webapplication will run by default on port 7189.
If that doesn't work for you, configure it to an appropriate port by updating the [application.yml's](https://github.com/balajeetm/t-nut/blob/master/src/main/resources/application.yml) server.port property

![Run Application](/assets/startapp.png)

> Alternatively, you can build the jar using "mvn clean package" and run the built jar, using "java -jar target/tnut.jar" on the terminal

* **Launch Swagger UI**<br>
The [T-Nut](http://blog.balajeetm.com/blog/2017/02/21/technical-nuts/) web application comes with [swagger](http://swagger.io/) support.<br>
[Swagger](http://swagger.io/) is the most popular API framework for documenting ReST Apis.<br>
The project uses [spring-fox](https://github.com/springfox/springfox), to generate runtime documentation of its ReST APIs and also help you to execute the apis on the fly.<br>

The application's swagger apis are available by default in the below location
http://localhost:7189/swagger-ui.html

Once you go to the link, [T-Nut](http://blog.balajeetm.com/blog/2017/02/21/technical-nuts/) application's swagger page will look like the below:
![T-Nut Swagger](/assets/swagger.png)

* **Execute the APIs and test the flows**
Once the swagger is launched, each [T-Nut](http://blog.balajeetm.com/blog/2017/02/21/technical-nuts/) is separated as different items in the accordion with different apis representing different solutions for the same T-Nut.

Execute the APIs and have fun [unjorgoning](http://blog.balajeetm.com/blog/2017/02/13/welcome-aboard/)

Cheers

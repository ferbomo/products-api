# Products service
We want you to implement a REST API endpoint that given a list of products,
 applies some discounts to them and can be filtered.
 
## What we expect
Code structure/architecture must fit this use case, as simple or as complex needed to complete what is asked for.

Code must be testable without requiring networking or the filesystem. Tests should be runnable with 1 command.

The project must be runnable with 1 simple command from any machine.

Explanations on decisions taken

## Strategy
I've created a Maven project, so it's needed maven 3.6.3 and Java 8 to run the app.

I implemented the api using hexagonal architecture, or ports and adapters architectural pattern.
As far as I understand it, the domain it's my app and is only accessible using interfaces, that are implemented
by the adapters. The app interface are the primary ports and adapters and when the app needs some resource uses the secondary ones.
The app has only one use case that is retrieve all products filtering with optional parameters.
So, in the use case, we get the products from a json, then filter them, apply discounts using discount service, 
and finally return them converted to a valid response.
Every important class is unit tested, and there is a small controller test.

## Execution
In the main folder, run: mvn clean install to create the executable and run the tests.

Go to the target folder and type: java -jar products-api-0.1.0-SNAPSHOT.jar

In the browser, go to http://localhost:8080/swagger-ui.html, and you will find the swagger page to test
easily the endpoint.
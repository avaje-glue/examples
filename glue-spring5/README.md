# Base Glue Example

Glues together Jetty + Jersey + Jackson + Spring5

## Application

See src/main/java/org.example.Application

This class
- Has our main() method
- Annotated with the @Glue annotation

The @Glue annotation references the Spring `@Configuration` bean
that controls the wiring of Spring.

Note that we are using Spring for Dependency Injection only - there
is no dependency on `spring-web`.


## AppConfig - Spring `@Configuration`

This is a Spring `@Configuration` bean that controls the wiring.
We are using `@Import` and trying to not have any (or minimise) classpath scanning
such that we have nice startup behavior for both scaling and deployments.


## `@Path`

Currently Spring beans with `@Path` are registered with Jersey as JAX-RS Resource beans.
We need to add more flexibility here (support cases where the `@Path` annotation is on interfaces).


## application.yml and application-test.yml

These are loaded via `glue-properties` with a view of supporting other DI options (Guice & Dagger)
and to support configuration of various startup and shutdown options.

External properties can be defined using arguments starting with `-P` (like Spring).


## static resources

By default we use Jersey via a Servlet Filter that has a regex to specify urls that pass through
to the default servlet (for static resources) or other servlets or Web Sockets.

The default regex is: `(/favicon.ico|/(assets|images|fonts|css|js)/.*)`

So the url `http://localhost:8090/assets/foo` will return a static resource from 
`src/main/resources/web/assets/foo` 

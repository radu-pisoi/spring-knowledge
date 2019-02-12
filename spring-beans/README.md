# Introduction to the Spring IoC Container and Beans

## What is Inversion of Control?
Def: Inversion of Control is a principle in software engineering by which the control of objects or portions of a program is transferred to a container or framework.

Def: IoC is a design pattern that describes inverting the flow of control in a system, so execution flow is not controlled by a central piece of code. This means that components should only depend on abstractions of other components and are not be responsible for handling the creation of dependent objects. Instead, object instances are supplied at runtime by an IoC container through Dependency Injection (DI).

In the Spring framework, the IoC container is represented by the interface ApplicationContext. The Spring container is responsible for instantiating, configuring and assembling objects known as beans, as well as managing their lifecycle.

## What is Dependency Injection?
Dependency injection is a pattern through which to implement IoC, where the control being inverted is the setting of object’s dependencies.

Dependency Injection in Spring can be done through constructors, setters or fields.
### Setter-Based Dependency Injection
The container will call setter methods of our class, 
after invoking a no-argument constructor or no-argument static factory method to instantiate the bean.

### Field-Based Dependency Injection
In case of Field-Based DI, we can inject the dependencies by marking them with an @Autowired annotation:

## Spring Bean Lifecycle. Custom Action attached with bean creation and destruction
To run a custom code after bean initialization you can use @PostConstruct annotation or InitializingBean interface.

A method annotated with @PreDestroy runs only once, just before Spring removes our bean from the application context.

The @Bean initMethod attribute
Then, we can define the bean using the @Bean annotation:


The JSR-250 @PostConstruct and @PreDestroy annotations are generally
considered best practice for receiving lifecycle callbacks in a modern Spring application. 
Using these annotations means that your beans are not coupled to Spring-specific interfaces.

## Lazy Initialization
The @Lazy annotation has been present since Spring version 3.0. There’re several ways to tell the IoC container to initialize a bean lazily.
https://www.baeldung.com/spring-lazy-annotation

## @Qualifier to resolve ambiguous situations
We use @Qualifier along with @Autowired to provide the bean id or bean name we want to inject in ambiguous situations.
See sample from com.oxygenxml.knowledge.spring.bean.qualifier

## Spring Bean Scopes

The latest version of Spring framework defines 6 types of scopes:
* singleton
* prototype
* request
* session
* application
* websocket

The last four scopes mentioned request, session, application and websocket are only available in a web-aware application.


https://www.baeldung.com/spring-bean-scopes

References:
https://www.baeldung.com/inversion-control-and-dependency-injection-in-spring
https://docs.spring.io/spring-framework/docs/current/spring-framework-reference/core.html#beans

# Introduction to the Spring IoC Container and Beans

## What is Inversion of Control?
Def: Inversion of Control is a principle in software engineering by which the control of objects or portions of a program is transferred to a container or framework.

Def: IoC is a design pattern that describes inverting the flow of control in a system, so execution flow is not controlled by a central piece of code. This means that components should only depend on abstractions of other components and are not be responsible for handling the creation of dependent objects. Instead, object instances are supplied at runtime by an IoC container through Dependency Injection (DI).

## What is Dependency Injection?
Dependency injection is a pattern through which to implement IoC, where the control being inverted is the setting of object’s dependencies.

## The Spring IoC Container
In the Spring framework, the IoC container is represented by the interface ApplicationContext. The Spring container is responsible for instantiating, configuring and assembling objects known as beans, as well as managing their lifecycle.

References:
https://www.baeldung.com/inversion-control-and-dependency-injection-in-spring
https://docs.spring.io/spring-framework/docs/current/spring-framework-reference/core.html#beans

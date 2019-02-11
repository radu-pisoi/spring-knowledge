We use @Qualifier along with @Autowired to provide the bean id or bean name we want to use in ambiguous situations.

@Primary
Sometimes we need to define multiple beans of the same type. In these cases, the injection will be unsuccessful because Spring has no clue which bean we need.

https://www.baeldung.com/spring-core-annotations
https://www.baeldung.com/spring-primary
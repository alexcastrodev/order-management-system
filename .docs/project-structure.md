# Summary

At the moment, some decision will 

## Web pattern

I am currently using Spring MVC. Over the years, I've gained experience with the MVC 
pattern through various projects using PHP, Ruby, and Node.js.

## Data persistence

While the repository pattern might be too complex for a starter project, 
it aligns with JPA standards, so I plan to implement it according to the official documentation. 

Keeping it simple is the goal.

----

The basic repository extends Repository. Spring Boot team suggest to consider how much API surface you want to expose towards your application. 

More complex repository interfaces are ListCrudRepository or JpaRepository.

Ref: https://docs.spring.io/spring-data/jpa/reference/jpa/getting-started.html

---

## Creation and Update timestamps

by project standard, we will use:

```java
@CreationTimestamp
private LocalDateTime createdAt;

@UpdateTimestamp
private LocalDateTime updatedAt;
```

Ref: https://docs.jboss.org/hibernate/orm/5.4/userguide/html_single/Hibernate_User_Guide.html#mapping-generated-UpdateTimestamp

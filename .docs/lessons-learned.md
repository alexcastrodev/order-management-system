# Summary

lessons learned creating this project:

JPA implementation uses Reflection to create instances of entity classes, that's why I have compiler error 
on creating a constructor of class.

Ref: https://www.baeldung.com/jpa-no-argument-constructor-entity-class#reasons-for-no-arg-constructor
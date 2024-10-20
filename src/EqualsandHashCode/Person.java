package EqualsandHashCode;

import java.util.Objects;

public class Person {
    private int age;
    private String name;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    @Override
    public boolean equals(Object obj) {

        // Java's Object class defines equals(Object obj) as public boolean equals(Object obj).
        // Since the method signatures don’t match, you are not overriding equals(),
        // but creating a new method with the same name (method overloading).


        // The parameter type in the correct equals() method should be Object, not Person.
        // This is because the equals() method is used to compare any two objects,
        // and the first step is to check if the passed object is indeed a Person instance.


        // It's important to first check if the passed object is null and if it is of the same class
        // before performing any field comparisons.
        // This avoids potential NullPointerExceptions and
        // ensures that you are comparing objects of the same type.
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        // In the overridden equals() method, after ensuring that the object is of the Person class,
        // you cast it to Person to compare the fields.
        Person person = (Person) obj;
        return age == person.age && name.equals(person.name);
    }


    // The hashCode() method should also be overridden whenever you override equals(),
    // as both methods are used together in hash-based collections (e.g., HashSet, HashMap).
    // This ensures consistency between equals() and hashCode().
    @Override
    public int hashCode() {
        return Objects.hash(age, name);
    }

}// Person class

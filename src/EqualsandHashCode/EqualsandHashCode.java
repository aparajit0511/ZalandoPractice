package EqualsandHashCode;

public class EqualsandHashCode {
    public static void main(String[] args) {

        Person person1 = new Person("John",19);
        Person person2 = new Person("John",19);

        boolean result = person1.equals(person2);
        System.out.println("Print Boolean Result "+ result);

        int hash_1 = person1.hashCode();
        int hash_2 = person2.hashCode();
        // same hash
        System.out.println(hash_1);
        System.out.println(hash_2);
    }
}



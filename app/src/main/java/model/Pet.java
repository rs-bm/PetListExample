package model;

public class Pet {
    String name;
    String breed;
    int age;

    public Pet(String name, String breed, int age) {
        this.name = name;
        this.breed = breed;
        this.age = age;
    }
    public String toString() {
        return (name + " (" + breed + "): " + age);
    }

}

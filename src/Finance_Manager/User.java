/*
File: User.java
Name: Riya Rami
Email: riyar1@umbc.edu
*/

package Finance_Manager;

/* This class the user information including name, age, and income. */
public class User {
    private final String name;
    private final int age;
    private final double income;

    public User(String name, int age, double income) {
        this.name = name;
        this.age = age;
        this.income = income;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getIncome() {
        return income;
    }
}

package Finance_Manager;

class User {
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

    public double getIncome() {
        return income;
    }
}
package Finance_Manager;

abstract class PersonalFinanceManager {
    protected static int userCount;
    protected int userId;

    public PersonalFinanceManager() {
        this.userId = ++userCount;
    }

    public static void staticMethod() {
        System.out.println("Your finance report is completed. Thank you.");
    }

    public abstract void printUserInfo();

    public void displayUserId() {
        System.out.println("User ID: " + this.userId);
    }
}

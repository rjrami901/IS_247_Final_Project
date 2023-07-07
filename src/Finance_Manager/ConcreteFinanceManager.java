package Finance_Manager;

class ConcreteFinanceManager extends PersonalFinanceManager {
    @Override
    public void printUserInfo() {
        System.out.println("User: " + this.userId);
        System.out.println("User count: " + PersonalFinanceManager.userCount);
    }
}

/*
File: ConcreteFinanceManager.java
Name: Riya Rami
Date: 07/07/2023
Instructor: Prof. Shiva Sharma
Email: riyar1@umbc.edu
*/

package Finance_Manager;

class ConcreteFinanceManager extends PersonalFinanceManager {
    @Override
    public void printUserInfo() {
        System.out.println("User: " + this.userId);
        System.out.println("User count: " + PersonalFinanceManager.userCount);
    }
}

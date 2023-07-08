/*
File: InsufficientFundsException.java
Name: Riya Rami
Date: 07/07/2023
Instructor: Prof. Shiva Sharma
Email: riyar1@umbc.edu
*/

package Finance_Manager;

// Exception class for handling insufficient funds
class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}

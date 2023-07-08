/*
File: InsufficientFundsException.java
Name: Riya Rami
Email: riyar1@umbc.edu
*/

package Finance_Manager;

/* Exception class for handling insufficient funds */
public class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}

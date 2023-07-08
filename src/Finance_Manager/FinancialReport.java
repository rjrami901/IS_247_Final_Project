/*
File: FinancialReport.java
Name: Riya Rami
Date: 07/07/2023
Instructor: Prof. Shiva Sharma
Email: riyar1@umbc.edu
*/

package Finance_Manager;

import java.util.List;
import java.util.Map;

// Interface for generating financial reports
public interface FinancialReport {
    void generateReport(List<Account> accounts, User user, Map<String, Double> expenses);
}

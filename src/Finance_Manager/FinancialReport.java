package Finance_Manager;

import java.util.List;
import java.util.Map;

// Interface for generating financial reports
interface FinancialReport {
    void generateReport(List<Account> accounts, User user, Map<String, Double> expenses);
}

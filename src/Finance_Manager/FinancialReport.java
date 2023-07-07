package Finance_Manager;

import java.util.List;

// Interface for generating financial reports
interface FinancialReport<T> {
    void generateReport(List<T> items);
}

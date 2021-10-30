package price.test;

import price.test.service.AnalyzeNumberServiceTest;
import price.test.service.CalculateServiceTest;
import price.test.service.GeneralServiceTest;

public class TestMain {
    public static void main(String[] args) {
        AnalyzeNumberServiceTest analyzeNumberServiceTest = new AnalyzeNumberServiceTest();
        analyzeNumberServiceTest.runAllTests();
        CalculateServiceTest calculateServiceTest = new CalculateServiceTest();
        calculateServiceTest.runAllTests();
        GeneralServiceTest generalServiceTest = new GeneralServiceTest();
        generalServiceTest.testForMaxAllowableNumber();
    }
}

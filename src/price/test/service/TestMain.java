package price.test.service;

public class TestMain {
    public static void main(String[] args) {
        AnalyzeNumberServiceTest analyzeNumberServiceTest = new AnalyzeNumberServiceTest();
        analyzeNumberServiceTest.testWordForThousand();
        analyzeNumberServiceTest.testWordForCurrency();
        analyzeNumberServiceTest.testWordForMillion();
        analyzeNumberServiceTest.testWordForBillion();
    }
}

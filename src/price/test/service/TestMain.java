package price.test.service;

public class TestMain {
    public static void main(String[] args) {
        AnalyzeNumberServiceTest analyzeNumberServiceTest = new AnalyzeNumberServiceTest();
        analyzeNumberServiceTest.getHundredWordTest();
        analyzeNumberServiceTest.getDecimalWordByNumber();
        analyzeNumberServiceTest.getUnitWord();
        analyzeNumberServiceTest.getDecimalWordByUnit();
        analyzeNumberServiceTest.getUnitWordForZero();
    }
}

package price.test.service;

import price.main.service.GeneralService;

public class GeneralServiceTest {
    private final GeneralService generalService;

    public GeneralServiceTest() {
        this.generalService = new GeneralService();
    }

    public void testForMaxAllowableNumber() {
        System.out.println("Testing get word for max allowable number");
        String result = generalService.getResultWord(999999999999L);
        System.out.println(result);
        if (result.equals("Девятьсот девяносто девять миллиардов девятьсот девяносто девять миллионов девятьсот девяносто девять тысяч девятьсот девяносто девять рублей")) {
            System.out.println("Test passed");
        } else {
            System.err.println("Test failed");
        }
    }
}

package price.main;

import price.main.service.GeneralService;
import price.main.service.InputDataService;

public class Main {
    public static void main(String[] args) {
        InputDataService inputDataService = new InputDataService();
        long originValue = inputDataService.getInputNumber();
        System.out.println("originNumber: " + originValue);
        GeneralService numberService = new GeneralService();
        String result = numberService.getResultWord(originValue);
        System.out.println(result);
    }
}

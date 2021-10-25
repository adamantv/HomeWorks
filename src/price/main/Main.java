package price.main;

import price.main.service.GeneralService;

public class Main {
    public static void main(String[] args) {
        GeneralService numberService = new GeneralService();
        String result = numberService.enterDataAndGetResult();
        System.out.println(result);
    }
}

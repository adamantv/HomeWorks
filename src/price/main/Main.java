package price.main;

import price.main.service.NumberService;

public class Main {
    public static void main(String[] args) {
        NumberService numberService = new NumberService();
        String result = numberService.enterDataAndGetResult();
        System.out.println(result);
    }
}

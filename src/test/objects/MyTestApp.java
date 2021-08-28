package test.objects;

import test.objects.service.TestService;

public class MyTestApp {
    public static void main(String[] args) {
        TestService testService = new TestService();
        testService.test();
    }
}

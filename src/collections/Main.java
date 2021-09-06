package collections;

import collections.entity.Account;
import collections.entity.Client;
import collections.entity.Exchange;
import collections.service.AccountService;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        AccountService accountService = new AccountService();
        Exchange exchange = accountService.initializeExchange();
        System.out.println(exchange);

        List<Account> result1 = accountService.getAccountsByClientIdAndAccounts(5, exchange.getAccounts());
        System.out.println(result1);

        List<Account> result2 = accountService.getAccountsByClientIdAndClients(5, exchange.getClients());
        System.out.println(result2);

        Client resultClient1 = accountService.findClientByAccountIdAndAccounts(5, exchange.getAccounts());
        System.out.println(resultClient1);

        Client resultClient2 = accountService.findClientByAccountIdAndClients(5, exchange.getClients());
        System.out.println(resultClient2);
    }
}

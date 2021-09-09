package collections;

import collections.entity.Account;
import collections.entity.Client;
import collections.entity.Storage;
import collections.service.AccountService;
import collections.service.StorageFactory;

import java.time.Instant;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        AccountService accountService = new AccountService();
        StorageFactory storageFactory = new StorageFactory();

        Storage storage = storageFactory.initializeStorage();
        System.out.println("Created storage: " + storage);

        Client client = new Client();
        client.setId(3);
        client.setBornDate(Instant.parse("1992-04-20T00:00:00.000Z"));
        client.setName("name3");
        List<Account> resultAccountList = accountService.getAccountsByClient(client, storage);
        System.out.println("Result account list: " + resultAccountList);

        Account account = new Account();
        account.setId(7);
        account.setCount(2000);
        Client resultClient = accountService.getClientByAccount(account, storage);
        System.out.println("Found client: " + resultClient);
    }
}

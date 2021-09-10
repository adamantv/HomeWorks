package collections;

import collections.entity.Account;
import collections.entity.Client;
import collections.entity.Storage;
import collections.service.AccountService;
import collections.service.StorageFactory;

import java.time.Instant;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        AccountService accountService = new AccountService();
        StorageFactory storageFactory = new StorageFactory();

        Storage storage = storageFactory.initializeStorage();
        System.out.println("Created storage: " + storage);

        Client client = new Client();
        client.setId(UUID.fromString("4a95024a-f046-4d2f-8eda-0dbebaf588ba"));
        client.setName("name");
        client.setBornDate(LocalDate.parse("1992-05-20"));
        List<Account> resultAccountList = accountService.getAccountsByClient(client, storage);
        System.out.println("Result account list: " + resultAccountList);

        Account account = new Account();
        account.setId(UUID.fromString("54f86137-8f6d-41a5-a55c-5da5f2f37668"));
        account.setCount(5000);
        Client resultClient = accountService.getClientByAccount(account, storage);
        System.out.println("Found client: " + resultClient);
    }
}

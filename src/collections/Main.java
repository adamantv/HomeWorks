package collections;

import collections.entity.Account;
import collections.entity.Client;
import collections.entity.Storage;
import collections.service.AccountService;
import collections.factory.StorageFactory;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        StorageFactory storageFactory = new StorageFactory();
        AccountService accountService = new AccountService();
        Storage storage = storageFactory.initializeStorageWithList();
        System.out.println("Created objects: " + storage);

        Client client = new Client();
        client.setId(UUID.fromString("4a95024a-f046-4d2f-8eda-0dbebaf588ba"));
        client.setName("name");
        client.setBornDate(LocalDate.parse("1992-05-20"));

        Account account = new Account();
        account.setId(UUID.fromString("54f86137-8f6d-41a5-a55c-5da5f2f37668"));
        account.setCount(5000);

        Map<Client, List<Account>> mapWithKeyClient = storageFactory.initializeMapWithKeyClient(storage);
        List<Account> resultAccountList = accountService.getAccountsByClient(client, mapWithKeyClient);
        System.out.println("Result accounts from Map: " + resultAccountList);

        Map<Account, Client> mapWithKeyAccount = storageFactory.initializeMapWithKeyAccount(storage);
        Client resultClient = accountService.getClientByAccount(account, mapWithKeyAccount);
        System.out.println("Result client from Map: " + resultClient);
    }
}

package collections.factory;

import collections.entity.Account;
import collections.entity.Client;
import collections.entity.Storage;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class StorageFactory {
    /**
     * Storage imitates database. It contains clients, accounts and their relationships
     * For example, each client has 2 accounts. This number is optional
     * Rules for setting parameters are for example only, it can be improved
     * @return collections.entity.Storage
     */
    private Storage initializeStorageWithList() {
        Account account1 = new Account();
        account1.setId(UUID.fromString("c111f1e6-df3b-45ae-badd-5f073f0c97c6"));
        account1.setCount(5000);

        Account account2 = new Account();
        account2.setId(UUID.fromString("19e099d8-3e96-424e-983e-78c13eebd284"));
        account2.setCount(2000);

        Account account3 = new Account();
        account3.setId(UUID.fromString("2b790702-614b-4c8c-802b-aca95afd7246"));
        account3.setCount(5000);

        Account account4 = new Account();
        account4.setId(UUID.fromString("30e90c31-0a8a-4f10-9269-f56c397e0b9f"));
        account4.setCount(2000);

        Account account5 = new Account();
        account5.setId(UUID.fromString("54f86137-8f6d-41a5-a55c-5da5f2f37668"));
        account5.setCount(5000);

        Account account6 = new Account();
        account6.setId(UUID.fromString("6fe0fd8b-7a61-43a8-b0fa-0be8917be354"));
        account6.setCount(2000);

        Client client1 = new Client();
        client1.setId(UUID.fromString("23156a28-1e05-4d14-8347-3196c3a59039"));
        client1.setName("name");
        client1.setBornDate(LocalDate.parse("1992-04-20"));
        client1.setAccounts(Arrays.asList(account1, account2));
        account1.setClient(client1);
        account2.setClient(client1);

        Client client2 = new Client();
        client2.setId(UUID.fromString("4a95024a-f046-4d2f-8eda-0dbebaf588ba"));
        client2.setName("name");
        client2.setBornDate(LocalDate.parse("1992-05-20"));
        client2.setAccounts(Arrays.asList(account3, account4));
        account3.setClient(client2);
        account4.setClient(client2);

        Client client3 = new Client();
        client3.setId(UUID.fromString("70497171-fa1f-4ec9-96d2-bdeac6d49255"));
        client3.setName("name");
        client3.setBornDate(LocalDate.parse("1992-06-20"));
        client3.setAccounts(Arrays.asList(account5, account6));
        account5.setClient(client3);
        account6.setClient(client3);

        List<Client> clients = Arrays.asList(client1, client2, client3);
        List<Account> accounts = Arrays.asList(account1, account2, account3, account4, account5, account6);
        return new Storage(accounts, clients);
    }

    public HashMap<Client, List<Account>> initializeMapWithKeyClient() {
        HashMap<Client, List<Account>> map = new HashMap<>();
        Storage storage = initializeStorageWithList();
        for (Client client : storage.getClients()) {
            map.put(client, client.getAccounts());
        }
        return map;
    }

    public HashMap<Account, Client> initializeMapWithKeyAccount() {
        HashMap<Account, Client> map = new HashMap<>();
        Storage storage = initializeStorageWithList();
        for (Account account : storage.getAccounts()) {
            map.put(account, account.getClient());
        }
        return map;
    }
}

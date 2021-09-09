package collections.service;

import collections.entity.Account;
import collections.entity.Client;
import collections.entity.Storage;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StorageFactory {
    /**
     * Storage imitates database. It contains clients, accounts and their relationships
     * For example, each client has 2 accounts. This number is optional
     * Rules for setting parameters are for example only, it can be improved
     * @return collections.entity.Storage
     */
    public Storage initializeStorage() {
        List<Client> clients = new ArrayList<>();
        List<Account> accounts = new ArrayList<>();
        int clientCount = 5;

        for (int i = 0; i < clientCount; i++) {
            Account account1 = new Account();
            account1.setId(i + 1);
            account1.setCount(5000);

            Account account2 = new Account();
            account2.setId(i + clientCount + 1);
            account2.setCount(2000);

            Client client1 = new Client();
            client1.setId(i + 1);
            client1.setName("name" + (i + 1));
            String bornDate = "1992-04-20T00:00:00.000Z";
            client1.setBornDate(Instant.parse(bornDate));
            client1.setAccounts(Arrays.asList(account1, account2));

            account1.setClient(client1);
            account2.setClient(client1);

            clients.add(client1);
            accounts.add(account1);
            accounts.add(account2);
        }
        return new Storage(accounts, clients);
    }
}

package collections.service;

import collections.entity.Account;
import collections.entity.Client;
import collections.entity.Exchange;

import java.time.Instant;
import java.util.*;

public class AccountService {
    public Exchange initializeExchange() {
        List<Client> clients = new ArrayList<>();
        List<Account> accounts = new ArrayList<>();
        int clientCount = 100;

        for (int i = 0; i < clientCount; i++) {
            Account account1 = new Account();
            account1.setId(i + 1);
            account1.setCount(5000);

            Account account2 = new Account();
            account2.setId(i + clientCount + 1);
            account2.setCount(2000);

            Client client1 = new Client();
            client1.setId(i + 1);
            client1.setName("name" + 1);
            String bornDate = "1992-04-20T16:04:00.000Z";
            client1.setBornDate(Instant.parse(bornDate));
            client1.setAccounts(Arrays.asList(account1, account2));

            account1.setClient(client1);
            account2.setClient(client1);

            clients.add(client1);
            accounts.add(account1);
            accounts.add(account2);
        }
        return new Exchange(accounts, clients);
    }

    public List<Account> getAccountsByClientIdAndAccounts(long clientId, List<Account> inputAccounts) {
        List<Account> accountsResult = new ArrayList<>();
        for (Account inputAccount : inputAccounts) {
            if (inputAccount.getClient() != null && inputAccount.getClient().getId() == clientId) {
                accountsResult.add(inputAccount);
            }
        }
        return accountsResult;
    }

    public List<Account> getAccountsByClientIdAndClients(long clientId, List<Client> inputClients) {
        for (Client inputClient : inputClients) {
            if (inputClient.getId() == clientId && inputClient.getAccounts() != null) {
                return inputClient.getAccounts();
            }
        }
        return null;
    }

    public Client findClientByAccountIdAndAccounts(long accountId, List<Account> inputAccounts) {
        for (Account inputAccount : inputAccounts) {
            if (inputAccount.getId() == accountId) {
                return inputAccount.getClient();
            }
        }
        return null;
    }

    public Client findClientByAccountIdAndClients(long accountId, List<Client> inputClients) {
        for (Client inputClient : inputClients) {
            Optional<List<Account>> optionalAccounts = Optional.ofNullable(inputClient.getAccounts());
            if (optionalAccounts.isPresent()) {
                for (Account account : optionalAccounts.get()) {
                    if (account.getId() == accountId) {
                        return account.getClient();
                    }
                }
            }
        }
        return null;
    }
}

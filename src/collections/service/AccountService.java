package collections.service;

import collections.entity.Account;
import collections.entity.Client;

import java.util.List;
import java.util.Map;

public class AccountService {
    public List<Account> getAccountsByClient(Client client, Map<Client, List<Account>> mapWithKeyClient) {
        return mapWithKeyClient.get(client);
    }

    public Client getClientByAccount(Account account, Map<Account, Client> mapWithKeyAccount) {
        return mapWithKeyAccount.get(account);
    }
}

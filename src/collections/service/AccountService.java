package collections.service;

import collections.entity.Account;
import collections.entity.Client;
import collections.entity.Storage;

import java.util.List;

public class AccountService {
    public List<Account> getAccountsByClient(Client client, Storage storage) {
        for (Client inputClient : storage.getClients()) {
            if (inputClient.getAccounts() != null) {
                if (inputClient.equals(client)) {
                    return inputClient.getAccounts();
                }
            }
        }
        return null;
    }

    public Client getClientByAccount(Account account, Storage storage) {
        for (Account inputAccount : storage.getAccounts()) {
            if (inputAccount.equals(account)) {
                return inputAccount.getClient();
            }
        }
        return null;
    }


}

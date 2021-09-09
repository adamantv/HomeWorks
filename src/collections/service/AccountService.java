package collections.service;

import collections.entity.Account;
import collections.entity.Client;
import collections.entity.Storage;

import java.util.List;

public class AccountService {
    public List<Account> getAccountsByClient(Client client, Storage storage) {
        for (Client inputClient : storage.getClients()) {
            if (inputClient.getAccounts() != null) {
                if (inputClient.getId() == client.getId() &&
                        inputClient.getName().equals(client.getName()) &&
                        inputClient.getBornDate().equals(client.getBornDate())) {
                    return inputClient.getAccounts();
                }
            }
        }
        return null;
    }

    public Client getClientByAccount(Account account, Storage storage) {
        for (Account inputAccount : storage.getAccounts()) {
            if (inputAccount.getId() == account.getId() &&
            inputAccount.getCount() == account.getCount()) {
                return inputAccount.getClient();
            }
        }
        return null;
    }


}

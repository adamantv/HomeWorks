package collections.entity;

import java.util.List;
import java.util.Objects;

public class Storage {
    private List<Account> accounts;
    private List<Client> clients;

    public Storage() {
    }

    public Storage(List<Account> accounts, List<Client> clients) {
        this.accounts = accounts;
        this.clients = clients;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Storage)) return false;
        Storage storage = (Storage) o;
        return Objects.equals(getAccounts(), storage.getAccounts()) && Objects.equals(getClients(), storage.getClients());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAccounts(), getClients());
    }

    @Override
    public String toString() {
        return "Exchange{" +
                "accounts=" + accounts +
                ", clients=" + clients +
                '}';
    }
}

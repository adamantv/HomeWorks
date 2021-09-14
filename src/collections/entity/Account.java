package collections.entity;

import java.util.Objects;
import java.util.UUID;

public class Account {
    private UUID id;
    private Client client;
    private long count;

    public Account() {
    }

    public Account(UUID id, Client client, long count) {
        this.id = id;
        this.client = client;
        this.count = count;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Account)) return false;
        Account account = (Account) o;
        return getCount() == account.getCount() && getId().equals(account.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCount());
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", client=" + client.getId() +
                ", count=" + count +
                '}';
    }
}

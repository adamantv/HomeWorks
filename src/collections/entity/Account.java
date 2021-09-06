package collections.entity;

import java.util.Objects;

public class Account {
    private long id;
    private Client client;
    private long count;

    public Account() {
    }

    public Account(long id, Client client, long count) {
        this.id = id;
        this.client = client;
        this.count = count;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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
        return getId() == account.getId() && getCount() == account.getCount() && Objects.equals(getClient(), account.getClient());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getClient(), getCount());
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

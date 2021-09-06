package collections.entity;

import java.time.Instant;
import java.util.List;
import java.util.Objects;

public class Client {
    private long id;
    private String name;
    private Instant bornDate;
    private List<Account> accounts;

    public Client() {
    }

    public Client(long id, String name, Instant bornDate, List<Account> accounts) {
        this.id = id;
        this.name = name;
        this.bornDate = bornDate;
        this.accounts = accounts;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Instant getBornDate() {
        return bornDate;
    }

    public void setBornDate(Instant bornDate) {
        this.bornDate = bornDate;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Client)) return false;
        Client client = (Client) o;
        return getId() == client.getId() && Objects.equals(getName(), client.getName()) && Objects.equals(getBornDate(), client.getBornDate()) && Objects.equals(getAccounts(), client.getAccounts());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getBornDate(), getAccounts());
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", bornDate=" + bornDate +
                ", accounts=" + accounts.toString() +
                '}';
    }
}

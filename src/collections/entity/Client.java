package collections.entity;

import java.time.Instant;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class Client {
    private UUID id;
    private String name;
    private LocalDate bornDate;
    private List<Account> accounts;

    public Client() {
    }

    public Client(UUID id, String name, LocalDate bornDate, List<Account> accounts) {
        this.id = id;
        this.name = name;
        this.bornDate = bornDate;
        this.accounts = accounts;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBornDate() {
        return bornDate;
    }

    public void setBornDate(LocalDate bornDate) {
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
        return getId().equals(client.getId()) && getName().equals(client.getName()) && getBornDate().equals(client.getBornDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getBornDate());
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", bornDate=" + bornDate +
                ", accounts=" + accounts +
                '}';
    }
}

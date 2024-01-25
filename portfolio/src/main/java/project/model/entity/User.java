package project.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name="users")
public class User extends BaseEntity{

private String username;
private String password;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private List<Transaction> transactionList;




    public User() {
    }






    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }




    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public List<Transaction> getTransactionList() {
        return transactionList;
    }

    public void setTransactionList(List<Transaction> transactionList) {
        this.transactionList = transactionList;
    }
}

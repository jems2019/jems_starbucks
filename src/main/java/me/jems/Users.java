package me.jems;

import javax.persistence.*;

@Entity
@Table
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "username")
    private String userName;
    @Column(name = "hashed_password")
    private String hashedPassword;

    public Users() {

    }

    public Users(String userName, String hashedPassword) {
        this.userName = userName;
        this.hashedPassword = hashedPassword;
    }

    public Users(int id, String userName, String hashedPassword ){
        this.id = id;
        this.userName = userName;
        this.hashedPassword = hashedPassword;
    }

    public String getUserName() {
        return userName;
    }

    public String getHashedPassword() {
        return hashedPassword;
    }

    public void setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "{" +
                "id:" + id +
                ", username:'" + userName + '}';
    }
}

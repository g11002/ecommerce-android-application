package com.rajendra.onlinedailygroceries;

public class UserHelperClass {

    String name, username, emailid, phoneno, password;

    public UserHelperClass() {

    }

    public UserHelperClass(String name, String username, String emailid, String phoneno, String password) {
        this.name = name;
        this.username = username;
        this.emailid = emailid;
        this.phoneno = phoneno;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmailid() {
        return emailid;
    }

    public void setEmailid(String emailid) {
        this.emailid = emailid;
    }

    public String getPhoneno() {
        return phoneno;
    }

    public void setPhoneno(String phoneno) {
        this.phoneno = phoneno;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

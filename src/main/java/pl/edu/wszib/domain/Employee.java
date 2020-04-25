package pl.edu.wszib.domain;

import java.util.Date;

public class Employee {
    private long id;
    private String name;
    private String surname;
    private String login;
    private String department;
    private String position;
    private int age;
    private String adress;
    private String telephone;
    private Date firstWorkday;
    private Date lastWorkday;

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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Date getFirstWorkday() {
        return firstWorkday;
    }

    public void setFirstWorkday(Date firstWorkday) {
        this.firstWorkday = firstWorkday;
    }

    public Date getLastWorkday() {
        return lastWorkday;
    }

    public void setLastWorkday(Date lastWorkday) {
        this.lastWorkday = lastWorkday;
    }
}


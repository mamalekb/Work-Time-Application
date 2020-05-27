package pl.edu.wszib.domain;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;
import java.awt.*;
import java.util.Date;

@Entity
@Table(name="Employees")
public class Employee {

    @Id
    @GeneratedValue
    @Column
    private long id;

    @NotEmpty
    private String name;
    @NotEmpty
    private String surname;
    @Past
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateOfBirth;
    private String sex;
    private String login;
    private String email;
    private String department;
    private String position;
    private String adress;
    private String telephone;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date firstWorkday;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date lastWorkday;
    private int picture; //do poprawy
    private boolean working;

    public Employee() {
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public int getPicture() {
        return picture;
    } //do poprawy

    public void setPicture(int picture) {
        this.picture = picture;
    } //do poprawy

    public boolean isWorking() {
        return working;
    }

    public void setWorking(boolean working) {
        this.working = working;
    }
}


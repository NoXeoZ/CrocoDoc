package com.crocodoc.crocodocartifact.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
public class Profile implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    // Données personnelles
    private String lastName;
    private String firstName;
    private Date birthDate;

    // Données de communications
    private String address;
    private String phoneNumber;

    // Connexion
    private String mail;
    private String password;

    @ElementCollection
    private  List<String> specialities = new ArrayList<String>();

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getMail() {
        return mail;
    }



    public List<String> getSpecialities() {
        return specialities;
    }

    public Profile() {
    }

    //FOR TEST PURPOSES ONLY REMOVE FOR PRODUCTION
    public Profile(Long id, String mail, String password) {
        this.id = id;
        this.mail = mail;
        this.password = password;
    }

    public Profile(String lastName, String firstName, Date birthDate, String address, String phoneNumber, String mail, String password) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.birthDate = birthDate;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.mail = mail;
        this.password = password;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isChief(){
        return false;
    }

    public boolean openAgenda(Integer idProfile){
        return true;
    }

    public boolean checkConnexion(String email, String pw){
        return (this.mail.equals(email) && this.password.equals(pw));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Profile)) return false;
        Profile profile = (Profile) o;
        return getId() == profile.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "Profil{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", birthDate=" + birthDate +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", mail='" + mail + '\'' +
                //", password='" + password + '\'' +
                '}';
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Long getId() {
        return id;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getAddress() {
        return address;
    }


}

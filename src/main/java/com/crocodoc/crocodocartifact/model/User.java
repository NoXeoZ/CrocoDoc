package com.crocodoc.crocodocartifact.model;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue
    private long id ;
    @Column(name = "firstname", nullable = false)
    private String firstname;
    @Column(name = "lastname", nullable = false)
    private String lastname;
    @Column(name = "birth_date", nullable = false)
    private Date birthDate;
    @Column(name = "address", nullable = false)
    private String address;
    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;
    @Column(name = "email", nullable = false)
    private String email;
    @Column(name = "password", nullable = false)
    private String password;
    @Column(name = "RIB", nullable = false)
    private String RIB;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "id_type", nullable = false)
    private UserType type;

    @ManyToOne
    @JoinColumn(name = "id_structure", nullable = false)
    private Structure structure;

    @ManyToMany(fetch=FetchType.EAGER, cascade = CascadeType.REMOVE)
    @JoinTable(
            name="users_specialities",
            joinColumns=@JoinColumn(name="user_id", referencedColumnName="ID"),
            inverseJoinColumns=@JoinColumn(name="speciality_ID", referencedColumnName="ID"))
    private Set<Speciality> specialities = new HashSet<>();


    public User(String firstname, String lastname, Date birthDate, String address, String phoneNumber, String email, String password, String RIB, UserType type, Structure structure) {
        this.firstname = Objects.requireNonNull(firstname);
        this.lastname = Objects.requireNonNull(lastname);
        this.birthDate = Objects.requireNonNull(birthDate);
        this.address = Objects.requireNonNull(address);
        this.phoneNumber = Objects.requireNonNull(phoneNumber);
        this.email = Objects.requireNonNull(email);
        this.password = Objects.requireNonNull(password);
        this.RIB = Objects.requireNonNull(RIB);
        this.type = Objects.requireNonNull(type);
        this.structure = Objects.requireNonNull(structure);
    }

    User(){}

    public long getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = Objects.requireNonNull(firstname);
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = Objects.requireNonNull(lastname);
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = Objects.requireNonNull(birthDate);
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = Objects.requireNonNull(address);
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = Objects.requireNonNull(phoneNumber);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = Objects.requireNonNull(email);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = Objects.requireNonNull(password);
    }

    public String getRIB() {
        return RIB;
    }

    public void setRIB(String RIB) {
        this.RIB = Objects.requireNonNull(RIB);
    }

    public UserType getType() {
        return type;
    }

    public void setType(UserType type) {
        this.type = Objects.requireNonNull(type);
    }

    public Structure getStructure() {
        return structure;
    }

    public void setStructure(Structure structure) {
        this.structure = Objects.requireNonNull(structure);
    }

    public List<Speciality> getSpecialities() {
        return new ArrayList<>(specialities);
    }

    public void addSpeciality(Speciality speciality) {
        specialities.add(Objects.requireNonNull(speciality));
    }

    public void removeSpeciality(Speciality speciality) {
        specialities.remove(Objects.requireNonNull(speciality));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != user.id) return false;
        if (!firstname.equals(user.firstname)) return false;
        if (!lastname.equals(user.lastname)) return false;
        if (!birthDate.equals(user.birthDate)) return false;
        if (!address.equals(user.address)) return false;
        if (!phoneNumber.equals(user.phoneNumber)) return false;
        if (!email.equals(user.email)) return false;
        if (!password.equals(user.password)) return false;
        if (!RIB.equals(user.RIB)) return false;
        return type == user.type;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + firstname.hashCode();
        result = 31 * result + lastname.hashCode();
        result = 31 * result + birthDate.hashCode();
        result = 31 * result + address.hashCode();
        result = 31 * result + phoneNumber.hashCode();
        result = 31 * result + email.hashCode();
        result = 31 * result + password.hashCode();
        result = 31 * result + RIB.hashCode();
        result = 31 * result + type.hashCode();
        return result;
    }
}

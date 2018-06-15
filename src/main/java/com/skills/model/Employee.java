package com.skills.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity

public class Employee implements Serializable {
    @Id
    @GeneratedValue
    @JsonIgnore
    private long id;
    private String firstName;
    private String lastName;
    private String location;
    @ManyToMany(cascade = {CascadeType.MERGE,CascadeType.PERSIST})
    @JoinTable(
            name="EMP_SKILL",
            joinColumns=@JoinColumn(name="emp_id", referencedColumnName="id"),
            inverseJoinColumns=@JoinColumn(name="skill_id", referencedColumnName="sid"))

    @JsonIgnoreProperties("employees")
    private Set<Skill> skills = new HashSet<Skill>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }


    public Set<Skill> getSkills() {
        return skills;
    }

    public void setSkills(Set<Skill> skills) {
        this.skills = skills;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return getId() == employee.getId() &&
                Objects.equals(getFirstName(), employee.getFirstName()) &&
                Objects.equals(getLastName(), employee.getLastName()) &&
                Objects.equals(getLocation(), employee.getLocation());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getId(), getFirstName(), getLastName());
    }
}

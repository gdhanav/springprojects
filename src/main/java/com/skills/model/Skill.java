package com.skills.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Skill implements Serializable {

    @Id
    @GeneratedValue
    @JsonIgnore
    private long sid;
    @Column(unique=true)
    private String skillName;
    @ManyToMany(mappedBy="skills",fetch = FetchType.LAZY)
    //@JsonBackReference
    //@JsonManagedReference
    @Transient
    @JsonIgnoreProperties("skills")
    private Set<Employee> employees = new HashSet<>();



    public long getSid() {
        return sid;
    }

    public void setSid(long sid) {
        this.sid = sid;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }


    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Skill)) return false;
        Skill skill = (Skill) o;
        return getSid() == skill.getSid() &&
                Objects.equals(getSkillName(), skill.getSkillName());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getSid(), getSkillName());
    }
}

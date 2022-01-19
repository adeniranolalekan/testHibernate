package com.example.testhibernate.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * A Company.
 */
@Entity
@Table(name = "COMPANY")
public class Company implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Size(min = 2, max = 140)
    @Column(name = "name", length = 140, nullable = false)
    private String name;

    @NotNull
    @Column(name = "image_url", nullable = false)
    private String imageUrl;

    @NotNull
    @Size(max = 6)
    @Column(name = "primary_color", length = 6, nullable = false)
    private String primaryColor;

    @Size(max = 6)
    @Column(name = "secondary_color", length = 6)
    private String secondaryColor;

    @Size(max = 6)
    @Column(name = "company_code", length = 6)
    private String companyCode;

    @Size(max = 50)
    @Column(name = "domain", length = 50)
    private String domain;

//    @OneToMany(mappedBy = "company")
//    @JsonIgnore
//    private Set<User> users = new HashSet<>();

    @OneToMany(mappedBy = "company")
    @JsonIgnore
    private Set<UserInvitation> userInvitationss = new HashSet<>();

    @OneToMany(mappedBy = "company")
    @JsonIgnore
    private Set<Project> projects = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getPrimaryColor() {
        return primaryColor;
    }

    public void setPrimaryColor(String primaryColor) {
        this.primaryColor = primaryColor;
    }

    public String getSecondaryColor() {
        return secondaryColor;
    }

    public void setSecondaryColor(String secondaryColor) {
        this.secondaryColor = secondaryColor;
    }

//    public Set<User> getUserss() {
//        return userss;
//    }
//
//    public void setUserss(Set<User> users) {
//        this.userss = users;
//    }

    public Set<UserInvitation> getUserInvitationss() {
        return userInvitationss;
    }

    public void setUserInvitationss(Set<UserInvitation> userInvitations) {
        this.userInvitationss = userInvitations;
    }

    public Set<Project> getProjects() {
        return projects;
    }

    public void setProjects(Set<Project> projects) {
        this.projects = projects;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Company company = (Company) o;

        if (!Objects.equals(id, company.id)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", name='" + name + "'" +
                ", imageUrl='" + imageUrl + "'" +
                ", primaryColor='" + primaryColor + "'" +
                ", secondaryColor='" + secondaryColor + "'" +
                '}';
    }
}

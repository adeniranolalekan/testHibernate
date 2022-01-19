package com.example.testhibernate.domain.entity;


import com.example.testhibernate.domain.entity.util.CustomLocalDateSerializer;
import com.example.testhibernate.domain.entity.util.ISO8601LocalDateDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.hibernate.annotations.Type;
import org.joda.time.LocalDate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * A UserInvitation.
 */
@Entity
@Table(name = "USER_INVITATION")
public class UserInvitation extends BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Column(name = "email", nullable = false)
    private String email;

    @NotNull
    @Size(min = 64, max = 64)
    @Column(name = "guid", length = 64, nullable = false)
    private String guid;

    @Column(name = "owner")
    private Boolean owner;

    @Column(name = "read_only")
    private Boolean readOnly;

    @Column(name = "editor_own")
    private Boolean editorOwn;

    @Column(name = "editor_all")
    private Boolean editorAll;

    @NotNull
    //@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
    @JsonSerialize(using = CustomLocalDateSerializer.class)
    @JsonDeserialize(using = ISO8601LocalDateDeserializer.class)
    @Column(name = "expiration_date", nullable = false)
    private LocalDate expirationDate;

    @OneToOne
    private User user;

    @OneToOne
    private Project project;

    @ManyToMany
    @JoinTable(name = "USER_INVITATION_ACCEPTED",
            joinColumns = @JoinColumn(name="user_invitations_id", referencedColumnName="ID"),
            inverseJoinColumns = @JoinColumn(name="accepteds_id", referencedColumnName="ID"))
    private Set<User> accepteds = new HashSet<>();

    @ManyToOne
    private Company company;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public Boolean getOwner() {
        return owner;
    }

    public void setOwner(Boolean owner) {
        this.owner = owner;
    }

    public Boolean getReadOnly() {
        return readOnly;
    }

    public void setReadOnly(Boolean readOnly) {
        this.readOnly = readOnly;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Set<User> getAccepteds() {
        return accepteds;
    }

    public void setAccepteds(Set<User> users) {
        this.accepteds = users;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }



    public Boolean getEditorOwn() {
        return editorOwn;
    }

    public void setEditorOwn(Boolean editorOwn) {
        this.editorOwn = editorOwn;
    }

    public Boolean getEditorAll() {
        return editorAll;
    }

    public void setEditorAll(Boolean editorAll) {
        this.editorAll = editorAll;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        UserInvitation userInvitation = (UserInvitation) o;

        if ( ! Objects.equals(id, userInvitation.id)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "UserInvitation{" +
                "id=" + id +
                ", email='" + email + "'" +
                ", guid='" + guid + "'" +
                ", owner='" + owner + "'" +
                ", readOnly='" + readOnly + "'" +
                ", expirationDate='" + expirationDate + "'" +
                '}';
    }
}

package com.example.testhibernate.domain.entity;
import com.example.testhibernate.domain.entity.enumeration.ProjectStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * A Project.
 */
@Entity
@Table(name = "PROJECT")
public class Project extends BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Size(min = 3, max = 140)
    @Column(name = "name", length = 140, nullable = false)
    private String name;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private ProjectStatus status;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "customId")
    private String customId;

    @Column(name = "shared")
    private Boolean shared;

    @Column(name = "salt")
    private String salt;

    @Column(name = "is_comRequest_automatic")
    private Boolean isComRequestAutomatic = true;

    @ManyToOne
    private Client client;

    @ManyToOne
    private Company company;

    @OneToMany(mappedBy = "project")
    @JsonIgnore
    private Set<Video> videoss = new HashSet<>();

    @OneToMany(mappedBy = "project", fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    private Set<ProjectKeyword> projectKeywords = new HashSet<>();

    @OneToMany(mappedBy = "project")
    @JsonIgnore
    private Set<Audio> audioss = new HashSet<>();

    @Column(name = "project_start_date")
    //@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime projectStartDate;

    @Column(name = "project_end_date")
    //@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime projectEndDate;

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

    public ProjectStatus getStatus() {
        return status;
    }

    public void setStatus(ProjectStatus status) {
        this.status = status;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Set<Video> getVideoss() {
        return videoss;
    }

    public void setVideoss(Set<Video> videos) {
        this.videoss = videos;
    }

    public Set<ProjectKeyword> getProjectKeywords() {
        return projectKeywords;
    }

    public void setProjectKeywords(Set<ProjectKeyword> projectKeywords) {
        this.projectKeywords = projectKeywords;
    }

    public String getCustomId() {
        return customId;
    }

    public void setCustomId(String customId) {
        this.customId = customId;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Set<Audio> getAudioss() {
        return audioss;
    }

    public void setAudioss(Set<Audio> audioss) {
        this.audioss = audioss;
    }

    public Boolean getShared() {
        return shared;
    }

    public void setShared(Boolean shared) {
        this.shared = shared;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public Boolean getIsComRequestAutomatic() {
        return isComRequestAutomatic;
    }

    public void setIsComRequestAutomatic(Boolean isComRequestAutomatic) {
        this.isComRequestAutomatic = isComRequestAutomatic;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Project project = (Project) o;

        if (!Objects.equals(id, project.id)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", name='" + name + "'" +
                ", status='" + status + "'" +
                ", imageUrl='" + imageUrl + "'" +
                '}';
    }

    public static final Comparator<Project> byIdDesc = (p1, p2) ->
    {
        return Long.compare(p2.getId(), p1.getId());
    };

    public DateTime getProjectStartDate() {
        return projectStartDate;
    }

    public void setProjectStartDate(DateTime projectStartDate) {
        this.projectStartDate = projectStartDate;
    }

    public DateTime getProjectEndDate() {
        return projectEndDate;
    }

    public void setProjectEndDate(DateTime projectEndDate) {
        this.projectEndDate = projectEndDate;
    }
}

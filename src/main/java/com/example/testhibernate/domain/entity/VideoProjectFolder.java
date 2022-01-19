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
 * A VideoProjectFolder.
 */
@Entity
@Table(name = "VIDEO_PROJECT_FOLDER")
public class VideoProjectFolder implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Size(min = 1, max = 100)        
    @Column(name = "name", length = 100, nullable = false)
    private String name;

    @ManyToOne
    private Project project;

    @OneToMany(mappedBy = "folder")
    @JsonIgnore
    private Set<Video> videos = new HashSet<>();

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

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Set<Video> getVideos() {
        return videos;
    }

    public void setVideos(Set<Video> videos) {
        this.videos = videos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        VideoProjectFolder videoProjectFolder = (VideoProjectFolder) o;

        if ( ! Objects.equals(id, videoProjectFolder.id)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "VideoProjectFolder{" +
                "id=" + id +
                ", name='" + name + "'" +
                '}';
    }
}

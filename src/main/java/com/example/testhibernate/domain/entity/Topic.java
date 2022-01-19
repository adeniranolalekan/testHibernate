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
 * A Topic.
 */
@Entity
@Table(name = "TOPIC")
public class Topic extends BaseEntity  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Size(min = 1, max = 6)
    @Column(name = "topic_order", length = 6, nullable = false)
    private String order;

    @NotNull
    @Size(min = 3, max = 512)
    @Column(name = "description", length = 512, nullable = false)
    private String description;

    @ManyToOne
    private Project project;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "topic")
    @JsonIgnore
    private Set<TopicNote> topicNotess = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Set<TopicNote> getTopicNotess() {
        return topicNotess;
    }

    public void setTopicNotess(Set<TopicNote> topicNotes) {
        this.topicNotess = topicNotes;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Topic topic = (Topic) o;

        if ( ! Objects.equals(id, topic.id)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Topic{" +
                "id=" + id +
                ", description='" + description + "'" +
                '}';
    }
}

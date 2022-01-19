package com.example.testhibernate.domain.entity;

import com.example.testhibernate.domain.entity.util.CustomDateTimeDeserializer;
import com.example.testhibernate.domain.entity.util.CustomDateTimeSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.joda.time.DateTime;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Objects;

/**
 * A VideoTag.
 */
@Entity
@Table(name = "VIDEO_TAG")
public class VideoTag extends BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "position")
    private Long position;

    //@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    @JsonSerialize(using = CustomDateTimeSerializer.class)
    @JsonDeserialize(using = CustomDateTimeDeserializer.class)
    @Column(name = "tag_date_time")
    private DateTime tagDateTime;

    //@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    @JsonSerialize(using = CustomDateTimeSerializer.class)
    @JsonDeserialize(using = CustomDateTimeDeserializer.class)
    @Column(name = "tag_date_time_utc")
    private DateTime tagDateTimeUtc;

    @NotNull
    @Size(min = 3, max = 256)
    @Column(name = "text", length = 256, nullable = false)
    private String text;

    @ManyToOne
    private Project project;

    @ManyToOne
    private Video video;

    @ManyToOne
    private User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPosition() {
        return position;
    }

    public void setPosition(Long position) {
        this.position = position;
    }

    public DateTime getTagDateTime() {
        return tagDateTime;
    }

    public void setTagDateTime(DateTime tagDateTime) {
        this.tagDateTime = tagDateTime;
    }

    public DateTime getTagDateTimeUtc() {
        return tagDateTimeUtc;
    }

    public void setTagDateTimeUtc(DateTime tagDateTimeUtc) {
        this.tagDateTimeUtc = tagDateTimeUtc;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Video getVideo() {
        return video;
    }

    public void setVideo(Video video) {
        this.video = video;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        VideoTag videoTag = (VideoTag) o;

        if ( ! Objects.equals(id, videoTag.id)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "VideoTag{" +
                "id=" + id +
                ", position='" + position + "'" +
                ", tagDateTime='" + tagDateTime + "'" +
                ", text='" + text + "'" +
                '}';
    }
}

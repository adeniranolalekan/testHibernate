package com.example.testhibernate.domain.entity;

import com.example.testhibernate.domain.entity.util.CustomDateTimeDeserializer;
import com.example.testhibernate.domain.entity.util.CustomDateTimeSerializer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.joda.time.DateTime;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Objects;

/**
 * A AudioClip.
 */
@Entity
@Table(name = "AUDIO_CLIP")
public class AudioClip extends BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Column(name = "in_time", nullable = false)
    private Long in;

    @NotNull
    @Column(name = "out_time", nullable = false)
    private Long out;

    @Size(max = 512)
    @Column(name = "note", length = 512)
    private String note;

    @Column(name = "audio_bucket")
    private String audioBucket;

    @Column(name = "audio_path")
    private String audioPath;

    @Column(name = "audio_filename")
    private String audioFilename;

    @Size(max = 48)
    @Column(name = "transcoder_job_id", length = 48)
    private String transcoderJobId;

    @Size(max = 20)
    @Column(name = "transcoder_result_code", length = 20)
    private String transcoderResultCode;

    @Size(max = 512)
    @Column(name = "transcoder_result_message", length = 512)
    private String transcoderResultMessage;

    //@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    @JsonSerialize(using = CustomDateTimeSerializer.class)
    @JsonDeserialize(using = CustomDateTimeDeserializer.class)
    @Column(name = "transcoder_date_time")
    private DateTime transcoderDateTime;

    @Column(name = "cc_bucket")
    private String ccBucket;

    @Column(name = "cc_path")
    private String ccPath;

    @Column(name = "cc_filename")
    private String ccFilename;

    @JsonIgnore
    @Size(max = 300000)
    @Column(name = "closed_caption_json", length = 300000)
    private String closedCaptionJson;

    @ManyToOne
    private Audio audio;

    @ManyToOne
    private Topic topic;

    @ManyToOne
    private User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIn() {
        return in;
    }

    public void setIn(Long in) {
        this.in = in;
    }

    public Long getOut() {
        return out;
    }

    public void setOut(Long out) {
        this.out = out;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getAudioBucket() {
        return audioBucket;
    }

    public void setAudioBucket(String audioBucket) {
        this.audioBucket = audioBucket;
    }

    public String getAudioPath() {
        return audioPath;
    }

    public void setAudioPath(String audioPath) {
        this.audioPath = audioPath;
    }

    public String getAudioFilename() {
        return audioFilename;
    }

    public void setAudioFilename(String audioFilename) {
        this.audioFilename = audioFilename;
    }

    public String getTranscoderJobId() {
        return transcoderJobId;
    }

    public void setTranscoderJobId(String transcoderJobId) {
        this.transcoderJobId = transcoderJobId;
    }

    public String getTranscoderResultCode() {
        return transcoderResultCode;
    }

    public void setTranscoderResultCode(String transcoderResultCode) {
        this.transcoderResultCode = transcoderResultCode;
    }

    public String getTranscoderResultMessage() {
        return transcoderResultMessage;
    }

    public void setTranscoderResultMessage(String transcoderResultMessage) {
        this.transcoderResultMessage = transcoderResultMessage;
    }

    public DateTime getTranscoderDateTime() {
        return transcoderDateTime;
    }

    public void setTranscoderDateTime(DateTime transcoderDateTime) {
        this.transcoderDateTime = transcoderDateTime;
    }

    public String getCcBucket() {
        return ccBucket;
    }

    public void setCcBucket(String ccBucket) {
        this.ccBucket = ccBucket;
    }

    public String getCcPath() {
        return ccPath;
    }

    public void setCcPath(String ccPath) {
        this.ccPath = ccPath;
    }

    public String getCcFilename() {
        return ccFilename;
    }

    public void setCcFilename(String ccFilename) {
        this.ccFilename = ccFilename;
    }

    public String getClosedCaptionJson() {
        return closedCaptionJson;
    }

    public void setClosedCaptionJson(String closedCaptionJson) {
        this.closedCaptionJson = closedCaptionJson;
    }

    public Audio getAudio() {
        return audio;
    }

    public void setAudio(Audio audio) {
        this.audio = audio;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
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

        AudioClip audioClip = (AudioClip) o;

        if ( ! Objects.equals(id, audioClip.id)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "AudioClip{" +
                "id=" + id +
                ", in='" + in + "'" +
                ", out='" + out + "'" +
                ", note='" + note + "'" +
                ", audioBucket='" + audioBucket + "'" +
                ", audioPath='" + audioPath + "'" +
                ", audioFilename='" + audioFilename + "'" +
                ", transcoderJobId='" + transcoderJobId + "'" +
                ", transcoderResultCode='" + transcoderResultCode + "'" +
                ", transcoderResultMessage='" + transcoderResultMessage + "'" +
                ", transcoderDateTime='" + transcoderDateTime + "'" +
                ", ccBucket='" + ccBucket + "'" +
                ", ccPath='" + ccPath + "'" +
                ", ccFilename='" + ccFilename + "'" +
                ", closedCaptionJson='" + closedCaptionJson + "'" +
                '}';
    }
}

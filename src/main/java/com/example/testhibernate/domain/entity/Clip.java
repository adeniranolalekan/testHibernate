package com.example.testhibernate.domain.entity;

import com.example.testhibernate.domain.entity.enumeration.VolumeChangeStatus;
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
 * A Clip.
 */
@Entity
@Table(name = "CLIP")
public class Clip extends BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @NotNull
    @Column(name = "name", nullable = false)
    private String name;

    @NotNull
    @Column(name = "in_time", nullable = false)
    private Long in;

    @NotNull
    @Column(name = "out_time", nullable = false)
    private Long out;

    @Size(max = 512)
    @Column(name = "note", length = 512)
    private String note;

    @Column(name = "video_bucket")
    private String videoBucket;

    @Column(name = "video_path")
    private String videoPath;

    @Column(name = "video_filename")
    private String videoFilename;

    @Column(name = "thumbnail_bucket")
    private String thumbnailBucket;

    @Column(name = "thumbnail_path")
    private String thumbnailPath;

    @Column(name = "thumbnail_filename")
    private String thumbnailFilename;

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

    @Column(name = "cc_clip_filename")
    private String ccClipFilename;

    @Column(name = "volume_change_status")
    private VolumeChangeStatus volumeChangeStatus;

    @JsonIgnore
    @Size(max = 300000)
    @Column(name = "closed_caption_json", length = 300000)
    private String closedCaptionJson;
	
	@Column(name="is_computer_cc")
    private Boolean isComputerCC;

    @ManyToOne
    private Video video;

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

    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

    public String getVideoBucket() {
        return videoBucket;
    }

    public void setVideoBucket(String videoBucket) {
        this.videoBucket = videoBucket;
    }

    public String getVideoPath() {
        return videoPath;
    }

    public void setVideoPath(String videoPath) {
        this.videoPath = videoPath;
    }

    public String getVideoFilename() {
        return videoFilename;
    }

    public void setVideoFilename(String videoFilename) {
        this.videoFilename = videoFilename;
    }

    public String getThumbnailBucket() {
        return thumbnailBucket;
    }

    public void setThumbnailBucket(String thumbnailBucket) {
        this.thumbnailBucket = thumbnailBucket;
    }

    public String getThumbnailPath() {
        return thumbnailPath;
    }

    public void setThumbnailPath(String thumbnailPath) {
        this.thumbnailPath = thumbnailPath;
    }

    public String getThumbnailFilename() {
        return thumbnailFilename;
    }

    public void setThumbnailFilename(String thumbnailFilename) {
        this.thumbnailFilename = thumbnailFilename;
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

    public Video getVideo() {
        return video;
    }

    public void setVideo(Video video) {
        this.video = video;
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

    public String getCcClipFilename() {
        return ccClipFilename;
    }

    public void setCcClipFilename(String ccClipFilename) {
        this.ccClipFilename = ccClipFilename;
    }

    public VolumeChangeStatus getVolumeChangeStatus() {
        return volumeChangeStatus;
    }

    public void setVolumeChangeStatus(VolumeChangeStatus volumeChangeStatus) {
        this.volumeChangeStatus = volumeChangeStatus;
    }
	
	public Boolean getIsComputerCC() {
		return isComputerCC;
	}
	
	public void setIsComputerCC(Boolean isComputerCC) {
		this.isComputerCC = isComputerCC;
	}

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Clip clip = (Clip) o;

        if ( ! Objects.equals(id, clip.id)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

/*
    @Override
    public String toString() {
        return "Clip{" +
                "id=" + id +
                ", in='" + in + "'" +
                ", out='" + out + "'" +
                ", note='" + note + "'" +
                ", videoBucket='" + videoBucket + "'" +
                ", videoPath='" + videoPath + "'" +
                ", videoFilename='" + videoFilename + "'" +
                ", thumbnailBucket='" + thumbnailBucket + "'" +
                ", thumbnailPath='" + thumbnailPath + "'" +
                ", thumbnailFilename='" + thumbnailFilename + "'" +
                ", transcoderJobId='" + transcoderJobId + "'" +
                ", transcoderResultCode='" + transcoderResultCode + "'" +
                ", transcoderResultMessage='" + transcoderResultMessage + "'" +
                ", transcoderDateTime='" + transcoderDateTime + "'" +
                '}';
    }
*/
}

package com.example.testhibernate.domain.entity;

import com.example.testhibernate.domain.entity.enumeration.*;
import com.example.testhibernate.domain.entity.util.CustomDateTimeDeserializer;
import com.example.testhibernate.domain.entity.util.CustomDateTimeSerializer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.joda.time.DateTime;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * A Video.
 */
@Entity
@Table(name = "VIDEO")
public class Video extends BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Size(min = 3, max = 140)
    @Column(name = "name", length = 140, nullable = false)
    private String name;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "source", nullable = false)
    private VideoSource source;

    @Column(name = "video_bucket")
    private String videoBucket;

    @Column(name = "video_path")
    private String videoPath;

    @Column(name = "low_res_video_path")
    private String lowResVideoPath;

    @Column(name = "video_filename")
    private String videoFilename;

    @Column(name = "cc_video_filename")
    private String ccVideoFilename;

    @Column(name = "thumbnail_bucket")
    private String thumbnailBucket;

    @Column(name = "thumbnail_path")
    private String thumbnailPath;

    @Column(name = "thumbnail_filename")
    private String thumbnailFilename;

    @Column(name = "audio_data_bucket")
    private String audioDataBucket;

    @Column(name = "audio_data_path")
    private String audioDataPath;

    @Column(name = "audio_data_filename")
    private String audioDataFilename;

    @Column(name = "cc_bucket")
    private String ccBucket;

    @Column(name = "cc_path")
    private String ccPath;

    @Column(name = "cc_filename")
    private String ccFilename;

    @JsonIgnore
    @Size(max = 5000000)
    @Column(name = "closed_caption_json", length = 5000000)
    private String closedCaptionJson;

    @Column(name = "length")
    private Long length;

    @Size(max = 1000)
    @Column(name = "notes", length = 1000)
    private String notes;

    @Size(max = 100000)
    @Column(name = "request_json", length = 30000)
    private String requestJson;

    @Size(max = 20)
    @Column(name = "result_code", length = 20)
    private String resultCode;

    @Size(max = 100000)
    @Column(name = "result_message", length = 30000)
    private String resultMessage;

    @Column(name = "height")
    private Long height;

    @Column(name = "width")
    private Long width;

    @Column(name = "duration")
    private BigDecimal duration;

    @Column(name = "cc_status")
    @Enumerated(EnumType.STRING)
    private ClosedCaptionStatus ccStatus;

    @Column(name = "cc_requested_date")
    //@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    @JsonSerialize(using = CustomDateTimeSerializer.class)
    @JsonDeserialize(using = CustomDateTimeDeserializer.class)
    private DateTime ccRequestedDate;

    @Column(name = "cc_requested_by")
    private String ccRequestedBy;

    @Column(name = "cc_cost")
    private BigDecimal ccCost;

    @Column(name = "cc_response", length = 100000)
    private String ccResponse;

    @ManyToOne
    private Project project;

    @ManyToOne
    private VideoProjectFolder folder;

    @ManyToOne
    private Device device;

    @OneToMany(mappedBy = "video")
    @JsonIgnore
    private Set<Clip> clipss = new HashSet<>();

    @OneToMany(mappedBy = "video", fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    private Set<VideoSegment> videoSegments = new HashSet<>();

    @OneToMany(mappedBy = "video", fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    private Set<VideoKeyword> videoKeywords = new HashSet<>();


    @Size(max = 30)
    @Column(name = "cc_order_number", length = 30)
    private String ccOrderNumber;

    @Size(max = 30)
    @Column(name = "streamspot_id", length = 30)
    private String streamspotId;


    @Size(max = 30)
    @Column(name = "streamspot_id_hash", length = 30)
    private String streamspotIdHash;


    @Column(name = "recorded_date")
    //@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    @JsonSerialize(using = CustomDateTimeSerializer.class)
    @JsonDeserialize(using = CustomDateTimeDeserializer.class)
    private DateTime recordedDate;

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

    @Column(name = "video_rotation")
    @Enumerated(EnumType.STRING)
    private VideoRotation videoRotation;

    @Column(name = "orientation_change_status")
    private OrientationChangeStatus orientationChangeStatus;

	 /* Start : Newly added columns for computer transcription 
     * by Vishnupriya angler 
     * on 11th May 2019
     */
    @Column(name = "com_cc_bucket")
    private String comCcBucket;
    
    @Column(name = "com_cc_filename")
    private String comCcFileName;
    
    @Column(name = "com_cc_jobid")
    private String comCcJobId;
    
    @Column(name = "com_cc_path")
    private String comCcPath;

    @Column(name = "com_cc_requested_by")
    private String comCcRequestedBy;
    
    @Column(name = "com_cc_requested_date")
    //@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    @JsonSerialize(using = CustomDateTimeSerializer.class)
    @JsonDeserialize(using = CustomDateTimeDeserializer.class)
    private DateTime comCcRequestedDate;
    
    @Column(name = "com_cc_requested_type")
    @Enumerated(EnumType.STRING)
    private TranscriptionRequestType comCcRequestedType;
    
    @Column(name = "com_cc_status")
    @Enumerated(EnumType.STRING)
    private ClosedCaptionStatus comCcStatus;
    
	@JsonIgnore
    @Column(name = "com_closed_caption_json")
    private String comClosedCaptionJson;
	
	@Column(name = "is_com_request_sent")
    private Boolean isComRequestSent=false;
	
	@Column(name = "com_cc_video_filename")
    private String comCcVideoFilename;
	
	@Column(name="com_cc_vtt_format")
	private String vttFileFormat;

    
    /* End Newly added columns for computer transcription 
     * by Vishnupriya angler 
     * on 11th May 2019
     */

    public OrientationChangeStatus getOrientationChangeStatus() {
        return orientationChangeStatus;
    }

    public void setOrientationChangeStatus(OrientationChangeStatus orientationChangeStatus) {
        this.orientationChangeStatus = orientationChangeStatus;
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

    public VideoRotation getVideoRotation() {
        return videoRotation;
    }

    public void setVideoRotation(VideoRotation videoRotation) {
        this.videoRotation = videoRotation;
    }

    public Long getHeight() {
        return height;
    }

    public void setHeight(Long height) {
        this.height = height;
    }

    public Long getWidth() {
        return width;
    }

    public void setWidth(Long width) {
        this.width = width;
    }

    public BigDecimal getDuration() {
        return duration;
    }

    public void setDuration(BigDecimal duration) {
        this.duration = duration;
    }


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

    public VideoSource getSource() {
        return source;
    }

    public void setSource(VideoSource source) {
        this.source = source;
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

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Set<Clip> getClipss() {
        return clipss;
    }

    public void setClipss(Set<Clip> clips) {
        this.clipss = clips;
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultMessage() {
        return resultMessage;
    }

    public void setResultMessage(String resultMessage) {
        this.resultMessage = resultMessage;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getRequestJson() {
        return requestJson;
    }

    public void setRequestJson(String requestJson) {
        this.requestJson = requestJson;
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

    public ClosedCaptionStatus getCcStatus() {
        return ccStatus;
    }

    public void setCcStatus(ClosedCaptionStatus ccStatus) {
        this.ccStatus = ccStatus;
    }

    public DateTime getCcRequestedDate() {
        return ccRequestedDate;
    }

    public void setCcRequestedDate(DateTime ccRequestedDate) {
        this.ccRequestedDate = ccRequestedDate;
    }

    public String getCcRequestedBy() {
        return ccRequestedBy;
    }

    public void setCcRequestedBy(String ccRequestedBy) {
        this.ccRequestedBy = ccRequestedBy;
    }

    public BigDecimal getCcCost() {
        return ccCost;
    }

    public void setCcCost(BigDecimal ccCost) {
        this.ccCost = ccCost;
    }

    public String getCcOrderNumber() {
        return ccOrderNumber;
    }

    public void setCcOrderNumber(String ccOrderNumber) {
        this.ccOrderNumber = ccOrderNumber;
    }

    public String getCcResponse() {
        return ccResponse;
    }

    public void setCcResponse(String ccResponse) {
        this.ccResponse = ccResponse;
    }

    public Set<VideoSegment> getVideoSegments() {
        return videoSegments;
    }

    public void setVideoSegments(Set<VideoSegment> videoSegments) {
        this.videoSegments = videoSegments;
    }

    public String getLowResVideoPath() {
        return lowResVideoPath;
    }

    public void setLowResVideoPath(String lowResVideoPath) {
        this.lowResVideoPath = lowResVideoPath;
    }

    public Set<VideoKeyword> getVideoKeywords() {
        return videoKeywords;
    }

    public void setVideoKeywords(Set<VideoKeyword> videoKeywords) {
        this.videoKeywords = videoKeywords;
    }

    public String getAudioDataBucket() {
        return audioDataBucket;
    }

    public void setAudioDataBucket(String audioDataBucket) {
        this.audioDataBucket = audioDataBucket;
    }

    public String getAudioDataPath() {
        return audioDataPath;
    }

    public void setAudioDataPath(String audioDataPath) {
        this.audioDataPath = audioDataPath;
    }

    public String getAudioDataFilename() {
        return audioDataFilename;
    }

    public void setAudioDataFilename(String audioDataFilename) {
        this.audioDataFilename = audioDataFilename;
    }

    public Long getLength() {
        return length;
    }

    public void setLength(Long length) {
        this.length = length;
    }

    public String getCcVideoFilename() {
        return ccVideoFilename;
    }

    public void setCcVideoFilename(String ccVideoFilename) {
        this.ccVideoFilename = ccVideoFilename;
    }


    public String getStreamspotId() {
        return streamspotId;
    }

    public void setStreamspotId(String streamspotId) {
        this.streamspotId = streamspotId;
    }

    public String getStreamspotIdHash() {
        return streamspotIdHash;
    }

    public void setStreamspotIdHash(String streamspotIdHash) {
        this.streamspotIdHash = streamspotIdHash;
    }


    public DateTime getRecordedDate() {
        return recordedDate;
    }

    public void setRecordedDate(DateTime recordedDate) {
        this.recordedDate = recordedDate;
    }

    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }

    public VideoProjectFolder getFolder() {
        return folder;
    }

    public void setFolder(VideoProjectFolder folder) {
        this.folder = folder;
    }
	
	public String getComCcBucket() {
		return comCcBucket;
	}
	
	public void setComCcBucket(String comCcBucket) {
		this.comCcBucket = comCcBucket;
	}

	public String getComCcFileName() {
		return comCcFileName;
	}

	public void setComCcFileName(String comCcFileName) {
		this.comCcFileName = comCcFileName;
	}

	public String getComCcJobId() {
		return comCcJobId;
	}

	public void setComCcJobId(String comCcJobId) {
		this.comCcJobId = comCcJobId;
	}

	public String getComCcPath() {
		return comCcPath;
	}

	public void setComCcPath(String comCcPath) {
		this.comCcPath = comCcPath;
	}

	public String getComCcRequestedBy() {
		return comCcRequestedBy;
	}

	public void setComCcRequestedBy(String comCcRequestedBy) {
		this.comCcRequestedBy = comCcRequestedBy;
	}

	public DateTime getComCcRequestedDate() {
		return comCcRequestedDate;
	}

	public void setComCcRequestedDate(DateTime comCcRequestedDate) {
		this.comCcRequestedDate = comCcRequestedDate;
	}

	public TranscriptionRequestType getComCcRequestedType() {
		return comCcRequestedType;
	}

	public void setComCcRequestedType(TranscriptionRequestType comCcRequestedType) {
		this.comCcRequestedType = comCcRequestedType;
	}

	public ClosedCaptionStatus getComCcStatus() {
		return comCcStatus;
	}

	public void setComCcStatus(ClosedCaptionStatus comCcStatus) {
		this.comCcStatus = comCcStatus;
	}

	public String getComClosedCaptionJson() {
		return comClosedCaptionJson;
	}

	public void setComClosedCaptionJson(String comClosedCaptionJson) {
		this.comClosedCaptionJson = comClosedCaptionJson;
	}
	
	public Boolean getisComRequestSent() {
		return isComRequestSent;
	}

	public void setisComRequestSent(Boolean isComRequestSent) {
		this.isComRequestSent = isComRequestSent;
	}

	public String getComCcVideoFilename() {
		return comCcVideoFilename;
	}

	public void setComCcVideoFilename(String comCcVideoFilename) {
		this.comCcVideoFilename = comCcVideoFilename;
	}
	
	public String getVttFileFormat() {
		return vttFileFormat;
	}

	public void setVttFileFormat(String vttFileFormat) {
		this.vttFileFormat = vttFileFormat;
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Video video = (Video) o;

        if (!Objects.equals(id, video.id)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Video{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", source=" + source +
            ", videoBucket='" + videoBucket + '\'' +
            ", videoPath='" + videoPath + '\'' +
            ", lowResVideoPath='" + lowResVideoPath + '\'' +
            ", videoFilename='" + videoFilename + '\'' +
            ", ccVideoFilename='" + ccVideoFilename + '\'' +
            ", thumbnailBucket='" + thumbnailBucket + '\'' +
            ", thumbnailPath='" + thumbnailPath + '\'' +
            ", thumbnailFilename='" + thumbnailFilename + '\'' +
            ", audioDataBucket='" + audioDataBucket + '\'' +
            ", audioDataPath='" + audioDataPath + '\'' +
            ", audioDataFilename='" + audioDataFilename + '\'' +
            ", ccBucket='" + ccBucket + '\'' +
            ", ccPath='" + ccPath + '\'' +
            ", ccFilename='" + ccFilename + '\'' +
            ", length=" + length +
            ", resultCode='" + resultCode + '\'' +
            ", height=" + height +
            ", width=" + width +
            ", duration=" + duration +
            ", ccStatus=" + ccStatus +
            ", ccRequestedDate=" + ccRequestedDate +
            ", ccRequestedBy='" + ccRequestedBy + '\'' +
            ", ccCost=" + ccCost +
            ", ccResponse='" + ccResponse + '\'' +
            ", project=" + project +
            ", folder=" + folder +
            ", device=" + device +
            ", transcoderJobId='" + transcoderJobId + '\'' +
            ", transcoderResultCode='" + transcoderResultCode + '\'' +
            '}';
    }
}

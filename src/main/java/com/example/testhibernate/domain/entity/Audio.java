package com.example.testhibernate.domain.entity;

import com.example.testhibernate.domain.entity.enumeration.ClosedCaptionStatus;
import com.example.testhibernate.domain.entity.enumeration.TranscriptionRequestType;
import com.example.testhibernate.domain.entity.enumeration.VideoSource;
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
 * Ab Audio.
 */
@Entity
@Table(name = "AUDIO")
public class Audio extends BaseEntity implements Serializable {

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

    @Column(name = "audio_bucket")
    private String audioBucket;

    @Column(name = "audio_path")
    private String audioPath;

    @Column(name = "audio_filename")
    private String audioFilename;

    @Column(name = "cc_bucket")
    private String ccBucket;

    @Column(name = "cc_path")
    private String ccPath;

    @Column(name = "cc_filename")
    private String ccFilename;

    @Column(name = "audio_data_bucket")
    private String audioDataBucket;

    @Column(name = "audio_data_path")
    private String audioDataPath;

    @Column(name = "audio_data_filename")
    private String audioDataFilename;

    @Size(max = 20)
    @Column(name = "result_code", length = 20)
    private String resultCode;

    @Size(max = 30000)
    @Column(name = "result_message", length = 30000)
    private String resultMessage;

    @JsonIgnore
    @Size(max = 300000)
    @Column(name = "closed_caption_json", length = 300000)
    private String closedCaptionJson;

    @Column(name = "duration", precision = 10, scale = 2)
    private BigDecimal duration;

    @Size(max = 1000)
    @Column(name = "notes", length = 1000)
    private String notes;

    @Size(max = 30000)
    @Column(name = "request_json", length = 30000)
    private String requestJson;

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

    @Column(name = "cc_cost", precision = 10, scale = 2)
    private BigDecimal ccCost;

    @Size(max = 100000)
    @Column(name = "cc_response", length = 100000)
    private String ccResponse;

    @Size(max = 30)
    @Column(name = "cc_order_number", length = 30)
    private String ccOrderNumber;

    @ManyToOne
    private Project project;

    @ManyToOne
    private AudioProjectFolder folder;

    @OneToMany(mappedBy = "audio")
    @JsonIgnore
    private Set<AudioClip> audioClipss = new HashSet<>();

    @OneToMany(mappedBy = "audio", fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    private Set<AudioSegment> audioSegments = new HashSet<>();

    @OneToMany(mappedBy = "audio", fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    private Set<AudioKeyword> audioKeywords = new HashSet<>();

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
    
    @Column(name = "com_closed_caption_json")
    private String comClosedCaptionJson;
    
    /* End Newly added columns for computer transcription 
     * by Vishnupriya angler 
     * on 11th May 2019
     */

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

    public String getClosedCaptionJson() {
        return closedCaptionJson;
    }

    public void setClosedCaptionJson(String closedCaptionJson) {
        this.closedCaptionJson = closedCaptionJson;
    }

    public BigDecimal getDuration() {
        return duration;
    }

    public void setDuration(BigDecimal duration) {
        this.duration = duration;
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

    public String getCcResponse() {
        return ccResponse;
    }

    public void setCcResponse(String ccResponse) {
        this.ccResponse = ccResponse;
    }

    public String getCcOrderNumber() {
        return ccOrderNumber;
    }

    public void setCcOrderNumber(String ccOrderNumber) {
        this.ccOrderNumber = ccOrderNumber;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Set<AudioClip> getAudioClipss() {
        return audioClipss;
    }

    public void setAudioClipss(Set<AudioClip> audioClips) {
        this.audioClipss = audioClips;
    }

    public Set<AudioSegment> getAudioSegments() {
        return audioSegments;
    }

    public void setAudioSegments(Set<AudioSegment> audioSegments) {
        this.audioSegments = audioSegments;
    }

    public Set<AudioKeyword> getAudioKeywords() {
        return audioKeywords;
    }

    public void setAudioKeywords(Set<AudioKeyword> audioKeywords) {
        this.audioKeywords = audioKeywords;
    }

    public AudioProjectFolder getFolder() {
        return folder;
    }

    public void setFolder(AudioProjectFolder folder) {
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

	@Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Audio audio = (Audio) o;

        if (!Objects.equals(id, audio.id)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

	@Override
	public String toString() {
		return "Audio [id=" + id + ", name=" + name + ", source=" + source
				+ ", audioBucket=" + audioBucket + ", audioPath=" + audioPath
				+ ", audioFilename=" + audioFilename + ", ccBucket=" + ccBucket
				+ ", ccPath=" + ccPath + ", ccFilename=" + ccFilename
				+ ", audioDataBucket=" + audioDataBucket + ", audioDataPath="
				+ audioDataPath + ", audioDataFilename=" + audioDataFilename
				+ ", resultCode=" + resultCode + ", resultMessage="
				+ resultMessage + ", closedCaptionJson=" + closedCaptionJson
				+ ", duration=" + duration + ", notes=" + notes
				+ ", requestJson=" + requestJson + ", ccStatus=" + ccStatus
				+ ", ccRequestedDate=" + ccRequestedDate + ", ccRequestedBy="
				+ ccRequestedBy + ", ccCost=" + ccCost + ", ccResponse="
				+ ccResponse + ", ccOrderNumber=" + ccOrderNumber
				+ ", project=" + project + ", folder=" + folder
				+ ", audioClipss=" + audioClipss + ", audioSegments="
				+ audioSegments + ", audioKeywords=" + audioKeywords
				+ ", comCcBucket=" + comCcBucket + ", comCcFileName="
				+ comCcFileName + ", comCcJobId=" + comCcJobId + ", comCcPath="
				+ comCcPath + ", comCcRequestedBy=" + comCcRequestedBy
				+ ", comCcRequestedDate=" + comCcRequestedDate
				+ ", comCcRequestedType=" + comCcRequestedType
				+ ", comCcStatus=" + comCcStatus + ", comClosedCaptionJson="
				+ comClosedCaptionJson + "]";
	}

}

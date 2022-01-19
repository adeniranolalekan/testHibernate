package com.example.testhibernate.domain.entity;


import com.example.testhibernate.domain.entity.enumeration.ImportStatus;
import com.example.testhibernate.domain.entity.enumeration.VideoSource;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Objects;

/**
 * A AudioSegment.
 */
@Entity
@Table(name = "AUDIO_SEGMENT")
public class AudioSegment extends BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Column(name = "index", nullable = false)
    private Integer index;

    @NotNull
    @Size(min = 3, max = 2048)
    @Column(name = "url", length = 2048, nullable = false)
    private String url;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "source_type", nullable = false)
    private VideoSource source;

    @Column(name = "key")
    private String key;

    @Column(name = "file_name")
    private String fileName;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "import_status", nullable = false)
    private ImportStatus importStatus;

    @Column(name = "result")
    private String result;

    //The location in s3 where this video should be imported to
    @Column(name = "s3_path")
    private String s3Path;

    //The location in s3 where this video should be imported to
    @Column(name = "s3_file_name")
    private String s3FileName;

    //The location in s3 where this video should be imported to
    @Column(name = "s3_bucket")
    private String s3Bucket;

    @Column(name = "expected_file_name")
    private String expectedFileName;

    @Column(name = "size")
    private Long size;

    @ManyToOne
    @JsonIgnore
    private Audio audio;

    @ManyToOne
    @JsonIgnore
    private User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public VideoSource getSource() {
        return source;
    }

    public void setSource(VideoSource source) {
        this.source = source;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public ImportStatus getImportStatus() {
        return importStatus;
    }

    public void setImportStatus(ImportStatus importStatus) {
        this.importStatus = importStatus;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String gets3Path() {
        return s3Path;
    }

    public void sets3Path(String s3Path) {
        this.s3Path = s3Path;
    }

    public String gets3FileName() {
        return s3FileName;
    }

    public void sets3FileName(String s3FileName) {
        this.s3FileName = s3FileName;
    }

    public String gets3Bucket() {
        return s3Bucket;
    }

    public void sets3Bucket(String s3Bucket) {
        this.s3Bucket = s3Bucket;
    }

    public String getExpectedFileName() {
        return expectedFileName;
    }

    public void setExpectedFileName(String expectedFileName) {
        this.expectedFileName = expectedFileName;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public Audio getAudio() {
        return audio;
    }

    public void setAudio(Audio audio) {
        this.audio = audio;
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

        AudioSegment audioSegment = (AudioSegment) o;

        if ( ! Objects.equals(id, audioSegment.id)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "AudioSegment{" +
                "id=" + id +
                ", index='" + index + "'" +
                ", url='" + url + "'" +
                ", source='" + source + "'" +
                ", key='" + key + "'" +
                ", fileName='" + fileName + "'" +
                ", importStatus='" + importStatus + "'" +
                ", result='" + result + "'" +
                ", s3Path='" + s3Path + "'" +
                ", s3FileName='" + s3FileName + "'" +
                ", s3Bucket='" + s3Bucket + "'" +
                ", expectedFileName='" + expectedFileName + "'" +
                ", size='" + size + "'" +
                '}';
    }
}

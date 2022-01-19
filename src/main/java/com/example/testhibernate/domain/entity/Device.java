package com.example.testhibernate.domain.entity;


import com.example.testhibernate.domain.entity.enumeration.StreamSourceType;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

/**
 * A Device.
 */
@Entity
@Table(name = "DEVICE")
//@EntityListeners(DeviceListener.class)
public class Device implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "url")
    private String url;

    @Column(name = "embed")
    private String embed;

    @NotNull
    @Column(name = "name", nullable = false)
    private String name;

    @NotNull
    @Column(name = "description", nullable = false)
    private String description;

    @NotNull
    @Column(name = "serial_number", nullable = false)
    private String serialNumber;

    @NotNull
    @Column(name = "account", nullable = false)
    private String account;

    @NotNull
    @Column(name = "broadcaster", nullable = false)
    private String broadcaster;

    @Column(name = "api_key")
    private String apiKey;

    @Column(name = "stream_name")
    private String streamName;

    @Column(name = "stream_pw")
    private String streamPw;

    @Column(name = "origin_rtmp")
    private String originRtmp;

    @Column(name = "stream_source_type")
    private StreamSourceType streamSourceType;

    @ManyToOne
    private Company company;
    
    @OneToOne
    private ZoomAccount zoom;
    
    @Column(name="device_custom_name")
    private String customName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getEmbed() {
        return embed;
    }

    public void setEmbed(String embed) {
        this.embed = embed;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getBroadcaster() {
        return broadcaster;
    }

    public void setBroadcaster(String broadcaster) {
        this.broadcaster = broadcaster;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getStreamName() {
        return streamName;
    }

    public void setStreamName(String streamName) {
        this.streamName = streamName;
    }

    public String getStreamPw() {
        return streamPw;
    }

    public void setStreamPw(String streamPw) {
        this.streamPw = streamPw;
    }

    public String getOriginRtmp() {
        return originRtmp;
    }

    public void setOriginRtmp(String originRtmp) {
        this.originRtmp = originRtmp;
    }

    public StreamSourceType getStreamSourceType() {
        return streamSourceType;
    }

    public void setStreamSourceType(StreamSourceType streamSourceType) {
        this.streamSourceType = streamSourceType;
    }

    public String getCustomName() {
		return customName;
	}

	public void setCustomName(String customName) {
		this.customName = customName;
	}

	public ZoomAccount getZoom() {
		return zoom;
	}

	public void setZoom(ZoomAccount zoom) {
		this.zoom = zoom;
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Device device = (Device) o;

        if (!Objects.equals(id, device.id)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Device{" +
                "id=" + id +
                ", url='" + url + "'" +
                ", embed='" + embed + "'" +
                ", account='" + account + "'" +
                ", broadcaster='" + broadcaster + "'" +
                ", apiKey='" + apiKey + "'" +
                '}';
    }
    

}

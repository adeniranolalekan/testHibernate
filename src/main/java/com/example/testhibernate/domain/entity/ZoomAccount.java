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

/**
 * Ab Audio.
 */
@Entity
@Table(name = "zoom_account")
public class ZoomAccount extends BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Size(min = 3, max = 140)
    @Column(name = "name", length = 140, nullable = false)
    private String name;

    @NotNull
    @Column(name = "jwt_token", nullable = false)
    private String jwtToken;
    
    @NotNull
    @Column(name = "user_id", nullable = false)
    private String userId;

    @Column(name = "jwt_expiry_on")
    //@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    @JsonSerialize(using = CustomDateTimeSerializer.class)
    @JsonDeserialize(using = CustomDateTimeDeserializer.class)
    private DateTime jwtExpiryOn;
    
    @Column(name = "token_status")
    private Boolean tokenStatus = false;

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

	public String getJwtToken() {
		return jwtToken;
	}

	public void setJwtToken(String jwtToken) {
		this.jwtToken = jwtToken;
	}

	public DateTime getJwtExpiryOn() {
		return jwtExpiryOn;
	}

	public void setJwtExpiryOn(DateTime jwtExpiryOn) {
		this.jwtExpiryOn = jwtExpiryOn;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Boolean getTokenStatus() {
		return tokenStatus;
	}

	public void setTokenStatus(Boolean tokenStatus) {
		this.tokenStatus = tokenStatus;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((jwtExpiryOn == null) ? 0 : jwtExpiryOn.hashCode());
		result = prime * result + ((jwtToken == null) ? 0 : jwtToken.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ZoomAccount other = (ZoomAccount) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (jwtExpiryOn == null) {
			if (other.jwtExpiryOn != null)
				return false;
		} else if (!jwtExpiryOn.equals(other.jwtExpiryOn))
			return false;
		if (jwtToken == null) {
			if (other.jwtToken != null)
				return false;
		} else if (!jwtToken.equals(other.jwtToken))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ZoomAccount [id=" + id + ", userId=" + userId + ", name=" + name + ", jwtToken=" + jwtToken + ", jwtExpiryOn=" + jwtExpiryOn
				+ "]";
	}

    
}

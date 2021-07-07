package com.cg.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Channel {
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private Long channelId; 
	
	private String channelName;

	

	public Long getChannelId() {
		return channelId;
	}

	public void setChannelId(Long channelId) {
		this.channelId = channelId;
	}

	public String getChannelName() {
		return channelName;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}

	@Override
	public String toString() {
		return "Channel [Id=" + channelId + ", channelName=" + channelName + "]";
	}
	
	

	
}

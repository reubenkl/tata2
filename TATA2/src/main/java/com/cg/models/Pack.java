package com.cg.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Pack implements Comparable<Pack>  {
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private Long packId;
	
    private Double packCost;
    
    private Integer packValidity;
   
    private String packDescription;
    
    private String packName;
    
    private Integer packCount = 0;
    
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Channel> channelList;
    
    @OneToMany(mappedBy = "pack", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Recharge> recharges;
    
    @ManyToOne
    @JsonBackReference
    private Account account;
    
    @Override
    public int compareTo(Pack o) {
        Pack p = (Pack) o;
        if (this.packCost > p.packCost) {
            return 1;
        } else
            return -1;
    }
    @Transient
    private long accountId;

	public Long getPackId() {
		return packId;
	}
	public void setPackId(Long id) {
		this.packId = id;
	}
	public Double getPackCost() {
		return packCost;
	}
	public void setPackCost(Double packCost) {
		this.packCost = packCost;
	}
	public Integer getPackValidity() {
		return packValidity;
	}
	public void setPackValidity(Integer packValidity) {
		this.packValidity = packValidity;
	}
	public String getPackDescription() {
		return packDescription;
	}
	public void setPackDescription(String packDescription) {
		this.packDescription = packDescription;
	}
	public String getPackName() {
		return packName;
	}
	public void setPackName(String packName) {
		this.packName = packName;
	}
	public Integer getPackCount() {
		return packCount;
	}
	public void setPackCount(Integer packCount) {
		this.packCount = packCount;
	}
	public List<Channel> getChannelList() {
		return channelList;
	}
	public void setChannelList(List<Channel> channelList) {
		this.channelList = channelList;
	}
	public List<Recharge> getRecharges() {
		return recharges;
	}
	public void setRecharges(List<Recharge> recharges) {
		this.recharges = recharges;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {}
	public long getAccountId() {
		return accountId;
	}
	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}
	@Override
	public String toString() {
		return "Pack [id=" + packId + ", packCost=" + packCost + ", packValidity=" + packValidity + ", packDescription="
				+ packDescription + ", packName=" + packName + ", packCount=" + packCount + ", channelList="
				+ channelList + ", recharges=" + recharges + ", account=" + account + ", accountId=" + accountId + "]";
	}
    
    
    
}

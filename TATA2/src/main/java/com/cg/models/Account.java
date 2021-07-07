package com.cg.models;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Account {
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private Long accountId;
	
	@NotNull
	@OneToOne(cascade = CascadeType.ALL)
	private User user;
	
	@NotNull
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME, pattern = "yyyy-MM-dd")
    private LocalDate registeredDate = LocalDate.now();
    
    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<ServiceRequest> requests;
    
    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Pack> packs ;

	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public LocalDate getRegisteredDate() {
		return registeredDate;
	}

	public void setRegisteredDate(LocalDate registeredDate) {
		this.registeredDate = registeredDate;
	}

	public List<ServiceRequest> getRequests() {
		return requests;
	}

	public void setRequests(List<ServiceRequest> requests) {
		this.requests = requests;
	}

	public List<Pack> getPacks() {
		return packs;
	}

	public void setPacks(List<Pack> packs) {
		this.packs = packs;
	}

	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", user=" + user + ", registeredDate=" + registeredDate
				+ ", requests=" + requests + ", packs=" + packs + "]";
	}

}


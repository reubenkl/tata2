package com.cg.models;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Recharge {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long rechargeId;
	
    private Double amount;
    
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME, pattern = "yyyy-MM-dd")
    private LocalDate purchasedDate = LocalDate.now();
    
    @NotNull
    @ManyToOne(cascade = CascadeType.ALL)
    private Pack pack;

	public Long getRechargeId() {
		return rechargeId;
	}

	public void setRechargeId(Long id) {
		this.rechargeId = id;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public LocalDate getPurchasedDate() {
		return purchasedDate;
	}

	public void setPurchasedDate(LocalDate purchasedDate) {
		this.purchasedDate = purchasedDate;
	}

	public Pack getPack() {
		return pack;
	}

	public void setPack(Pack pack) {
		this.pack = pack;
	}

	@Override
	public String toString() {
		return "Recharge [id=" + rechargeId + ", amount=" + amount + ", purchasedDate=" + purchasedDate + ", pack=" + pack
				+ "]";
	}
    
    
    
}

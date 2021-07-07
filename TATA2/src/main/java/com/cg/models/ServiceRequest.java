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

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class ServiceRequest {
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private Long id;
		
//		@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME, pattern = "yyyy-MM-dd")
//	    private LocalDate requestedDate;
	    
	    @ManyToOne(cascade = CascadeType.ALL)
	    @JsonBackReference
	    private Account account;
	    
	    @NotNull
	    private String message;

}

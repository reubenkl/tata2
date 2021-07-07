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
	private Long id;
	
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
    
    
    
}

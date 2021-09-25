package com.mrsac.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="rank_mst_new")
public class RankBean {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
    private int sr;
	private String Rank;
    private String rnkid;
    private String Rank_category;
    private String rcid;
    private String Staff_type;
    private String PE_DE_Cat_id;
    
    private String Cathierarchy;
    
    public int getSr() {
		return sr;
	}
	public void setSr(int sr) {
		this.sr = sr;
	}
	public String getRank() {
		return Rank;
	}
	public void setRank(String rank) {
		Rank = rank;
	}
	public String getRnkid() {
		return rnkid;
	}
	public void setRnkid(String rnkid) {
		this.rnkid = rnkid;
	}
	public String getRank_category() {
		return Rank_category;
	}
	public void setRank_category(String rank_category) {
		Rank_category = rank_category;
	}
	public String getRcid() {
		return rcid;
	}
	public void setRcid(String rcid) {
		this.rcid = rcid;
	}
	public String getStaff_type() {
		return Staff_type;
	}
	public void setStaff_type(String staff_type) {
		Staff_type = staff_type;
	}
	
	public String getCathierarchy() {
		return Cathierarchy;
	}
	public void setCathierarchy(String cathierarchy) {
		Cathierarchy = cathierarchy;
	}
	public String getPE_DE_Cat_id() {
		return PE_DE_Cat_id;
	}
	public void setPE_DE_Cat_id(String pE_DE_Cat_id) {
		PE_DE_Cat_id = pE_DE_Cat_id;
	}
	
	
	
}

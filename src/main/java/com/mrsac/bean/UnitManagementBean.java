package com.mrsac.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "master_unit_table_r1")
public class UnitManagementBean {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int	 id ;
		private int	 srno;				
		private String	  ps_code;
		private String	  zncode;
		private String	  rng_code; 
		private String	  ps_name ;
		private String	  dtename;
		 private String  ps_cctns ;
		 private String	  dg_code ;
		 private String	  cp_sp_rpf;
		 private String	  cityrange_n;
		 private String	  zone_n;
		 private String	  JURISDICTION ;
		 private String	  police_stn_lat;
		 private String	  police_stn_long ;
		 private String	  range_cent_lat;
		 private String	  range_cent_long ;
		 private String	  dist_cent_lat ;
		 private String	  dist_cent_long ; 
		  private String	  police_stn_lat_n ;
		  private String	  police_stn_long_n ;
		  private String	  population;
		  private String	  district_id ;
		  private String	  range_id ;
		  private String	  Level0 ;
		  private String	  Level1;
		  private String  Level2 ;
		  private String  Level3;
		  private String  branch ;	
		  
		  public int getSrno() {
				return srno;
			}
			public void setSrno(int srno) {
				this.srno = srno;
			}
			public int getId() {
				return id;
			}
			public void setId(int id) {
				this.id = id;
			}
			public String getPs_code() {
				return ps_code;
			}
			public void setPs_code(String ps_code) {
				this.ps_code = ps_code;
			}
			public String getZncode() {
				return zncode;
			}
			public void setZncode(String zncode) {
				this.zncode = zncode;
			}
			public String getRng_code() {
				return rng_code;
			}
			public void setRng_code(String rng_code) {
				this.rng_code = rng_code;
			}
			public String getPs_name() {
				return ps_name;
			}
			public void setPs_name(String ps_name) {
				this.ps_name = ps_name;
			}
			public String getDtename() {
				return dtename;
			}
			public void setDtename(String dtename) {
				this.dtename = dtename;
			}
			public String getPs_cctns() {
				return ps_cctns;
			}
			public void setPs_cctns(String ps_cctns) {
				this.ps_cctns = ps_cctns;
			}
			public String getDg_code() {
				return dg_code;
			}
			public void setDg_code(String dg_code) {
				this.dg_code = dg_code;
			}
			public String getCp_sp_rpf() {
				return cp_sp_rpf;
			}
			public void setCp_sp_rpf(String cp_sp_rpf) {
				this.cp_sp_rpf = cp_sp_rpf;
			}
			public String getCityrange_n() {
				return cityrange_n;
			}
			public void setCityrange_n(String cityrange_n) {
				this.cityrange_n = cityrange_n;
			}
			public String getZone_n() {
				return zone_n;
			}
			public void setZone_n(String zone_n) {
				this.zone_n = zone_n;
			}
			public String getJURISDICTION() {
				return JURISDICTION;
			}
			public void setJURISDICTION(String jURISDICTION) {
				JURISDICTION = jURISDICTION;
			}
			public String getPolice_stn_lat() {
				return police_stn_lat;
			}
			public void setPolice_stn_lat(String police_stn_lat) {
				this.police_stn_lat = police_stn_lat;
			}
			public String getPolice_stn_long() {
				return police_stn_long;
			}
			public void setPolice_stn_long(String police_stn_long) {
				this.police_stn_long = police_stn_long;
			}
			public String getRange_cent_lat() {
				return range_cent_lat;
			}
			public void setRange_cent_lat(String range_cent_lat) {
				this.range_cent_lat = range_cent_lat;
			}
			public String getRange_cent_long() {
				return range_cent_long;
			}
			public void setRange_cent_long(String range_cent_long) {
				this.range_cent_long = range_cent_long;
			}
			public String getDist_cent_lat() {
				return dist_cent_lat;
			}
			public void setDist_cent_lat(String dist_cent_lat) {
				this.dist_cent_lat = dist_cent_lat;
			}
			public String getDist_cent_long() {
				return dist_cent_long;
			}
			public void setDist_cent_long(String dist_cent_long) {
				this.dist_cent_long = dist_cent_long;
			}
			public String getPolice_stn_lat_n() {
				return police_stn_lat_n;
			}
			public void setPolice_stn_lat_n(String police_stn_lat_n) {
				this.police_stn_lat_n = police_stn_lat_n;
			}
			public String getPolice_stn_long_n() {
				return police_stn_long_n;
			}
			public void setPolice_stn_long_n(String police_stn_long_n) {
				this.police_stn_long_n = police_stn_long_n;
			}
			public String getPopulation() {
				return population;
			}
			public void setPopulation(String population) {
				this.population = population;
			}
			public String getDistrict_id() {
				return district_id;
			}
			public void setDistrict_id(String district_id) {
				this.district_id = district_id;
			}
			public String getRange_id() {
				return range_id;
			}
			public void setRange_id(String range_id) {
				this.range_id = range_id;
			}
			public String getLevel0() {
				return Level0;
			}
			public void setLevel0(String level0) {
				Level0 = level0;
			}
			public String getLevel1() {
				return Level1;
			}
			public void setLevel1(String level1) {
				Level1 = level1;
			}
			public String getLevel2() {
				return Level2;
			}
			public void setLevel2(String level2) {
				Level2 = level2;
			}
			public String getLevel3() {
				return Level3;
			}
			public void setLevel3(String level3) {
				Level3 = level3;
			}
			public String getBranch() {
				return branch;
			}
			public void setBranch(String branch) {
				this.branch = branch;
			}
			

}

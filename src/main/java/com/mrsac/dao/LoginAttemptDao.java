package com.mrsac.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mrsac.bean.LoginAttemptBean;

@Repository
public interface LoginAttemptDao extends JpaRepository<LoginAttemptBean, Long> {

	
	@Modifying(clearAutomatically = true)
	@Query(value = "update tbl_login_attempt set end_session =:end_session where attempt_id =:attempt_id" ,nativeQuery = true)
	public void logoutUser(@Param("end_session") String end_session , @Param("attempt_id") int attempt_id);
	
	@Query(value = "select * from tbl_login_attempt where start_session like :date%" , nativeQuery = true)
	public List<LoginAttemptBean> getLoginHistoryCurrentMonth(@Param("date") String date);
	
	@Query(value = "select * from tbl_login_attempt where start_session between STR_TO_DATE(:fromDate, '%Y-%m-%d %H:%i:%s') and STR_TO_DATE(:toDate, '%Y-%m-%d %H:%i:%s')",nativeQuery = true)
	public List<LoginAttemptBean> getLoginHistoryMonthWise(@Param("fromDate") String fromDate , @Param("toDate") String toDate);
}

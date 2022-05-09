package com.ecom.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="emp_leave")
public class LeaveModel {
	
	@Id
	@Column(name="leave_id")
	private int id;

	@Column(name="leave_applying_date")
	private Date leaveApplyingDate;

	@Column(name="leave_type")
	private String leaveType;

	@Column(name="leave_from_date")
	private Date leaveFromDate;

	@Column(name="leave_to_date")
	private Date leaveToDate;

	@Column(name="emp_id")
	private String empoyeeId;

	@Column(name="emp_reporting_authority")
	private String empReportingAuthority;

	@Column(name="leave_duration")
	private int leaveDuration;

	@Column(name="leave_reason")
	private String leaveReason;

	@Column(name="reporting_autority_comments")
	private String reportingAutorityComments;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getLeaveApplyingDate() {
		return leaveApplyingDate;
	}

	public void setLeaveApplyingDate(Date leaveApplyingDate) {
		this.leaveApplyingDate = leaveApplyingDate;
	}

	public String getLeaveType() {
		return leaveType;
	}

	public void setLeaveType(String leaveType) {
		this.leaveType = leaveType;
	}

	public Date getLeaveFromDate() {
		return leaveFromDate;
	}

	public void setLeaveFromDate(Date leaveFromDate) {
		this.leaveFromDate = leaveFromDate;
	}

	public Date getLeaveToDate() {
		return leaveToDate;
	}

	public void setLeaveToDate(Date leaveToDate) {
		this.leaveToDate = leaveToDate;
	}

	public String getEmpoyeeId() {
		return empoyeeId;
	}

	public void setEmpoyeeId(String empoyeeId) {
		this.empoyeeId = empoyeeId;
	}

	public String getEmpReportingAuthority() {
		return empReportingAuthority;
	}

	public void setEmpReportingAuthority(String empReportingAuthority) {
		this.empReportingAuthority = empReportingAuthority;
	}

	public int getLeaveDuration() {
		return leaveDuration;
	}

	public void setLeaveDuration(int leaveDuration) {
		this.leaveDuration = leaveDuration;
	}

	public String getLeaveReason() {
		return leaveReason;
	}

	public void setLeaveReason(String leaveReason) {
		this.leaveReason = leaveReason;
	}

	public String getReportingAutorityComments() {
		return reportingAutorityComments;
	}

	public void setReportingAutorityComments(String reportingAutorityComments) {
		this.reportingAutorityComments = reportingAutorityComments;
	}

	@Override
	public String toString() {
		return "LeaveModel [id=" + id + ", leaveApplyingDate=" + leaveApplyingDate + ", leaveType=" + leaveType
				+ ", leaveFromDate=" + leaveFromDate + ", leaveToDate=" + leaveToDate + ", empoyeeId=" + empoyeeId
				+ ", empReportingAuthority=" + empReportingAuthority + ", leaveDuration=" + leaveDuration
				+ ", leaveReason=" + leaveReason + ", reportingAutorityComments=" + reportingAutorityComments + "]";
	}
}

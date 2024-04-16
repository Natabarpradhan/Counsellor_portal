package Natabarit.entity;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
@Entity
public class Enquiry {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer enqId;
private String stuName;
private Long stuPhon;
private String mode;
private String course;
private String status;

@CreationTimestamp
private LocalDate createdDate;

@UpdateTimestamp
private LocalDate updatedDate;
@ManyToOne
@JoinColumn(name="counsellor_id")
private Counsellor counsellor;
public Integer getEnqId() {
	return enqId;
}
public void setEnqId(Integer enqId) {
	this.enqId = enqId;
}
public String getStuName() {
	return stuName;
}
public void setStuName(String stuName) {
	this.stuName = stuName;
}
public Long getStuPhon() {
	return stuPhon;
}
public void setStuPhon(Long stuPhon) {
	this.stuPhon = stuPhon;
}
public String getMode() {
	return mode;
}
public void setMode(String mode) {
	this.mode = mode;
}
public String getCourse() {
	return course;
}
public void setCourse(String course) {
	this.course = course;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public LocalDate getCreatedDate() {
	return createdDate;
}
public void setCreatedDate(LocalDate createdDate) {
	this.createdDate = createdDate;
}
public LocalDate getUpdatedDate() {
	return updatedDate;
}
public void setUpdatedDate(LocalDate updatedDate) {
	this.updatedDate = updatedDate;
}
public Counsellor getCounsellor() {
	return counsellor;
}
public void setCounsellor(Counsellor counsellor) {
	this.counsellor = counsellor;
}



}

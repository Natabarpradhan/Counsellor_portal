package Natabarit.entity;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Counsellor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer counsellerId;
private String name;
private String email;
private String pwd;
private Long phno;

@CreationTimestamp
private LocalDate createDate;
@UpdateTimestamp 
private LocalDate updateDate;
@OneToMany(mappedBy = "counsellor",cascade = CascadeType.ALL)
private List<Enquiry> enquirie;
	public Integer getCounsellerId() {
		return counsellerId;
	}
	public void setCounsellerId(Integer counsellerId) {
		this.counsellerId = counsellerId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public Long getPhno() {
		return phno;
	}
	public void setPhno(Long phno) {
		this.phno = phno;
	}
	public LocalDate getCreateDate() {
		return createDate;
	}
	public void setCreateDate(LocalDate createDate) {
		this.createDate = createDate;
	}
	public LocalDate getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(LocalDate updateDate) {
		this.updateDate = updateDate;
	}
	public List<Enquiry> getEnquirie() {
		return enquirie;
	}
	public void setEnquirie(List<Enquiry> enquirie) {
		this.enquirie = enquirie;
	}


}

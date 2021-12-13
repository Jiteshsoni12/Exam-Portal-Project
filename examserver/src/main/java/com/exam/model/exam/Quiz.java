package com.exam.model.exam;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="quiz")
public class Quiz {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long qId;
	private String title;
	private String discription;
	
	private String maxMarks;
	private String numberOfQutions;
	
	private boolean active = false;
	
	@ManyToOne
	private Category category;
	
	@OneToMany(mappedBy = "quiz",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JsonIgnore
	private Set<Question> quitions = new HashSet<>();
	
	public Quiz() {}

	public Quiz(String title, String discription, String maxMarks, String numberOfQutions, boolean active) {
		this.title = title;
		this.discription = discription;
		this.maxMarks = maxMarks;
		this.numberOfQutions = numberOfQutions;
		this.active = active;
	}

	public Long getqId() {
		return qId;
	}

	public void setqId(Long qId) {
		this.qId = qId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDiscription() {
		return discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}

	public String getMaxMarks() {
		return maxMarks;
	}

	public void setMaxMarks(String maxMarks) {
		this.maxMarks = maxMarks;
	}

	public String getNumberOfQutions() {
		return numberOfQutions;
	}

	public void setNumberOfQutions(String numberOfQutions) {
		this.numberOfQutions = numberOfQutions;
	}


	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Set<Question> getQuitions() {
		return quitions;
	}

	public void setQuitions(Set<Question> quitions) {
		this.quitions = quitions;
	}
	
	
	
}

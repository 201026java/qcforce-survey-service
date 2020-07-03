package com.revature.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "response", schema = "qcforce_survey")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Response implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	private int id; // primary key

	@Column(name = "response_ts")
	private Timestamp submittedResponseTs;

	@ManyToOne
	@JoinColumn(name = "form_id")
	private Form form; // foreign key form_id

	@OneToMany(mappedBy = "response", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Answer> answers = new ArrayList<Answer>();

	public Response() {
		super();
	}

	public Response(int id, Timestamp submittedResponseTs, Form form, List<Answer> answers) {
		super();
		this.id = id;
		this.submittedResponseTs = submittedResponseTs;
		this.form = form;
		this.answers = answers;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Timestamp getSubmittedResponseTs() {
		return submittedResponseTs;
	}

	public void setSubmittedResponseTs(Timestamp submittedResponseTs) {
		this.submittedResponseTs = submittedResponseTs;
	}

	public Form getForm() {
		return form;
	}

	public void setForm(Form form) {
		this.form = form;
	}

	public List<Answer> getAnswers() {
		return answers;
	}

	public void addAnswers(Answer answer) {
		this.answers.add(answer);
	}

	@Override
	public String toString() {
		return "Response [id=" + id + ", submittedResponseTs=" + submittedResponseTs + ", form=" + form + ", answers="
				+ answers + "]";
	}

}
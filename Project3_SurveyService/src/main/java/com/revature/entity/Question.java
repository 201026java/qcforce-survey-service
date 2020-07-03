package com.revature.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "question", schema = "qcforce_survey")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Question implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;// PK

	@Column(name = "question_string")
	private String questionString;

	/*
	 * @OneToMany private int formId;// FK
	 */

	@ManyToOne
	@JoinColumn(name = "form_id")
	private Form form; // foreign key form_id

	@OneToMany(mappedBy = "question", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Answer> answers = new ArrayList<Answer>();

	public Question() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Question(int id, String questionString, Form form, List<Answer> answers) {
		super();
		this.id = id;
		this.questionString = questionString;
		this.form = form;
		this.answers = answers;
	}

	public Question(Form form) {
		super();
		this.form = form;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getQuestionString() {
		return questionString;
	}

	public void setQuestionString(String questionString) {
		this.questionString = questionString;
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
		return "Question [id=" + id + ", questionString=" + questionString + ", form=" + form + ", answers=" + answers
				+ "]";
	}

}
package com.xdf.exams.bean;

import java.util.HashSet;
import java.util.Set;


/**
 * Question generated by MyEclipse - Hibernate Tools
 */

public class Question  implements java.io.Serializable {


    // Fields    

     private Long questionid;
     private Subject subject;
     private String content;
     private int score;
     private int qtype;
     private String rightanswer;
     private String sdate;
     private Set optionses = new HashSet(0);
     private Set examrecords = new HashSet(0);


    // Constructors

    /** default constructor */
    public Question() {
    }

	/** minimal constructor */
    public Question(Subject subject, String content, int score, String rightanswer, String sdate) {
        this.subject = subject;
        this.content = content;
        this.score = score;
        this.rightanswer = rightanswer;
        this.sdate = sdate;
    }
    
    /** full constructor */
    public Question(Subject subject, String content, int score, String rightanswer, String sdate, Set optionses, Set examrecords) {
        this.subject = subject;
        this.content = content;
        this.score = score;
        this.rightanswer = rightanswer;
        this.sdate = sdate;
        this.optionses = optionses;
        this.examrecords = examrecords;
    }

   
    // Property accessors

    public Long getQuestionid() {
        return this.questionid;
    }
    
    public void setQuestionid(Long questionid) {
        this.questionid = questionid;
    }

    public Subject getSubject() {
        return this.subject;
    }
    
    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public String getContent() {
        return this.content;
    }
    
    public void setContent(String content) {
        this.content = content;
    }

    public int getScore() {
        return this.score;
    }
    
    public void setScore(int score) {
        this.score = score;
    }

    public String getRightanswer() {
        return this.rightanswer;
    }
    
    public void setRightanswer(String rightanswer) {
        this.rightanswer = rightanswer;
    }

    public String getSdate() {
        return this.sdate;
    }
    
    public void setSdate(String sdate) {
        this.sdate = sdate;
    }

    public Set getOptionses() {
        return this.optionses;
    }
    
    public void setOptionses(Set optionses) {
        this.optionses = optionses;
    }

    public Set getExamrecords() {
        return this.examrecords;
    }
    
    public void setExamrecords(Set examrecords) {
        this.examrecords = examrecords;
    }

	public int getQtype() {
		return qtype;
	}

	public void setQtype(int qtype) {
		this.qtype = qtype;
	}
   








}
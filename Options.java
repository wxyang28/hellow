package com.xdf.exams.bean;



/**
 * Options generated by MyEclipse - Hibernate Tools
 */

public class Options  implements java.io.Serializable {


    // Fields    

     private Long optionid;
     private Question question;
     private String content;


    // Constructors

    /** default constructor */
    public Options() {
    }

    
    /** full constructor */
    public Options(Question question, String content) {
        this.question = question;
        this.content = content;
    }

   
    // Property accessors

    public Long getOptionid() {
        return this.optionid;
    }
    
    public void setOptionid(Long optionid) {
        this.optionid = optionid;
    }

    public Question getQuestion() {
        return this.question;
    }
    
    public void setQuestion(Question question) {
        this.question = question;
    }

    public String getContent() {
        return this.content;
    }
    
    public void setContent(String content) {
        this.content = content;
    }
   








}
package com.ryxx.bpim.entity;


/**
 * author Delgado
 */
public class QuestionAnswer extends VoBase
{
    
    /** 序列号 */
    private static final long serialVersionUID = 2859075908176503625L;
    
    private Long id;
    
    private String keyword;
    
    private String question;
    
    private String answer;
    
    private UserInfo questionUser;
    
    private UserInfo answerUser;
    
    private String type;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the question
	 */
	public String getQuestion() {
		return question;
	}

	/**
	 * @param question the question to set
	 */
	public void setQuestion(String question) {
		this.question = question;
	}

	/**
	 * @return the answer
	 */
	public String getAnswer() {
		return answer;
	}

	/**
	 * @param answer the answer to set
	 */
	public void setAnswer(String answer) {
		this.answer = answer;
	}

	/**
	 * @return the questionUser
	 */
	public UserInfo getQuestionUser() {
		return questionUser;
	}

	/**
	 * @param questionUser the questionUser to set
	 */
	public void setQuestionUser(UserInfo questionUser) {
		this.questionUser = questionUser;
	}

	/**
	 * @return the answerUser
	 */
	public UserInfo getAnswerUser() {
		return answerUser;
	}

	/**
	 * @param answerUser the answerUser to set
	 */
	public void setAnswerUser(UserInfo answerUser) {
		this.answerUser = answerUser;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the keyword
	 */
	public String getKeyword() {
		return keyword;
	}

	/**
	 * @param keyword the keyword to set
	 */
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	
    
    
}

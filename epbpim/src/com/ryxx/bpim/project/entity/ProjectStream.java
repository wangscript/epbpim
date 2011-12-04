/**
 * 
 */
package com.ryxx.bpim.project.entity;

import com.ryxx.bpim.entity.VoBase;
import com.ryxx.bpim.user.entity.UserInfo;

/**
 * @author Delgado Ding
 *
 */
public class ProjectStream extends VoBase{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5824525163798153024L;

	
	private Long id;
	private Long projectId;
	private UserInfo submitter;
	private int streamType;
	private double mondy;
	private String comments;
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
	 * @return the projectId
	 */
	public Long getProjectId() {
		return projectId;
	}
	/**
	 * @param projectId the projectId to set
	 */
	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}
	/**
	 * @return the submitter
	 */
	public UserInfo getSubmitter() {
		return submitter;
	}
	/**
	 * @param submitter the submitter to set
	 */
	public void setSubmitter(UserInfo submitter) {
		this.submitter = submitter;
	}
	/**
	 * @return the streamType
	 */
	public int getStreamType() {
		return streamType;
	}
	/**
	 * @param streamType the streamType to set
	 */
	public void setStreamType(int streamType) {
		this.streamType = streamType;
	}
	/**
	 * @return the mondy
	 */
	public double getMondy() {
		return mondy;
	}
	/**
	 * @param mondy the mondy to set
	 */
	public void setMondy(double mondy) {
		this.mondy = mondy;
	}
	/**
	 * @return the comments
	 */
	public String getComments() {
		return comments;
	}
	/**
	 * @param comments the comments to set
	 */
	public void setComments(String comments) {
		this.comments = comments;
	}
	
	
	
}

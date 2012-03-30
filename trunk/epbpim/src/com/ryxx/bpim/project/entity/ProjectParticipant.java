/**
 * 
 */
package com.ryxx.bpim.project.entity;

import com.ryxx.bpim.entity.VoBase;

/**
 * @author Delgado Ding
 *
 */
public class ProjectParticipant extends VoBase
{
    
    /** 序列号 */
    private static final long serialVersionUID = 7769144412814247787L;
    
    private long participantID;
    
    private String participantName;
    
    public long getParticipantID()
    {
        return participantID;
    }
    
    public void setParticipantID(long participantID)
    {
        this.participantID = participantID;
    }
    
    public String getParticipantName()
    {
        return participantName;
    }
    
    public void setParticipantName(String participantName)
    {
        this.participantName = participantName;
    }
    
}

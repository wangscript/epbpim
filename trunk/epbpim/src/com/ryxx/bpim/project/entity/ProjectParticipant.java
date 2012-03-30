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
    
    private String participant;
    
    public String getParticipant()
    {
        return participant;
    }
    
    public void setParticipant(String participant)
    {
        this.participant = participant;
    }
    
}

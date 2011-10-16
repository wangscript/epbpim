package com.ryxx.bpim.dao;

import java.util.List;

import com.ryxx.bpim.entity.GuideData;

/**
 * author Delgado
 */
public interface GuideDataDAO extends BaseDAO<GuideData, Long>
{
    
    void saveGuideData(GuideData guideData);
    
    void deleteGuideData(GuideData guideData);
    
    List<GuideData> listGuideData(GuideData guideData);
    
    List<GuideData> getGuideData(GuideData guideData);
    
    int getRowCount(GuideData guideData);
    
}

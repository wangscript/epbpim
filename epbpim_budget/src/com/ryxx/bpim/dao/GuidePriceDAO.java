package com.ryxx.bpim.dao;

import java.util.List;

import com.ryxx.bpim.entity.GuidePrice;

/**
 * author Delgado
 */
public interface GuidePriceDAO extends BaseDAO<GuidePrice, Long>
{
    
    void saveGuidePrice(GuidePrice guidePrice);
    
    void deleteGuidePrice(GuidePrice guidePrice);
    
    List<GuidePrice> listGuidePrice(GuidePrice guidePrice);
    
    int getRowCount(GuidePrice guidePrice);
    
}

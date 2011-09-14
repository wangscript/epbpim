package com.ryxx.bpim.dao;

import java.util.List;

import com.ryxx.bpim.entity.NewsAnnouncement;

public interface NewsAnnounceDAO extends BaseDAO<NewsAnnouncement, Long>
{
    void saveNewsAnnouncement(NewsAnnouncement newsAnnouncement);
    
    void deleteNewsAnnouncement(NewsAnnouncement newsAnnouncement);
    
    NewsAnnouncement viewNewsAnnouncement(NewsAnnouncement newsAnnouncement);
    
    List<NewsAnnouncement> listNewsAnnouncement(NewsAnnouncement newsAnnouncement);
    
    int getRowCount(NewsAnnouncement newsAnnouncement);
}

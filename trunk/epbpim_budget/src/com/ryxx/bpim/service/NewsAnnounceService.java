package com.ryxx.bpim.service;

import java.util.List;

import com.ryxx.bpim.dao.NewsAnnounceDAO;
import com.ryxx.bpim.entity.NewsAnnouncement;

public interface NewsAnnounceService extends BaseService<NewsAnnouncement, NewsAnnounceDAO, Long>
{
    List<NewsAnnouncement> findAll();
    
    public NewsAnnouncement getNews(NewsAnnouncement newsAnnouncement);
    
    boolean insertNews(NewsAnnouncement newsAnnouncement);
    
    boolean updateNews(NewsAnnouncement newsAnnouncement);
    
    boolean deleteNews(NewsAnnouncement newsAnnouncement);
}

package com.ryxx.bpim.system.service;

import java.util.List;

import com.ryxx.bpim.service.BaseService;
import com.ryxx.bpim.system.dao.NewsAnnounceDAO;
import com.ryxx.bpim.system.entity.NewsAnnouncement;

public interface NewsAnnounceService extends BaseService<NewsAnnouncement, NewsAnnounceDAO, Long>
{
    List<NewsAnnouncement> findAll();
    
    public NewsAnnouncement getNews(NewsAnnouncement newsAnnouncement);
    
    boolean saveNews(NewsAnnouncement newsAnnouncement);
    
    boolean updateNews(NewsAnnouncement newsAnnouncement);
    
    boolean deleteNews(NewsAnnouncement newsAnnouncement);
}

package com.ryxx.bpim.service;

import java.util.List;

import com.ryxx.bpim.dao.NewsAnnounceDAO;
import com.ryxx.bpim.entity.NewsAnnouncement;

public class NewsAnnounceServiceImpl extends AbstractService<NewsAnnouncement, NewsAnnounceDAO, Long> implements NewsAnnounceService
{
    
    
    public List<NewsAnnouncement> findAll()
    {
        return getDao().listNewsAnnouncement(null);
    }
    
    public NewsAnnouncement getNews(NewsAnnouncement newsAnnouncement)
    {
        return getDao().viewNewsAnnouncement(newsAnnouncement);
    }
    
    public boolean insertNews(NewsAnnouncement newsAnnouncement)
    {
        getDao().save(newsAnnouncement);
        return true;
    }
    
    public boolean updateNews(NewsAnnouncement newsAnnouncement)
    {
        getDao().save(newsAnnouncement);
        return true;
    }
    
    public boolean deleteNews(NewsAnnouncement newsAnnouncement)
    {
        getDao().remove(newsAnnouncement);
        return true;
    }
    
}

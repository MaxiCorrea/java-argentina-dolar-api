package com.argentina.dolar.api.news.economy.repository;

import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.argentina.dolar.api.news.economy.scraper.NewsEconomyScraper;
import com.argentina.dolar.api.news.shared.News;

@Repository
public class NewsEconomyRepository {

  @Autowired
  private NewsEconomyScraper scraper;
  
  public List<News> getNews(
      final String url) throws IOException {
    return scraper.scrap(url);
  }
  
}

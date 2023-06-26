package com.argentina.dolar.api.news.technology.repository;

import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.argentina.dolar.api.news.shared.News;
import com.argentina.dolar.api.news.technology.scraper.NewsTechnologyScraper;

@Repository
public class NewsTechnologyRepository {

  @Autowired
  private NewsTechnologyScraper scraper;

  public List<News> getNews(
      final String url) throws IOException {
    return scraper.scrap(url);
  }

}

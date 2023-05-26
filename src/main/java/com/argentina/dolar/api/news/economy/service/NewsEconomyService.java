package com.argentina.dolar.api.news.economy.service;

import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.argentina.dolar.api.news.economy.repository.NewsEconomyRepository;
import com.argentina.dolar.api.news.shared.News;

@Service
public class NewsEconomyService {

  @Value("${dolarsi.news.economy.url}")
  private String economyNewsUrlPath;  
  
  @Autowired
  private NewsEconomyRepository repository;

  public List<News> getNews() throws IOException {
    return repository.getNews(economyNewsUrlPath);
  }

  public List<News> getNews(
      final Integer pageNumber) throws IOException {
    String basePath = economyNewsUrlPath;
    String path = String.format("%s/page/%d/",basePath, pageNumber);
    return repository.getNews(path);
  }
  
}

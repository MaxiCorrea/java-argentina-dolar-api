package com.argentina.dolar.api.news.technology.service;

import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.argentina.dolar.api.news.shared.News;
import com.argentina.dolar.api.news.technology.repository.NewsTechnologyRepository;

@Service
public class NewsTechnologyService {

  @Value("${dolarsi.news.technology.url}")
  private String technologyNewsUrlPath;  
  
  @Autowired
  private NewsTechnologyRepository repository;

  public List<News> getNews() throws IOException {
    return repository.getNews(technologyNewsUrlPath);
  }

  public List<News> getNews(
      final Integer pageNumber) throws IOException {
    String basePath = technologyNewsUrlPath;
    String path = String.format("%s/page/%d/",basePath, pageNumber);
    return repository.getNews(path);
  }
  
}

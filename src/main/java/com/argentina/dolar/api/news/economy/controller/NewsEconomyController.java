package com.argentina.dolar.api.news.economy.controller;

import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.argentina.dolar.api.news.economy.service.NewsEconomyService;
import com.argentina.dolar.api.news.shared.News;

@RestController
@RequestMapping("news")
public class NewsEconomyController {

  @Autowired
  private NewsEconomyService service;
  
  @GetMapping("/economy")
  public ResponseEntity<List<News>> getEconomyNews() throws IOException {
    return ResponseEntity.ok(service.getNews());
  }
  
  @GetMapping("/economy/page/{pageNumber}")
  public ResponseEntity<List<News>> getEconomyNews(
      @PathVariable final Integer pageNumber) throws IOException {
    return ResponseEntity.ok(service.getNews(pageNumber));
  }
  
}

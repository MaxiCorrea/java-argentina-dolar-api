package com.argentina.dolar.api.news.technology.controller;

import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.argentina.dolar.api.news.shared.News;
import com.argentina.dolar.api.news.technology.service.NewsTechnologyService;
import io.swagger.annotations.Api;

@RestController
@Api(tags = "News Technology")
@RequestMapping("news")
public class NewsTechnologyController {

  @Autowired
  private NewsTechnologyService service;
  
  @GetMapping("/technology")
  public ResponseEntity<List<News>> getTechnologyNews() throws IOException {
    return ResponseEntity.ok(service.getNews());
  }
  
  @GetMapping("/technology/page/{pageNumber}")
  public ResponseEntity<List<News>> getTechnologyNews(
      @PathVariable final Integer pageNumber) throws IOException {
    return ResponseEntity.ok(service.getNews(pageNumber));
  }
  
}

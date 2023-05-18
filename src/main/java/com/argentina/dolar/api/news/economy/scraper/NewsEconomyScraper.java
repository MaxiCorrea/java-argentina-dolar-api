package com.argentina.dolar.api.news.economy.scraper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Attribute;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;
import com.argentina.dolar.api.news.shared.News;

@Component
public class NewsEconomyScraper {

  public List<News> scrap(
      final String url) throws IOException {
    Document document = Jsoup.connect(url).get();
    Element element = document.getElementById("blog-grid");
    Elements elements = element.getElementsByClass("content_wrapper");
    int srcIdx = 0;
    List<String> srcImgList = new ArrayList<>();
    for(Element e : element.getElementsByClass("entry-content-media")) {
      for(Element img : e.getElementsByTag("img")) {
        for(Attribute att : img.attributes()) {
          if("src".equals(att.getKey())) {
            srcImgList.add(att.getValue());
          }
        }
      }
    }
    List<News> news = new ArrayList<>();
    for(Element tag : elements) {
      String titleValue = null;
      String hrefValue = null;
      String imageValue = null;
      String contentValue = null;
      for(Element header : tag.getElementsByClass("entry-header")) {
        if(srcIdx < srcImgList.size()) {
          imageValue = srcImgList.get(srcIdx++);
        }
        for(Element title : header.getElementsByClass("entry-title")) {
          for(Element tagA : title.getElementsByTag("a")) {
            for(Attribute att : tagA.attributes()) {
              if("title".equals(att.getKey())) {
                titleValue = att.getValue();
              }
              if("href".equals(att.getKey())) {
                hrefValue = att.getValue();
              }
            }
          }
        }
      }
      for(Element content : tag.getElementsByClass("entry-content")) {
        Elements tagsP = content.getElementsByTag("p");
        if(!tagsP.isEmpty()) {
          contentValue = tagsP.get(0).text();
        }
      }
      news.add(new News(imageValue, titleValue, contentValue, hrefValue));
    }
    return news;
  }
  
}

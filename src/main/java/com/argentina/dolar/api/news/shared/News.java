package com.argentina.dolar.api.news.shared;

public class News {

  private String image;
  private String title;
  private String content;
  private String href;
 
  public News(
      final String image,
      final String title,
      final String content,
      final String href) {
    this.image = image;
    this.title = title;
    this.content = content;
    this.href = href;
  }

  public String getImage() {
    return image;
  }

  public String getTitle() {
    return title;
  }

  public String getContent() {
    return content;
  }

  public String getHref() {
    return href;
  }
  
}

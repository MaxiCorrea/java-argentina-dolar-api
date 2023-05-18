package com.argentina.dolar.api.main.repository;

import static org.springframework.http.HttpMethod.GET;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.client.ClientHttpRequest;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.RestTemplate;
import com.argentina.dolar.api.main.domain.Dollar;
import com.argentina.dolar.api.main.extractor.DollarExtractor;

@Repository
public class DollarRepository {

  @Autowired
  private DollarExtractor dollarExtractor;
  
  public List<Dollar> getPrices(
      final String dollarYesUrl) {
    try {
      RestTemplate template = new RestTemplate();
      URI url = new URI(dollarYesUrl);
      RequestCallback callback = (ClientHttpRequest r) -> {};
      return template.execute(url, GET, callback, dollarExtractor);
    } catch (URISyntaxException e) {
      e.printStackTrace();
      return Collections.emptyList();
    }
  }
  
}

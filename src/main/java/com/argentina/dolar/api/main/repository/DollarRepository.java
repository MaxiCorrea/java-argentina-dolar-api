package com.argentina.dolar.api.main.repository;

import static org.springframework.http.HttpMethod.GET;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.client.ClientHttpRequest;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.RestTemplate;
import com.argentina.dolar.api.main.domain.Dollar;
import com.argentina.dolar.api.main.extractor.DollarExtractor;

@Repository
public class DollarRepository {

  @Value("${dolarsi.url}")
  private String dolarSiURL;
  
  @Autowired
  private DollarExtractor dolarExtractor;
  
  public List<Dollar> getPrices() {
    try {
      RestTemplate template = new RestTemplate();
      URI url = new URI(dolarSiURL);
      RequestCallback callback = (ClientHttpRequest r) -> {};
      return template.execute(url, GET, callback, dolarExtractor);
    } catch (URISyntaxException e) {
      e.printStackTrace();
      return Collections.emptyList();
    }
  }
  
}

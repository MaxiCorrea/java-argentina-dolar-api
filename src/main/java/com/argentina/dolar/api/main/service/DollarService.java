package com.argentina.dolar.api.main.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.argentina.dolar.api.main.domain.Dollar;
import com.argentina.dolar.api.main.repository.DollarRepository;

@Service
public class DollarService {

  @Value("${dolarsi.url}")
  private String dollarYesUrl;
  
  @Autowired
  private DollarRepository dollarRepository;
  
  public List<Dollar> getDollarPrices() {
    return dollarRepository.getPrices(dollarYesUrl);
  }
  
}

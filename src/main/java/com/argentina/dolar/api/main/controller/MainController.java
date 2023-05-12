package com.argentina.dolar.api.main.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.argentina.dolar.api.main.domain.Dollar;
import com.argentina.dolar.api.main.service.DollarService;

@RestController
@RequestMapping("main")
public class MainController {

  @Autowired
  private DollarService dollarService;

  @GetMapping("/")
  public ResponseEntity<List<Dollar>> getDollarPrices() {
    return ResponseEntity.ok(dollarService.getDollarPrices());
  }

}

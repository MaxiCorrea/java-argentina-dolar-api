package com.argentina.dolar.api.main.domain;

import java.math.BigDecimal;

public class Dollar {
  
  private BigDecimal buys;
  private BigDecimal sale;
  private Integer agency;
  private String name;
  private Double variation;
  private Boolean saleZero;
  private Integer decimals;
  
  public Dollar(
      final BigDecimal buys, 
      final BigDecimal sale, 
      final Integer agency, 
      final String name, 
      final Double variation,
      final Boolean saleZero, 
      final Integer decimals) {
    
    this.buys = buys;
    this.sale = sale;
    this.agency = agency;
    this.name = name;
    this.variation = variation;
    this.saleZero = saleZero;
    this.decimals = decimals;
  }

  public BigDecimal getBuys() {
    return buys;
  }

  public BigDecimal getSale() {
    return sale;
  }

  public Integer getAgency() {
    return agency;
  }

  public String getName() {
    return name;
  }

  public Double getVariation() {
    return variation;
  }

  public Boolean getSaleZero() {
    return saleZero;
  }

  public Integer getDecimals() {
    return decimals;
  }
   
}

package com.argentina.dolar.api.main.domain;

import java.math.BigDecimal;

public class DollarCreator {

  public static final Dollar createOfStrings(
      final String compra, 
      final String venta, 
      final String agencia,
      final String nombre,
      final String variacion, 
      final String ventaCero, 
      final String decimales) {
    
    return new Dollar(
        toBigDecimal(compra),
        toBigDecimal(venta),
        Integer.valueOf(agencia),
        String.valueOf(nombre),
        Double.valueOf(variacion.replaceAll("[,]", ".")),
        Boolean.valueOf(ventaCero),
        Integer.valueOf(decimales)
      );
  }
  
  private static BigDecimal toBigDecimal(
      final String text) {
    try {
      String parsed = text.replaceAll("[,]", ".");
      return new BigDecimal(parsed);
    } catch (Exception ex) {
      return null;
    }
  }
  
}

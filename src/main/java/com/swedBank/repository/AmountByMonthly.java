package com.swedBank.repository;

import java.util.HashMap;

public class AmountByMonthly {
  public static final String PROP_DATE = "date";
  public static final String PROP_SUMPRICE= "price";

  private String date;
  private double price;

  public AmountByMonthly(HashMap<String, Object> values) {
    this.date = (String) values.get(PROP_DATE);
    this.price  = (Long) values.get(PROP_SUMPRICE);
  }
}

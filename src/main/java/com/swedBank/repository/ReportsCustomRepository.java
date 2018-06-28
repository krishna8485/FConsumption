package com.swedBank.repository;

import java.util.*;

public interface ReportsCustomRepository{
  List<?>  getTotalAmountSpent(String driverId);
  List<?>  consumpationByMonth(String driverId, String month);
}
package com.swedBank.repository;

import java.util.*;

public interface ReportsCustomRepository{
  List<?>  findRegistrationCount(String driverId);
  List<?>  findConsumpationByMonth(String driverId, String month);
}
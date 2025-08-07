package com.abhi.service;

import com.abhi.model.Tourist;

import java.util.List;

public interface ITouristMgmtService {
    String registerTourist(Tourist tourist);

    List<Tourist> fetchAllTourists();

    Tourist fetchTouristById(Integer id);

    String updateTouristByDetails(Tourist tourist);

    String updateTouristBudgetById(Integer id, Float hikePercent);

    String deleteTouristById(Integer id);
}

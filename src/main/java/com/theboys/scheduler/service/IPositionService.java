package com.theboys.scheduler.service;

import com.theboys.scheduler.dto.PositionDto;

import java.util.List;

public interface IPositionService {
    List<PositionDto> findAll();
    PositionDto findById(int theId);
    PositionDto save(PositionDto thePosition);
    void deleteById(int theId);
}

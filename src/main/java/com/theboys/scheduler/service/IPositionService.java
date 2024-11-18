package com.theboys.scheduler.service;

import com.theboys.scheduler.dto.PositionDto;
import com.theboys.scheduler.entity.Position;

import java.util.List;

public interface IPositionService {
    List<PositionDto> findAll();
    PositionDto findById(int theId);
    PositionDto save(Position thePosition);
    void deleteById(int theId);
}

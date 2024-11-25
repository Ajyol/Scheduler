package com.theboys.scheduler.service;

import com.theboys.scheduler.dao.PositionRepository;
import com.theboys.scheduler.dto.PositionDto;
import com.theboys.scheduler.entity.Position;
import com.theboys.scheduler.exception.PositionNotFoundException;
import com.theboys.scheduler.mapper.EntityDtoMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PositionService implements IPositionService{
    private final PositionRepository positionRepository;
    private final EntityDtoMapper entityDtoMapper;

    public PositionService(PositionRepository positionRepository, EntityDtoMapper entityDtoMapper) {
        this.positionRepository = positionRepository;
        this.entityDtoMapper = entityDtoMapper;
    }

    @Override
    public List<PositionDto> findAll() {
        List<Position> positions = positionRepository.findAll();
        return entityDtoMapper.mapPositionsToDtoList(positions);
    }

    @Override
    public PositionDto findById(int theId) {
        Optional<Position> position = positionRepository.findById(theId);
        return position.map(entityDtoMapper::mapPositionToDto)
                .orElseThrow(() -> new PositionNotFoundException("Department with ID " + theId + " not found"));
    }

    @Override
    public PositionDto save(PositionDto thePosition) {
        Position position = entityDtoMapper.mapPositionDtoToEntity(thePosition);
        position = positionRepository.save(position);
        return entityDtoMapper.mapPositionToDto(position);
    }

    @Override
    public void deleteById(int theId) {
        if (!positionRepository.existsById(theId)) {
            throw new PositionNotFoundException("Position with ID " + theId + " not found");
        }
        positionRepository.deleteById(theId);
    }
}

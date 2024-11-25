package com.theboys.scheduler.controller;


import com.theboys.scheduler.dto.PositionDto;
import com.theboys.scheduler.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PositionController {

    private final PositionService positionService;

    @Autowired
    public PositionController(PositionService positionService) {
        this.positionService = positionService;
    }

    @GetMapping("/positions")
    public List<PositionDto> findAllPositions() { return positionService.findAll(); }

    @GetMapping("/positions/{positionId}")
    public ResponseEntity<PositionDto> getPositionById(@PathVariable int positionId) {
        PositionDto positionDto = positionService.findById(positionId);
        return new ResponseEntity<>(positionDto, HttpStatus.OK);
    }

    @PostMapping("/positions")
    public ResponseEntity<PositionDto> addPosition(@RequestBody PositionDto positionDto) {
        PositionDto savedPosition = positionService.save(positionDto);
        return new ResponseEntity<>(savedPosition, HttpStatus.CREATED);
    }

    @PutMapping("/positions")
    public ResponseEntity<PositionDto> updatedPosition(@RequestBody PositionDto positionDto) {
        PositionDto updatedPosition = positionService.save(positionDto);
        return new ResponseEntity<>(updatedPosition, HttpStatus.OK);
    }

    @DeleteMapping("/positions/{positionId}")
    public ResponseEntity<String> deletePosition(@PathVariable int positionId) {
        positionService.deleteById(positionId);
        return new ResponseEntity<>("Position deleted successfully.", HttpStatus.OK);
    }
}

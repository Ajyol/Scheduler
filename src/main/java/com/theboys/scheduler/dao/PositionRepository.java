package com.theboys.scheduler.dao;

import com.theboys.scheduler.entity.Position;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PositionRepository extends JpaRepository<Position, Long> {
}

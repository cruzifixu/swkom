package at.fhtw.swen3.services;

import at.fhtw.swen3.persistence.entities.HopEntity;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.Optional;

@Service
public interface HopService {
    Optional<HopEntity> getHop(Long code) throws SQLException;
}

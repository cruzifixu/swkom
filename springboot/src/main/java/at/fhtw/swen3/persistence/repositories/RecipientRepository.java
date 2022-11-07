package at.fhtw.swen3.persistence.repositories;

import at.fhtw.swen3.persistence.entity.Recipient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipientRepository extends JpaRepository<Recipient, Long> {
    List<Recipient> findByName(String name);
}

package at.fhtw.swen3.persistence.repositories;
import java.util.List;

import at.fhtw.swen3.services.dto.WebHook;
import org.springframework.data.repository.CrudRepository;

public interface WebhookRepository  extends CrudRepository<WebHook, Long>{

    public List<WebHook> findByTypeAndData(String type, String data);

    public List<WebHook> findByData(String type);
}

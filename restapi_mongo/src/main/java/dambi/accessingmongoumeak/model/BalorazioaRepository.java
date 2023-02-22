package dambi.accessingmongoumeak.model;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BalorazioaRepository {

    List<Balorazioa> findAll();
}

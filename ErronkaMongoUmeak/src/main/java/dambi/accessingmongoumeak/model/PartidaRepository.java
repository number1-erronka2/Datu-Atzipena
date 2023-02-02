package dambi.accessingmongoumeak.model;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface PartidaRepository {
    List<Partida> findAll();
}

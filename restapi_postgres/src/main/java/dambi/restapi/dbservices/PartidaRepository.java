package dambi.restapi.dbservices;

import org.springframework.data.repository.CrudRepository;
import dambi.restapi.domainobject.*;

public interface PartidaRepository extends CrudRepository<Partida, Integer> {

    Iterable<Partida> findAll();

    Partida findById(int id);
}

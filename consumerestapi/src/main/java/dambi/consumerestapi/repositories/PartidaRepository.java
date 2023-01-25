package dambi.consumerestapi.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;

import dambi.consumerestapi.domainObjects.Partida;

@Repository
public interface PartidaRepository {

    Partida save(Partida partida);

    List<Partida> findAll();

    void update(Partida partida);

    long delete(int id);

    Partida findById(int id);

}

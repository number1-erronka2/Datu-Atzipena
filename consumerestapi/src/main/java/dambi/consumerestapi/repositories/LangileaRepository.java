package dambi.consumerestapi.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;

import dambi.consumerestapi.domainObjects.Langilea;

@Repository
public interface LangileaRepository {
    
    Langilea save(Langilea person);

    List<Langilea> findAll();

    void update(Langilea person);

    long delete(String izena);

    Langilea findById(String id);
}

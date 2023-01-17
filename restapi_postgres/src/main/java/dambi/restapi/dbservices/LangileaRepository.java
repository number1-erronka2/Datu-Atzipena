package dambi.restapi.dbservices;

import org.springframework.data.repository.CrudRepository;
import dambi.restapi.domainobject.*;

public interface LangileaRepository extends CrudRepository<Langilea, Integer> {

    Langilea findByIzena(String izena);

}

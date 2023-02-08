package dambi.accessingmongoumeak.model;

import org.springframework.stereotype.Repository;


@Repository
public interface LangileaRepository {
    Langilea findByIzena(String izena);
}

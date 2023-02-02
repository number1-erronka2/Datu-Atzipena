package dambi.accessingmongoumeak.model;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface PartidaRepository {
    List<Partida> findAll();
    Partida findById(int id);
    List<Partida> findByPuntuazioa(int puntuazioa);
    List<Partida> findByIzena(String erabiltzailea);
    List<Partida> findByEmail(String email);
    List<Partida> findByTaldea(int taldea);

}

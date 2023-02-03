package dambi.accessingmongoumeak.model;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface PartidaRepository {
    List<Partida> findAll();

    Partida findById(int id);

    List<Partida> findByPuntuazioa(int puntuazioa);

    List<Partida> findByErabiltzaileIzena(String erabiltzailea);

    List<Partida> findByEmail(String email);

    List<Partida> findByTaldea(int taldea);

    //List<Partida> findByData(Date data);

}

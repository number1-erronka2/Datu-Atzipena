package dambi.restapi.domainobject;

import java.util.Date;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data //getter, setter, toString, equals
@NoArgsConstructor //automatically generates a constructor with no parameters
@AllArgsConstructor //automatically generates a constructor with all parameters
@Entity(name = "partida")
@Table(name = "partida")
public class Partida {
    
    @Id //primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @JoinColumn(name = "erabiltzailea", nullable = false)
    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private Langilea langilea;

    @Column(name = "puntuazioa")
    private float puntuazioa;

    @Column(name = "data")
    private Date data;

}

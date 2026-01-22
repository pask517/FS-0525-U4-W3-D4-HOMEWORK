package andreapascarella;

import andreapascarella.dao.EventsDAO;
import andreapascarella.dao.LocationsDAO;
import andreapascarella.dao.PersonDAO;
import andreapascarella.entities.Concert;
import andreapascarella.entities.FootballMatch;
import andreapascarella.entities.Location;
import andreapascarella.entities.Person;
import andreapascarella.enums.EventType;
import andreapascarella.enums.GenderType;
import andreapascarella.enums.GenreType;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("FS-0525-U4-W3-D4-HOMEWORKpu");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();

        LocationsDAO ld = new LocationsDAO(em);

        EventsDAO ed = new EventsDAO(em);

        PersonDAO pd = new PersonDAO(em);

        Location sanSiro = new Location("Stadio San Siro", "Milano");
        Location arenaDiVerona = new Location("Arena di Verona", "Verona");
        Location stadioOlimpico = new Location("Stadio Olimpico", "Roma");

        //ld.saveLocation(sanSiro);
        //ld.saveLocation(arenaDiVerona);
        //ld.saveLocation(stadioOlimpico);

        Location sanSiroFromDB = ld.findById("b78dc915-2522-4c29-ace7-533cbbabeac7");
        Location stadioOlimpicoFromDB = ld.findById("5a0d8de7-4b6d-497a-932b-15abbf40bc94");
        Location arenaDiVeronaFromDB = ld.findById("0276d795-df79-4d3c-aae7-85cdb2209507");

        FootballMatch interJuve = new FootballMatch("Inter-Juventus", LocalDate.of(2026, 4, 22), "Bella partita", EventType.PUBLIC, 20000, sanSiroFromDB, "Inter", "Juventus", "Inter", 3, 1);
        Concert concertoPupo = new Concert("Concerto di Pupo", LocalDate.of(2026, 3, 6), "Pupissimo", EventType.PUBLIC, 20, arenaDiVeronaFromDB, GenreType.CLASSIC, true);

        //ed.saveEvent(interJuve);
        //ed.saveEvent(concertoPupo);

        Person andrea = new Person("Andrea", "Pascarella", "andreapascarella@ciao.com", LocalDate.of(1999, 12, 27), GenderType.MALE);
        Person benedetta = new Person("Benedetta", "Giuliano", "benedettagiuliano@ciao.com", LocalDate.of(2004, 10, 21), GenderType.FEMALE);

        //pd.savePerson(andrea);
        //pd.savePerson(benedetta);

        /*Person andreaFromDB = pd.findById("242f9cf5-18eb-4057-a012-bbdcbe76ac1e");
        Person benedettaFromDB = pd.findById("d541fa62-7b9e-4918-b142-0b2c64f8dd3c");

        AthleticsCompetition garaAtletica = new AthleticsCompetition("Gara atletica", LocalDate.of(2026, 6, 13), "Molto atletica", EventType.PRIVATE, 200, stadioOlimpicoFromDB, andreaFromDB);
        AthleticsCompetition garaCanto = new AthleticsCompetition("Gara di canto", LocalDate.of(2026, 11, 10), "Poco atletica", EventType.PRIVATE, 100, arenaDiVeronaFromDB, benedettaFromDB);
        AthleticsCompetition garaBallo = new AthleticsCompetition("Gara di ballo", LocalDate.of(2026, 7, 15), "Mediamente atletica", EventType.PUBLIC, 1000, arenaDiVeronaFromDB, benedettaFromDB);

        garaBallo.getAthletes().add(andreaFromDB);
        garaBallo.getAthletes().add(benedettaFromDB);

        System.out.println(garaBallo.getAthletes());
        ed.saveEvent(garaBallo);*/

        System.out.println("Hello World!");

        em.close();
        emf.close();
    }
}

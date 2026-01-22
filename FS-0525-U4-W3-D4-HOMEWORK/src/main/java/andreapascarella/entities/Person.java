package andreapascarella.entities;


import andreapascarella.enums.GenderType;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "persons")
public class Person {

    @Id
    @GeneratedValue
    @Column(name = "person_id")
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String surname;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private LocalDate birthDate;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private GenderType genderType;

    @OneToMany(mappedBy = "owner")
    private List<Participation> participations;

    @OneToOne(mappedBy = "winner")
    private AthleticsCompetition wonCompetition;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private AthleticsCompetition competition;

    public Person() {
    }

    public Person(String name, String surname, String email, LocalDate birthDate, GenderType genderType) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.birthDate = birthDate;
        this.genderType = genderType;
    }

    public UUID getPersonId() {
        return id;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public GenderType getGenderType() {
        return genderType;
    }

    public List<Participation> getParticipations() {
        return participations;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", birthDate=" + birthDate +
                ", genderType=" + genderType +
                ", participations=" + participations +
                '}';
    }
}

package andreapascarella.entities;

import andreapascarella.enums.EventType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import java.time.LocalDate;

@Entity
public class FootballMatch extends Event {

    @Column(nullable = false)
    private String homeTeam;

    @Column(nullable = false)
    private String awayTeam;

    private String winnerTeam;

    private int homeTeamGoals;

    private int awayTeamGoals;

    public FootballMatch() {
    }

    public FootballMatch(String title, LocalDate eventDate, String description, EventType eventType, int maxNumberOfPartecipants, Location eventLocation, String homeTeam, String awayTeam, String winnerTeam, int homeTeamGoals, int awayTeamGoals) {
        super(title, eventDate, description, eventType, maxNumberOfPartecipants, eventLocation);
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.winnerTeam = winnerTeam;
        this.homeTeamGoals = homeTeamGoals;
        this.awayTeamGoals = awayTeamGoals;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public String getWinnerTeam() {
        return winnerTeam;
    }

    public int getHomeTeamGoals() {
        return homeTeamGoals;
    }

    public int getAwayTeamGoals() {
        return awayTeamGoals;
    }

    @Override
    public String toString() {
        return super.toString() +
                "homeTeam='" + homeTeam + '\'' +
                ", awayTeam='" + awayTeam + '\'' +
                ", winnerTeam='" + winnerTeam + '\'' +
                ", homeTeamGoals=" + homeTeamGoals +
                ", awayTeamGoals=" + awayTeamGoals +
                '}';
    }
}

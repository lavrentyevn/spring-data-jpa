package com.nikolay.footballer;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "awarding")
public class Awarding {
    @EmbeddedId
    private AwardingId awardingId;
    @ManyToOne
    @MapsId("footballerId")
    @JoinColumn(
            name = "footballer_id",
            foreignKey = @ForeignKey(
                    name = "footballer_id_fk"
            )
    )
    private Footballer footballer;

    @ManyToOne
    @MapsId("achievementId")
    @JoinColumn(
            name = "achievement_id",
            foreignKey = @ForeignKey(
                    name = "achievement_id_fk"
            )
    )
    private Achievement achievement;

    @Column(
            name = "awarding_date",
            nullable = false
    )
    private LocalDateTime awardingDate;

    public Awarding(AwardingId awardingId, Footballer footballer, Achievement achievement, LocalDateTime awardingDate) {
        this.awardingId = awardingId;
        this.footballer = footballer;
        this.achievement = achievement;
        this.awardingDate = awardingDate;
    }

    public Awarding() {
    }

    public Awarding(Footballer footballer, Achievement achievement, LocalDateTime awardingDate) {
        this.footballer = footballer;
        this.achievement = achievement;
        this.awardingDate = awardingDate;
    }

    public AwardingId getAwardingId() {
        return awardingId;
    }

    public void setAwardingId(AwardingId awardingId) {
        this.awardingId = awardingId;
    }

    public Footballer getFootballer() {
        return footballer;
    }

    public void setFootballer(Footballer footballer) {
        this.footballer = footballer;
    }

    public Achievement getAchievement() {
        return achievement;
    }

    public void setAchievement(Achievement achievement) {
        this.achievement = achievement;
    }

    public LocalDateTime getAwardingDate() {
        return awardingDate;
    }

    public void setAwardingDate(LocalDateTime awardingDate) {
        this.awardingDate = awardingDate;
    }
}

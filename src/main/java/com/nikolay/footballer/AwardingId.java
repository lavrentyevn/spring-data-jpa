package com.nikolay.footballer;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class AwardingId implements Serializable {
    @Column(name = "footballer_id")
    private Long footballerId;
    @Column(name = "achievement_id")
    private Long achievementId;

    public AwardingId() {
    }

    public AwardingId(Long footballerId, Long achievementId) {
        this.footballerId = footballerId;
        this.achievementId = achievementId;
    }

    public Long getFootballerId() {
        return footballerId;
    }

    public void setFootballerId(Long footballerId) {
        this.footballerId = footballerId;
    }

    public Long getAchievementId() {
        return achievementId;
    }

    public void setAchievementId(Long achievementId) {
        this.achievementId = achievementId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AwardingId that = (AwardingId) o;
        return Objects.equals(footballerId, that.footballerId) && Objects.equals(achievementId, that.achievementId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(footballerId, achievementId);
    }
}

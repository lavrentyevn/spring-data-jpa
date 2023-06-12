package com.nikolay.footballer;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "transfer_history")
public class TransferHistory {
    @Id
    @SequenceGenerator(
            name = "transfer_history_seq",
            sequenceName = "transfer_history_seq",
            allocationSize = 1)
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "transfer_history_seq"
    )
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;
    @Column(
            name = "team_name",
            nullable = false
    )
    private String teamName;
    @Column(
            name = "transfer_date",
            nullable = false
    )
    private LocalDateTime transferDate;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @JoinColumn(
            name = "footballer_id",
            referencedColumnName = "id",
            nullable = false,
            foreignKey = @ForeignKey(
                    name = "footballer_id_fk"
            )
    )
    private Footballer footballer;

    public TransferHistory(String teamName, LocalDateTime transferDate, Footballer footballer) {
        this.teamName = teamName;
        this.transferDate = transferDate;
        this.footballer = footballer;
    }

    public TransferHistory() {
    }

    public TransferHistory(String teamName, LocalDateTime transferDate) {
        this.teamName = teamName;
        this.transferDate = transferDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public LocalDateTime getTransferDate() {
        return transferDate;
    }

    public void setTransferDate(LocalDateTime transferDate) {
        this.transferDate = transferDate;
    }

    public Footballer getFootballer() {
        return footballer;
    }

    public void setFootballer(Footballer footballer) {
        this.footballer = footballer;
    }
}

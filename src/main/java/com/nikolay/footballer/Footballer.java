package com.nikolay.footballer;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "footballer")
public class Footballer {
    @Id
    @SequenceGenerator(
            name = "footballer_seq",
            sequenceName = "footballer_seq",
            allocationSize = 1)
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "footballer_seq"
    )
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;
    @Column(
            name = "first_name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String firstName;
    @Column(
            name = "last_name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String lastName;
    @Column(
            name = "email",
            nullable = false,
            columnDefinition = "TEXT",
            unique = true
    )
    private String email;
    @Column(
            name = "birthday",
            nullable = false,
            columnDefinition = "TIMESTAMP WITHOUT TIME ZONE"
    )
    private LocalDateTime birthday;

    @OneToOne(
            mappedBy = "footballer",
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
            orphanRemoval = true
    )
    private FootballerIdCard footballerIdCard;

    @OneToMany(
            mappedBy = "footballer",
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
            orphanRemoval = true
    )
    private List<TransferHistory> transferHistories = new ArrayList<>();

    @OneToMany(
            mappedBy = "footballer",
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE}
    )
    private List<Awarding> awardings = new ArrayList<>();

    public Footballer() {
    }

    public Footballer(String firstName, String lastName, String email, LocalDateTime birthday) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.birthday = birthday;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDateTime birthday) {
        this.birthday = birthday;
    }

    public FootballerIdCard getFootballerIdCard() {
        return footballerIdCard;
    }

    public void setFootballerIdCard(FootballerIdCard footballerIdCard) {
        this.footballerIdCard = footballerIdCard;
    }

    public List<TransferHistory> getTransferHistories() {
        return transferHistories;
    }

    public void setTransferHistories(List<TransferHistory> transferHistories) {
        this.transferHistories = transferHistories;
    }

    public void addTransfer(TransferHistory transferHistory) {
        if(!this.transferHistories.contains(transferHistory)) {
            this.transferHistories.add(transferHistory);
            transferHistory.setFootballer(this);
        }
    }

    public void removeTransfer(TransferHistory transferHistory) {
        if(this.transferHistories.contains(transferHistory)) {
            this.transferHistories.remove(transferHistory);
            transferHistory.setFootballer(null);
        }
    }

    public List<Awarding> getAwardings() {
        return awardings;
    }

    public void setAwardings(List<Awarding> awardings) {
        this.awardings = awardings;
    }

    public void addAwarding(Awarding awarding) {
        if(!awardings.contains(awarding)) {
            awardings.add(awarding);
        }
    }

    public void removeAwarding(Awarding awarding) {
        awardings.remove(awarding);
    }
}

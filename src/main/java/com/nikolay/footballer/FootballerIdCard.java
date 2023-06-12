package com.nikolay.footballer;

import jakarta.persistence.*;

@Entity
@Table(name = "footballer_id_card")
public class FootballerIdCard {
    @Id
    @SequenceGenerator(
            name = "footballer_id_card_seq",
            sequenceName = "footballer_id_card_seq",
            allocationSize = 1)
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "footballer_id_card_seq"
    )
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;
    @Column(
            name = "card_number",
            nullable = false,
            unique = true
    )
    private String cardNumber;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @JoinColumn(
            name = "footballer_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "footballer_id_fk"
            )
    )
    private Footballer footballer;

    public FootballerIdCard() {
    }

    public FootballerIdCard(String cardNumber, Footballer footballer) {
        this.cardNumber = cardNumber;
        this.footballer = footballer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Footballer getFootballer() {
        return footballer;
    }

    public void setFootballer(Footballer footballer) {
        this.footballer = footballer;
    }
}

package com.nikolay.footballer;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "achievement")
public class Achievement {
    @Id
    @SequenceGenerator(
            name = "achievement_seq",
            sequenceName = "achievement_seq",
            allocationSize = 1)
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "achievement_seq"
    )
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;

    @Column(
            name = "name",
            nullable = false
    )
    private String name;
    @Column(
            name = "type",
            nullable = false
    )
    private String type;

    @OneToMany(
            mappedBy = "achievement",
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE}
    )
    private List<Awarding> awardings = new ArrayList<>();

    public Achievement() {
    }

    public Achievement(String name, String type, List<Awarding> awardings) {
        this.name = name;
        this.type = type;
        this.awardings = awardings;
    }

    public Achievement(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public Achievement(Long id, String name, String type, List<Awarding> awardings) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.awardings = awardings;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

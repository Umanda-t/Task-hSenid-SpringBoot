package com.example.assignment.model;
import jakarta.persistence.*;

@Entity
@Table(name = "markstable")
public class Marks {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rid;

    @ManyToOne
    @JoinColumn(name = "studentid", nullable = false)
    private Students id;
    @Column(nullable = false, length = 90)
    private float maths;

    @Column(nullable = false, length = 90)
    private float science;

    @Column(nullable = false, length = 90)
    private float engish;

    @Column(nullable = false, length = 90)
    private float history;


    @Column(nullable = false, length = 90)
    private float sinhala;

    public Long getRid() {
        return rid;
    }

    public void setRid(Long rid) {
        this.rid = rid;
    }

    public Students getId() {
        return id;
    }

    public void setId(Students id) {
        this.id = id;
    }

    public float getMaths() {
        return maths;
    }

    public void setMaths(float maths) {
        this.maths = maths;
    }

    public float getScience() {
        return science;
    }

    public void setScience(float science) {
        this.science = science;
    }

    public float getEngish() {
        return engish;
    }

    public void setEngish(float engish) {
        this.engish = engish;
    }

    public float getHistory() {
        return history;
    }

    public void setHistory(float history) {
        this.history = history;
    }

    public float getSinhala() {
        return sinhala;
    }

    public void setSinhala(float sinhala) {
        this.sinhala = sinhala;
    }
}


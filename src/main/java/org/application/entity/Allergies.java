package org.application.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "allergies")
public class Allergies {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long allergies_id;

    @Column(name = "category")
    private String category;

    @Column(name = "clinical_status")
    private String clinicalStatus;

    @Column(name = "severity")
    private String severity;

    @OneToOne
    @JoinColumn(name = "clinical_id")
    private Clinical clinical;

    public Allergies() {
    }
    public Allergies(String category, String clinicalStatus, String severity) {
        this.category = category;
        this.clinicalStatus = clinicalStatus;
        this.severity = severity;
    }

    public Long getAllergies_id() {
        return allergies_id;
    }

    public void setAllergies_id(Long allergies_id) {
        this.allergies_id = allergies_id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getClinicalStatus() {
        return clinicalStatus;
    }

    public void setClinicalStatus(String clinicalStatus) {
        this.clinicalStatus = clinicalStatus;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public Clinical getClinical() {
        return clinical;
    }

    public void setClinical(Clinical clinical) {
        this.clinical = clinical;
    }

}

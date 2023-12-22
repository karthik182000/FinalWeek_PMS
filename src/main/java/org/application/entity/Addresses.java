package org.application.entity;
import jakarta.persistence.*;

@Entity
@Table(name = "addresses")
public class Addresses {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long adresses_id;

    private String type;
    private String line1;
    private String line2;
    private String city;

    @Column(name = "zip_code")
    private Long zipCode;

    @Column(name = "state_code")
    private Long stateCode;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;
    public Addresses() {
    }
    public Addresses(String type, String line1, String line2, String city, Long zipCode, Long stateCode, Patient patient) {
        this.type = type;
        this.line1 = line1;
        this.line2 = line2;
        this.city = city;
        this.zipCode = zipCode;
        this.stateCode = stateCode;
        this.patient = patient;
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLine1() {
        return line1;
    }

    public void setLine1(String line1) {
        this.line1 = line1;
    }

    public String getLine2() {
        return line2;
    }

    public void setLine2(String line2) {
        this.line2 = line2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Long getZipCode() {
        return zipCode;
    }

    public void setZipCode(Long zipCode) {
        this.zipCode = zipCode;
    }

    public Long getStateCode() {
        return stateCode;
    }

    public void setStateCode(Long stateCode) {
        this.stateCode = stateCode;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}


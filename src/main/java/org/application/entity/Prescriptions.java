package org.application.entity;
import jakarta.persistence.*;

@Entity
@Table(name = "prescriptions")
public class Prescriptions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long prescriptions_id;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @Column(name = "ndc")
    private Long ndc;

    @Column(name = "rx_number")
    private String rxNumber;

    @Column(name = "drug_name")
    private String drugName;

    private String strength;
    private String strengthUnits;
    private Integer supply;
    private Integer refills;


    public Prescriptions() {
    }
    public Prescriptions(Long ndc, String rxNumber, String drugName, String strength, String strengthUnits,
                        Integer supply, Integer refills, Patient patient) {
        this.ndc = ndc;
        this.rxNumber = rxNumber;
        this.drugName = drugName;
        this.strength = strength;
        this.strengthUnits = strengthUnits;
        this.supply = supply;
        this.refills = refills;
        this.patient = patient;
    }

    public Long getPrescriptions_id() {
        return prescriptions_id;
    }

    public void setPrescriptions_id(Long prescriptions_id) {
        this.prescriptions_id = prescriptions_id;
    }

    public Long getNdc() {
        return ndc;
    }
    public void setNdc(Long ndc) {
        this.ndc = ndc;
    }

    public String getRxNumber() {
        return rxNumber;
    }
    public void setRxNumber(String rxNumber) {
        this.rxNumber = rxNumber;
    }

    public String getDrugName() {
        return drugName;
    }
    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }

    public String getStrength() {
        return strength;
    }
    public void setStrength(String strength) {
        this.strength = strength;
    }

    public String getStrengthUnits() {
        return strengthUnits;
    }
    public void setStrengthUnits(String strengthUnits) {
        this.strengthUnits = strengthUnits;
    }

    public Integer getSupply() {
        return supply;
    }
    public void setSupply(Integer supply) {
        this.supply = supply;
    }

    public Integer getRefills() {
        return refills;
    }
    public void setRefills(Integer refills) {
        this.refills = refills;
    }

    public Patient getPatient() {
        return patient;
    }
    public void setPatient(Patient patient) {
        this.patient = patient;
    }

}


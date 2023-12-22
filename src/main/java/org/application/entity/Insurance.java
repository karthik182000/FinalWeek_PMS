package org.application.entity;



import jakarta.persistence.*;

@Entity
@Table(name = "insurance")
public class Insurance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long insurance_id;

    @Column(name = "policy_holder_first_name")
    private String policyHolderFirstname;

    @Column(name = "policy_holder_last_name")
    private String policyHolderLastname;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    public Insurance() {

    }

    public Long getInsurance_id() {
        return insurance_id;
    }

    public void setInsurance_id(Long insurance_id) {
        this.insurance_id = insurance_id;
    }

    public String getPolicyHolderFirstname() {
        return policyHolderFirstname;
    }
    public void setPolicyHolderFirstname(String policyHolderFirstname) {
        this.policyHolderFirstname = policyHolderFirstname;
    }

    public String getPolicyHolderLastname() {
        return policyHolderLastname;
    }
    public void setPolicyHolderLastname(String policyHolderLastname) {
        this.policyHolderLastname = policyHolderLastname;
    }

    public Patient getPatient() {
        return patient;
    }
    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}

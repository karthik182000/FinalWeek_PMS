package org.application.entity;
import jakarta.persistence.*;
import java.util.List;
import java.time.LocalDate;

@Entity
@Table(name = "patients")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long patient_id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;
    private String gender;

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
    private List<Clinical> clinicalList;

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
    private List<Insurance> insuranceList;

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
    private List<Addresses> addressList;

    @OneToMany(mappedBy="patient",cascade=CascadeType.ALL)
    private List<Prescriber> prescriberList;


    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
    private List<Prescriptions> prescriptionList;

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
    private List<Contact> contactList;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


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

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }


    public Patient() {

    }


    public List<Clinical> getClinicalList() {
        return clinicalList;
    }

    public void setClinicalList(List<Clinical> clinicalList) {
        this.clinicalList = clinicalList;
    }



    public List<Insurance> getInsuranceList() {
        return insuranceList;
    }



    public void setInsuranceList(List<Insurance> insuranceList) {
        this.insuranceList = insuranceList;
    }

    public List<Addresses> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<Addresses> addressList) {
        this.addressList = addressList;
    }




    public List<Prescriptions> getPrescriptionList() {
        return prescriptionList;
    }

    public void setPrescriptionList(List<Prescriptions> prescriptionList) {
        this.prescriptionList = prescriptionList;
    }


    public void setUser(User user) {
    }

    public Object getPatient_id() {
        return patient_id;
    }


    public List<Contact> getContactList() {
        return contactList;
    }

    public void setContactList(List<Contact> contactList) {
        this.contactList = contactList;
    }

    public List<Prescriber> getPrescriberList() {
        return prescriberList;
    }

    public void setPrescriberList(List<Prescriber> prescriberList) {
        this.prescriberList = prescriberList;
    }
}

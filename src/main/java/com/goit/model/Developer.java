package com.goit.model;

import com.goit.dao.dao_tables_interfaces.Identity;
import java.util.Date;

public class Developer implements Identity {
  private Long id;
  private String lastName;
  private String firstName;
  private String surname;
  private Integer developerAge;
  private Date dateOfBirth;
  private String gender;
  private Long companyId;
  private Double salary;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getSurname() {
    return surname;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  public Integer getDeveloperAge() {
    return developerAge;
  }

  public void setDeveloperAge(Integer developerAge) {
    this.developerAge = developerAge;
  }

  public Date getDateOfBirth() {
    return dateOfBirth;
  }

  public void setDateOfBirth(Date dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public Long getCompanyId() {
    return companyId;
  }

  public void setCompanyId(Long companyId) {
    this.companyId = companyId;
  }

  public Double getSalary() {
    return salary;
  }

  public void setSalary(Double salary) {
    this.salary = salary;
  }

  @Override
  public String toString() {
    return "Developer{" +
        "id=" + id +
        ", lastName='" + lastName + '\'' +
        ", firstName='" + firstName + '\'' +
        ", surname='" + surname + '\'' +
        ", developerAge=" + developerAge +
        ", dateOfBirth='" + dateOfBirth + '\'' +
        ", gender='" + gender + '\'' +
        ", companyId=" + companyId +
        ", salary=" + salary +
        '}';
  }
}
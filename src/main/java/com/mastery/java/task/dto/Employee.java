package com.mastery.java.task.dto;
import javax.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long   employee_id;

    @Column
    private String first_name;

    @Column
    private String last_name;

    @Column
    private String department_id;

    @Column
    private String job_title;

    @Column
    private String gender;

    @Column
    private String date_of_birth;

    // This default constructor is required if there are other constructors.
    public Employee() {
    }

    public Employee(Long employee_id,
                    String first_name,
                    String last_name,
                    String department_id,
                    String job_title,
                    String gender,
                    String date_of_birth)
    {
        this.employee_id   = employee_id;
        this.first_name    = first_name;
        this.last_name     = last_name;
        this.department_id = department_id;
        this.job_title     = job_title;
        this.gender        = gender;
        this.date_of_birth = date_of_birth;
    }

    // Getters
    public Long getemployee_id() {
        return employee_id;
    }

    public String getfirst_name() {
        return first_name;
    }

    public String getlast_name() {
        return last_name;
    }

    public String getdepartment_id() {
        return department_id;
    }

    public String getjob_title() {
        return job_title;
    }

    public String getgender() {
        return gender;
    }

    public String getdate_of_birth() {
        return date_of_birth;
    }

    // Setters
    public void setemployee_id(Long employee_id) {
        this.employee_id = employee_id;
    }

    public void setfirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setlast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setdepartment_id(String department_id) {
        this.department_id = department_id;
    }

    public void setjob_title(String job_title) {
        this.job_title = job_title;
    }

    public void setgender(String gender) {
        this.gender = gender;
    }

    public void setdate_of_birth(String date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + employee_id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", department_id='" + department_id + '\'' +
                ", job_title='" + job_title + '\'' +
                ", gender='" + gender + '\'' +
                ", date_of_birth='" + date_of_birth + '\'' +
                '}';
    }
}

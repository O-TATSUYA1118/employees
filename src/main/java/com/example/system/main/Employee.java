package com.example.system.main;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

//Entityを使うことでテーブルが作成される
@Entity
public class Employee {
//	プライマリーキー
    @Id
//    連番が自動で振られる
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    private String name;
    @NotNull
    @Min(value = 0)
    @Max(value = 130)
    private Integer age;
    private String sex;
    @NotEmpty
    @Size(max = 30)
    private String address;
    @NotEmpty
    @Size(max = 30)
    private String department;

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
    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }
    public String getSex() {
        return sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
    public String getAddress() {
        return  address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public String getDepartment() {
        return department;
    }
    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + ", age=" + age + ", sex=" + sex + ", adress=" + address + ", department=" + department +"]";
    }
}
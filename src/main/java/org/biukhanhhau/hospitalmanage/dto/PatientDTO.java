package org.biukhanhhau.hospitalmanage.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
public class PatientDTO {
    private String name;
    private String age;
    private String problem;
    private List<Integer> nurses;

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProblem() {
        return problem;
    }

    public void setProblem(String problem) {
        this.problem = problem;
    }

    public List<Integer> getNurses() {
        return nurses;
    }

    public void setNurses(List<Integer> nurses) {
        this.nurses = nurses;
    }
}

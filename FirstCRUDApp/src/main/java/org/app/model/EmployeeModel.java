package org.app.model;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeModel extends DeptModel
{
    private int id;
    private String name;
    private String email;
    private String contact;
    private int salary;
    private int deptid;
    
}

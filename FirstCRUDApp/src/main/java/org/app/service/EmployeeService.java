package org.app.service;

import java.util.*;

import org.app.model.DeptModel;
import org.app.model.EmployeeModel;


public interface EmployeeService 
{
   public boolean isAddEmployee(EmployeeModel model);
   public Optional<List<DeptModel>> getAllDeptList(DeptService deptService);
   public List<DeptModel> getDeptForEmployee();
   public List<Object[]> getEmployeeWithDept();
   boolean isDeleteEmployee(int id);
   boolean isUpdateEmployee(EmployeeModel model);
}

package org.app.repository;

import org.app.model.EmployeeModel;
import java.util.*;
public interface EmployeeRepository 
{
  public boolean isAddNewEmployee(EmployeeModel Model);
  public List<Object[]> getEmployeeWithDept();
  boolean isDeleteEmployee(int id);
  boolean isUpdateEmployee(EmployeeModel model);
}

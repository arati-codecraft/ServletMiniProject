package org.app.service;

import java.util.List;
import java.util.Optional;

import org.app.model.DeptModel;
import org.app.model.EmployeeModel;
import org.app.repository.EmployeeRepository;
import org.app.repository.EmployeeRepositoryImpl;

public class EmployeeServiceImpl implements EmployeeService{

	 EmployeeRepository empRepo=new EmployeeRepositoryImpl();
	@Override
	public boolean isAddEmployee(EmployeeModel model) {
		// TODO Auto-generated method stub
		return empRepo.isAddNewEmployee(model);
	}

	@Override
	public Optional<List<DeptModel>> getAllDeptList(DeptService deptService) {
		Optional<List<DeptModel>> o=  deptService.getAllDepts();
		return o;
				
	}

	@Override
	public List<DeptModel> getDeptForEmployee() 
	{
		DeptService deptService=new DeptServiceImpl();
	    Optional<List<DeptModel>> o=this.getAllDeptList(deptService);
	    
		return o.get();
	}

	@Override
	public List<Object[]> getEmployeeWithDept() {
		
		return empRepo.getEmployeeWithDept();
	}

	@Override
	public boolean isDeleteEmployee(int id) {
		// TODO Auto-generated method stub
		return empRepo.isDeleteEmployee(id);
	}
	
	@Override
	public boolean isUpdateEmployee(EmployeeModel model)
	{
	    return empRepo.isUpdateEmployee(model);
	}
}
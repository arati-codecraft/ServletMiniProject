package org.app.service;

import java.util.List;
import java.util.Optional;

import org.app.model.DeptModel;
import org.app.repository.DeptRepository;
import org.app.repository.DeptRepositoryImpl;

public class DeptServiceImpl implements DeptService
{
   DeptRepository deptRepo=new DeptRepositoryImpl();
	@Override
	public boolean isAddNewDept(DeptModel model)
	{
		
		return deptRepo.isAddDept(model);
	}
	@Override
	public Optional<List<DeptModel>> getAllDepts() {
		// TODO Auto-generated method stub
		return deptRepo.getAllDepts();
	}
	@Override
	public boolean isDeleteDept(int deptId) {
		// TODO Auto-generated method stub
		return deptRepo.isDeleteDept(deptId);
	}
	@Override
	public boolean isUpdateDept(DeptModel model) {
		// TODO Auto-generated method stub
		return deptRepo.isUpdateDept(model);
	}

}

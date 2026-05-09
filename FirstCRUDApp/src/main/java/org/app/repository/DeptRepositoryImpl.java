package org.app.repository;

import java.util.*;

import org.app.model.DeptModel;

public class DeptRepositoryImpl extends DBConfig implements DeptRepository
{
    List<DeptModel> deptList;
	@Override
	public boolean isAddDept(DeptModel model) {
		// TODO Auto-generated method stub
		
		try
		{
			stmt=super.conn.prepareStatement("insert into dept values('0',?)");
			stmt.setString(1,model.getName());
			int value=stmt.executeUpdate();
			return value>0?true:false;
		}
		catch(Exception ex)
		{
		   System.out.println("Error is "+ex);
		   return false;
		}
		
	}

	@Override
	public Optional<List<DeptModel>> getAllDepts() 
	{
		try
		{
			deptList=new ArrayList<DeptModel>();
			stmt=conn.prepareStatement("Select * from dept");
			rs=stmt.executeQuery();
			
			while(rs.next())
			{
				DeptModel model=new DeptModel();
				model.setId(rs.getInt(1));
				model.setName(rs.getString(2));
				deptList.add(model);
			}
			return Optional.ofNullable(deptList);
		}
		catch(Exception ex)
		{
			System.out.println("Error is "+ex);
			return null;
		}
	
	}

	@Override
	public boolean isDeleteDept(int deptId)
	{
		try
		{
			stmt = conn.prepareStatement("delete from dept where deptid=?");
			stmt.setInt(1, deptId);
			return stmt.executeUpdate() > 0;
		}
		catch(Exception ex)
		{
			System.out.println("Error is " + ex);
			return false;
		}
	}

	@Override
	public boolean isUpdateDept(DeptModel model)
	{
		// TODO Auto-generated method stub
		try
		{
			stmt=conn.prepareStatement("update dept set name=? where deptid=?");
			stmt.setString(1,model.getName());
			stmt.setInt(2, model.getId());
			int value=stmt.executeUpdate();
			if(value>0)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		catch(Exception ex)
		{
			System.out.println("Error is"+ex);
			return false;
		}
		
	}

}

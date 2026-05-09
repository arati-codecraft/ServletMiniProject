package org.app.repository;

import java.util.ArrayList;
import java.util.List;

import org.app.model.EmployeeModel;

public class EmployeeRepositoryImpl extends DBConfig implements EmployeeRepository
{
    private List<Object[]> list;
	@Override
	public boolean isAddNewEmployee(EmployeeModel model) 
	{
		try
		{
			stmt = conn.prepareStatement("INSERT INTO employee (name, email, contact, salary, deptid) VALUES (?,?,?,?,?)");

			stmt.setString(1,model.getName()); 
			stmt.setString(2,model.getEmail()); 
			stmt.setString(3, model.getContact()); 
			stmt.setInt(4,model.getSalary());
			stmt.setInt(5,model.getDeptid());
			return stmt.executeUpdate()>0?true:false;
		}
		catch(Exception ex)
		{
			System.out.println("Error is "+ex);
		}
		return false;
	}

	@Override
	
	public List<Object[]> getEmployeeWithDept() {
	    List<Object[]> list = new ArrayList<>();
	    try {
	        stmt = conn.prepareStatement(
	        		"SELECT e.id, e.name, e.email, e.contact, e.salary, d.name " +
	        				"FROM employee e INNER JOIN dept d ON e.deptid = d.deptid"  );
	        rs = stmt.executeQuery();
	        while (rs.next()) {
	        	list.add(new Object[] {
	        		    rs.getInt(1),       // id
	        		    rs.getString(2),    // name
	        		    rs.getString(3),    // email
	        		    rs.getString(4),    // contact
	        		    rs.getInt(5),       // salary
	        		    rs.getString(6)     // dept name
	        		});
	        }
	    } catch (Exception ex) {
	        System.out.println("Error is " + ex);
	    }
	    return list;
	}

	@Override
	public boolean isDeleteEmployee(int id)
	{
	    try
	    {
	        stmt = conn.prepareStatement(
	            "delete from employee where id=?"
	        );

	        stmt.setInt(1,id);

	        return stmt.executeUpdate()>0;
	    }
	    catch(Exception ex)
	    {
	        System.out.println("Error is "+ex);
	    }

	    return false;
	}
	
	@Override
	public boolean isUpdateEmployee(EmployeeModel model)
	{
	    try
	    {
	        stmt = conn.prepareStatement(
	            "update employee set name=? where id=?"
	        );

	        stmt.setString(1,model.getName());

	        stmt.setInt(2,model.getId());

	        return stmt.executeUpdate()>0;
	    }
	    catch(Exception ex)
	    {
	        System.out.println("Error is "+ex);
	    }

	    return false;
	}

}


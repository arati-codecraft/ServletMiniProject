package org.app.repository;

import org.app.model.DeptModel;
import java.util.*;
public interface DeptRepository 
{
   public boolean isAddDept(DeptModel model);
   public Optional<List<DeptModel>> getAllDepts();
   public boolean isDeleteDept(int deptId);
   public boolean isUpdateDept(DeptModel model);
}

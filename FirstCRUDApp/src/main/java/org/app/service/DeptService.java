package org.app.service;

import org.app.model.DeptModel;
import java.util.*;
public interface DeptService 
{
    public boolean isAddNewDept(DeptModel model);
    public Optional<List<DeptModel>> getAllDepts();
    public boolean isDeleteDept(int deptId);
    public boolean isUpdateDept(DeptModel model );
}

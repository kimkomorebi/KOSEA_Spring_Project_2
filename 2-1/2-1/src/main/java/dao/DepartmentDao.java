package dao;

import java.util.List;

import model.Department;
import model.Employee;

public interface DepartmentDao {
	public List<Department> getDepartments();
	public List<Employee> getEmployees();
}

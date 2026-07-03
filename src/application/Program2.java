package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

import java.util.List;
import java.util.Scanner;

public class Program2 {

    public static void main(String[] args) {

        var sc = new Scanner(System.in);

        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

        System.out.println("=== TESTE 1: department findById ===");
        Department department = departmentDao.findBYId(3);
        System.out.println(department);

        System.out.println("\n=== TESTE 2: department findAll ===");
        List<Department> list = departmentDao.findAll();
        for (Department obj : list) {
            System.out.println(obj);
        }

        System.out.println("\n=== TESTE 3: department insert ===");
        Department newDepartment = new Department(null, "Toys");
        departmentDao.insert(newDepartment);
        System.out.println("Insert! New Id = " + newDepartment.getId());

        System.out.println("\n=== TESTE 4: department update ===");
        department = departmentDao.findBYId(1);
        department.setName("Computers Updated");
        departmentDao.update(department);
        System.out.println("Update completed!");

        System.out.println("\n=== TESTE 5: department delete ===");
        System.out.println("Enter the id for delete test: ");
        int id = sc.nextInt();
        departmentDao.deleteById(id);
        System.out.println("Delete completed!");

        sc.close();
    }
}
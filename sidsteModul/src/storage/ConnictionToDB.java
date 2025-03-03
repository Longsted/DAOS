package storage;

import application.model.Company;
import application.model.Employee;

import java.sql.*;
import java.util.ArrayList;

public class ConnictionToDB {
    private static Connection minConnection;

    static {
        try {
            minConnection = DriverManager
                    .getConnection("jdbc:sqlserver://localhost\\SQLExpress;databaseName=company;user=sa;password=torben07;");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static ArrayList<Company> getCompanies() {
        ArrayList<Company> comp = new ArrayList<Company>();
        try {
            Statement stmt = null;
            stmt = minConnection.createStatement();
            ResultSet res = stmt.executeQuery("select * from Company");
            while (res.next()) {
                int id = res.getInt(1);
                String name = res.getString(2);
                int hours = res.getInt(3);
                Company company = new Company(id, name, hours);
                comp.add(company);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return comp;
    }

    public static ArrayList<Employee> getEmployee() {
        ArrayList<Employee> emp = new ArrayList<Employee>();
        try {
            Statement stmt = null;
            stmt = minConnection.createStatement();
            ResultSet res = stmt.executeQuery("select * from Employee");
            while (res.next()) {
                int id = res.getInt(1);
                String name = res.getString(2);
                int wage = res.getInt(3);
                Employee employee = new Employee(id, name, wage);
                emp.add(employee);
            }

        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return emp;
    }

    public static ArrayList<Employee> getEmpForComp(int companyid) {
        ArrayList<Employee> ansatte = new ArrayList<Employee>();
       //TODO
        try{
            Statement stmt = null;
            stmt = minConnection.createStatement();
            ResultSet res = stmt.executeQuery("select employeeId, e.navn, loen from Employee e where companyId =" + companyid);
            while (res.next()) {

                int id = res.getInt(1);
                String name = res.getString(2);
                int wage = res.getInt(3);
                Employee employee = new Employee(id, name, wage);
                ansatte.add(employee);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }

        return ansatte;
    }

    //return name of company for employee
    public static String getCompanyForEmp(Employee emp) {
        String Cname = "";
        try{
            Statement stmt = null;
            stmt = minConnection.createStatement();
            ResultSet res = stmt.executeQuery("select c.navn from Company c join employee e on c.companyId = e.companyId where employeeId =" + emp.getEmployeeId());
            while (res.next()) {
            Cname = res.getString(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
        //TODO
        return Cname;
    }
    //return id of company for employee
    public static int getCompanyIdForEmp(Employee emp) {
        int id = Integer.MIN_VALUE;
        //TODO
        try{
            Statement stmt = null;
            stmt = minConnection.createStatement();
            ResultSet res = stmt.executeQuery("select c.companyId from Company c join employee e on c.companyId = e.companyId where employeeId =" + emp.getEmployeeId());
            while (res.next()) {
                id = res.getInt(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }

        return id;
    }

    public static void createCompany(String name, int hours) {
        //TODO

        try {
            String sql = "insert into company values('" + name + "'," + hours +")";
            Statement stmt = null;
            stmt = minConnection.createStatement();
             stmt.execute(sql);

        }catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public static int getHoursPrWeek(int empId){
        int hoursrWeek = 0;
       //TODO
        try{
            Statement stmt = null;
            stmt = minConnection.createStatement();
            ResultSet res = stmt.executeQuery("select timerPrUge from Company c join employee e on c.companyId = e.companyId where employeeId =" + empId);
            while (res.next()) {
                hoursrWeek = res.getInt(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
        return hoursrWeek;
    }

    public static void updateCompany(String name, int hours, int compId){
        //TODO
        try{
            Statement stmt = null;
            stmt = minConnection.createStatement();
            stmt.executeQuery("select companyId from company c UPDATE  company set navn = '" + name +"', timerPrUge =" + hours + "where companyId = " + compId);

        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public static void updateEmployee(String name, int wage, int empId, int compID){
        //TODO
    }

    public static void addEmployee(String name, int wage, int compId){
       //TODO
    }

    public static void removeEmployee(Employee emp) {
        //TODO
    }
    public static int getNumberOfEmp(Company company){
        int antal = 0;
        //TODO
        return antal;
    }

    public static String removeCompany(int id) {
        String s = "slettet";
        //TODO
        return s;
    }
}

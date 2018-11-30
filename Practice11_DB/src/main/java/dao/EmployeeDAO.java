package dao;

import entity.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static dao.LogDAO.logger;

public class EmployeeDAO extends AbstractDAO<Integer, Employee, String> {

    public EmployeeDAO(Connection connection) {
        super(connection);
    }

    @Override
    public List<Employee> findAll() {
        List<Employee> listEmployee = new ArrayList<>();
        Statement statement = null;
        try {
            try {
                statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * from employees");
                listEmployee = createListOfEmployeeUsingResultSet(listEmployee, resultSet);

            } finally {
                close(statement);
            }
        } catch (SQLException e) {
            logger.error("SQL Error"+e.getMessage());
        }
        return listEmployee;
    }

    @Override
    public List<Employee> findById(Integer id) {
        List<Employee> listEmployee = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("select * from employees where dep_number = ?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            listEmployee = createListOfEmployeeUsingResultSet(listEmployee, resultSet);
        } catch (SQLException e) {
            logger.error("SQL Error"+e.getMessage());
        } finally {
            close(preparedStatement);
        }
        return listEmployee;
    }

    @Override
    public void addById(Integer id, String task) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement =
                    connection.prepareStatement("insert into task (description, emp_id) values (?, ?)");
            preparedStatement.setString(1, task);
            preparedStatement.setInt(2, id);
            int i = preparedStatement.executeUpdate();
            System.out.println(i);
        } catch (SQLException e) {
            logger.error("SQL Error"+e.getMessage());
        }
        finally {
            close(preparedStatement);
        }
    }

    private List<Employee> createListOfEmployeeUsingResultSet(List<Employee> listEmployee, ResultSet resultSet) throws SQLException {
        while (resultSet.next()) {
            listEmployee.add(new Employee(
                    resultSet.getInt("id"),
                    resultSet.getString("name"),
                    resultSet.getString("surname"),
                    resultSet.getString("position"),
                    resultSet.getInt("dep_number")
            ));
        }
        return listEmployee;
    }
}

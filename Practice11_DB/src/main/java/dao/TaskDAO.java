package dao;

import entity.Task;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static dao.LogDAO.logger;

public class TaskDAO extends AbstractDAO<Integer, Task, String> {
    public TaskDAO(Connection connection) {
        super(connection);
    }

    @Override
    public List<Task> findAll() {
        List<Task> listEmployee = new ArrayList<>();
        Statement statement = null;
        try {
            try {
                statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * from task");
                while (resultSet.next()) {
                    listEmployee.add(new Task(
                            resultSet.getInt("id"),
                            resultSet.getString("description"),
                            resultSet.getInt("emp_id")
                    ));
                }

            } finally {
                close(statement);
            }
        } catch (SQLException e) {
            logger.error("SQL Error"+e.getMessage());
        }
        return listEmployee;
    }

    @Override
    public List<Task> findById(Integer id) {
        List<Task> listEmployee = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("select * from task where emp_id = ?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                listEmployee.add(new Task(
                        resultSet.getInt("id"),
                        resultSet.getString("description"),
                        resultSet.getInt("emp_id")
                ));
            }
        } catch (SQLException e) {
            logger.error("SQL Error"+e.getMessage());
        } finally {
            close(preparedStatement);
        }
        return listEmployee;
    }

    @Override
    public void addById(Integer id, String task) {
        //some code
    }
}

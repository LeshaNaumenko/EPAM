import dao.EmployeeDAO;
import view.MenuSql;
import entity.Task;
import dao.TaskDAO;
import entity.Employee;

import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ResourceBundle db = ResourceBundle.getBundle("db");

        MyСonnection myСonnection = new MyСonnection(db.getString("url"),
                db.getString("user"),
                db.getString("password"));

        run(myСonnection);

    }

    public static void run(MyСonnection myСonnection) {
        EmployeeDAO employeeDAO;
        TaskDAO taskDAO;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println(MenuSql.MENU_TASK);
            int i = scanner.nextInt();
            switch (i) {
                case 1:
                    employeeDAO = new EmployeeDAO(myСonnection.getMyConnection());
                    List<Employee> allEmp = employeeDAO.findAll();
                    printList(allEmp);
                    break;
                case 2:
                    taskDAO = new TaskDAO(myСonnection.getMyConnection());
                    List<Task> allTask = taskDAO.findAll();
                    printList(allTask);
                    break;
                case 3:
                    System.out.print("Введите номер отдела:");
                    int i1 = new Scanner(System.in).nextInt();
                    employeeDAO = new EmployeeDAO(myСonnection.getMyConnection());
                    List<Employee> byId = employeeDAO.findById(i1);
                    printList(byId);
                    break;
                case 4:
                    System.out.print("Введите id сотрудника:");
                    int empId = new Scanner(System.in).nextInt();
                    System.out.print("Введите задание для сотрудника:");
                    String task = new Scanner(System.in).nextLine();
                    employeeDAO = new EmployeeDAO(myСonnection.getMyConnection());
                    employeeDAO.addById(empId, task);
                    break;
                case 5:
                    System.out.print("Введите id сотрудника:");
                    int emloyeeId = new Scanner(System.in).nextInt();
                    taskDAO = new TaskDAO(myСonnection.getMyConnection());
                    List<Task> byId1 = taskDAO.findById(emloyeeId);
                    printList(byId1);
                    break;
                case 0:
                    myСonnection.close();
                    System.exit(0);
                default:
            }
        }
    }

    private static void printList(List list) {
        for (Object o : list) {
            System.out.println(o);
        }
        System.out.println();
    }
}

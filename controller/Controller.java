package controller;

import java.util.List;

import model.Student;
import model.Type;
import service.DataService;
import view.StudentView;
import model.User;

public class Controller {

    private final DataService service = new DataService();
    private final StudentView view = new StudentView();

    public void createStudent(String firstName, String lastName, String middleName){
        service.create(firstName, lastName, middleName, Type.STUDENT);

    }

    public void getAllStudent(){
        List<User> userList = service.getAllStudent();
        for(User user: userList){
            Student student = (Student) user;
            view.printOnConsole(student);
        }

    }
}

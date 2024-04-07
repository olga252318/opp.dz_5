package service;
import java.util.ArrayList;
import java.util.List;
import model.StudyGroup;
import model.Student;
import model.Teacher;
import model.Type;

public class DataService {

    private List<StudyGroup> userList;

    public void create(String firstName, String lastName, String middleName, Type type){
        int id = getFreeId(type);
        if(Type.STUDENT == type){
            Student student = new Student(firstName, lastName, middleName, id);
            userList.add(student);
        }
        if(Type.TEACHER == type){
            Teacher teacher = new Teacher(firstName, lastName, middleName, id);
            userList.add(teacher);
        }

    }

    public StudyGroup getUserById(Type type, int id){
        boolean itsStudent = Type.STUDENT == type;
        StudyGroup currentuser = null;

        for(StudyGroup user: userList){
            if(user instanceof Teacher && !itsStudent && ((Teacher) user).getTeacherId() == id){
                currentuser = user;
            }
            if(user instanceof Student && itsStudent && ((Student) user).getStudentId() == id){
                currentuser = user;
            }
        }

        return currentuser;
    }


    public List<StudyGroup> getAllUser(){
        return userList;
    }

    public List<StudyGroup> getAllStudent(){
        List<StudyGroup> student = new ArrayList<>();
        for(StudyGroup user: userList){
            if(user instanceof Student){
                student.add(user);
            }
        }
        return student;
    }

    public int getFreeId(Type type){
        boolean itsStudent = Type.STUDENT == type;
        int lastId =1;
        for(StudyGroup user: userList){
            if(user instanceof Teacher && !itsStudent){
                lastId = ((Teacher)user).getTeacherId()+ 1;
            }
            if(user instanceof Student && itsStudent){
                lastId = ((Student)user).getStudentId() +1;
            }
        }
        return lastId;
    }

}

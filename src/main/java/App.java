import com.github.javafaker.Faker;
import jakarta.persistence.EntityManager;
import org.example.Entity.*;
import org.example.Menu.EmployeeMenu;
import org.example.Menu.StudentMenu;
import org.example.Menu.TeacherMenu;
import org.example.Service.baseEmployee.BaseEmployeeService;
import org.example.Service.baseEmployee.imp.BaseEmployeeServiceImp;
import org.example.Util.HibernateUtil;
import org.example.enums.Days;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Set;

public class App {
    public static void main(String[] args) {
        EmployeeMenu employeeMenu = new EmployeeMenu();
        BaseEmployeeService service = new BaseEmployeeServiceImp();
            Lesson lesson = new Lesson();
            employeeMenu.instantiateOrUpdateLesson(lesson,1);

    }
}

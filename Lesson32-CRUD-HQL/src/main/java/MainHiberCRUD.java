import domain.Readiness;
import domain.Sex;
import entity.PersonEntity;
import entity.TaskEntity;
import service.impl.PersonDao;
import service.impl.TaskDao;

import java.time.LocalDate;
import java.util.Date;

public class MainHiberCRUD {
    public static void main(String[] args) {
        PersonDao personDao = new PersonDao();
        TaskDao taskDao = new TaskDao();

        PersonEntity vladWorker = PersonEntity.builder()
                .sex(Sex.MAN)
                .name("Vlad")
                .dateOfBirth(LocalDate.parse("2001-11-12"))
                .build();

        PersonEntity sashaWorker = PersonEntity.builder()
                .sex(Sex.WOMAN)
                .name("Saha")
                .dateOfBirth(LocalDate.parse("1983-04-06"))
                .build();

        TaskEntity refactoringTask = TaskEntity.builder()
                .nameOfTask("Refactoring")
                .taskDescription("Long and hard job, should know patterns!")
                .readiness(Readiness.NEW)
                .person(vladWorker)
                .build();

        TaskEntity bugFixing = TaskEntity.builder()
                .nameOfTask("bugFixing")
                .taskDescription("Not a bug but a feature!")
                .readiness(Readiness.DONE)
                .person(sashaWorker)
                .build();

        TaskEntity security = TaskEntity.builder()
                .nameOfTask("Develop Security")
                .taskDescription("Even Dadya Vasia can break our programm - deal with it!")
                .readiness(Readiness.IN_PROGRESS)
                .person(sashaWorker)
                .build();

        personDao.save(vladWorker);
        personDao.save(sashaWorker);

        taskDao.save(refactoringTask);
        taskDao.save(bugFixing);
        taskDao.save(security);
    }
}

import domain.Readiness;
import domain.Sex;
import dto.PersonSearchDto;
import dto.TaskSearchDto;
import entity.PersonEntity;
import entity.TaskEntity;
import lombok.NonNull;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import service.Dao;
import service.impl.PersonDao;
import service.impl.TaskDao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static java.util.Objects.nonNull;
import static org.apache.commons.lang3.StringUtils.isNotBlank;

public class MainHiberCRUD {
    public static void main(String[] args) {
        /*PersonDao personDao = new PersonDao();
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
                .build();

        TaskEntity bugFixing = TaskEntity.builder()
                .nameOfTask("bugFixing")
                .taskDescription("Not a bug but a feature!")
                .readiness(Readiness.DONE)
                .build();

        TaskEntity security = TaskEntity.builder()
                .nameOfTask("Develop Security")
                .taskDescription("Even Dadya Vasia can break our programm - deal with it!")
                .readiness(Readiness.DONE)
                .build();

        vladWorker.addTask(refactoringTask);
        vladWorker.addTask(bugFixing);
        sashaWorker.addTask(security);

        personDao.save(vladWorker);
        personDao.save(sashaWorker);

        System.out.println("Get Persons with readiness task value : ");
        List<PersonEntity> byTaskReadiness = personDao.getByTaskReadiness(Readiness.DONE);
        System.out.println(byTaskReadiness);

        System.out.println("Show all");
        List<PersonEntity> all = personDao.getAll();
        System.out.println(all);

        personDao.delete(sashaWorker);

        System.out.println("After deleting worker :");
        List<TaskEntity> all1 = taskDao.getAll();
        System.out.println(all1);

        taskDao.delete(bugFixing);
        taskDao.update(refactoringTask, Readiness.IN_PROGRESS);

        System.out.println("Delete and update task");
        System.out.println(taskDao.getAll());

        personDao.delete(vladWorker);*/

        // TODO : Put in new classes

        PersonSearchDto searchPerson = PersonSearchDto.builder()
                .dateOfBirth(LocalDate.parse("1983-04-06"))
                .sex(Sex.WOMAN)
                .build();

        TaskSearchDto searchPhone = TaskSearchDto.builder()
                .build();

        Session session = Dao.openSessionAndTransaction();
        Criteria criteria = session.createCriteria(PersonEntity.class, "pe");

        List list;

        if(searchPerson == null){
            list = criteria.list();
        }else {
            if(isNotBlank(searchPerson.getName())){
                criteria.add(Restrictions.eq("name",searchPerson.getName()));
            }
            if(nonNull(searchPerson.getSex())){
                criteria.add(Restrictions.eq("sex", searchPerson.getSex()));
            }
            if(nonNull(searchPerson.getDateOfBirth())){
                criteria.add(Restrictions.between("dateOfBirth", LocalDate.parse("1982-08-12"), LocalDate.parse("2010-11-12")));
            }
        }

        Criteria criteriaPhone = criteria.createCriteria("pe.entityList", "pt");
        if(searchPerson == null){
            list = criteria.list();
        }else {
            if(nonNull(searchPhone.getReadiness())){
                criteriaPhone.add(Restrictions.eq("pt.readiness", searchPhone.getReadiness()));
            }
        }

        criteria.list().forEach(System.out::println);

        Dao.closeSessionAndTransaction(session);
    }
}

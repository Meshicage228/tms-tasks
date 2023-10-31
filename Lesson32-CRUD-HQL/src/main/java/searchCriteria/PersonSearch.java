package searchCriteria;

import dto.PersonSearchDto;
import dto.TaskSearchDto;
import entity.PersonEntity;
import org.apache.commons.collections4.CollectionUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import service.Dao;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static java.util.Objects.nonNull;
import static org.apache.commons.collections4.CollectionUtils.isNotEmpty;
import static org.apache.commons.lang3.StringUtils.isNotBlank;

public class PersonSearch {
    public static List<PersonEntity> personCriteria(PersonSearchDto search) {
        Session session = Dao.openSessionAndTransaction();
        Criteria criteria = session.createCriteria(PersonEntity.class, "pe");

        List list;

        if (isNotBlank(search.getName())) {
            criteria.add(Restrictions.eq("name", search.getName()));
        }
        if (nonNull(search.getSex())) {
            criteria.add(Restrictions.eq("sex", search.getSex()));
        }
        if (nonNull(search.getDateOfBirth())) {
            criteria.add(Restrictions.between("dateOfBirth", LocalDate.parse("1982-08-12"), LocalDate.parse("2010-11-12")));
        }

        list = criteria.list();

        Dao.closeSessionAndTransaction(session);
        return list;
    }

    public static List<PersonEntity> getByTaskCriteria(TaskSearchDto search) {
        Session session = Dao.openSessionAndTransaction();
        Criteria criteria = session.createCriteria(PersonEntity.class, "pe");
        Criteria criteriaPhone = criteria.createCriteria("pe.entityList", "pt");

        List list;

        if (nonNull(search.getReadiness())) {
            criteriaPhone.add(Restrictions.eq("pt.readiness", search.getReadiness()));
        }
        if (isNotBlank(search.getNameOfTask())) {
            criteriaPhone.add(Restrictions.eq("pt.nameOfTask", search.getNameOfTask()));
        }
        list = criteria.list();
        Dao.closeSessionAndTransaction(session);
        return list;
    }
}

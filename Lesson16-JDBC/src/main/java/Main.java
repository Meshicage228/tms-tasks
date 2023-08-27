import service.PersonService;
import service.TownService;
import domain.Person;
import domain.Town;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException{
        List<Person> lst = List.of(
                new Person("Oleg", "Vladimirovich", "Minsk"),
                new Person("Olya","Tulka", "Minsk"),
                new Person("Sergey", "Ivanov", "Moscow"),
                new Person("Saha", "Pilkov", "Petersburg"),
                new Person("Oksana", "Olegovna", "Brest"));

        PersonService.save(lst);
        PersonService.delete(2);
        PersonService.findAll().forEach(System.out::println);

        TownService.save(new Town("Minsk"));
        TownService.delete(2);


    }

}

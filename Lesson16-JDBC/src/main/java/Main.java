import service.impl.Person;
import service.impl.Town;

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

        Person person = new Person();
        person.save(lst);

        Town town = new Town("Vitebsk");

        town.save();

        town.delete("Minsk");

        person.findAll().forEach(System.out::println);

        person.deleteByNameSurname("Olya", "Tulka");

    }

}

import service.PatterMatch;
import service.PersonService;
import service.TownService;
import domain.Person;
import domain.Town;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException{
          PatterMatch<Person, Integer> personManager = new PersonService();
          PatterMatch<Town, Integer> townManager = new TownService();

          Person person1 = new Person("Oleg", "Vladimirovich", "Minsk");
          Person person2 = new Person("Olya","Tulka", "Minsk");
          Person person3 = new Person("Sergey", "Ivanov", "Moscow");
          Person person4 = new Person("Saha", "Pilkov", "Petersburg");
          Person person5 = new Person("Oksana", "Olegovna", "Brest");

        personManager.save(person1);
        personManager.save(person2);
        personManager.save(person3);
        personManager.save(person4);
        personManager.save(person5);

        personManager.delete(2);

        personManager.findAll().forEach(System.out::println);

        townManager.save(new Town("Gomel"));

        townManager.delete(2);

        townManager.findAll().forEach(System.out::println);
    }

}

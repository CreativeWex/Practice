package springcourse.DAO;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import springcourse.models.Person;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private List<Person> peopleList;
    private static int PEOPLE_COUNT;

    {
        peopleList = new ArrayList<>();
        peopleList.add(new Person(++PEOPLE_COUNT, "Tom"));
        peopleList.add(new Person(++PEOPLE_COUNT, "Nick"));
        peopleList.add(new Person(++PEOPLE_COUNT, "Jack"));
        peopleList.add(new Person(++PEOPLE_COUNT, "Sam"));
        peopleList.add(new Person(++PEOPLE_COUNT, "Hugo"));
    }

    public List<Person> getPeopleList() {
        return peopleList;
    }

    public Person showById(int id) {
        return peopleList.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }

    public void save(Person person) {
        person.setId(++PEOPLE_COUNT);
        peopleList.add(person);
    }
}

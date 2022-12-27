package springcourse.DAO;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import springcourse.models.Person;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private List<Person> peopleList;

    {
        peopleList = new ArrayList<>();
        peopleList.add(new Person(1, "Tom"));
        peopleList.add(new Person(2, "Nick"));
        peopleList.add(new Person(3, "Jack"));
        peopleList.add(new Person(4, "Sam"));
        peopleList.add(new Person(5, "Hugo"));
    }

    public List<Person> getPeopleList() {
        return peopleList;
    }

    public Person showById(int id) {
        return peopleList.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }
}

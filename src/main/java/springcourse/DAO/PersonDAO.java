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
        peopleList.add(new Person(++PEOPLE_COUNT, "Tom", 24, "tom@mail.ru"));
        peopleList.add(new Person(++PEOPLE_COUNT, "Bob", 52, "bob@mail.ru"));
        peopleList.add(new Person(++PEOPLE_COUNT, "Mike", 18, "mike@yahoo.com"));
        peopleList.add(new Person(++PEOPLE_COUNT, "Katy", 34, "katy@gmail.com"));
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

    public void update(int id, Person updatedPerson) {
        Person oldPerson = showById(id);
        oldPerson.setName(updatedPerson.getName());
        oldPerson.setEmail(updatedPerson.getEmail());
        oldPerson.setAge(updatedPerson.getAge());
    }

    public void delete(int id) {
        peopleList.removeIf(p -> p.getId() == id);
    }
}

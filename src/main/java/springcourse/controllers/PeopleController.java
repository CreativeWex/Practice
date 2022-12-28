package springcourse.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import springcourse.DAO.PersonDAO;
import springcourse.models.Person;

@Controller
@RequestMapping("/people")
public class PeopleController {

    private final PersonDAO personDAO;

    @Autowired
    public PeopleController(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    @GetMapping()
    public String getIndex(Model model) {
        model.addAttribute("peopleList", personDAO.getPeopleList());
        return "people/index";
    }

    @GetMapping("/{id}")
    public String showPerson(@PathVariable("id") int id, Model model) {
        model.addAttribute("person", personDAO.showById(id));
        return "people/showById";
    }

    @GetMapping("/new")
    public String addNewPerson(@ModelAttribute("person") Person person) {
        return "people/newPerson";
    }

    @PostMapping
    public String createNewPerson(@ModelAttribute("person") Person person) {
        personDAO.save(person);
        return "redirect:/people";
    }

}

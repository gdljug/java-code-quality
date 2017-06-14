package application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = {"/", "/person"})
public class IndexController {

    @Autowired
    private PersonRepository personRepository;

    @ResponseBody
    @GetMapping("/{id}")
    public Person getPerson(@PathVariable("id") Long id) {
        return personRepository.findOne(id);
    }

    @ResponseBody
    @GetMapping
    public Person getPerson() {
        return personRepository.findOne(1L);
    }
    
    @ResponseBody
    @PostMapping
    public Person savePerson(@RequestBody Person person) {
        return personRepository.save(person);
    }

}

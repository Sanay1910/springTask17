package no.experis.task17;

import org.springframework.web.bind.annotation.*;

@RestController
public class personController {

    @RequestMapping("/person")
    public person personFind(@RequestParam(value = "ID", defaultValue = "Meh") String ID) {
        System.out.println("Trying to find person: " + ID);
        person returnPerson = null;
        for (person per : SQLtoREST.persons) {
            if (per.getPersonID().equals(ID)) {
                System.out.println(" --- PERSON --- ");
                returnPerson = per;
            }
        }
        if (returnPerson == null) {
            System.out.println(" --- PERSON NOT FOUND --- ");
        }
        return returnPerson;
    }

    @GetMapping("/person/{ID}")
    public person personGet(@PathVariable String ID) {
        System.out.println("Trying to find person: " + ID);
        person returnPerson = null;
        for (person per : SQLtoREST.persons) {
            if (per.getPersonID().equals(ID)) {
                System.out.println(" --- PERSON FOUND --- ");
                returnPerson = per;
            }
        }
        if (returnPerson == null) {
            System.out.println(" --- PERSON WAS NOT FOUND --- ");
        }
        return returnPerson;

    }
}

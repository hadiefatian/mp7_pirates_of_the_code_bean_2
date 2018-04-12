package at.refugeecode.dutchman;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DutchmanEndpoint {

    private String cheast = "I found the Dead Man’s Chest,\n but nothing is inside of it!!";


    @GetMapping("/dutchman")
    String getCheast() {
        return cheast;
    }

}

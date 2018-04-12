package at.refugeecode.tiadalama;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TiaDalamaEndpoint {

    @Value("${urldutchman}")
    String DutchmanUrl;

    @GetMapping("/tiadalama")
    String getDutchmanurl(){
        return DutchmanUrl;
    }
}

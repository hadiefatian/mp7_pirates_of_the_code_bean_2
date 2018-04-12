package at.refugeecode.jacksparrow;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@RestController
public class JackSparrowEndpoint {

    @Value("${tiadalama}")
    String TiaDalamaUrl;

    @GetMapping("jacksparrow")
    String getCoins(){

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<String> forEntity1 = null;
        try {
            forEntity1 = restTemplate.getForEntity(TiaDalamaUrl, String.class);
        } catch (RestClientException e) {
            System.out.println("A problem occurred connecting to Tia Dalama");
            return "A problem occurred connecting to Tia Dalama";
            //e.printStackTrace();
        }
        String coinUrl = forEntity1.getBody();

        ResponseEntity<String> forEntity2 = null;
        try {
            forEntity2 = restTemplate.getForEntity(coinUrl, String.class);
        } catch (RestClientException e) {
            System.out.println("A problem occurred connecting to Dutchman");
            return "A problem occurred connecting to Dutchman";
        }

        return forEntity2.getBody();
    }
}

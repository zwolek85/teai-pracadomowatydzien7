package pl.zwolek.teaiweek7.catsnews.client;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;
import pl.zwolek.teaiweek7.catsnews.client.dtos.AnimalFact;

@Controller
class CatController implements CatClient {

    @Override
    public AnimalFact getCatFact() {
        RestTemplate restTemplate = new RestTemplate();

        AnimalFact animalFact = restTemplate.getForObject("https://cat-fact.herokuapp.com/facts/random", AnimalFact.class);
        JsonNode image = restTemplate.getForObject("https://aws.random.cat/meow", JsonNode.class).get("file");
        animalFact.setSrc(image.asText());

        return animalFact;
    }

}

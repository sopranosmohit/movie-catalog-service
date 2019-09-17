package io.mylearning.moviecatalogservice;

import io.mylearning.moviecatalogservice.CatalogItem;
import io.mylearning.moviecatalogservice.models.Rating;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping(path = "/catalog")
public class MovieCatalogResource {


    @RequestMapping(value = "/{userId}",method = RequestMethod.GET)
    public List<CatalogItem> getCatalogItemList(@PathVariable String userId)
    {
        List<Rating> ratings = Arrays.asList(new Rating("1234",4),new Rating("5678",5));
        return Collections.singletonList(new CatalogItem("Tansformers","Test",4));


    }
}

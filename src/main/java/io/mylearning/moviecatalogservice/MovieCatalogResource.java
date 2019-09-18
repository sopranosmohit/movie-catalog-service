package io.mylearning.moviecatalogservice;


import io.mylearning.moviecatalogservice.models.Movie;
import io.mylearning.moviecatalogservice.models.Rating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/catalog")
public class MovieCatalogResource {

    @Autowired
    private WebClient.Builder webClientBuilder;

    @RequestMapping(value = "/{userId}",method = RequestMethod.GET)
    public List<CatalogItem> getCatalogItemList(@PathVariable String userId)
    {


        RestTemplate template = new RestTemplate();


        List<Rating> ratingsList = Arrays.asList(new Rating("1234",4),new Rating("5678",5));

        return ratingsList.stream()
                .map(rating -> {
                    Movie movie = template.getForObject("http://localhost:8080/movie/" + rating.getMovieId(), Movie.class);
                    return new CatalogItem(movie.getName(), "Description", rating.getRating());
                })
                .collect(Collectors.toList());

       


    }
}

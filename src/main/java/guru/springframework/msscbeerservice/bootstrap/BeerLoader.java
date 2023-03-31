package guru.springframework.msscbeerservice.bootstrap;

import guru.springframework.msscbeerservice.domain.Beer;
import guru.springframework.msscbeerservice.repositories.BeerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class BeerLoader implements CommandLineRunner {

    public static final String BEER_1_UPC = "0631234200036";
    public static final String BEER_2_UPC = "0631234300019";
    public static final String BEER_3_UPC = "0083783375213";

    private final BeerRepository beerRepository;

    public BeerLoader(BeerRepository beerRepository) {
        this.beerRepository = beerRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadBeerObjects();
    }

    private void loadBeerObjects() {

        if(beerRepository.count() == 0) {

            beerRepository.save(Beer.builder()
                    .beerName("Baltika")
                    .beerStyle("9")
                    .quantityToBrew(200)
                    .minOnHand(12)
                    .upc(BEER_1_UPC)
                    .price(BigDecimal.valueOf(69.96))
                    .build());

            beerRepository.save(Beer.builder()
                    .beerName("RADLER")
                    .beerStyle("LAMAIE")
                    .quantityToBrew(500)
                    .minOnHand(12)
                    .upc(BEER_3_UPC)
                    .price(BigDecimal.valueOf(13.37))
                    .build());

            beerRepository.save(Beer.builder()
                    .beerName("Kozel")
                    .beerStyle("Bruna")
                    .quantityToBrew(500)
                    .minOnHand(12)
                    .upc(BEER_2_UPC)
                    .price(BigDecimal.valueOf(13.37))
                    .build());
        }

    }


}

package only.mybeer.controller;

import lombok.RequiredArgsConstructor;
import only.mybeer.domain.Beer;
import only.mybeer.domain.User;
import only.mybeer.domain.repository.BeerRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;

@Controller
@RequestMapping("/product/beers")
@RequiredArgsConstructor
public class BeerController {
    private final BeerRepository beerRepository;

    @GetMapping("")
    public String beers(Model model) {
        List<Beer> beers = beerRepository.findAll();
        model.addAttribute("beers", beers);
        return "beer/beers";
    }

    @GetMapping("/{beerId}")
    public String getBeer(@PathVariable Long beerId, Model model) {
        Beer beer = beerRepository.findById(beerId);
        model.addAttribute("beer", beer);
        return "beer/beer";
    }

    @GetMapping("/update/{beerId}")
    public String updateForm(@PathVariable Long beerId, Model model) {
        Beer beer = beerRepository.findById(beerId);
        model.addAttribute("beer", beer);
        return "beer/update";
    }

    @PostMapping("/update/{beerId}")
    public String updateBeer(@ModelAttribute("Beer") Beer beer, Model model) {
        beerRepository.update(beer);
        return "redirect:/product/beers/" + beer.getBeerId();
    }

    @GetMapping("/remove/{beerId}")
    public String removeBeer(@PathVariable Long beerId, Model model) {
        beerRepository.delete(beerId);
        model.addAttribute("removeStatus", true);
        model.addAttribute("beerId", beerId);
        return "redirect:/product/beers";
    }

    @PostConstruct
    public void init() {
        beerRepository.save(new Beer("코젤다크", 3800, 1, 4.8));
        beerRepository.save(new Beer("카스", 2900, 2, 4.5));
        beerRepository.save(new Beer("구미호", 3700, 3, 6.3));
    }
}

package com.wwsis.noclegi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class hotelController {
    private HotelRepo hotelRepo;

    @Autowired
    public hotelController(HotelRepo hotelRepo) {
        this.hotelRepo = hotelRepo;
    }

    @RequestMapping("/dodawanie")
    public String dodajemy() {
        return "dodaj";
    }

    @RequestMapping("/dodaj")
    public String dodajemyDane(
            @RequestParam("nazwa") String nazwa,
            @RequestParam("telefon") String telefon,
            @RequestParam("email") String email,
            @RequestParam("liczbaGwiazdek") Integer liczbaGwiazdek,
            @RequestParam("opis") String opis,
            Model model)
            throws Exception {

        Hotel hotel = new Hotel(nazwa, telefon, email, liczbaGwiazdek, opis);
        System.out.println(hotel);
        hotelRepo.save(hotel);
        model.addAttribute("hotel", hotel);
        return "Widok";
    }

    @RequestMapping("/pokaz")
    public String pokaz(Model model) {
        for (Hotel hotele : hotelRepo.findAll()) {
            System.out.println(hotele);
        }
        model.addAttribute("hotele", hotelRepo.findAll());
        return "pokaz";
    }

    @RequestMapping("/kasuj")
    public String kasuj(@RequestParam("id") Integer id, Model model){
        hotelRepo.deleteById(id);
        model.addAttribute("hotele", hotelRepo.findAll());
        return "pokaz";
    }

    @RequestMapping("/wyszukaj")
    public String wyszukaj(@RequestParam("kryterium") String kryterium, Model model){
        model.addAttribute("hotele", hotelRepo.findAllBynazwa(kryterium));
        return "pokaz";
    }

    @RequestMapping("/przekieruj")
    public String przekieruj(
            @RequestParam("id") Integer id, Model model
    )
            throws Exception {
        System.out.println(hotelRepo.findById(id));
        model.addAttribute("hotel", hotelRepo.findById(id));
        return "aktualizuj";
    }

    @RequestMapping("/aktualizuj")
    public String update(
            @RequestParam("id") Integer id,
            @RequestParam("nazwa") String nazwa,
            @RequestParam("telefon") String telefon,
            @RequestParam("email") String email,
            @RequestParam("liczbaGwiazdek") Integer liczbaGwiazdek,
            @RequestParam("opis") String opis,
            Model model)
            throws Exception {

        Hotel hotel = new Hotel(id, nazwa, telefon, email, liczbaGwiazdek, opis);
        System.out.println(hotel);
        hotelRepo.save(hotel);
        model.addAttribute("hotel", hotel);
        return "Widok";
    }
}



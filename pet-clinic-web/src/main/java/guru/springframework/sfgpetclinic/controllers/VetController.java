package guru.springframework.sfgpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class VetController {

    @RequestMapping({"/vet","/vets","/vets/index.html","/vets/index"})
    public String list(){
        return "vets/index";
    }
}

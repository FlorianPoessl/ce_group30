package ce.group30.fahrradlenker.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class FahrradlenkerController {
    @RequestMapping("/index")
    public ModelAndView myindex(){
        return new ModelAndView("index");
    }
}

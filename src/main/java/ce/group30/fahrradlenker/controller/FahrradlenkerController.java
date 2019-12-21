package ce.group30.fahrradlenker.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class FahrradlenkerController {
    @RequestMapping("/index")
    public ModelAndView getIndex(){
        return new ModelAndView("index");
    }

    @RequestMapping("/customer")
    public ModelAndView getCustomer(){
        return new ModelAndView("customer");
    }

    @RequestMapping("/gearing")
    public ModelAndView getGearing(){
        return new ModelAndView("gearing");
    }

    @RequestMapping("/handle")
    public ModelAndView getHandle(){
        return new ModelAndView("handle");
    }

    @RequestMapping("/material")
    public ModelAndView getMaterial(){
        return new ModelAndView("material");
    }

    @RequestMapping("/order")
    public ModelAndView getOrder(){
        return new ModelAndView("order");
    }

    @RequestMapping("/handlebar")
    public ModelAndView getHandlebar(){
        return new ModelAndView("handlebar");
    }


}

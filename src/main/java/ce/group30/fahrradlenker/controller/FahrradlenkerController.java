package ce.group30.fahrradlenker.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

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
    public ModelAndView getHandlebar() throws IOException {
        final URL url = new URL("https://www.maripavi.at/produkt/lenkertyp");
        final URLConnection urlConnection = url.openConnection();
        urlConnection.setDoOutput(true);
        urlConnection.setRequestProperty("Content-Type", "application/json; charset=utf-8");
        urlConnection.connect();
        /*final OutputStream outputStream = urlConnection.getOutputStream();
        outputStream.write(("{\"fNamn\": \"" + stringData + "\"}").getBytes("UTF-8"));
        outputStream.flush();*/
        final InputStream inputStream = urlConnection.getInputStream();
        System.out.println(inputStream.read());
        return new ModelAndView("handlebar");
    }


}

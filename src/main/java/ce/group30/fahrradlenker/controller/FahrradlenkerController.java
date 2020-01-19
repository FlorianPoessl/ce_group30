package ce.group30.fahrradlenker.controller;

import ce.group30.fahrradlenker.objects.Customer;
import ce.group30.fahrradlenker.objects.Order;
import ce.group30.fahrradlenker.services.CustomerService;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponentsBuilder;

import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

@RestController
public class FahrradlenkerController {

    private static CustomerService customerService = new CustomerService();

    @RequestMapping("/index")
    public ModelAndView getIndex(){
        return new ModelAndView("index");
    }

    @RequestMapping("/customer")
    public ModelAndView getCustomer(){
        return new ModelAndView("customer");
    }

    @PostMapping("/newCustomer")
    public void addNewCustomer(@RequestParam("vorname") String vorname, @RequestParam("nachname") String nachname) {
        System.out.println(vorname + " " + nachname);
        customerService.addNewCustomer(vorname, nachname);
    }

    @RequestMapping("/gearing")
    public ModelAndView getGearing(){
        return new ModelAndView("gearing");
    }

    @GetMapping("/getGearing")
    public String getAvailableGearings() throws IOException {
        String handlebar = customerService.getCustomer().getBestellungen().getLenkertyp();
        return (this.createRequest("https://www.maripavi.at/produkt/schaltung", handlebar, "lenkertyp"));
    }

    @PostMapping("/addGearing")
    public void addGearing(@RequestParam("gearing") String gearing) {
        customerService.setSchaltung(gearing);
    }

    @RequestMapping("/handle")
    public ModelAndView getHandle(){
        return new ModelAndView("handle");
    }

    @GetMapping("/getHandle")
    public String getAvailableHandles() throws IOException {
        String material = customerService.getCustomer().getBestellungen().getMaterial();
        return (this.createRequest("https://www.maripavi.at/produkt/griff", material, "material"));
    }

    @PostMapping("/addHandle")
    public void addHandle(@RequestParam("handle") String handle) {
        customerService.setGriff(handle);
    }

    @RequestMapping("/material")
    public ModelAndView getMaterial(){
        return new ModelAndView("material");
    }

    @GetMapping("/getMaterial")
    public String getAvailableMaterial() throws IOException {
        String handlebar = customerService.getCustomer().getBestellungen().getLenkertyp();
        return (this.createRequest("https://www.maripavi.at/produkt/material", handlebar, "lenkertyp"));
    }

    @PostMapping("/addMaterial")
    public void addMaterial(@RequestParam("material") String material) {
        customerService.setMaterial(material);
    }

    @RequestMapping("/order")
    public ModelAndView getOrder(){
        return new ModelAndView("order");
    }

    @GetMapping("/getOrderInfo")
    public String getAvailableOrder() throws IOException {
        return customerService.getOrderAndCustomerInfoJson();
    }

    @RequestMapping("/handlebar")
    public ModelAndView getHandlebar() throws IOException {
        return new ModelAndView("handlebar");
    }

    @GetMapping("/getHandlebar")
    public String getAvailableHandlebars() throws IOException {
        return (this.createRequest("https://www.maripavi.at/produkt/lenkertyp", null, null));
    }

    @PostMapping("/addHandlebar")
    public void addHandlebar(@RequestParam("handlebar") String handlebar) {
        Order order = new Order();
        System.out.println("addHandlebar called");
        customerService.getCustomer().setBestellungen(order);
        customerService.setLenkertyp(handlebar);
    }

    @GetMapping("/checkOrder")
    public String checkOrder() throws IOException {
        Map<String, String> data = customerService.getOrderInfoJson();

        return this.createPostRequest("https://www.maripavi.at/bestellung", data);
    }

    public String createRequest(String specifiedUrl, String parameter, String parameterDetail) throws IOException {
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();

        System.out.println(specifiedUrl);
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(specifiedUrl);;
        if(parameter != null) {
            builder = builder.queryParam(parameterDetail, parameter);
        }

        System.out.println(builder.toUriString());

        HttpEntity<?> entity = new HttpEntity<>(headers);

        HttpEntity<String> response = restTemplate.exchange(
                builder.toUriString(),
                HttpMethod.GET,
                entity,
                String.class);

        return response.getBody();
    }

    public String createPostRequest(String specifiedUrl, Map<String, String> parameter) throws IOException {
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();

        System.out.println(specifiedUrl);
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(specifiedUrl);;
        for(Map.Entry<String, String> parameterEntry : parameter.entrySet()) {
            builder = builder.queryParam(parameterEntry.getKey(), parameterEntry.getValue());
        }

        System.out.println(builder.toUriString());

        HttpEntity<?> entity = new HttpEntity<>(headers);

        HttpEntity<String> response = restTemplate.exchange(
                builder.toUriString(),
                HttpMethod.POST,
                entity,
                String.class);

        return response.getBody();
    }

}

package ce.group30.fahrradlenker.controller;

import ce.group30.fahrradlenker.objects.Customer;
import ce.group30.fahrradlenker.objects.Order;
import ce.group30.fahrradlenker.objects.Test;
import ce.group30.fahrradlenker.services.CustomerService;
import ce.group30.fahrradlenker.services.ParameterStringBuilder;
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
    public String getAvailableGearings(@RequestParam("data") String data) throws IOException {
        return (this.createRequest("https://www.maripavi.at/produkt/schaltung", data, "lenkertyp"));
    }

    @RequestMapping("/handle")
    public ModelAndView getHandle(){
        return new ModelAndView("handle");
    }

    @GetMapping("/getHandle")
    public String getAvailableHandles(@RequestParam("data") String data) throws IOException {
        return (this.createRequest("https://www.maripavi.at/produkt/griff", data, "material"));
    }

    @RequestMapping("/material")
    public ModelAndView getMaterial(){
        return new ModelAndView("material");
    }

    @GetMapping("/getMaterial")
    public String getAvailableMaterial() throws IOException {
        String handlebar = customerService.getCustomer().getBestellungen().getLenkertyp();
        System.out.println(handlebar);
        return (this.createRequest("https://www.maripavi.at/produkt/material/", handlebar, "lenkertyp"));
    }

    @RequestMapping("/order")
    public ModelAndView getOrder(){
        return new ModelAndView("order");
    }

    @GetMapping("/getOrder")
    public String getAvailableOrder() throws IOException {
        return (this.createRequest("https://www.maripavi.at/produkt/lenkertyp", null, null));
    }

    @RequestMapping("/handlebar")
    public ModelAndView getHandlebar() throws IOException {
        return new ModelAndView("handlebar");
    }

    @GetMapping("/getHandlebar")
    public String getAvailableHandlebars() throws IOException {
        System.out.println("Nachname: " + customerService.getCustomer().getNachname());
        return (this.createRequest("https://www.maripavi.at/produkt/lenkertyp", null, null));
    }

    @PostMapping("/addHandlebar")
    public void addHandlebar(@RequestParam("handlebar") String handlebar) {
        Order order = new Order();
        System.out.println("addHandlebar called");
        customerService.getCustomer().setBestellungen(order);
        customerService.setLenkertyp(handlebar);
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

        /*URL url = new URL(specifiedUrl);

        byte[] postDataBytes = null;
        if (parameter != null) {
            Map<String, Object> params = new LinkedHashMap<>();
            params.put(parameterDetail, parameter);

            StringBuilder postData = new StringBuilder();
            for (Map.Entry<String, Object> param : params.entrySet()) {
                if (postData.length() != 0) postData.append('&');
                postData.append(URLEncoder.encode(param.getKey(), "UTF-8"));
                postData.append('=');
                postData.append(URLEncoder.encode(String.valueOf(param.getValue()), "UTF-8"));
            }
            postDataBytes = postData.toString().getBytes("UTF-8");
        }
        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
        conn.setRequestMethod("GET");
        conn.setDoOutput(true);
        if(parameter != null) {
            conn.getOutputStream().write(postDataBytes);
            System.out.println(conn.getRequestMethod());
        }
        Reader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
        StringBuilder data = new StringBuilder();
        for (int c; (c = in.read()) >= 0;) {
            data.append((char)c);
        }
        String intentData = data.toString();
        System.out.println(intentData);

        return intentData;


        /*URL url = new URL(specifiedUrl);
        HttpsURLConnection con = (HttpsURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("Content-Type", "application/json");

        if(parameter != null) {
            System.out.println(parameterDetail + ":" + parameter);
            Map<String, String> parameters = new HashMap<>();
            parameters.put(parameterDetail, parameter);



            con.setDoOutput(true);
            DataOutputStream out = new DataOutputStream(con.getOutputStream());
            out.writeBytes(ParameterStringBuilder.getParamsString(parameters));
            out.flush();
            out.close();
        }

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer content = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();
        System.out.println(content.toString());
        con.disconnect();
        return content.toString();*/
    }

}

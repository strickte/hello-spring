package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@RequestMapping("hello")
public class Controllers {
    //handle request at path http://localhost:8080/hello

//    @GetMapping("hello")
//    @ResponseBody
//    public String hello(){
//        return "Hello, Spring!";
//    }

//    //handle request at path //http://localhost:8080/hello/goodbye
//    @GetMapping("goodbye")
//    public String goodbye(){
//        return "Goodbye, Spring!";
//    }

    //handle requests of the form http://localhost:8080/hello?name=LaunchCode
    @RequestMapping(method = RequestMethod.POST)
    public String helloWithQueryParam(@RequestParam String name, @RequestParam String language){
        if (name == null) {
            name = "World";
        }
        return createMessage(name, language);
    }

    public static String createMessage(String n, String l) {
        String greeting = "";
        if (l.equals("english")) {
            greeting = "Hello, ";
        } else if (l.equals("german")) {
            greeting = "Hallo, ";
        } else if (l.equals("french")) {
            greeting = "Bonjour, ";
        } else if (l.equals("japanese")) {
            greeting = "Konnichiwa, ";
        } else if (l.equals("italian")) {
            greeting = "Bonjourno, ";
        }
        return greeting + n + "!";
    }

//    //handle requests of the form http://localhost:8080/hello/LaunchCode
//    @GetMapping("{name}")
//    public String helloWithPathParam(@PathVariable String name){
//        return "Hello, " + name + "!";
//    }

    //handles requests for http://localhost:8080/hello/form
    @GetMapping("form")
    public String helloForm() {
        return "<html>" +
                "<body>" +
                "<form action = '/hello' method = 'post'>" + // submit a request to /hello
                "<input type = 'text' name = 'name' >" +

                "<label for='language'>Choose a language:</label>" +
                "<select name='language' id='cars'>" +
                "    <option value='english'>English</option>" +
                "    <option value='german'>German</option>" +
                "    <option value='french'>French</option>" +
                "    <option value='japanese'>Japanese</option>" +
                "    <option value='italian'>Italian</option>" +
                "</select>" +
                "<input type = 'submit' value = 'Greet Me!' >" +
                "</form>" +
                "</body>" +
                "</html>";
    }
}

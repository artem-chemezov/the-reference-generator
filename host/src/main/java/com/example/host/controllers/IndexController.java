package com.example.host.controllers;

import com.example.host.Ref;
import com.example.host.db.Queries;
import com.google.gson.Gson;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
public class IndexController {
    ConfigurableApplicationContext ctx = (ConfigurableApplicationContext) new ClassPathXmlApplicationContext("file:src/main/java/com/example/host/Config.xml");
    Queries qw = new Queries((JdbcTemplate) ctx.getBean("jdbcTemplate"));

    @RequestMapping("/")
    public String home() {
        return "Its /";
    }

    @RequestMapping(value = "/", method = RequestMethod.GET, params = {"shortname"})
    public String js(@RequestParam(value = "shortname") String shortname) {
        return "[" + new Gson().toJson(new Ref("vk.com", "vk")) + "]";
    }


    @RequestMapping(value = "/full", method = RequestMethod.GET, params = {"shortname"})
    public String getFull(@RequestParam(value = "shortname") String shortname) {
        return "[" + new Gson().toJson(qw.getFull(shortname)) + "]";
    }

    @RequestMapping(value = "/short", method = RequestMethod.GET, params = {"fullname"})
    public String getShort(@RequestParam(value = "fullname") String fullname) {
        return "[" + new Gson().toJson(qw.getShort(fullname)) + "]";
    }
/*
    @RequestMapping(value = "/post", method = RequestMethod.POST)
    public String put(@RequestBody Ref ref) {
            qw.putData(ref);
            return "[" + new Gson().toJson(ref) + "]";
    }
*/
}
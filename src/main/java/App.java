import org.apache.log4j.BasicConfigurator;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");
        String layout = "templates/layout.vtl";

        BasicConfigurator.configure();

        get("/", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("template", "templates/index.vtl");
            return new VelocityTemplateEngine().render(
                    new ModelAndView(model, layout)
            );
        });

        get("/stylists", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("stylists",Stylist.all());
            model.put("template", "templates/stylists.vtl");
            return new VelocityTemplateEngine().render(
                    new ModelAndView(model, layout)
            );
        });
        get("/stylists/new", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("template", "templates/add-stylist-form.vtl");
            return new VelocityTemplateEngine().render(
                    new ModelAndView(model, layout)
            );
        });

        post("/stylists", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            String firstName = req.queryParams("firstName");
            String secondName = req.queryParams("secondName");
            String Age = req.queryParams("Age");
            String Email = req.queryParams("Email");
            Stylist stylist = new Stylist(firstName,secondName,Email,Integer.parseInt(Age));
            stylist.save();
            model.put("template", "templates/stylists.vtl");
            return new VelocityTemplateEngine().render(
                    new ModelAndView(model, layout)
            );
        });





        get("/clients", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("template", "templates/clients.vtl");
            return new VelocityTemplateEngine().render(
                    new ModelAndView(model, layout)
            );
        });
        get("/clients/new", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("template", "templates/add-client-form.vtl");
            return new VelocityTemplateEngine().render(
                    new ModelAndView(model, layout)
            );
        });

    }
}

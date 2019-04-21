import org.apache.log4j.BasicConfigurator;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.get;
import static spark.Spark.staticFileLocation;

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

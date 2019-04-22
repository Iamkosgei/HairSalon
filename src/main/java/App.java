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

        ProcessBuilder process = new ProcessBuilder();
        Integer port;
        if (process.environment().get("PORT") != null) {
            port = Integer.parseInt(process.environment().get("PORT"));
        } else {
            port = 4567;
        }
        port(port);


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
            model.put("template", "templates/stylist-added-success-page.vtl");
            return new VelocityTemplateEngine().render(
                    new ModelAndView(model, layout)
            );
        });

        get("/stylist/:id", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
           Stylist stylist = Stylist.find(Integer.parseInt(req.params(":id")));
            model.put("stylist", stylist);
            model.put("template", "templates/stylist.vtl");
            return new VelocityTemplateEngine().render(
                    new ModelAndView(model, layout)
            );
        });

        post("/stylist/:id/delete", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            Stylist stylist = Stylist.find(Integer.parseInt(req.params(":id")));
            stylist.delete();
            model.put("template", "templates/stylist-delete-success-page.vtl");
            return new VelocityTemplateEngine().render(
                    new ModelAndView(model, layout)
            );
        });

        get("/stylist/:id/edit", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            Stylist stylist = Stylist.find(Integer.parseInt(req.params(":id")));
            model.put("stylist", stylist);
            model.put("template", "templates/stylist-edit.vtl");
            return new VelocityTemplateEngine().render(
                    new ModelAndView(model, layout)
            );
        });

        post("/stylist/:id/edit", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            String firstName = req.queryParams("firstName");
            String secondName = req.queryParams("secondName");
            String age = req.queryParams("Age");
            String email = req.queryParams("Email");
            Stylist stylist = Stylist.find(Integer.parseInt(req.params(":id")));
            stylist.update(firstName,secondName,email,Integer.parseInt(age));
            String url = String.format("/stylist/%d",stylist.getId());
            res.redirect(url);
            return new VelocityTemplateEngine().render(
                    new ModelAndView(model, layout)
            );
        });





        get("/clients", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("clients", Client.all());
            model.put("template", "templates/clients.vtl");
            return new VelocityTemplateEngine().render(
                    new ModelAndView(model, layout)
            );
        });
        get("/clients/new", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("stylists",Stylist.all());
            model.put("template", "templates/add-client-form.vtl");
            return new VelocityTemplateEngine().render(
                    new ModelAndView(model, layout)
            );
        });

        post("/clients", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            String firstName = req.queryParams("firstName");
            String secondName = req.queryParams("secondName");
            String phone = req.queryParams("phone");
            String email = req.queryParams("email");
            String country = req.queryParams("country");
            String county = req.queryParams("county");
            String stylistId = req.queryParams("stylistId");
            Client client = new Client(firstName,secondName,phone,email,country,county,Integer.parseInt(stylistId));
            client.save();
            model.put("template", "templates/client-added-success-page.vtl");
            return new VelocityTemplateEngine().render(
                    new ModelAndView(model, layout)
            );
        });

        get("/client/:id", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            Client client = Client.find(Integer.parseInt(req.params(":id")));
            model.put("client", client);
            model.put("template", "templates/client.vtl");
            return new VelocityTemplateEngine().render(
                    new ModelAndView(model, layout)
            );
        });

        post("/client/:id/delete", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            Client client = Client.find(Integer.parseInt(req.params(":id")));
            client.delete();
            res.redirect("/clients");
            return new VelocityTemplateEngine().render(
                    new ModelAndView(model, layout)
            );
        });

        get("/client/:id/edit", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            Client client = Client.find(Integer.parseInt(req.params(":id")));
            model.put("client", client);
            model.put("stylists",Stylist.all());
            model.put("template", "templates/client-edit.vtl");
            return new VelocityTemplateEngine().render(
                    new ModelAndView(model, layout)
            );
        });

        post("/client/:id/edit", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            String firstName = req.queryParams("firstName");
            String secondName = req.queryParams("secondName");
            String phone = req.queryParams("phone");
            String email = req.queryParams("email");
            String country = req.queryParams("country");
            String county = req.queryParams("county");
            String stylistId = req.queryParams("stylistId");
            Client client = Client.find(Integer.parseInt(req.params(":id")));
            client.update(firstName,secondName,phone,email,country,county,Integer.parseInt(stylistId));
            String url = String.format("/client/%d",client.getId());
            res.redirect(url);
            return new VelocityTemplateEngine().render(
                    new ModelAndView(model, layout)
            );
        });

    }
}

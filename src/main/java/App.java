import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;
import java.io.Console;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/",(request,response)->{
      Map<String, Object> model =  new HashMap<String, Object>();
      model.put("template","templates/index.vtl");
      return new ModelAndView(model,layout);
    }, new VelocityTemplateEngine());

    post("/resume", (request, response)->{
      Map<String, Object> model = new HashMap<String, Object>();
      ArrayList<Job> jobList = request.session().attribute("jobs");
      if(jobList ==null){
        jobList = new ArrayList<Job>();
        request.session().attribute("jobs",jobList);
      }
      Job aJob = new Job(request.queryParams("title"),request.queryParams("company"),request.queryParams("description"),request.queryParams("start-date"),request.queryParams("end-date"));
      jobList.add(aJob);
      model.put("jobs",request.session().attribute("jobs"));
      model.put("template","templates/resume.vtl");
      return new ModelAndView(model,layout);
    }, new VelocityTemplateEngine());

  }
}

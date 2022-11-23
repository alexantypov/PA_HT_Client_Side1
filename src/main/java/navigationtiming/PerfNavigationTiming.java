package navigationtiming;

import org.json.JSONException;
import org.json.simple.JSONObject;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import pages.HomePage;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

import static java.awt.SystemColor.window;

public class PerfNavigationTiming extends HomePage {
    public PerfNavigationTiming(WebDriver driver) {
        super(driver);
    }

    public void PerfNavigationTiming(String url) {

        driver.get(url);
        perfNavigationTiming("Home Page");
    }
//    private Map<String, Object> timing = null;
//    JavascriptExecutor js;
//    private static FileWriter fileWriter;

    public void perfNavigationTiming(String pageName) {

        Map<String, Object> timings = null;
        String javaScriptForPerformance = "var timings = performance.timing || {}; return timings;";

        long responseStart = 0;
        long navigationStart = 0;
        long domInteractive = 0;
        long domLoading = 0;
        long loadEventEnd = 0;
        long domComplete = 0;
        long loadEventStart = 0;

        String responseStart_ = "responseStart";
        String navigationStart_ = "navigationStart";
        String domInteractive_ = "domInteractive";
        String domLoading_ = "domLoading";
        String loadEventEnd_ = "loadEventEnd";
        String domComplete_ = "domComplete";
        String loadEventStart_ = "loadEventStart";

        JavascriptExecutor jsrunner = (JavascriptExecutor) driver;

        timings = (Map<String, Object>) jsrunner.executeScript(javaScriptForPerformance);


        for (Map.Entry<String, Object> t : timings.entrySet()) {
            if (t.getKey().equals(responseStart_)) responseStart = (long) t.getValue();
            if (t.getKey().equals(navigationStart_)) navigationStart = (long) t.getValue();
            if (t.getKey().equals(domInteractive_)) domInteractive = (long) t.getValue();
            if (t.getKey().equals(domLoading_)) domLoading = (long) t.getValue();
            if (t.getKey().equals(loadEventEnd_)) loadEventEnd = (long) t.getValue();
            if (t.getKey().equals(domComplete_)) domComplete = (long) t.getValue();
            if (t.getKey().equals(loadEventStart_)) loadEventStart = (long) t.getValue();
        }

        long latency = responseStart - navigationStart;
        long tti = domInteractive - domLoading;
        long total_time = loadEventEnd - navigationStart;
        long ttl = domComplete - domInteractive;
        long onload = loadEventEnd - loadEventStart;

        System.out.println(pageName + ":");
        System.out.println("latency = " + latency + " ms");
        System.out.println("tti = " + tti + " ms");
        System.out.println("total_time = " + total_time + " ms");
        System.out.println("ttl = " + ttl + " ms");
        System.out.println("onload = " + onload + " ms");
        System.out.println();

//----JSON

        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yy HH:mm:ss");

        String path = "src/main/resources/perfomance.json";

        JSONObject json = new JSONObject();
        JSONObject innerJsonObject = new JSONObject();

        try {
            innerJsonObject.put("tti", tti);
            innerJsonObject.put("total_time", total_time);
            innerJsonObject.put("ttl", ttl);
            innerJsonObject.put("onload", onload);

            json.put(pageName, innerJsonObject);
            json.put("Date of testing", dtf.format(localDateTime));


        } catch (JSONException e) {
            e.printStackTrace();
        }

        try (PrintWriter out = new PrintWriter(new FileWriter(path, true))) {
            out.write(json.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

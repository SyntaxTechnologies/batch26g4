package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.CommonMethods;

public class Hooks extends CommonMethods {

    @Before
    public void start() {
        openBrowserAndLaunchApplication();
    }

    @After
    public void end(Scenario scenario) {

        try {
            if (driver != null) {

                byte[] picture = takeScreenshot(
                        (scenario.isFailed() ? "failed/" : "passed/")
                                + scenario.getName()
                );

                scenario.attach(
                        picture,
                        "image/png",
                        scenario.getName()
                );
            }

        } catch (Exception e) {

            System.out.println(
                    "Screenshot could not be taken: " + e.getMessage()
            );

        } finally {

            closeBrowser();
        }
    }
}
import java.util.ArrayList;

public class ScenarioRepository {

    public static ArrayList<Scenario> getAllScenarios() {

        ArrayList<Scenario> scenarios = new ArrayList<>();


        // EDUCATION - TEAM ALPHA
        Scenario educationAlpha = new Scenario("Scenario C - Team Alpha", "Education");

        // Dimension 1
        Dimension usability = new Dimension("Usability", 25);

        Metric susScore = new Metric("SUS Score", 50, "Higher", 0, 100, "points", 89);

        Metric onboardingTime = new Metric("Onboarding Time", 50, "Lower", 0, 60, "minutes", 5);

        usability.addMetric(susScore);
        usability.addMetric(onboardingTime);


        // Dimension 2
        Dimension reliability = new Dimension("Reliability", 20);

        Metric uptime = new Metric("Uptime", 50, "Higher", 95, 100, "%", 98);

        Metric mttr = new Metric("MTTR", 50, "Lower", 0, 120, "minutes", 20);

        reliability.addMetric(uptime);
        reliability.addMetric(mttr);


        educationAlpha.addDimension(usability);
        educationAlpha.addDimension(reliability);

        scenarios.add(educationAlpha);

        // EDUCATION - TEAM BETA
        Scenario educationBeta = new Scenario("Scenario D - Team Beta", "Education");


        // Dimension 1
        Dimension performance = new Dimension("Performance", 20);

        Metric videoStart = new Metric("Video Start Time", 50, "Lower", 0, 15, "seconds", 3);

        Metric concurrentUsers = new Metric("Concurrent Exams", 50, "Higher", 0, 600, "users", 450);

        performance.addMetric(videoStart);
        performance.addMetric(concurrentUsers);

        educationBeta.addDimension(performance);

        scenarios.add(educationBeta);


        // HEALTH - HOSPITAL SYSTEM
        Scenario hospital = new Scenario("Scenario A - Hospital System", "Health");

        Dimension accessibility = new Dimension("Accessibility", 20);

        Metric wcag = new Metric("WCAG Compliance", 50, "Higher", 0, 100, "%", 92);

        Metric screenReader = new Metric("Screen Reader Score", 50, "Higher", 0, 100, "%", 85);

        accessibility.addMetric(wcag);
        accessibility.addMetric(screenReader);

        hospital.addDimension(accessibility);

        scenarios.add(hospital);


        // HEALTH - CLINIC SYSTEM
        Scenario clinic = new Scenario("Scenario B - Clinic System", "Health");

        //Dimension 1
        Dimension functionality = new Dimension("Functional Suitability", 15);

        Metric featureCompletion = new Metric("Feature Completion", 50, "Higher", 0, 100, "%", 80);

        Metric submitRate = new Metric("Submit Rate", 50, "Higher", 0, 100, "%", 75);

        functionality.addMetric(featureCompletion);
        functionality.addMetric(submitRate);

        clinic.addDimension(functionality);

        scenarios.add(clinic);


        return scenarios;
    }
}

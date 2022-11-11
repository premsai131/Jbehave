package runners;
//import org.junit.jupiter.api.Test;

import com.amazon.example.hooks.ApplicationHooks;
import com.amazon.example.stepDefinitions.LoginPageTest;
import com.amazon.example.stepDefinitions.LoginWithOutCreds;
import io.qameta.allure.jbehave.AllureJbehave;
import org.jbehave.core.ConfigurableEmbedder;
import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.embedder.Embedder;
import org.jbehave.core.reporters.Format;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;
import org.junit.Test;


import java.io.IOException;
import java.util.Arrays;
import java.util.List;
//@RunWith(SpringJUnit4ClassRunner.class)
public class StoryRunner1 extends ConfigurableEmbedder{
    public Embedder embedder;
   static String[] stories={
     "homepage.story",
     "LoginPage.story",
           "LoginWithoutCreds.story"
    };
    private static List<String> storyPaths = Arrays.asList("com/amazon/example/stories/LoginWithoutCreds.story");
   @Test
    public void run() {
       embedder = configuredEmbedder();
       configuredEmbedder()
               .embedderControls()
               .useThreads(1);
       embedder.configuration();
       String storypath1 = "resources/homepage.story";
        embedder.runStoriesAsPaths(storyPaths);
   }
    public Configuration configuration(){
        System.setProperty("allure.results.directory", "build/allure-results");
        return (new MostUsefulConfiguration().useStoryReporterBuilder(new StoryReporterBuilder().withFormats(Format.CONSOLE, Format.TXT, Format.HTML, Format.XML, Format.STATS).withReporters(new AllureJbehave())));
    }
    @Override
    public InjectableStepsFactory stepsFactory() {
        try {
            return new InstanceStepsFactory(configuration(), new ApplicationHooks(), new LoginPageTest(), new LoginWithOutCreds());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

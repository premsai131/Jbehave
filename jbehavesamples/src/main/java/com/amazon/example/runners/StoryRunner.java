package com.amazon.example.runners;

import com.amazon.example.hooks.ApplicationHooks;
import com.amazon.example.steps.LoginPageTest;
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
public class StoryRunner extends ConfigurableEmbedder{
    public Embedder embedder;
   static String[] stories={
     "homepage.story",
     "LoginPage.story"
    };
    private static List<String> storyPaths = Arrays.asList("com/amazon/example/stories/"+stories[1]);
   @Test
    public void run() {
       embedder = configuredEmbedder();
       configuredEmbedder()
               .embedderControls()
               .doGenerateViewAfterStories(true)
               .doIgnoreFailureInStories(false)
               .doIgnoreFailureInView(true)
               .doVerboseFailures(true)
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
            return new InstanceStepsFactory(configuration(),new LoginPageTest());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

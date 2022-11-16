package com.amazon.example.stories;

import java.io.IOException;
import java.util.List;


import com.amazon.example.stepDefinitions.LoginPageTest;
import com.amazon.example.stepDefinitions.LoginWithOutCreds;
import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.reporters.Format;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;

import com.amazon.example.hooks.ApplicationHooks;

import io.qameta.allure.jbehave.AllureJbehave;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.IncludeTags;
import org.junit.runner.RunWith;

import org.jbehave.core.Embeddable;
import org.jbehave.core.io.StoryFinder;
import org.junit.runner.RunWith;

import static java.util.Arrays.asList;
import static org.jbehave.core.io.CodeLocations.codeLocationFromClass;

@RunWith(JUnitPlatform.class)
@IncludeTags("SmokeTest")
public class StoryRunner2 extends JUnitStories{

    @Override
	public Configuration configuration() {
		Class<? extends Embeddable> embeddableClass = this.getClass();
        return (new MostUsefulConfiguration().useStoryReporterBuilder(new StoryReporterBuilder().withFormats(Format.CONSOLE, Format.TXT, Format.HTML, Format.XML, Format.STATS).withReporters(new AllureJbehave())));

    }
    @Override
	public InjectableStepsFactory stepsFactory() {
        try {
            return new InstanceStepsFactory(configuration(), new LoginWithOutCreds(),new ApplicationHooks(), new LoginPageTest());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public List<String> storyPaths() {
        return new StoryFinder().findPaths(
            codeLocationFromClass(this.getClass()).getFile(), asList("**/"
                    + System.getProperty("storyFilter", "*") + ".story"),
            null);
    }

}
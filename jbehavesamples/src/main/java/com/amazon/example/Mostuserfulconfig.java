package com.amazon.example;

import com.amazon.example.steps.BookMyFlight;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;

import java.util.Arrays;
import java.util.List;

public class Mostuserfulconfig extends JUnitStories {

    public Mostuserfulconfig(){
        super();
    }
    @Override
    public InjectableStepsFactory stepsFactory() {
        return new InstanceStepsFactory(configuration(), new BookMyFlight());
    }

    protected List<String> storyPaths() {
        return Arrays.asList("resources/homepage.story");
    }
}

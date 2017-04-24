package com.automation.ui.commonui.test;

import java.util.List;

import org.jbehave.core.annotations.Configure;
import org.jbehave.core.annotations.UsingEmbedder;
import org.jbehave.core.embedder.Embedder;
import org.jbehave.core.io.StoryFinder;
import org.junit.runner.RunWith;

@RunWith(SpringAnnotatedEmbedderRunner.class)
@Configure()
@UsingEmbedder(embedder = Embedder.class, generateViewAfterStories = true, ignoreFailureInStories = false, ignoreFailureInView = false, storyTimeoutInSecs = 1200)
@UsingSpring(resources = { "classpath:crts-application-context.xml",
		"classpath:steps/dsl/crts-jbehave-commons-dsl-configuration-    steps.xml",
		"classpath:steps/dsl/crts-jbehave-order-dsl-steps-    context.xml" })
public class Order1Story extends CommonsStoryConfiguration {

	protected List<String> storyPaths() {
		return new StoryFinder().findPaths(codeLocationFromClass(this.getClass()).getFile(),
				asList("**/" + System.getProperty("storyFilter", "*") + "order/dsl/order-  1P-dsl*.story"), null);
	}

}

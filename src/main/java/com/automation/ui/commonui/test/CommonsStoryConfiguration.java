package com.automation.ui.commonui.test;

import java.text.SimpleDateFormat;
import java.util.List;

import org.jbehave.core.InjectableEmbedder;
import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.embedder.StoryControls;
import org.jbehave.core.failures.FailureStrategy;
import org.jbehave.core.failures.SilentlyAbsorbingFailure;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.parsers.RegexPrefixCapturingPatternParser;
import org.jbehave.core.reporters.CrossReference;
import org.jbehave.core.reporters.Format;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.ParameterConverters;
import org.jbehave.core.steps.ParameterConverters.DateConverter;
import org.junit.Test;

public abstract class CommonsStoryConfiguration extends InjectableEmbedder {

	@Test
	public void run() throws Throwable {

		final CrossReference crossReference = new CrossReference().withJsonOnly().withOutputAfterEachStory(true)
				.excludingStoriesWithNoExecutedScenarios(true);

		final SeleniumContext seleniumContext = new SeleniumContext();

		// Step Monitor
		// final ContextView contextView = new
		// LocalFrameContextView().sized(640, 120);
		// final SeleniumStepMonitor stepMonitor = new
		// SeleniumStepMonitor(contextView,
		// seleniumContext, crossReference.getStepMonitor());

		// Formatting
		final Format[] formats = new Format[] { new SeleniumContextOutput(seleniumContext), CONSOLE, HTML };

		// StoryRporterBuilder
		final StoryReporterBuilder reporterBuilder = new StoryReporterBuilder();
		reporterBuilder.withCodeLocation(codeLocationFromClass(CommonsStoryConfiguration.class));
		reporterBuilder.withFailureTrace(true);
		reporterBuilder.withFailureTraceCompression(true);
		reporterBuilder.withDefaultFormats();
		reporterBuilder.withFormats(formats);
		reporterBuilder.withCrossReference(crossReference);

		// PatternParser
		final RegexPrefixCapturingPatternParser stepPatternParser = new RegexPrefixCapturingPatternParser("$");

		// Parameter converter
		final DateConverter dateConverter = new DateConverter(new SimpleDateFormat("yyyy-MM-dd"));
		final ParameterConverters parameterConverters = new ParameterConverters();
		parameterConverters.addConverters(dateConverter);

		// Failure Strategy
		final FailureStrategy strategy = new SilentlyAbsorbingFailure();

		// Story Control
		final StoryControls storyControls = new StoryControls();
		storyControls.doDryRun(false);
		storyControls.doSkipScenariosAfterFailure(false);

		// Configuration
		final Configuration configuration = injectedEmbedder().configuration();
		configuration.useStoryLoader(new LoadFromClasspath(CommonsStoryConfiguration.class));
		configuration.useStoryReporterBuilder(reporterBuilder);
		configuration.useStepPatternParser(stepPatternParser);
		configuration.useParameterConverters(parameterConverters);
		configuration.useFailureStrategy(strategy);
		configuration.useStoryControls(storyControls);
		// configuration.useStepMonitor(stepMonitor);

		injectedEmbedder().runStoriesAsPaths(storyPaths());

	}

	protected abstract List<String> storyPaths();

}

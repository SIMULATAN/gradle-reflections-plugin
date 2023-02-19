package com.github.simulatan.gradle.plugin.reflections;

import org.gradle.api.Plugin;
import org.gradle.api.Project;

public class ReflectionsPlugin implements Plugin<Project> {

	public static final String PLUGIN_NAME = ReflectionsPlugin.class.getPackage().getName();

	@Override
	public void apply(Project target) {
		// default settings
		target.getExtensions().create(ReflectionsPluginExtension.EXTENSION_NAME, ReflectionsPluginExtension.class);
		// generateMetadataIndex task
		target.getTasks().create(ReflectionsMetadataEmbeddingTask.TASK_NAME, ReflectionsMetadataEmbeddingTask.class);
	}
}

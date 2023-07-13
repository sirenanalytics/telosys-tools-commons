package org.telosys.tools.commons.plugins;

import java.io.File;
import java.util.List;

public class PluginHandler {

	public static IPlugin plugin;
	
	public static void setPlugin(IPlugin pluginToSet) {
		plugin = pluginToSet;
	}
	
	public static IPlugin getPlugin() {
		return plugin;
	}
	
	public static void addAnnotations(List annotations) {
		IPlugin plugin = getPlugin();
		if (plugin != null) {
			plugin.addAnnotations(annotations);
		}
	}
	
	public static void putGeneratorContexts(/*GeneratorContext*/ Object generatorContext, /*Model*/ Object model, String bundleName) {
		IPlugin plugin = getPlugin();
		if (plugin != null) {
			plugin.putGeneratorContexts(/*GeneratorContext*/ generatorContext, /*Model*/ model, bundleName) ;
		}
	}

	public static /*ParsingResult*/ Object parseModel(File modelFolder) {
		IPlugin plugin = getPlugin();
		if (plugin != null) {
			return plugin.parseModel(modelFolder);
		}
		return null;
	}
	
}

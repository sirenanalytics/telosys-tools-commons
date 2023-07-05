package org.telosys.tools.commons.plugins;

import java.util.List;

public interface IPlugin {

	public void addAnnotations(List annotations);
	public IPluginAnnotationData newPluginAnnotationData();
	public void putGeneratorContexts(/*GeneratorContext*/ Object generatorContext, /*Model*/ Object model, String bundleName);

}

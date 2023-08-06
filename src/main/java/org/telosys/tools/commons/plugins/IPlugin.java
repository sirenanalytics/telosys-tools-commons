package org.telosys.tools.commons.plugins;

import java.io.File;
import java.util.List;

import org.telosys.tools.commons.cfg.TelosysToolsCfg;

public interface IPlugin {

	public void addAnnotations(List annotations);
	public IPluginAnnotationData newPluginAnnotationData();
	public void putGeneratorContexts(/*GeneratorContext*/ Object generatorContext, TelosysToolsCfg telosysToolsCfg, /*Model*/ Object model, String bundleName);

	public /*ParsingResult*/ Object parseModel(File modelFolder);	
}

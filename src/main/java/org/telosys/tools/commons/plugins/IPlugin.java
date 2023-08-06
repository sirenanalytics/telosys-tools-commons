package org.telosys.tools.commons.plugins;

import java.io.File;
import java.util.List;

import org.telosys.tools.commons.cfg.TelosysToolsCfg;

public interface IPlugin {

	public void addAnnotations(List annotations);
	public IPluginAnnotationData newPluginAnnotationData();
	public void putGeneratorContexts(/*GeneratorContext*/ Object generatorContext, TelosysToolsCfg telosysToolsCfg, /*Model*/ Object model, String bundleName);

	public /*ParsingResult*/ Object parseModel(File modelFolder);
	
	public /*LinkInContext*/ Object newLinkInContext(/*EntityInContext*/ Object entity, /*Link*/ Object link, /*ModelInContext*/ Object modelInContext, /*EnvInContext*/ Object envInContext);	

	public /*AttributeInContext*/ Object newAttributeInContext(/*EntityInContext*/ Object entity, /*Attribute*/ Object attribute, /*ModelInContext*/ Object modelInContext, /*EnvInContext*/ Object env);
	
	public /*EntityInContext*/ Object newEntityInContext(/*Entity*/ Object entity, String defaultEntityPackage, /*ModelInContext*/ Object modelInContext, /*EnvInContext*/ Object env);	
}

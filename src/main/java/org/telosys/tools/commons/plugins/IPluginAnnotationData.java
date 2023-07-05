package org.telosys.tools.commons.plugins;

public interface IPluginAnnotationData {

	public Object get(String annotation, String key);
	public void set(String annotation, String key, Object object);
	
}

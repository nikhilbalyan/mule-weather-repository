package org.mule.extension.weather.internal;

import org.mule.connect.internal.connection.WeatherConnectionProvider;
import org.mule.extension.weather.internal.operations.WeatherZipOperations;
import org.mule.runtime.extension.api.annotation.Extension;
import org.mule.runtime.extension.api.annotation.Operations;
import org.mule.runtime.extension.api.annotation.connectivity.ConnectionProviders;
import org.mule.runtime.extension.api.annotation.dsl.xml.Xml;

import static org.mule.runtime.api.meta.Category.COMMUNITY;


/**
 * This is the main class of an extension, is the entry point from which configurations, connection providers, operations
 * and sources are going to be declared.
 */
@Xml(prefix = "weather")
@ConnectionProviders(WeatherConnectionProvider.class)
@Extension(name = "Weather", vendor = "in.nikhil", category = COMMUNITY)
@Operations({WeatherZipOperations.class})
public class WeatherExtension {

}

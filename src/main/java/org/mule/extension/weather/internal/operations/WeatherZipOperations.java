package org.mule.extension.weather.internal.operations;

import org.mule.connect.internal.connection.WeatherConnection;
import org.mule.extension.weather.internal.WeatherConstants;
import org.mule.runtime.extension.api.annotation.param.Connection;
import org.mule.runtime.extension.api.annotation.param.MediaType;
import org.mule.runtime.extension.api.annotation.param.Parameter;
import org.mule.runtime.extension.api.annotation.param.display.DisplayName;
import org.mule.runtime.extension.api.annotation.param.display.Example;

import java.io.InputStream;

import static org.mule.runtime.extension.api.annotation.param.MediaType.ANY;

/**
 *  This class is a container for operations, every public method in this class will be taken as an extension operation
 */
public class WeatherZipOperations {
    @Parameter
    @Example("30303")
    @DisplayName("ZIP Code")
    private int zipCode;

    @MediaType(value = ANY, strict = false)
    @DisplayName(WeatherConstants.ZIP)
    public InputStream getWeatherByZip(@Connection WeatherConnection connection) {
        return connection.callHttpZIP(zipCode);
    }
}

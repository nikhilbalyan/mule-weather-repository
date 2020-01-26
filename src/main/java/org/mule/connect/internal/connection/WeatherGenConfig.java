package org.mule.connect.internal.connection;

import org.mule.runtime.extension.api.annotation.Expression;
import org.mule.runtime.extension.api.annotation.param.Parameter;
import org.mule.runtime.extension.api.annotation.param.display.DisplayName;
import org.mule.runtime.extension.api.annotation.param.display.Placement;
import org.mule.runtime.extension.api.annotation.param.display.Summary;

public class WeatherGenConfig {
    private static final String GENL = "General";
    public enum Channel {
        openWeather, yahoo, forecast
    };

    @Parameter
    @Placement(tab = GENL)
    @DisplayName("Weather Channel")
    @Summary("Options: openweather, yahoo, forecast")
    @Expression(org.mule.runtime.api.meta.ExpressionSupport.NOT_SUPPORTED)
    private String wChannel;

    public String getWChannel() {
        return wChannel;
    }
}

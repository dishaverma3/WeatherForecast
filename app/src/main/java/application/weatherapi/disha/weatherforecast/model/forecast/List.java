
package application.weatherapi.disha.weatherforecast.model.forecast;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import application.weatherapi.disha.weatherforecast.model.current.Clouds;
import application.weatherapi.disha.weatherforecast.model.current.Weather;
import application.weatherapi.disha.weatherforecast.model.current.Wind;

public class List implements Serializable
{

    @SerializedName("dt")
    @Expose
    private Integer dt;
    @SerializedName("main")
    @Expose
    private MainForecast main;
    @SerializedName("weather")
    @Expose
    private java.util.List<Weather> weather = null;
    @SerializedName("clouds")
    @Expose
    private Clouds clouds;
    @SerializedName("wind")
    @Expose
    private Wind wind;
    @SerializedName("sys")
    @Expose
    private SysForecast sys;
    @SerializedName("dt_txt")
    @Expose
    private String dtTxt;
    private final static long serialVersionUID = 3090572673601523304L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public List() {
    }

    /**
     * 
     * @param dt
     * @param dtTxt
     * @param weather
     * @param main
     * @param clouds
     * @param sys
     * @param wind
     */
    public List(Integer dt, MainForecast main, java.util.List<Weather> weather, Clouds clouds, Wind wind, SysForecast sys, String dtTxt) {
        super();
        this.dt = dt;
        this.main = main;
        this.weather = weather;
        this.clouds = clouds;
        this.wind = wind;
        this.sys = sys;
        this.dtTxt = dtTxt;
    }

    public Integer getDt() {
        return dt;
    }

    public void setDt(Integer dt) {
        this.dt = dt;
    }

    public MainForecast getMain() {
        return main;
    }

    public void setMain(MainForecast main) {
        this.main = main;
    }

    public java.util.List<Weather> getWeather() {
        return weather;
    }

    public void setWeather(java.util.List<Weather> weather) {
        this.weather = weather;
    }

    public Clouds getClouds() {
        return clouds;
    }

    public void setClouds(Clouds clouds) {
        this.clouds = clouds;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public SysForecast getSys() {
        return sys;
    }

    public void setSys(SysForecast sys) {
        this.sys = sys;
    }

    public String getDtTxt() {
        return dtTxt;
    }

    public void setDtTxt(String dtTxt) {
        this.dtTxt = dtTxt;
    }

}

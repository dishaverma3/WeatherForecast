package application.weatherapi.disha.weatherforecast.model;

public class WeatherDays {
    private String icon;
    private String dayName;
    private String temp;

    public WeatherDays(String icon, String dayName, String temp) {
        this.icon = icon;
        this.dayName = dayName;
        this.temp = temp;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getDayName() {
        return dayName;
    }

    public void setDayName(String dayName) {
        this.dayName = dayName;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }
}

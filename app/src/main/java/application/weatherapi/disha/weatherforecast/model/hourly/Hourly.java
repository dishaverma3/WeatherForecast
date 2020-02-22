
package application.weatherapi.disha.weatherforecast.model.hourly;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Hourly implements Serializable
{

    @SerializedName("cod")
    @Expose
    private String cod;
    @SerializedName("message")
    @Expose
    private Integer message;
    @SerializedName("cnt")
    @Expose
    private Integer cnt;
    @SerializedName("list")
    @Expose
    private java.util.List<application.weatherapi.disha.weatherforecast.model.hourly.List> list = null;
    @SerializedName("city")
    @Expose
    private City city;
    private final static long serialVersionUID = 4100741924150941760L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Hourly() {
    }

    /**
     * 
     * @param city
     * @param cnt
     * @param cod
     * @param message
     * @param list
     */
    public Hourly(String cod, Integer message, Integer cnt, java.util.List<application.weatherapi.disha.weatherforecast.model.hourly.List> list, City city) {
        super();
        this.cod = cod;
        this.message = message;
        this.cnt = cnt;
        this.list = list;
        this.city = city;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public Integer getMessage() {
        return message;
    }

    public void setMessage(Integer message) {
        this.message = message;
    }

    public Integer getCnt() {
        return cnt;
    }

    public void setCnt(Integer cnt) {
        this.cnt = cnt;
    }

    public java.util.List<application.weatherapi.disha.weatherforecast.model.hourly.List> getList() {
        return list;
    }

    public void setList(java.util.List<application.weatherapi.disha.weatherforecast.model.hourly.List> list) {
        this.list = list;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

}

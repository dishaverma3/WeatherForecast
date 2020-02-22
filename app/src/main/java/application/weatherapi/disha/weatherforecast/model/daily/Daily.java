
package application.weatherapi.disha.weatherforecast.model.daily;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Daily implements Serializable
{

    @SerializedName("city")
    @Expose
    private City city;
    @SerializedName("cod")
    @Expose
    private String cod;
    @SerializedName("message")
    @Expose
    private Double message;
    @SerializedName("cnt")
    @Expose
    private Integer cnt;
    @SerializedName("list")
    @Expose
    private java.util.List<application.weatherapi.disha.weatherforecast.model.daily.List> list = null;
    private final static long serialVersionUID = -6382358621166750031L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Daily() {
    }

    /**
     * 
     * @param city
     * @param cnt
     * @param cod
     * @param message
     * @param list
     */
    public Daily(City city, String cod, Double message, Integer cnt, java.util.List<application.weatherapi.disha.weatherforecast.model.daily.List> list) {
        super();
        this.city = city;
        this.cod = cod;
        this.message = message;
        this.cnt = cnt;
        this.list = list;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public Double getMessage() {
        return message;
    }

    public void setMessage(Double message) {
        this.message = message;
    }

    public Integer getCnt() {
        return cnt;
    }

    public void setCnt(Integer cnt) {
        this.cnt = cnt;
    }

    public java.util.List<application.weatherapi.disha.weatherforecast.model.daily.List> getList() {
        return list;
    }

    public void setList(java.util.List<application.weatherapi.disha.weatherforecast.model.daily.List> list) {
        this.list = list;
    }

}

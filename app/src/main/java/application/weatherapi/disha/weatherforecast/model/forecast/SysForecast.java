
package application.weatherapi.disha.weatherforecast.model.forecast;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SysForecast implements Serializable
{

    @SerializedName("pod")
    @Expose
    private String pod;
    private final static long serialVersionUID = -8210845051610236207L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public SysForecast() {
    }

    /**
     * 
     * @param pod
     */
    public SysForecast(String pod) {
        super();
        this.pod = pod;
    }

    public String getPod() {
        return pod;
    }

    public void setPod(String pod) {
        this.pod = pod;
    }

}

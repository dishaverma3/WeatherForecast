
package application.weatherapi.disha.weatherforecast.model.hourly;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Rain implements Serializable
{

    @SerializedName("3h")
    @Expose
    private Double _3h;
    private final static long serialVersionUID = 7465628341516335137L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Rain() {
    }

    /**
     * 
     * @param _3h
     */
    public Rain(Double _3h) {
        super();
        this._3h = _3h;
    }

    public Double get3h() {
        return _3h;
    }

    public void set3h(Double _3h) {
        this._3h = _3h;
    }

}

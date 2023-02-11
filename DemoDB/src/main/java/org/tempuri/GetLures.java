
package org.tempuri;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="BodyOfWater" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="PredictTime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Weather" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="WaterTemp" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="WaterColor" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "bodyOfWater",
    "predictTime",
    "weather",
    "waterTemp",
    "waterColor"
})
@XmlRootElement(name = "GetLures")
public class GetLures {

    @XmlElement(name = "BodyOfWater")
    protected String bodyOfWater;
    @XmlElement(name = "PredictTime")
    protected String predictTime;
    @XmlElement(name = "Weather")
    protected String weather;
    @XmlElement(name = "WaterTemp")
    protected String waterTemp;
    @XmlElement(name = "WaterColor")
    protected String waterColor;

    /**
     * Gets the value of the bodyOfWater property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBodyOfWater() {
        return bodyOfWater;
    }

    /**
     * Sets the value of the bodyOfWater property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBodyOfWater(String value) {
        this.bodyOfWater = value;
    }

    /**
     * Gets the value of the predictTime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPredictTime() {
        return predictTime;
    }

    /**
     * Sets the value of the predictTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPredictTime(String value) {
        this.predictTime = value;
    }

    /**
     * Gets the value of the weather property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWeather() {
        return weather;
    }

    /**
     * Sets the value of the weather property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWeather(String value) {
        this.weather = value;
    }

    /**
     * Gets the value of the waterTemp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWaterTemp() {
        return waterTemp;
    }

    /**
     * Sets the value of the waterTemp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWaterTemp(String value) {
        this.waterTemp = value;
    }

    /**
     * Gets the value of the waterColor property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWaterColor() {
        return waterColor;
    }

    /**
     * Sets the value of the waterColor property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWaterColor(String value) {
        this.waterColor = value;
    }

}


package org.tempuri;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
 *         &lt;element name="sLocation" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="sLat" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="sLong" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
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
    "sLocation",
    "sLat",
    "sLong"
})
@XmlRootElement(name = "GetCurrentWeatherConditions")
public class GetCurrentWeatherConditions {

    protected String sLocation;
    protected String sLat;
    protected String sLong;

    /**
     * Gets the value of the sLocation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSLocation() {
        return sLocation;
    }

    /**
     * Sets the value of the sLocation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSLocation(String value) {
        this.sLocation = value;
    }

    /**
     * Gets the value of the sLat property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSLat() {
        return sLat;
    }

    /**
     * Sets the value of the sLat property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSLat(String value) {
        this.sLat = value;
    }

    /**
     * Gets the value of the sLong property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSLong() {
        return sLong;
    }

    /**
     * Sets the value of the sLong property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSLong(String value) {
        this.sLong = value;
    }

}


package com.oyo.luxury.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="room-type" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="accomodation-date" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="noOfDays" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="person-name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "roomType",
    "accomodationDate",
    "noOfDays",
    "personName"
})
@XmlRootElement(name = "check-in")
public class CheckIn {

    @XmlElement(name = "room-type", required = true)
    protected String roomType;
    @XmlElement(name = "accomodation-date", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar accomodationDate;
    protected int noOfDays;
    @XmlElement(name = "person-name", required = true)
    protected String personName;

    /**
     * Gets the value of the roomType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRoomType() {
        return roomType;
    }

    /**
     * Sets the value of the roomType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRoomType(String value) {
        this.roomType = value;
    }

    /**
     * Gets the value of the accomodationDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getAccomodationDate() {
        return accomodationDate;
    }

    /**
     * Sets the value of the accomodationDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setAccomodationDate(XMLGregorianCalendar value) {
        this.accomodationDate = value;
    }

    /**
     * Gets the value of the noOfDays property.
     * 
     */
    public int getNoOfDays() {
        return noOfDays;
    }

    /**
     * Sets the value of the noOfDays property.
     * 
     */
    public void setNoOfDays(int value) {
        this.noOfDays = value;
    }

    /**
     * Gets the value of the personName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPersonName() {
        return personName;
    }

    /**
     * Sets the value of the personName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPersonName(String value) {
        this.personName = value;
    }

}

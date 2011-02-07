
package org.example.ws_ht.api;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for tStatus.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="tStatus">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="CREATED"/>
 *     &lt;enumeration value="READY"/>
 *     &lt;enumeration value="RESERVED"/>
 *     &lt;enumeration value="IN_PROGRESS"/>
 *     &lt;enumeration value="SUSPENDED"/>
 *     &lt;enumeration value="COMPLETED"/>
 *     &lt;enumeration value="FAILED"/>
 *     &lt;enumeration value="ERROR"/>
 *     &lt;enumeration value="EXITED"/>
 *     &lt;enumeration value="OBSOLETE"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "tStatus")
@XmlEnum
public enum TStatus {

    CREATED,
    READY,
    RESERVED,
    IN_PROGRESS,
    SUSPENDED,
    COMPLETED,
    FAILED,
    ERROR,
    EXITED,
    OBSOLETE;

    public String value() {
        return name();
    }

    public static TStatus fromValue(String v) {
        return valueOf(v);
    }

}

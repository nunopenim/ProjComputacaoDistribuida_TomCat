
package maven.projetoCD.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * This class was generated by Apache CXF 2.6.13
 * Wed Jan 06 15:36:10 GMT 2021
 * Generated source version: 2.6.13
 */

@XmlRootElement(name = "somarResponse", namespace = "http://projetoCD.maven/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "somarResponse", namespace = "http://projetoCD.maven/")

public class SomarResponse {

    @XmlElement(name = "return")
    private int _return;

    public int getReturn() {
        return this._return;
    }

    public void setReturn(int new_return)  {
        this._return = new_return;
    }

}



package maven.projetoCD.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * This class was generated by Apache CXF 2.6.13
 * Sun Jan 03 13:56:13 GMT 2021
 * Generated source version: 2.6.13
 */

@XmlRootElement(name = "bananasResponse", namespace = "http://projetoCD.maven/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "bananasResponse", namespace = "http://projetoCD.maven/")

public class BananasResponse {

    @XmlElement(name = "return")
    private java.lang.String _return;

    public java.lang.String getReturn() {
        return this._return;
    }

    public void setReturn(java.lang.String new_return)  {
        this._return = new_return;
    }

}


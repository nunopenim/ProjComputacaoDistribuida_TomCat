
package maven.projetoCD.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * This class was generated by Apache CXF 2.6.13
 * Tue Jan 05 13:29:03 GMT 2021
 * Generated source version: 2.6.13
 */

@XmlRootElement(name = "listarItensResponse", namespace = "http://projetoCD.maven/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "listarItensResponse", namespace = "http://projetoCD.maven/")

public class ListarItensResponse {

    @XmlElement(name = "return")
    private java.lang.String _return;

    public java.lang.String getReturn() {
        return this._return;
    }

    public void setReturn(java.lang.String new_return)  {
        this._return = new_return;
    }

}



package maven.projetoCD.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * This class was generated by Apache CXF 2.6.13
 * Thu Jan 14 12:28:25 GMT 2021
 * Generated source version: 2.6.13
 */

@XmlRootElement(name = "setStartTime", namespace = "http://projetoCD.maven/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "setStartTime", namespace = "http://projetoCD.maven/")

public class SetStartTime {

    @XmlElement(name = "arg0")
    private long arg0;

    public long getArg0() {
        return this.arg0;
    }

    public void setArg0(long newArg0)  {
        this.arg0 = newArg0;
    }

}


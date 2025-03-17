
package es.unican.ss.client;

import javax.xml.namespace.QName;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the es.unican.ss.client package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _DatosNoDisponibles_QNAME = new QName("http://business.ss.unican.es/", "DatosNoDisponibles");
    private final static QName _ParadaNoValida_QNAME = new QName("http://business.ss.unican.es/", "ParadaNoValida");
    private final static QName _ConsultaTUS_QNAME = new QName("http://business.ss.unican.es/", "consultaTUS");
    private final static QName _ConsultaTUSResponse_QNAME = new QName("http://business.ss.unican.es/", "consultaTUSResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: es.unican.ss.client
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link DatosNoDisponibles }
     * 
     */
    public DatosNoDisponibles createDatosNoDisponibles() {
        return new DatosNoDisponibles();
    }

    /**
     * Create an instance of {@link ParadaNoValida }
     * 
     */
    public ParadaNoValida createParadaNoValida() {
        return new ParadaNoValida();
    }

    /**
     * Create an instance of {@link ConsultaTUS }
     * 
     */
    public ConsultaTUS createConsultaTUS() {
        return new ConsultaTUS();
    }

    /**
     * Create an instance of {@link ConsultaTUSResponse }
     * 
     */
    public ConsultaTUSResponse createConsultaTUSResponse() {
        return new ConsultaTUSResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DatosNoDisponibles }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DatosNoDisponibles }{@code >}
     */
    @XmlElementDecl(namespace = "http://business.ss.unican.es/", name = "DatosNoDisponibles")
    public JAXBElement<DatosNoDisponibles> createDatosNoDisponibles(DatosNoDisponibles value) {
        return new JAXBElement<DatosNoDisponibles>(_DatosNoDisponibles_QNAME, DatosNoDisponibles.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ParadaNoValida }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ParadaNoValida }{@code >}
     */
    @XmlElementDecl(namespace = "http://business.ss.unican.es/", name = "ParadaNoValida")
    public JAXBElement<ParadaNoValida> createParadaNoValida(ParadaNoValida value) {
        return new JAXBElement<ParadaNoValida>(_ParadaNoValida_QNAME, ParadaNoValida.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConsultaTUS }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ConsultaTUS }{@code >}
     */
    @XmlElementDecl(namespace = "http://business.ss.unican.es/", name = "consultaTUS")
    public JAXBElement<ConsultaTUS> createConsultaTUS(ConsultaTUS value) {
        return new JAXBElement<ConsultaTUS>(_ConsultaTUS_QNAME, ConsultaTUS.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConsultaTUSResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ConsultaTUSResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://business.ss.unican.es/", name = "consultaTUSResponse")
    public JAXBElement<ConsultaTUSResponse> createConsultaTUSResponse(ConsultaTUSResponse value) {
        return new JAXBElement<ConsultaTUSResponse>(_ConsultaTUSResponse_QNAME, ConsultaTUSResponse.class, null, value);
    }

}

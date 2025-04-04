/*
 *
 *    geo-platform
 *    Rich webgis framework
 *    http://geo-platform.org
 *   ====================================================================
 *
 *   Copyright (C) 2008-2025 geoSDI Group (CNR IMAA - Potenza - ITALY).
 *
 *   This program is free software: you can redistribute it and/or modify it
 *   under the terms of the GNU General Public License as published by
 *   the Free Software Foundation, either version 3 of the License, or
 *   (at your option) any later version. This program is distributed in the
 *   hope that it will be useful, but WITHOUT ANY WARRANTY; without
 *   even the implied warranty of MERCHANTABILITY or FITNESS FOR
 *   A PARTICULAR PURPOSE. See the GNU General Public License
 *   for more details. You should have received a copy of the GNU General
 *   Public License along with this program. If not, see http://www.gnu.org/licenses/
 *
 *   ====================================================================
 *
 *   Linking this library statically or dynamically with other modules is
 *   making a combined work based on this library. Thus, the terms and
 *   conditions of the GNU General Public License cover the whole combination.
 *
 *   As a special exception, the copyright holders of this library give you permission
 *   to link this library with independent modules to produce an executable, regardless
 *   of the license terms of these independent modules, and to copy and distribute
 *   the resulting executable under terms of your choice, provided that you also meet,
 *   for each linked independent module, the terms and conditions of the license of
 *   that module. An independent module is a module which is not derived from or
 *   based on this library. If you modify this library, you may extend this exception
 *   to your version of the library, but you are not obligated to do so. If you do not
 *   wish to do so, delete this exception statement from your version.
 */
package org.geosdi.geoplatform.jaxb;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.util.Collections;
import java.util.Map;

/**
 * The GeoPlatformJAXBContext class provides the client's entry point to the
 * JAXBContext. This class allows you to perform the classic operations
 * of the marshal and unmarshal JAXBContext
 *
 * @author Giuseppe La Scaleia - CNR IMAA geoSDI Group
 * @email giuseppe.lascaleia@geosdi.org
 */
public abstract class GeoPlatformJAXBContext extends GPBaseJAXBContext {

    /**
     * <p/>
     * Create a new instance of a <tt>GeoPlatformJAXBContext</tt> class.
     *
     * @throws JAXBException if an error was encountered while creating the
     *                       <tt>JAXBContext</tt> such as
     *                       <ol>
     *                       <li>failure to locate either ObjectFactory.class or jaxb.index in the packages</li>
     *                       <li>an ambiguity among global elements contained in the contextPath</li>
     *                       <li>failure to locate a value for the context factory provider property</li>
     *                       <li>mixing schema derived packages from different providers on the same contextPath</li>
     *                       </ol>
     */
    public GeoPlatformJAXBContext(String contextPath) throws JAXBException {
        this(contextPath, Thread.currentThread().getContextClassLoader());
    }

    /**
     * <p>
     * Obtain a new instance of a <tt>GeoPlatformJAXBContext</tt> class.
     * <p/>
     * </p>
     * The context path which is a list of  colon (':', \u005Cu003A) separated
     * java package names that contain schema-derived classes and/or fully
     * qualified JAXB-annotated classes.
     *
     * @throws JAXBException if an error was encountered while creating the
     *                       <tt>JAXBContext</tt> such as
     *                       <ol>
     *                       <li>failure to locate either ObjectFactory.class or jaxb.index in the packages</li>
     *                       <li>an ambiguity among global elements contained in the contextPath</li>
     *                       <li>failure to locate a value for the context factory provider property</li>
     *                       <li>mixing schema derived packages from different providers on the same contextPath</li>
     *                       </ol>
     */
    public GeoPlatformJAXBContext(String contextPath, ClassLoader classLoader)
            throws JAXBException {
        this(contextPath, classLoader, Collections.<String, Object> emptyMap());
    }

    /**
     * <p/>
     * Obtain a new instance of a <tt>GeoPlatformJAXBContext</tt> class.
     * <p/>
     * <p/>
     *
     * @param contextPath list of java package names that contain schema derived classes
     * @param classLoader This class loader will be used to locate the implementation classes.
     * @param properties  provider-specific properties. Can be null, which means the same thing as passing
     *                    in an empty map.
     * @throws JAXBException if an error was encountered while creating the
     *                       <tt>JAXBContext</tt> such as
     *                       <ol>
     *                       <li>failure to locate either ObjectFactory.class or jaxb.index in the packages</li>
     *                       <li>an ambiguity among global elements contained in the contextPath</li>
     *                       <li>failure to locate a value for the context factory provider property</li>
     *                       <li>mixing schema derived packages from different providers on the same contextPath</li>
     *                       </ol>
     */
    public GeoPlatformJAXBContext(String contextPath, ClassLoader classLoader,
                                  Map<String, ?> properties) throws JAXBException {

        super(contextPath, classLoader, properties);
    }

    /**
     * @param classToBeBound list of java classes to be recognized by the new {@link JAXBContext}.
     *                       Can be empty, in which case a {@link JAXBContext} that only knows about
     *                       spec-defined classes will be returned.
     * @throws JAXBException            if an error was encountered while creating the
     *                                  <tt>JAXBContext</tt>, such as (but not limited to):
     *                                  <ol>
     *                                  <li>No JAXB implementation was discovered</li>
     *                                  <li>Classes use JAXB annotations incorrectly</li>
     *                                  <li>Classes have colliding annotations (i.e., two classes with the same type name)</li>
     *                                  <li>The JAXB implementation was unable to locate
     *                                  provider-specific out-of-band information (such as additional
     *                                  files generated at the development time.)</li>
     *                                  </ol>
     * @throws IllegalArgumentException if the parameter contains {@code null} (i.e., {@code GeoPlatformJAXBContext(null);})
     */
    public GeoPlatformJAXBContext(Class... classToBeBound)
            throws JAXBException {

        super(classToBeBound);
    }

    public GeoPlatformJAXBContext(JAXBContext theJaxbContext) {
        super(theJaxbContext);
    }

    /**
     * Create a <p>Marshaller</p> object that can be used to convert a
     * java content tree into XML data.
     *
     * @return a <tt>Marshaller</tt> object
     * @throws JAXBException if an error was encountered while creating the
     **/
    protected Marshaller createMarshaller() throws Exception {
        Marshaller marshaller = this.jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
        return marshaller;
    }

    /**
     * Create an <p>Unmarshaller</p> object that can be used to convert XML
     * data into a java content tree.
     *
     * @return an <tt>Unmarshaller</tt> object
     * @throws JAXBException if an error was encountered while creating the
     *                       <tt>Unmarshaller</tt> object
     */
    protected Unmarshaller createUnmarshaller() throws Exception {
        return this.jaxbContext.createUnmarshaller();
    }
}

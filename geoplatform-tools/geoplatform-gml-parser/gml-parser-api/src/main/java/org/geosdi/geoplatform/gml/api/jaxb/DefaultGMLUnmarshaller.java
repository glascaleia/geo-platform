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
package org.geosdi.geoplatform.gml.api.jaxb;

import org.geosdi.geoplatform.gml.api.jaxb.context.AbstractGMLUnmarshaller;
import org.geosdi.geoplatform.gml.api.parser.exception.ParserException;
import org.locationtech.jts.geom.Geometry;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;

import javax.annotation.Nonnull;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLStreamReader;
import javax.xml.transform.Source;
import java.io.File;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;

import static com.google.common.base.Preconditions.checkArgument;
import static javax.annotation.meta.When.NEVER;

/**
 * @author Giuseppe La Scaleia - CNR IMAA geoSDI Group
 * @email giuseppe.lascaleia@geosdi.org
 */
public class DefaultGMLUnmarshaller extends AbstractGMLUnmarshaller {

    /**
     * @param theUnmarshaller
     */
    public DefaultGMLUnmarshaller(@Nonnull(when = NEVER) Unmarshaller theUnmarshaller) {
        super(theUnmarshaller);
    }

    /**
     * @param f
     * @param <T>
     * @return {@link T}
     * @throws JAXBException
     * @throws ParserException
     */
    @Override
    public <T extends Geometry> T unmarshal(@Nonnull(when = NEVER) File f) throws JAXBException, ParserException {
        checkArgument(f != null && !f.isDirectory() && f.exists(), "The Parameter file must not be null, must not be a directory and must exists.");
        return (T) super.parseElement(this.unmarshaller.unmarshal(f));
    }

    /**
     * @param is
     * @param <T>
     * @return {@link T}
     * @throws JAXBException
     * @throws ParserException
     */
    @Override
    public <T extends Geometry> T unmarshal(@Nonnull(when = NEVER) InputStream is) throws JAXBException, ParserException {
        checkArgument(is != null, "The Parameter InputStream must not be null.");
        return (T) super.parseElement(this.unmarshaller.unmarshal(is));
    }

    /**
     * @param reader
     * @param <T>
     * @return {@link T}
     * @throws JAXBException
     * @throws ParserException
     */
    @Override
    public <T extends Geometry> T unmarshal(@Nonnull(when = NEVER) Reader reader) throws JAXBException, ParserException {
        checkArgument(reader != null, "The Parameter reader must not be null.");
        return (T) super.parseElement(this.unmarshaller.unmarshal(reader));
    }

    /**
     * @param url
     * @param <T>
     * @return {@link T}
     * @throws JAXBException
     * @throws ParserException
     */
    @Override
    public <T extends Geometry> T unmarshal(@Nonnull(when = NEVER) URL url) throws JAXBException, ParserException {
        checkArgument(url != null, "The Parameter url must not be null.");
        return (T) super.parseElement(this.unmarshaller.unmarshal(url));
    }

    /**
     * @param source
     * @param <T>
     * @return {@link T}
     * @throws JAXBException
     * @throws ParserException
     */
    @Override
    public <T extends Geometry> T unmarshal(@Nonnull(when = NEVER) InputSource source) throws JAXBException, ParserException {
        checkArgument(source != null, "The Parameter inputSource must not be null.");
        return (T) super.parseElement(this.unmarshaller.unmarshal(source));
    }

    /**
     * @param source
     * @param <T>
     * @return {@link T}
     * @throws Exception
     */
    @Override
    public <T extends Geometry> T unmarshal(@Nonnull(when = NEVER) Source source) throws Exception {
        checkArgument(source != null, "The Parameter source must not be null");
        return (T) super.parseElement(this.unmarshaller.unmarshal(source));
    }

    /**
     * @param reader
     * @param <T>
     * @return {@link T}
     * @throws Exception
     */
    @Override
    public <T extends Geometry> T unmarshal(@Nonnull(when = NEVER) XMLStreamReader reader) throws Exception {
        checkArgument(reader != null, "The Parameter xmlStreamReader must not be null.");
        return (T) super.parseElement(this.unmarshaller.unmarshal(reader));
    }

    /**
     * @param reader
     * @param <T>
     * @return {@link T}
     * @throws Exception
     */
    @Override
    public <T extends Geometry> T unmarshal(@Nonnull(when = NEVER) XMLEventReader reader) throws Exception {
        checkArgument(reader != null, "The Parameter xmlEventReader must not be null.");
        return (T) super.parseElement(this.unmarshaller.unmarshal(reader));
    }

    /**
     * @param node
     * @param <T>
     * @return {@link T}
     * @throws JAXBException
     * @throws ParserException
     */
    @Override
    public <T extends Geometry> T unmarshal(@Nonnull(when = NEVER) Node node) throws JAXBException, ParserException {
        checkArgument(node != null, "The Parameter node must not be null.");
        return (T) super.parseElement(this.unmarshaller.unmarshal(node));
    }

    /**
     * @param node
     * @param declaredType
     * @param <T>
     * @return {@link JAXBElement<T>}
     * @throws JAXBException
     * @throws ParserException
     */
    @Override
    public <T extends Geometry> JAXBElement<T> unmarshal(@Nonnull(when = NEVER) Node node, @Nonnull(when = NEVER) Class<T> declaredType) throws JAXBException, ParserException {
        checkArgument(node != null, "The Parameter node must not be null.");
        checkArgument(declaredType != null, "The Parameter declaredType must not be null.");
        return super.parseElement(this.unmarshaller.unmarshal(node), declaredType);
    }

    /**
     * @param source
     * @param declaredType
     * @param <T>
     * @return {@link JAXBElement<T>}
     * @throws JAXBException
     * @throws ParserException
     */
    @Override
    public <T extends Geometry> JAXBElement<T> unmarshal(@Nonnull(when = NEVER) Source source, @Nonnull(when = NEVER) Class<T> declaredType) throws JAXBException, ParserException {
        checkArgument(source != null, "The Parameter source must not be null.");
        checkArgument(declaredType != null, "The Parameter declaredType must not be null.");
        return super.parseElement(this.unmarshaller.unmarshal(source), declaredType);
    }

    /**
     * @param reader
     * @param declaredType
     * @param <T>
     * @return {@link JAXBElement<T>}
     * @throws JAXBException
     * @throws ParserException
     */
    @Override
    public <T extends Geometry> JAXBElement<T> unmarshal(@Nonnull(when = NEVER) XMLStreamReader reader, @Nonnull(when = NEVER) Class<T> declaredType) throws JAXBException, ParserException {
        checkArgument(reader != null, "The Parameter xmlStreamReader must not be null.");
        checkArgument(declaredType != null, "The Parameter declaredType must not be null.");
        return super.parseElement(this.unmarshaller.unmarshal(reader), declaredType);
    }

    /**
     * @param reader
     * @param declaredType
     * @param <T>
     * @return {@link JAXBElement<T>}
     * @throws JAXBException
     * @throws ParserException
     */
    @Override
    public <T extends Geometry> JAXBElement<T> unmarshal(@Nonnull(when = NEVER) XMLEventReader reader, @Nonnull(when = NEVER) Class<T> declaredType) throws JAXBException, ParserException {
        checkArgument(reader != null, "The Parameter xmlEventReader must not be null.");
        checkArgument(declaredType != null, "The Parameter declaredType must not be null.");
        return super.parseElement(this.unmarshaller.unmarshal(reader), declaredType);
    }

    /**
     * @throws Exception
     */
    @Override
    public void dispose() throws Exception {
        logger.debug("@@@@@@@@@@@@@@@@@@@@@@@Called {}#dspose\n", this.getClass().getSimpleName());
    }
}
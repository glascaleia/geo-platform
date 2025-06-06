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
package org.geosdi.geoplatform.jaxb.pool.factory;

import org.apache.commons.pool2.BasePooledObjectFactory;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.impl.DefaultPooledObject;

import javax.annotation.Nonnull;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import static com.google.common.base.Preconditions.checkArgument;
import static java.lang.Boolean.TRUE;
import static javax.annotation.meta.When.NEVER;
import static javax.xml.bind.Marshaller.JAXB_ENCODING;
import static javax.xml.bind.Marshaller.JAXB_FORMATTED_OUTPUT;

/**
 * @author Giuseppe La Scaleia - CNR IMAA geoSDI Group
 * @email giuseppe.lascaleia@geosdi.org
 */
public class GPMarshallerFactory extends BasePooledObjectFactory<Marshaller> {

    private final JAXBContext jaxbContext;

    /**
     * @param theJaxbContext
     */
    public GPMarshallerFactory(@Nonnull(when = NEVER) JAXBContext theJaxbContext) {
        checkArgument(theJaxbContext != null, "The Parameter jaxbContext must not be null.");
        this.jaxbContext = theJaxbContext;
    }

    /**
     * Creates an object instance, to be wrapped in a {@link PooledObject}.
     * <p>This method <strong>must</strong> support concurrent, multi-threaded
     * activation.</p>
     *
     * @return an instance to be served by the pool
     * @throws Exception if there is a problem creating a new instance,
     *                   this will be propagated to the code requesting an object.
     */
    @Override
    public Marshaller create() throws Exception {
        Marshaller marshaller = this.jaxbContext.createMarshaller();
        marshaller.setProperty(JAXB_FORMATTED_OUTPUT, TRUE);
        marshaller.setProperty(JAXB_ENCODING, "UTF-8");
        return marshaller;
    }

    /**
     * Wrap the provided instance with an implementation of
     * {@link PooledObject}.
     *
     * @param obj the instance to wrap
     * @return The provided instance, wrapped by a {@link PooledObject}
     */
    @Override
    public PooledObject<Marshaller> wrap(Marshaller obj) {
        return new DefaultPooledObject(obj);
    }
}
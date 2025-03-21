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
package org.geosdi.geoplatform.connector.jaxb.context.pool;

import org.geosdi.geoplatform.connector.jaxb.repository.WFSConnectorJAXBContextPool;
import org.geosdi.geoplatform.jaxb.pool.GeoPlatformJAXBContextPool;
import org.geosdi.geoplatform.jaxb.repository.GeoPlatformJAXBContextRepository;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import java.util.Map;

/**
 * @author Giuseppe La Scaleia - CNR IMAA geoSDI Group
 * @email giuseppe.lascaleia@geosdi.org
 */
public class WFSJAXBContextPool extends GeoPlatformJAXBContextPool {

    /**
     * @param contextPath
     * @throws JAXBException
     */
    public WFSJAXBContextPool(String contextPath) throws JAXBException {
        super(contextPath);
    }

    /**
     * @param contextPath
     * @param classLoader
     * @throws JAXBException
     */
    public WFSJAXBContextPool(String contextPath, ClassLoader classLoader) throws JAXBException {
        super(contextPath, classLoader);
    }

    /**
     * @param contextPath
     * @param classLoader
     * @param properties
     * @throws JAXBException
     */
    public WFSJAXBContextPool(String contextPath, ClassLoader classLoader, Map<String, ?> properties)
            throws JAXBException {
        super(contextPath, classLoader, properties);
    }

    /**
     * @param classToBeBound
     * @throws JAXBException
     */
    public WFSJAXBContextPool(Class... classToBeBound) throws JAXBException {
        super(classToBeBound);
    }

    /**
     * @param theJaxbContext
     */
    public WFSJAXBContextPool(JAXBContext theJaxbContext) {
        super(theJaxbContext);
    }

    public static class WFSJAXBContextPoolKey extends GeoPlatformJAXBContextRepository.GeoPlatformJAXBContextKey {

        public WFSJAXBContextPoolKey() {
            super(WFSConnectorJAXBContextPool.class);
        }

        @Override
        public boolean isCompatibleValue(Object val) {
            return (val instanceof WFSJAXBContextPool);
        }
    }
}

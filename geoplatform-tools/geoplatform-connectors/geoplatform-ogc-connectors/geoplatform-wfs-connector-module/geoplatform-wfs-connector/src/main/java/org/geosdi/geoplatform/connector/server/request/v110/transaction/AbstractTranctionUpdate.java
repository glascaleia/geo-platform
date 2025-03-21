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
package org.geosdi.geoplatform.connector.server.request.v110.transaction;

import com.google.common.collect.Lists;
import org.geosdi.geoplatform.connector.server.request.ITransactionOperationStrategy;
import org.geosdi.geoplatform.connector.wfs.response.AttributeDTO;
import org.geosdi.geoplatform.connector.wfs.response.GeometryAttributeDTO;
import org.geosdi.geoplatform.exception.IllegalParameterFault;
import org.geosdi.geoplatform.gml.api.AbstractGeometry;
import org.geosdi.geoplatform.gml.api.parser.jts.geometry.sextante.JTSSextanteParser;
import org.geosdi.geoplatform.xml.wfs.v110.PropertyType;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.io.WKTReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Nonnull;
import javax.xml.namespace.QName;
import java.util.List;

import static com.google.common.base.Preconditions.checkArgument;
import static javax.annotation.meta.When.NEVER;
import static org.geosdi.geoplatform.gml.impl.v311.jts.parameter.JTSParametersRepo.getDefaultSextanteParser;

/**
 * @author Giuseppe La Scaleia - CNR IMAA geoSDI Group
 * @email giuseppe.lascaleia@geosdi.org
 */
public abstract class AbstractTranctionUpdate implements ITransactionOperationStrategy {

    protected static final Logger logger = LoggerFactory.getLogger(AbstractTranctionUpdate.class);
    //
    private static final JTSSextanteParser jtsSextanteParser = getDefaultSextanteParser();
    //
    private final WKTReader wktReader;

    AbstractTranctionUpdate() {
        this.wktReader = new WKTReader(new GeometryFactory());
    }

    /**
     * @param attributes
     * @return {@link List<PropertyType>}
     * @throws Exception
     */
    final List<PropertyType> getPropertyToUpdate(@Nonnull(when = NEVER) List<AttributeDTO> attributes) throws Exception {
        checkArgument((attributes != null) && !(attributes.isEmpty()), "The Parameter attributes must not be null or empty.");
        List<PropertyType> properties = Lists.newArrayListWithCapacity(attributes.size());
        for (AttributeDTO attribute : attributes) {
            if (!attribute.isNillable() && attribute.getValue() == null) {
                throw new IllegalParameterFault("Property '" + attribute.getName() + "' cannot be null.");
            }
            PropertyType property = new PropertyType();
            QName qName = new QName(attribute.getName());
            property.setName(qName);
            property.setValue(((attribute instanceof GeometryAttributeDTO) ? createGeometry((GeometryAttributeDTO) attribute) : attribute.getValue()));
            properties.add(property);
        }
        return properties;
    }

    /**
     * @param geometry
     * @return {@link Object}
     * @throws Exception
     */
    final Object createGeometry(GeometryAttributeDTO geometry) throws Exception {
        String wktGeometry = geometry.getValue();
        checkArgument(((wktGeometry != null) && !(wktGeometry.trim().isEmpty())), "The Parameter wktGeometry must not be null or an empty string.");
        Geometry jtsGeometry = this.wktReader.read(wktGeometry);
        if (geometry.getSrid() != null) {
            jtsGeometry.setSRID(geometry.getSrid());
        }
        AbstractGeometry gmlGeometry = jtsSextanteParser.parseGeometry(jtsGeometry);
        logger.debug("####################HERE GML GEOMETRY GENERATED : {}", gmlGeometry);
        return gmlGeometry;
    }
}
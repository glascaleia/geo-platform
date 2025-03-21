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
package org.geosdi.geoplatform.connector.server.request.v202;

import org.geosdi.geoplatform.connector.server.GPServerConnector;
import org.geosdi.geoplatform.connector.server.request.CatalogGetRecordById;
import org.geosdi.geoplatform.connector.server.request.CatalogGetRecordByIdRequest;
import org.geosdi.geoplatform.xml.csw.v202.ElementSetNameType;
import org.geosdi.geoplatform.xml.csw.v202.GetRecordByIdResponseType;
import org.geosdi.geoplatform.xml.csw.v202.GetRecordByIdType;

import static com.google.common.base.Preconditions.checkArgument;
import static org.geosdi.geoplatform.xml.csw.v202.ElementSetType.SUMMARY;
import static org.geosdi.geoplatform.xml.csw.v202.ElementSetType.fromValue;

/**
 * @author Giuseppe La Scaleia - CNR IMAA geoSDI Group
 * @email giuseppe.lascaleia@geosdi.org
 */
public class CatalogGetRecordByIdV202 extends CatalogGetRecordById<GetRecordByIdResponseType, GetRecordByIdType> implements CatalogGetRecordByIdRequest<GetRecordByIdResponseType> {

    public CatalogGetRecordByIdV202(GPServerConnector server) {
        super(server);
    }

    /**
     * @return {@link GetRecordByIdType}
     * @throws Exception
     */
    @Override
    protected GetRecordByIdType createRequest() throws Exception {
        checkArgument((this.id != null) && !(this.id.isEmpty()), "The Parameter id must not be null or an empty list");
        GetRecordByIdType request = new GetRecordByIdType();
        request.setId(id);
        if (this.outputSchema != null) {
            request.setOutputSchema(this.outputSchema.toString());
        }
        ElementSetNameType elementSetNameType = new ElementSetNameType();
        elementSetNameType.setValue(elementSetType != null ? fromValue(elementSetType) : SUMMARY);
        request.setElementSetName(elementSetNameType);
        return request;
    }
}
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
package org.geosdi.geoplatform.connector.server.request.v110.param;

import org.geosdi.geoplatform.connector.server.request.WFSGetFeatureRequest;
import org.geosdi.geoplatform.xml.wfs.v110.QueryType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Nonnull;

import java.util.List;

import static com.google.common.base.Preconditions.checkArgument;
import static io.reactivex.rxjava3.core.Observable.fromIterable;
import static javax.annotation.meta.When.NEVER;

/**
 * @author Giuseppe La Scaleia - CNR IMAA geoSDI Group
 * @email giuseppe.lascaleia@geosdi.org
 */
class WFSPropertyNamesParam extends WFSBaseGetFeatureRequestParam {

    private static final Logger logger = LoggerFactory.getLogger(WFSPropertyNamesParam.class);

    WFSPropertyNamesParam() {
    }

    /**
     * @param theRequest
     * @param theQueryType
     * @throws Exception
     */
    @Override
    protected void internalApply(WFSGetFeatureRequest theRequest, QueryType theQueryType) throws Exception {
        List<String> propertyNames = theRequest.getPropertyNames();
        fromIterable(propertyNames)
                .filter(v -> ((v != null) && !(v.trim().isEmpty())))
                .doOnComplete(() -> logger.debug("################### propertyNames processed."))
                .subscribe(theQueryType.getPropertyNameOrXlinkPropertyNameOrFunction()::add, Throwable::printStackTrace);
    }

    /**
     * @param theRequest
     * @return {@link Boolean}
     */
    @Override
    protected boolean canBeApplyParam(@Nonnull(when = NEVER) WFSGetFeatureRequest theRequest) {
        checkArgument(theRequest != null, "The Parameter WFSGetFeatureRequest must not be null.");
        return theRequest.isSetPropertyNames();
    }
}
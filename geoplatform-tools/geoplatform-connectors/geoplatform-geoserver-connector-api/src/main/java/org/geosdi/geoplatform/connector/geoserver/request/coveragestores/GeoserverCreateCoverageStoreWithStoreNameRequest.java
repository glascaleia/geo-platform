/**
 *
 *    geo-platform
 *    Rich webgis framework
 *    http://geo-platform.org
 *   ====================================================================
 *
 *   Copyright (C) 2008-2021 geoSDI Group (CNR IMAA - Potenza - ITALY).
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
package org.geosdi.geoplatform.connector.geoserver.request.coveragestores;

import org.apache.hc.core5.http.NameValuePair;
import org.geosdi.geoplatform.connector.geoserver.coveragestores.GPCoverateStoreExtension;
import org.geosdi.geoplatform.connector.geoserver.coveragestores.GPParameterConfigure;
import org.geosdi.geoplatform.connector.geoserver.coveragestores.GPUploadMethod;
import org.geosdi.geoplatform.connector.server.request.json.GPJsonConnectorRequest;

import javax.annotation.Nonnull;
import java.io.File;

import static javax.annotation.meta.When.NEVER;

/**
 * @author Vito Salvia - CNR IMAA geoSDI Group
 * @email vito.salvia@gmail.com
 */
public interface GeoserverCreateCoverageStoreWithStoreNameRequest extends GPJsonConnectorRequest<Boolean, GeoserverCreateCoverageStoreWithStoreNameRequest> {

    /**
     * @param theWorkspace
     * @return {@link GeoserverCreateCoverageStoreWithStoreNameRequest}
     */
    GeoserverCreateCoverageStoreWithStoreNameRequest withWorkspace(@Nonnull(when = NEVER) String theWorkspace);

    /**
     * @param theStore
     * @return {@link GeoserverCreateCoverageStoreWithStoreNameRequest}
     */
    GeoserverCreateCoverageStoreWithStoreNameRequest withStore(@Nonnull(when = NEVER) String theStore);

    /**
     * @param theMethod
     * @return {@link GeoserverCreateCoverageStoreWithStoreNameRequest}
     */
    GeoserverCreateCoverageStoreWithStoreNameRequest withMethod(@Nonnull(when = NEVER) GPUploadMethod theMethod);

    /**
     * @param theFormat
     * @return {@link GeoserverCreateCoverageStoreWithStoreNameRequest}
     */
    GeoserverCreateCoverageStoreWithStoreNameRequest withFormat(@Nonnull(when = NEVER) GPCoverateStoreExtension theFormat);

    /**
     * @param theParameterConfigure
     * @return {@link GeoserverCreateCoverageStoreWithStoreNameRequest}
     */
    GeoserverCreateCoverageStoreWithStoreNameRequest withConfigure(@Nonnull(when = NEVER) GPParameterConfigure theParameterConfigure);

    /**
     * @param theParams
     * @return {@link GeoserverCreateCoverageStoreWithStoreNameRequest}
     */
    GeoserverCreateCoverageStoreWithStoreNameRequest withParams(@Nonnull(when = NEVER) NameValuePair... theParams);

    /**
     * @param theFile
     * @return {@link GeoserverCreateCoverageStoreWithStoreNameRequest}
     */
    GeoserverCreateCoverageStoreWithStoreNameRequest withFile(@Nonnull(when = NEVER) File theFile);

    /**
     * @param theMymeType
     * @return {@link GeoserverCreateCoverageStoreWithStoreNameRequest}
     */
    GeoserverCreateCoverageStoreWithStoreNameRequest withMimeType(@Nonnull(when = NEVER) String theMymeType);

    /**
     * @param theFileName
     * @return {@link GeoserverCreateCoverageStoreWithStoreNameRequest}
     */
    GeoserverCreateCoverageStoreWithStoreNameRequest withFileName(@Nonnull(when = NEVER) String theFileName);

    /**
     * @param theCoverageName
     * @return
     */
    GeoserverCreateCoverageStoreWithStoreNameRequest withCoverageName(@Nonnull(when = NEVER) String theCoverageName);
}
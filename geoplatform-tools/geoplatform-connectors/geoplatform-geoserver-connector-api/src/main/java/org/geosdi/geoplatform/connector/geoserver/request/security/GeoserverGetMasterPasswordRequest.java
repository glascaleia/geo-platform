package org.geosdi.geoplatform.connector.geoserver.request.security;

import org.geosdi.geoplatform.connector.geoserver.model.security.GPGeoserverMasterPassword;
import org.geosdi.geoplatform.connector.server.request.json.GPJsonConnectorRequest;

/**
 * @author Vito Salvia - CNR IMAA geoSDI Group
 * @email vito.salvia@gmail.com
 */
public interface GeoserverGetMasterPasswordRequest extends GPJsonConnectorRequest<GPGeoserverMasterPassword, GeoserverGetMasterPasswordRequest> {
}
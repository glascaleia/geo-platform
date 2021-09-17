package org.geosdi.geoplatform.connector.geoserver.request.settings;

import org.geosdi.geoplatform.connector.geoserver.model.settings.contact.GPGeoserverContactSettings;
import org.geosdi.geoplatform.connector.server.request.json.GPJsonConnectorRequest;

/**
 * @author Vito Salvia - CNR IMAA geoSDI Group
 * @email vito.salvia@gmail.com
 */
public interface GeoserverLoadContactSettingsRequest extends GPJsonConnectorRequest<GPGeoserverContactSettings, GeoserverLoadContactSettingsRequest> {
}
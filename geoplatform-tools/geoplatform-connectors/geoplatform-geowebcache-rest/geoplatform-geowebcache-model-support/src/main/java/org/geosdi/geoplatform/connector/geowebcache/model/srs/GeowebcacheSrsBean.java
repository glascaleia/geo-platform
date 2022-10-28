package org.geosdi.geoplatform.connector.geowebcache.model.srs;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Giuseppe La Scaleia - CNR IMAA geoSDI Group
 * @email giuseppe.lascaleia@geosdi.org
 */
@ToString
@Getter
@Setter
public class GeowebcacheSrsBean implements IGeowebcacheSrsBean {

    private static final long serialVersionUID = -8741112827617099689L;
    //
    private Integer number;
}
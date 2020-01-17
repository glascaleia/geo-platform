package org.geosdi.geoplatform.rs.support.request.binder;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.geosdi.geoplatform.hibernate.validator.support.request.GPI18NRequestValidator;

/**
 * @author Giuseppe La Scaleia - CNR IMAA geoSDI Group
 * @email giuseppe.lascaleia@geosdi.org
 */
public interface GPRequestBinder<B extends Object> extends GPI18NRequestValidator {

    /**
     * @return {@link B}
     * @throws Exception
     */
    @JsonIgnore
    B bind() throws Exception;
}
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
package org.geosdi.geoplatform.experimental.jwt.support.spring.configuration;

import lombok.Getter;
import lombok.ToString;
import net.jcip.annotations.Immutable;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;

import static com.google.common.base.Preconditions.checkArgument;
import static java.lang.Math.abs;

/**
 * @author Giuseppe La Scaleia - CNR IMAA geoSDI Group
 * @email giuseppe.lascaleia@geosdi.org
 */
@ToString
@Immutable
@Component(value = "gpJwtConfiguration")
class GPJwtConfiguration implements IGPJwtConfiguration {

    private static final long serialVersionUID = 1873198581522066412L;
    //
    private static final String GP_JWT_EXPIRATION = "jwtRestConfigurator{gp.jwt_expiration:@null}";
    private static final String GP_JWT_REFRESH_TOKEN_EXPIRATION = "jwtRestConfigurator{gp.jwt_refresh_token_expiration:@null}";
    private static final String GP_JWT_ROLE_CLAIM_KEY = "jwtRestConfigurator{gp.jwt_role_clain_key:@null}";
    //
    @Getter
    @Value(value = GP_JWT_SECRET_KEY)
    private SecretKey secretKey;
    @Value(value = GP_JWT_EXPIRATION)
    private Long expiration;
    @Value(value = GP_JWT_REFRESH_TOKEN_EXPIRATION)
    private Long refreshTokenExpiration;
    @Value(value = GP_JWT_ROLE_CLAIM_KEY)
    @Getter
    private String jwtRoleClaimKey;

    /**
     * @return {@link Long}
     */
    @Override
    public Long getExpiration() {
        return ((this.expiration != null) ? abs(this.expiration) : 3600000L);
    }

    /**
     * @return {@link Long}
     */
    @Override
    public Long getRefreshTokenExpiration() {
        return ((this.refreshTokenExpiration != null) ? abs(this.refreshTokenExpiration) : 25200000L);
    }

    /**
     * Invoked by the containing {@code BeanFactory} after it has set all bean properties
     * and satisfied {@link BeanFactoryAware}, {@code ApplicationContextAware} etc.
     * <p>This method allows the bean instance to perform validation of its overall
     * configuration and final initialization when all bean properties have been set.
     *
     * @throws Exception in the event of misconfiguration (such as failure to set an
     *                   essential property) or if initialization fails for any other reason
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        checkArgument(((jwtRoleClaimKey != null) && !(jwtRoleClaimKey.trim().isEmpty()) && !(jwtRoleClaimKey.equals(GP_JWT_ROLE_CLAIM_KEY))), "The Parameter jwtRoleClaimKey must not be null or an empty string or " + GP_JWT_ROLE_CLAIM_KEY);
    }
}
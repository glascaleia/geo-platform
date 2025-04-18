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
package org.geosdi.geoplatform.response.factory;

import com.google.common.collect.Maps;
import org.geosdi.geoplatform.core.model.GPAccount;
import org.geosdi.geoplatform.core.model.GPUser;
import org.geosdi.geoplatform.core.model.IGPAccount;
import org.geosdi.geoplatform.core.model.adapter.IGPUserAdapter;
import org.geosdi.geoplatform.response.ShortAccountDTO;
import org.geosdi.geoplatform.response.UserDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;
import static java.util.stream.Collectors.toList;

/**
 * @author Giuseppe La Scaleia - CNR IMAA geoSDI Group
 * @email giuseppe.lascaleia@geosdi.org
 */
public final class AccountDTOFactory {

    private static final Logger logger = LoggerFactory.getLogger(AccountDTOFactory.class);

    private static final Map<Class<? extends GPAccount>, AccountDTOStrategy> parameters = Maps.<Class<? extends GPAccount>, AccountDTOStrategy>newHashMap();

    static {
        for (AccountDTOStrategy accountStrategy : AccountStrategyFinder.getValidStrategies(AccountDTOStrategy.class)) {
            parameters.put(accountStrategy.forClass(), accountStrategy);
        }
        logger.debug("\n\n@@@@@@@@@@@@@@@@@@@@@@@@@@ShortAccountDTOFactory parameters " + "map up with {} values.\n\n",
                parameters.size());
    }

    AccountDTOFactory() {
    }

    /**
     * @param accounts
     * @return {@link List<ShortAccountDTO>}
     */
    public static List<ShortAccountDTO> buildShortAccountDTOList(List<GPAccount> accounts) {
        checkNotNull(accounts, "The List of Accounts must not be null.");
        return accounts.stream().filter(Objects::nonNull).map(AccountDTOFactory::buildAccountDTO).collect(toList());
    }

    /**
     * @param accounts
     * @return {@link List<ShortAccountDTO>}
     */
    public static List<ShortAccountDTO> buildShortAccountDecoratorDTOList(List<IGPUserAdapter> accounts) {
        checkNotNull(accounts, "The List of Accounts must not be null.");
        return accounts
                .stream()
                .filter(Objects::nonNull)
                .map(AccountDTOFactory::buildAccountDTO)
                .collect(toList());
    }

    /**
     * @param <V>
     * @param account
     * @return {@link GPAccount}
     */
    public static <V extends IGPAccount> ShortAccountDTO buildAccountDTO(V account) {
        AccountDTOStrategy strategy = parameters.get(account.getClass());
        return (strategy != null) ? strategy.create(account) : null;
    }

    /**
     * @param theGpUserAdapter
     * @return
     */
    public static ShortAccountDTO buildAccountDTO(IGPUserAdapter theGpUserAdapter) {
        checkArgument(theGpUserAdapter != null, "The Parameter theGpUserAdapter must not be null");
        AccountDTOStrategy strategy = parameters.get(theGpUserAdapter.getUser().getClass());
        return (strategy != null && strategy instanceof UserDTOStrategy) ? ((UserDTOStrategy) strategy).create(theGpUserAdapter) : null;
    }

    /**
     * @param users
     * @return {@link List<UserDTO>}
     */
    public static List<UserDTO> buildUserDTOList(List<GPUser> users) {
        checkNotNull(users, "The List of Accounts must not be null.");
        return users.stream()
                .filter(Objects::nonNull)
                .map(AccountDTOFactory::buildAccountDTO)
                .filter(v -> v instanceof UserDTO)
                .map(v -> (UserDTO) v)
                .collect(Collectors.toList());
    }
}
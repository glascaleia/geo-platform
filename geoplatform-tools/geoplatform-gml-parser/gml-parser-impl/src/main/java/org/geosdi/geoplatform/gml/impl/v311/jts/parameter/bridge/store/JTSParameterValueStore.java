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
package org.geosdi.geoplatform.gml.impl.v311.jts.parameter.bridge.store;

import org.geosdi.geoplatform.gml.impl.v311.jts.parameter.bridge.finder.JTSParameterValueFinder;
import org.geosdi.geoplatform.gml.impl.v311.jts.parameter.bridge.implementor.JTSParameterEnum;
import org.geosdi.geoplatform.gml.impl.v311.jts.parameter.bridge.implementor.JTSParameterValue;
import org.geosdi.geoplatform.support.bridge.finder.GPImplementorFinder;
import org.geosdi.geoplatform.support.bridge.implementor.GPImplementor;
import org.geosdi.geoplatform.support.bridge.implementor.GPImplementor.GPImplementorKey;
import org.geosdi.geoplatform.support.bridge.store.GPImplementorStore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

import static com.google.common.base.Preconditions.checkArgument;
import static java.util.function.Function.identity;
import static java.util.stream.Collectors.toMap;

/**
 * @author Giuseppe La Scaleia - CNR IMAA geoSDI Group
 * @email giuseppe.lascaleia@geosdi.org
 */
public class JTSParameterValueStore implements GPImplementorStore<JTSParameterValue<? extends Object>> {

    private static final long serialVersionUID = 6888382924751232089L;
    //
    private static final Logger logger = LoggerFactory.getLogger(JTSParameterValueStore.class);
    private static final GPImplementorFinder<JTSParameterValue<? extends Object>> finder = new JTSParameterValueFinder();
    private static final Map<GPImplementorKey<JTSParameterEnum>, JTSParameterValue<? extends Object>> jtsParameterValueImplementors;

    static {
        jtsParameterValueImplementors = finder.getValidImplementors()
                .stream()
                .collect(toMap(GPImplementor::getKey, identity(), (v1, v2) -> v1, LinkedHashMap::new));
        logger.debug("@@@@@@@@@@@@@@@@@@@@@@{} up with {} values.\n\n", JTSParameterValueStore.class.getSimpleName(),
                jtsParameterValueImplementors.size());
    }

    /**
     * @param key
     * @return {@link JTSParameterValue}
     * @throws Exception
     */
    @Override
    public JTSParameterValue<? extends Object> getImplementorByKey(GPImplementorKey key) throws Exception {
        checkArgument((key != null), "The Parameter key must not be null");
        return jtsParameterValueImplementors.get(key);
    }

    /**
     * @return {@link Set<JTSParameterValue>}
     */
    @Override
    public Set<JTSParameterValue<? extends Object>> getAllImplementors() {
        return Collections.unmodifiableSet(finder.getAllImplementors());
    }

    /**
     * @return {@link JTSParameterValue}
     */
    @Override
    public Collection<JTSParameterValue<? extends Object>> getValidImplementors() {
        return Collections.unmodifiableCollection(finder.getValidImplementors());
    }
}
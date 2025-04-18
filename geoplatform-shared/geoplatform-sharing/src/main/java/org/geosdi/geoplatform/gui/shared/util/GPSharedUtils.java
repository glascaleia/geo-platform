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
package org.geosdi.geoplatform.gui.shared.util;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * @author Nazzareno Sileno - CNR IMAA geoSDI Group
 * @email nazzareno.sileno@geosdi.org
 */
public class GPSharedUtils {

    public static <T> List<T> safeList(List<T> list) {
        return list == null ? Collections.EMPTY_LIST : list;
    }

    public static <T> Collection<T> safeCollection(Collection<T> collection) {
        return collection == null ? Collections.EMPTY_SET : collection;
    }

    public static <TK, TV> Map<TK, TV> safeMap(Map<TK, TV> map) {
        return map == null ? Collections.EMPTY_MAP : map;
    }

    public static boolean isEmpty(final String string) {
        if (string == null || string.isEmpty()) {
            return true;
        }
        return false;
    }

    public static boolean isNotEmpty(final String string) {
        if (string == null || string.isEmpty()) {
            return false;
        }
        return true;
    }

    public static boolean isNotEmpty(final Object[] obj) {
        if (obj == null || obj.length == 0) {
            return false;
        }
        return true;
    }

    public static <T> boolean isEmpty(final List<T> objList) {
        if (objList == null || objList.isEmpty()) {
            return true;
        }
        return false;
    }
    
    public static <T> boolean isNotEmpty(final List<T> objList) {
        if (objList == null || objList.isEmpty()) {
            return false;
        }
        return true;
    }

    public static boolean isNotNull(Object... objs) {
        assert objs != null;
        for (Object obj : objs) {
            if (!isNotNull(obj)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isNull(Object... objs) {
        assert objs != null;
        for (Object obj : objs) {
            if (!isNull(obj)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isNotNull(Object obj) {
        return !isNull(obj);
    }

    public static boolean isNull(Object obj) {
        return (obj == null);
    }

}

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
package org.geosdi.geoplatform.persistence.dao;

import org.geosdi.geoplatform.persistence.dao.exception.GPDAOException;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Nonnull;
import javax.annotation.meta.When;
import java.io.Serializable;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author Giuseppe La Scaleia - CNR IMAA geoSDI Group
 * @author Vincenzo Monteverde <vincenzo.monteverde@geosdi.org>
 * @email giuseppe.lascaleia@geosdi.org
 */
public interface GPBaseDAO<T extends Object, ID extends Serializable> extends GPGenericDAO<T> {

    /**
     * @param id
     * @return {@link Integer}
     * @throws GPDAOException
     */
    Integer delete(ID id) throws GPDAOException;

    /**
     * @param id
     * @return {@link Integer}
     * @throws GPDAOException
     */
    @Transactional(transactionManager = "gpTransactionManager")
    Integer deleteByID(ID id) throws GPDAOException;

    /**
     * @param id
     * @return {@link T}
     * @throws GPDAOException
     */
    T find(ID id) throws GPDAOException;

    /**
     * @return {@link List<T>}
     */
    List<T> findAll() throws GPDAOException;

    /**
     * @param start
     * @param end
     * @return {@link List<T>}
     * @throws GPDAOException
     */
    List<T> findAll(int start, int end) throws GPDAOException;

    /**
     * @return {@link Stream<T>}
     * @throws GPDAOException
     */
    default Stream<T> streamAll() throws GPDAOException {
        return this.findAll().stream();
    }

    /**
     * @param start
     * @param end
     * @return {@link Stream<T>}
     * @throws GPDAOException
     */
    default Stream<T> streamAll(int start, int end) throws GPDAOException {
        return this.findAll(start, end).stream();
    }

    /**
     * @return {@link Number}
     */
    Number count() throws GPDAOException;

    /**
     * @param theIds
     * @return {@link List<T>}
     * @throws GPDAOException
     */
    List<T> findByIds(@Nonnull(when = When.NEVER) List<ID> theIds) throws GPDAOException;
}
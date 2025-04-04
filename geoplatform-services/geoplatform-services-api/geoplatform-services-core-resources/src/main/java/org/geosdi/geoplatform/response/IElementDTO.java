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
package org.geosdi.geoplatform.response;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * For handle this inteface with JAXB.
 *
 * @author Vincenzo Monteverde <vincenzo.monteverde@geosdi.org>
 * @author Michele Santomauro
 */
@XmlJavaTypeAdapter(value = ElementDTOAdapter.class)
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        property = "type")
@JsonSubTypes({
    @JsonSubTypes.Type(value = FolderDTO.class, name = "FolderDTO"),
    @JsonSubTypes.Type(value = RasterLayerDTO.class, name = "RasterLayerDTO"),
    @JsonSubTypes.Type(value = VectorLayerDTO.class, name = "VectorLayerDTO"),
    @JsonSubTypes.Type(value = ShortLayerDTO.class, name = "ShortLayerDTO")})
public interface IElementDTO extends Comparable<IElementDTO> {

    /**
     * @return {@link Long}
     */
    Long getId();

    /**
     * @param theID
     */
    void setId(Long theID);

    /**
     * @return {@link String}
     */
    String getName();

    /**
     * @param theName
     */
    void setName(String theName);

    /**
     * @return {@link Integer}
     */
    Integer getPosition();

    /**
     * @param thePosition
     */
    void setPosition(Integer thePosition);

    /**
     * @return {@link Boolean}
     */
    Boolean isShared();

    /**
     * @param theShared
     */
    void setShared(Boolean theShared);

    /**
     * @return {@link Boolean}
     */
    Boolean isChecked();

    /**
     * @param theChecked
     */
    void setChecked(Boolean theChecked);
}
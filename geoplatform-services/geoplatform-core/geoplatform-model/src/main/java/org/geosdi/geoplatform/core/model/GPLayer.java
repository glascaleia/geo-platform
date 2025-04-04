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
package org.geosdi.geoplatform.core.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.geosdi.geoplatform.gui.shared.GPLayerType;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlTransient;

/**
 * @author Francesco Izzi - geoSDI
 *
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({@JsonSubTypes.Type(value = GPRasterLayer.class, name = "GPRaster"),
        @JsonSubTypes.Type(value = GPVectorLayer.class, name = "GPVector")})
@XmlTransient
@XmlSeeAlso(value = {GPRasterLayer.class, GPVectorLayer.class})
@Entity
@Table(name = "gp_layer", indexes = {@Index(columnList = "name", name = "LAYER_NAME_INDEX")
})
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "gp_layer")
@Getter
@Setter
@ToString
public abstract class GPLayer implements IGPLayer {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 5746325405739614413L;
    //
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GP_LAYER_SEQ")
    @SequenceGenerator(name = "GP_LAYER_SEQ", sequenceName = "GP_LAYER_SEQ")
    private Long id;
    //
    @Column(nullable = false)
    private String title;
    //
    @Column
    private String name;
    //
    @Column(name = "alias_name")
    private String alias;
    //
    @Column(name = "abstract", columnDefinition = "TEXT")
    private String abstractText;
    //
    @Column(name = "url_server")
    private String urlServer;
    //
    @Column
    private String srs;
    //
    @Column(name = "cql_filter", columnDefinition = "TEXT")
    private String cqlFilter;
    //
    @Column(name = "time_filter", columnDefinition = "TEXT")
    private String timeFilter;
    //
    @Embedded
    private GPBBox bbox;
    //
    @Column(name = "layer_type", nullable = false)
    @Enumerated(EnumType.STRING)
    private GPLayerType layerType;
    //    
    @Column
    private int position = -1;
    //
    @Column
    private boolean checked = false;
    //
    @Column
    private boolean shared = false;
    //
    @Column
    private boolean cached = false;
    //
    @Column(name = "single_tile_request", nullable = false)
    private boolean singleTileRequest = false;

    /**
     * (non-Javadoc)
     *
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        GPLayer other = (GPLayer) obj;
        if (id != other.id) {
            return false;
        }
        return true;
    }

    /**
     * (non-Javadoc)
     *
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (id ^ (id >>> 32));
        return result;
    }
}

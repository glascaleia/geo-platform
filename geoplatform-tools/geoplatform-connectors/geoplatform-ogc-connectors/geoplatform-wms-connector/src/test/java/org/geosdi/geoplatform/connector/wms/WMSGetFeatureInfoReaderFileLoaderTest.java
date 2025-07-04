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
package org.geosdi.geoplatform.connector.wms;

import org.geosdi.geoplatform.connector.GPConnectorFile;
import org.geosdi.geoplatform.connector.IGPConnectorFile;
import org.geosdi.geoplatform.connector.IGPConnectorFileStorage;
import org.geosdi.geoplatform.support.jackson.GPJacksonSupport;
import org.geosdi.geoplatform.support.jackson.JacksonSupport;
import org.junit.BeforeClass;

import javax.annotation.Nonnull;
import java.io.File;
import java.util.LinkedHashMap;
import java.util.stream.Stream;

import static java.io.File.separator;
import static java.util.function.Function.identity;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toMap;
import static java.util.stream.Stream.of;
import static javax.annotation.meta.When.NEVER;
import static org.geosdi.geoplatform.support.jackson.property.GPJacksonSupportEnum.*;
import static org.geosdi.geoplatform.support.jackson.property.GPJsonIncludeFeature.NON_NULL;

/**
 * @author Giuseppe La Scaleia - CNR IMAA geoSDI Group
 * @email giuseppe.lascaleia@geosdi.org
 */
public class WMSGetFeatureInfoReaderFileLoaderTest {

    public static final JacksonSupport JACKSON_SUPPORT = new GPJacksonSupport(UNWRAP_ROOT_VALUE_DISABLE,
            FAIL_ON_UNKNOW_PROPERTIES_DISABLE,
            ACCEPT_SINGLE_VALUE_AS_ARRAY_ENABLE,
            WRAP_ROOT_VALUE_DISABLE,
            INDENT_OUTPUT_ENABLE, NON_NULL);
    //
    protected static String basePath;
    protected static IGPConnectorFileStorage storage;

    @BeforeClass
    public static void beforeClass() throws Exception {
        basePath = of(new File(".").getCanonicalPath(), "src", "test", "resources", "stax")
                .collect(joining(separator, "", separator));
        storage = IGPConnectorFileStorage.of(toStreamFilesName()
                .map(WMSGetFeatureInfoReaderFileLoaderTest::toGPConnectorFile)
                .collect(toMap(IGPConnectorFile::getKey, identity(), (v1, v2) -> v1, LinkedHashMap::new)));
    }

    /**
     * @param theValue
     * @return {@link GPConnectorFile}
     */
    protected static GPConnectorFile toGPConnectorFile(@Nonnull(when = NEVER) String theValue) {
        return new GPConnectorFile(theValue, new File(basePath.concat(theValue)));
    }

    /**
     * @return {@link Stream<String>}
     */
    public static Stream<String> toStreamFilesName() {
        return of("geoserver-Vigneti-GetFeatureInfo.xml", "geoserver-GetFeatureInfo.xml",
                "geoserver-GetFeatureInfo1.xml", "geoserver-GetFeatureInfo-Point.xml",
                "geoserver-GetFeatureInfo-MultiLineString.xml", "spearfish-GetFeatureInfo.xml",
                "tasmaniaRoads-GetFeatureInfo.xml", "tasmaniaStates-GetFeatureInfo.xml", "tiger_ny-GetFeatureInfo.xml",
                "sfdem-GetFeatureInfo.xml", "nurcAPk50095-GetFeatureInfo.xml", "nurcArcSample-GetFeatureInfo.xml",
                "comuni-GetFeatureInfo.xml", "parchiNaturali-GetFeatureInfo.xml", "retiRiserve-GetFeatureInfo.xml",
                "linee-GetFeatureInfo.xml", "azioniPunto-GetFeatureInfo.xml", "comuniBasilicata-GetFeatureInfo.xml",
                "corine-GetFeatureInfo.xml", "airports.xml", "geologia.xml", "livelloEdifici.xml", "volumetria.xml",
                "livelloEdifici1.xml", "masw.xml", "CF_zonepianificazione_mappeinterattive.xml",
                "PianoCampiFlegrei.xml", "PianiCampiFlegrei.xml", "rsdi_alt_300_a_400.xml", "aziende.xml",
                "EneaClipFilled.xml", "test.xml", "ParchiBasilicata.xml", "centri_abitati.xml", "mobileBeni.xml",
                "PercorsiNavette.xml", "aggregatiStrutturali.xml", "aggregati_zrvesuvioflegrei.xml",
                "exeflegrei_esiti_c_danni.xml", "ABR_Comuni.xml", "AereeUrbaneValoreStorico.xml", "PNSRS_Valanghe.xml",
                "AreeAmmassamento.xml", "Ferrovie.xml", "MonumentiBizantini.xml", "ReteGas.xml", "AziendeSanitarie.xml",
                "ABR_CaveAttive.xml", "AreeUrbaneValoreStorico.xml", "BaciniIdrogeografici.xml",
                "geoserver-building_resonance_level.xml", "admin_vigneti_catastali.xml", "VulcanoCampiIstat.xml",
                "CAMP_Lahars.xml", "rsdi_alt_600_a_700.xml", "rsdi_fiumi_basilicata.xml", "rsdi_sentieri_app_lucano.xml",
                "dtsew_campania_20150324_20201122.xml", "dtsup_campania_20150324_20201122.xml", "pozzuoliAcque.xml",
                "laghi.xml", "viabilità.xml", "vincoli.xml", "CorsiAcque.xml", "NavteqStreet.xml",
                "CAMPIndustrieARischio.xml", "layer_importer148.xml", "fluids_rete_zk.xml", "AreeBonifica.xml",
                "CentraliElettriche.xml", "features.xml", "Geositi.xml", "ADBRisk.xml", "PoliziaIDR.xml",
                "ParchiRegionaliRiserve.xml", "ReteGeodetica.xml", "ElementiRidotti.xml", "UsoSuoloRT.xml",
                "AlberiMonumentali.xml", "AcqueSecondarie.xml", "AdminGeo.xml", "IDT_SU20G_ZONIZZAZIONE.xml",
                "CBLN_COMPRENSORIO.xml", "Biodiversit_ittica_acque_correnti.xml", "RegimeSperimentale.xml",
                "EMSR634_AOI01_GRA_PRODUCT_builtUpP_r1_v1.xml", "WaterTemp.xml", "AIDT_OP08V_POI_EXPORT.xml");
    }

    /**
     * @return {@link String[]}
     */
    public static String[] toArrayFilesName() {
        return toStreamFilesName().toArray(String[]::new);
    }
}
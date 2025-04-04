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
package org.geosdi.geoplatform.connector.wms.stax2;

import org.junit.FixMethodOrder;
import org.junit.Test;

import static org.junit.runners.MethodSorters.NAME_ASCENDING;

/**
 * @author Giuseppe La Scaleia - CNR IMAA geoSDI Group
 * @email giuseppe.lascaleia@geosdi.org
 */
@FixMethodOrder(value = NAME_ASCENDING)
public class GPWMSGetFeatureInfoWoodstoxReaderTest extends WMSGetFeatureInfoWoodstoxReaderTest {

    @Test
    public void a_a_wmsGetFeatureInfoWoodstoxReaderTest() throws Exception {
        logger.info("#######################FEATURE_COLLECTION_VIGNETI : {}\n", JACKSON_SUPPORT.getDefaultMapper()
                .writeValueAsString(wmsGetFeatureInfoWoodstoxReader.read(storage.find("geoserver-Vigneti-GetFeatureInfo.xml"))));
    }

    @Test
    public void a_b_wmsGetFeatureInfoWoodstoxReaderTest() throws Exception {
        logger.info("#######################FEATURE_COLLECTION_STATES : {}\n", JACKSON_SUPPORT.getDefaultMapper()
                .writeValueAsString(wmsGetFeatureInfoWoodstoxReader.read(storage.find("geoserver-GetFeatureInfo.xml"))));
    }

    @Test
    public void a_c_wmsGetFeatureInfoWoodstoxReaderTest() throws Exception {
        logger.info("#######################FEATURE_COLLECTION_STATES_1 : {}\n", JACKSON_SUPPORT.getDefaultMapper()
                .writeValueAsString(wmsGetFeatureInfoWoodstoxReader.read(storage.find("geoserver-GetFeatureInfo1.xml"))));
    }

    @Test
    public void a_d_wmsGetFeatureInfoWoodstoxReaderTest() throws Exception {
        logger.info("#######################FEATURE_COLLECTION_ADMIN_TEMPO : {}\n", JACKSON_SUPPORT.getDefaultMapper()
                .writeValueAsString(wmsGetFeatureInfoWoodstoxReader.read(storage.find("geoserver-GetFeatureInfo-Point.xml"))));
    }

    @Test
    public void a_e_wmsGetFeatureInfoWoodstoxReaderTest() throws Exception {
        logger.info("#######################FEATURE_COLLECTION_TIGER_ROADS : {}\n", JACKSON_SUPPORT.getDefaultMapper()
                .writeValueAsString(wmsGetFeatureInfoWoodstoxReader.read(storage.find("geoserver-GetFeatureInfo-MultiLineString.xml"))));
    }

    @Test
    public void a_f_wmsGetFeatureInfoWoodstoxReaderTest() throws Exception {
        logger.info("#######################FEATURE_COLLECTION_SPEARFISH : {}\n", JACKSON_SUPPORT.getDefaultMapper()
                .writeValueAsString(wmsGetFeatureInfoWoodstoxReader.read(storage.find("spearfish-GetFeatureInfo.xml"))));
    }

    @Test
    public void a_g_wmsGetFeatureInfoWoodstoxReaderTest() throws Exception {
        logger.info("#######################FEATURE_COLLECTION_TASMANIA_ROADS : {}\n", JACKSON_SUPPORT.getDefaultMapper()
                .writeValueAsString(wmsGetFeatureInfoWoodstoxReader.read(storage.find("tasmaniaRoads-GetFeatureInfo.xml"))));
    }

    @Test
    public void a_h_wmsGetFeatureInfoWoodstoxReaderTest() throws Exception {
        logger.info("#######################FEATURE_COLLECTION_TASMANIA_STATES : {}\n", JACKSON_SUPPORT.getDefaultMapper()
                .writeValueAsString(wmsGetFeatureInfoWoodstoxReader.read(storage.find("tasmaniaStates-GetFeatureInfo.xml"))));
    }

    @Test
    public void a_i_wmsGetFeatureInfoWoodstoxReaderTest() throws Exception {
        logger.info("#######################FEATURE_COLLECTION_TYGER_NY : {}\n", JACKSON_SUPPORT.getDefaultMapper()
                .writeValueAsString(wmsGetFeatureInfoWoodstoxReader.read(storage.find("tiger_ny-GetFeatureInfo.xml"))));
    }

    @Test
    public void a_l_wmsGetFeatureInfoWoodstoxReaderTest() throws Exception {
        logger.info("#######################FEATURE_COLLECTION_SF_DEM : {}\n", JACKSON_SUPPORT.getDefaultMapper()
                .writeValueAsString(wmsGetFeatureInfoWoodstoxReader.read(storage.find("sfdem-GetFeatureInfo.xml"))));
    }

    @Test
    public void a_m_wmsGetFeatureInfoWoodstoxReaderTest() throws Exception {
        logger.info("#######################FEATURE_COLLECTION_NURC_APk50095 : {}\n", JACKSON_SUPPORT.getDefaultMapper()
                .writeValueAsString(wmsGetFeatureInfoWoodstoxReader.read(storage.find("nurcAPk50095-GetFeatureInfo.xml"))));
    }

    @Test
    public void a_n_wmsGetFeatureInfoWoodstoxReaderTest() throws Exception {
        logger.info("#######################FEATURE_COLLECTION_NURC_ARC_SAMPLE : {}\n", JACKSON_SUPPORT.getDefaultMapper()
                .writeValueAsString(wmsGetFeatureInfoWoodstoxReader.read(storage.find("nurcArcSample-GetFeatureInfo.xml"))));
    }

    @Test
    public void a_o_wmsGetFeatureInfoWoodstoxReaderTest() throws Exception {
        logger.info("#######################FEATURE_COLLECTION_COMUNI : {}\n", JACKSON_SUPPORT.getDefaultMapper()
                .writeValueAsString(wmsGetFeatureInfoWoodstoxReader.read(storage.find("comuni-GetFeatureInfo.xml"))));
    }

    @Test
    public void a_p_wmsGetFeatureInfoWoodstoxReaderTest() throws Exception {
        logger.info("#######################FEATURE_COLLECTION_PARCHI_NATURALI : {}\n", JACKSON_SUPPORT.getDefaultMapper()
                .writeValueAsString(wmsGetFeatureInfoWoodstoxReader.read(storage.find("parchiNaturali-GetFeatureInfo.xml"))));
    }

    @Test
    public void a_q_wmsGetFeatureInfoWoodstoxReaderTest() throws Exception {
        logger.info("#######################FEATURE_COLLECTION_RETI_RISERVE : {}\n", JACKSON_SUPPORT.getDefaultMapper()
                .writeValueAsString(wmsGetFeatureInfoWoodstoxReader.read(storage.find("retiRiserve-GetFeatureInfo.xml"))));
    }

    @Test
    public void a_r_wmsGetFeatureInfoWoodstoxReaderTest() throws Exception {
        logger.info("#######################FEATURE_COLLECTION_LINEE : {}\n", JACKSON_SUPPORT.getDefaultMapper()
                .writeValueAsString(wmsGetFeatureInfoWoodstoxReader.read(storage.find("linee-GetFeatureInfo.xml"))));
    }

    @Test
    public void a_s_wmsGetFeatureInfoWoodstoxReaderTest() throws Exception {
        logger.info("#######################FEATURE_COLLECTION_AZIONI_PUNTO : {}\n", JACKSON_SUPPORT.getDefaultMapper()
                .writeValueAsString(wmsGetFeatureInfoWoodstoxReader.read(storage.find("azioniPunto-GetFeatureInfo.xml"))));
    }

    @Test
    public void a_t_wmsGetFeatureInfoWoodstoxReaderTest() throws Exception {
        logger.info("#######################FEATURE_COLLECTION_COMUNI_BASILICATA : {}\n", JACKSON_SUPPORT.getDefaultMapper()
                .writeValueAsString(wmsGetFeatureInfoWoodstoxReader.read(storage.find("comuniBasilicata-GetFeatureInfo.xml"))));
    }

    @Test
    public void a_u_wmsGetFeatureInfoWoodstoxReaderTest() throws Exception {
        logger.info("#######################FEATURE_COLLECTION_CORINE : {}\n", JACKSON_SUPPORT.getDefaultMapper()
                .writeValueAsString(wmsGetFeatureInfoWoodstoxReader.read(storage.find("corine-GetFeatureInfo.xml"))));
    }

    @Test
    public void a_v_wmsGetFeatureInfoWoodstoxReaderTest() throws Exception {
        logger.info("#######################FEATURE_COLLECTION_AIRPORTS : {}\n", JACKSON_SUPPORT.getDefaultMapper()
                .writeValueAsString(wmsGetFeatureInfoWoodstoxReader.read(storage.find("airports.xml"))));
    }

    @Test
    public void a_w_wmsGetFeatureInfoWoodstoxReaderTest() throws Exception {
        logger.info("#######################FEATURE_COLLECTION_GEOLOGIA : {}\n", JACKSON_SUPPORT.getDefaultMapper()
                .writeValueAsString(wmsGetFeatureInfoWoodstoxReader.read(storage.find("geologia.xml"))));
    }

    @Test
    public void a_x_wmsGetFeatureInfoWoodstoxReaderTest() throws Exception {
        logger.info("#######################FEATURE_COLLECTION_LIVELLO_EDIFICI : {}\n", JACKSON_SUPPORT.getDefaultMapper()
                .writeValueAsString(wmsGetFeatureInfoWoodstoxReader.read(storage.find("livelloEdifici.xml"))));
    }

    @Test
    public void a_y_wmsGetFeatureInfoWoodstoxReaderTest() throws Exception {
        logger.info("#######################FEATURE_COLLECTION_VOLUMETRIA : {}\n", JACKSON_SUPPORT.getDefaultMapper()
                .writeValueAsString(wmsGetFeatureInfoWoodstoxReader.read(storage.find("volumetria.xml"))));
    }

    @Test
    public void a_z_wmsGetFeatureInfoWoodstoxReaderTest() throws Exception {
        logger.info("#######################FEATURE_COLLECTION_LIVELLO_EDIFICI_1 : {}\n", JACKSON_SUPPORT.getDefaultMapper()
                .writeValueAsString(wmsGetFeatureInfoWoodstoxReader.read(storage.find("livelloEdifici1.xml"))));
    }

    @Test
    public void b_a_wmsGetFeatureInfoWoodstoxReaderTest() throws Exception {
        logger.info("#######################FEATURE_COLLECTION_MASW : {}\n", JACKSON_SUPPORT.getDefaultMapper()
                .writeValueAsString(wmsGetFeatureInfoWoodstoxReader.read(storage.find("masw.xml"))));
    }

    @Test
    public void b_b_wmsGetFeatureInfoWoodstoxReaderTest() throws Exception {
        logger.info("#######################FEATURE_COLLECTION_CF_zonepianificazione_mappeinterattive : {}\n", JACKSON_SUPPORT
                .getDefaultMapper()
                .writeValueAsString(wmsGetFeatureInfoWoodstoxReader.read(storage.find("CF_zonepianificazione_mappeinterattive.xml"))));
    }

    @Test
    public void b_c_wmsGetFeatureInfoWoodstoxReaderTest() throws Exception {
        logger.info("#######################FEATURE_COLLECTION_PianoCampiFlegrei : {}\n", JACKSON_SUPPORT.getDefaultMapper()
                .writeValueAsString(wmsGetFeatureInfoWoodstoxReader.read(storage.find("PianoCampiFlegrei.xml"))));
    }

    @Test
    public void b_d_wmsGetFeatureInfoWoodstoxReaderTest() throws Exception {
        logger.info("#######################FEATURE_COLLECTION_PianiCampiFlegrei : {}\n", JACKSON_SUPPORT.getDefaultMapper()
                .writeValueAsString(wmsGetFeatureInfoWoodstoxReader.read(storage.find("PianiCampiFlegrei.xml"))));
    }

    @Test
    public void b_e_wmsGetFeatureInfoWoodstoxReaderTest() throws Exception {
        logger.info("#######################FEATURE_COLLECTION_rsdi_alt_300_a_400 : {}\n", JACKSON_SUPPORT.getDefaultMapper()
                .writeValueAsString(wmsGetFeatureInfoWoodstoxReader.read(storage.find("rsdi_alt_300_a_400.xml"))));
    }

    @Test
    public void b_f_wmsGetFeatureInfoWoodstoxReaderTest() throws Exception {
        logger.info("#######################FEATURE_COLLECTION_aziende : {}\n", JACKSON_SUPPORT.getDefaultMapper()
                .writeValueAsString(wmsGetFeatureInfoWoodstoxReader.read(storage.find("aziende.xml"))));
    }

    @Test
    public void b_g_wmsGetFeatureInfoWoodstoxReaderTest() throws Exception {
        logger.info("#######################FEATURE_COLLECTION_EneaClipFilled : {}\n", JACKSON_SUPPORT.getDefaultMapper()
                .writeValueAsString(wmsGetFeatureInfoWoodstoxReader.read(storage.find("EneaClipFilled.xml"))));
    }

    @Test
    public void b_h_wmsGetFeatureInfoWoodstoxReaderTest() throws Exception {
        logger.info("#######################FEATURE_COLLECTION_test : {}\n", JACKSON_SUPPORT.getDefaultMapper()
                .writeValueAsString(wmsGetFeatureInfoWoodstoxReader.read(storage.find("test.xml"))));
    }

    @Test
    public void b_i_wmsGetFeatureInfoWoodstoxReaderTest() throws Exception {
        logger.info("#######################FEATURE_COLLECTION_ParchiBasilicata : {}\n", JACKSON_SUPPORT.getDefaultMapper()
                .writeValueAsString(wmsGetFeatureInfoWoodstoxReader.read(storage.find("ParchiBasilicata.xml"))));
    }

    @Test
    public void b_j_wmsGetFeatureInfoWoodstoxReaderTest() throws Exception {
        logger.info("#######################FEATURE_COLLECTION_CentriAbitati : {}\n", JACKSON_SUPPORT.getDefaultMapper()
                .writeValueAsString(wmsGetFeatureInfoWoodstoxReader.read(storage.find("centri_abitati.xml"))));
    }

    @Test
    public void b_k_wmsGetFeatureInfoWoodstoxReaderTest() throws Exception {
        logger.info("#######################FEATURE_COLLECTION_mobileBeni : {}\n", JACKSON_SUPPORT.getDefaultMapper()
                .writeValueAsString(wmsGetFeatureInfoWoodstoxReader.read(storage.find("mobileBeni.xml"))));
    }

    @Test
    public void b_l_wmsGetFeatureInfoWoodstoxReaderTest() throws Exception {
        logger.info("#######################FEATURE_COLLECTION_PercorsiNavette : {}\n", JACKSON_SUPPORT.getDefaultMapper()
                .writeValueAsString(wmsGetFeatureInfoWoodstoxReader.read(storage.find("PercorsiNavette.xml"))));
    }

    @Test
    public void b_m_wmsGetFeatureInfoWoodstoxReaderTest() throws Exception {
        logger.info("#######################FEATURE_COLLECTION_aggregatiStrutturali : {}\n", JACKSON_SUPPORT.getDefaultMapper()
                .writeValueAsString(wmsGetFeatureInfoWoodstoxReader.read(storage.find("aggregatiStrutturali.xml"))));
    }

    @Test
    public void b_n_wmsGetFeatureInfoWoodstoxReaderTest() throws Exception {
        logger.info("#######################FEATURE_COLLECTION_aggregati_zrvesuvioflegrei : {}\n", JACKSON_SUPPORT.getDefaultMapper()
                .writeValueAsString(wmsGetFeatureInfoWoodstoxReader.read(storage.find("aggregati_zrvesuvioflegrei.xml"))));
    }

    @Test
    public void b_0_wmsGetFeatureInfoWoodstoxReaderTest() throws Exception {
        logger.info("#######################FEATURE_COLLECTION_exeflegrei_esiti_c_danni : {}\n", JACKSON_SUPPORT.getDefaultMapper()
                .writeValueAsString(wmsGetFeatureInfoWoodstoxReader.read(storage.find("exeflegrei_esiti_c_danni.xml"))));
    }

    @Test
    public void b_p_wmsGetFeatureInfoWoodstoxReaderTest() throws Exception {
        logger.info("#######################FEATURE_COLLECTION_pozzuoli_acque : {}\n", JACKSON_SUPPORT.getDefaultMapper()
                .writeValueAsString(wmsGetFeatureInfoWoodstoxReader.read(storage.find("pozzuoliAcque.xml"))));
    }

    @Test
    public void b_q_wmsGetFeatureInfooWoodstoxReaderTest() throws Exception {
        logger.info("#######################FEATURE_COLLECTION_laghi : {}\n", JACKSON_SUPPORT.getDefaultMapper()
                .writeValueAsString(wmsGetFeatureInfoWoodstoxReader.read(storage.find("laghi.xml"))));
    }

    @Test
    public void b_r_wmsGetFeatureInfooWoodstoxReaderTest() throws Exception {
        logger.info("#######################FEATURE_COLLECTION_viabilità : {}\n", JACKSON_SUPPORT.getDefaultMapper()
                .writeValueAsString(wmsGetFeatureInfoWoodstoxReader.read(storage.find("viabilità.xml"))));
    }

    @Test
    public void b_s_wmsGetFeatureInfooWoodstoxReaderTest() throws Exception {
        logger.info("#######################FEATURE_COLLECTION_vincoli : {}\n", JACKSON_SUPPORT.getDefaultMapper()
                .writeValueAsString(wmsGetFeatureInfoWoodstoxReader.read(storage.find("vincoli.xml"))));
    }

    @Test
    public void b_t_wmsGetFeatureInfooWoodstoxReaderTest() throws Exception {
        logger.info("#######################FEATURE_COLLECTION_corsi_acque : {}\n", JACKSON_SUPPORT.getDefaultMapper()
                .writeValueAsString(wmsGetFeatureInfoWoodstoxReader.read(storage.find("CorsiAcque.xml"))));
    }

    @Test
    public void b_u_wmsGetFeatureInfooWoodstoxReaderTest() throws Exception {
        logger.info("#######################FEATURE_COLLECTION : {}\n", JACKSON_SUPPORT.getDefaultMapper()
                .writeValueAsString(wmsGetFeatureInfoWoodstoxReader.read(storage.find("features.xml"))));
    }

    @Test
    public void b_v_wmsGetFeatureInfooWoodstoxReaderTest() throws Exception {
        logger.info("#######################FEATURE_COLLECTION_GEOSITI : {}\n", JACKSON_SUPPORT.getDefaultMapper()
                .writeValueAsString(wmsGetFeatureInfoWoodstoxReader.read(storage.find("Geositi.xml"))));
    }

    @Test
    public void d_h_wmsGetFeatureInfooWoodstoxReaderTest() throws Exception {
        logger.info("#######################FEATURE_COLLECTION_ADB_RISK : {}\n", JACKSON_SUPPORT.getDefaultMapper()
                .writeValueAsString(wmsGetFeatureInfoWoodstoxReader.read(storage.find("ADBRisk.xml"))));
    }

    @Test
    public void d_i_wmsGetFeatureInfooWoodstoxReaderTest() throws Exception {
        logger.info("#######################FEATURE_COLLECTION_POLIZIA_IDR : {}\n", JACKSON_SUPPORT.getDefaultMapper()
                .writeValueAsString(wmsGetFeatureInfoWoodstoxReader.read(storage.find("PoliziaIDR.xml"))));
    }

    @Test
    public void d_l_wmsGetFeatureInfooWoodstoxReaderTest() throws Exception {
        logger.info("#######################FEATURE_COLLECTION_PARCHI_REGIONALI_RISERVE : {}\n", JACKSON_SUPPORT.getDefaultMapper()
                .writeValueAsString(wmsGetFeatureInfoWoodstoxReader.read(storage.find("ParchiRegionaliRiserve.xml"))));
    }

    @Test
    public void d_m_wmsGetFeatureInfooWoodstoxReaderTest() throws Exception {
        logger.info("#######################FEATURE_COLLECTION_PARCHI_ELEMENTI_RIDOTTI : {}\n", JACKSON_SUPPORT.getDefaultMapper()
                .writeValueAsString(wmsGetFeatureInfoWoodstoxReader.read(storage.find("ElementiRidotti.xml"))));
    }

    @Test
    public void d_o_wmsGetFeatureInfooWoodstoxReaderTest() throws Exception {
        logger.info("#######################FEATURE_COLLECTION_ALBERI_MONUMENTALI : {}\n", JACKSON_SUPPORT.getDefaultMapper()
                .writeValueAsString(wmsGetFeatureInfoWoodstoxReader.read(storage.find("AlberiMonumentali.xml"))));
    }

    @Test
    public void d_p_wmsGetFeatureInfooWoodstoxReaderTest() throws Exception {
        logger.info("#######################FEATURE_COLLECTION_ACQUE_SECONDARIE : {}\n", JACKSON_SUPPORT.getDefaultMapper()
                .writeValueAsString(wmsGetFeatureInfoWoodstoxReader.read(storage.find("AcqueSecondarie.xml"))));
    }

    @Test
    public void d_q_wmsGetFeatureInfooWoodstoxReaderTest() throws Exception {
        logger.info("#######################FEATURE_COLLECTION_IDT_SU20G_ZONIZZAZIONE : {}\n", JACKSON_SUPPORT.getDefaultMapper()
                .writeValueAsString(wmsGetFeatureInfoWoodstoxReader.read(storage.find("IDT_SU20G_ZONIZZAZIONE.xml"))));
    }
}
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
package org.geosdi.geoplatform.experimental.jwt.support.spring.jasypt.crypt;

import org.geosdi.geoplatform.logger.support.annotation.GeoPlatformLog;
import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.runners.MethodSorters.NAME_ASCENDING;

/**
 * @author Giuseppe La Scaleia - CNR IMAA geoSDI Group
 * @email giuseppe.lascaleia@geosdi.org
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext-JWT-Crypt-Test.xml"})
@FixMethodOrder(NAME_ASCENDING)
public class GPJwtPooledPBEStringEncryptorTest {

    @GeoPlatformLog
    static Logger logger;
    //
    @Resource(name = "jwtRestPooledPBEStringEncryptor")
    private PooledPBEStringEncryptor jwtRestPooledPBEStringEncryptor;

    @Before
    public void setUp() throws Exception {
        assertNotNull(this.jwtRestPooledPBEStringEncryptor);
    }

    @Test
    public void a_encryptGPJwtSecretKeyTest() throws Exception {
        String secretKey = "677f6dc5ddbd92de148c5725a32f4c19a021db89d5fa14ff7529974f47a96ca9";
        String encryptedSecretKey = this.jwtRestPooledPBEStringEncryptor.encrypt(secretKey);
        assertTrue("GPJwtPooledPBEStringEncryptorTest / Encrypted secretKey doesn't match", this.jwtRestPooledPBEStringEncryptor
                .decrypt(encryptedSecretKey).equals(secretKey));
        logger.trace("@@@@@@@@@@@@@@GP_JWT_ENCRYPTED_SECRET_KEY : {}\n\n", encryptedSecretKey);
    }
}
/*
 *
 *    geo-platform
 *    Rich webgis framework
 *    http://geo-platform.org
 *   ====================================================================
 *
 *   Copyright (C) 2008-2026 geoSDI Group (CNR IMAA - Potenza - ITALY).
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
package org.geosdi.geoplatform.gui.client.rest;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.json.client.JSONValue;

/**
 * Legge il messaggio di una chiamata REST fallita dal body scritto dai servizi di geo-platform, cioè
 * {@code {"faultType":"...","message":"..."}} (vedi {@code GPRestExceptionMessage}), oppure lo stesso oggetto dentro
 * {@code gpRestExceptionMessage} con i provider che tengono la radice.
 *
 * @author Giuseppe La Scaleia - CNR IMAA geoSDI Group
 * @email giuseppe.lascaleia@geosdi.org
 */
public final class GPRestErrorMessage {

    /**
     * Classe di sole funzioni statiche: non si istanzia.
     */
    private GPRestErrorMessage() {
    }

    /**
     * Il body può non essere JSON (per esempio la pagina d'errore di un proxy): in quel caso, come quando manca
     * il messaggio, si usa theFallback invece di lanciare un'eccezione.
     *
     * @param theBody il body della risposta; può essere null, vuoto o non JSON
     * @param theFallback il messaggio da restituire quando nel body non c'è un messaggio leggibile
     * @return {@link String} il campo message, cercato nella radice o in {@code gpRestExceptionMessage}, senza
     * virgolette, oppure theFallback
     */
    public static String of(String theBody, String theFallback) {
        if ((theBody == null) || theBody.trim().isEmpty()) {
            return theFallback;
        }
        try {
            JSONObject body = JSONParser.parseStrict(theBody).isObject();
            JSONValue restException = (body != null) ? body.get("gpRestExceptionMessage") : null;
            JSONObject restExceptionObject = (restException != null) ? restException.isObject() : body;
            JSONValue message = (restExceptionObject != null) ? restExceptionObject.get("message") : null;
            JSONString messageString = (message != null) ? message.isString() : null;
            return (messageString != null) ? messageString.stringValue() : theFallback;
        } catch (Exception ex) {
            return theFallback;
        }
    }
}

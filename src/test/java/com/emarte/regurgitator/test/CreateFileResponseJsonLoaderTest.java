/*
 * Copyright (C) 2017 Miles Talmey.
 * Distributed under the MIT License (license terms are at http://opensource.org/licenses/MIT).
 */
package com.emarte.regurgitator.test;

import com.emarte.regurgitator.core.RegurgitatorException;
import com.emarte.regurgitator.extensions.web.CreateFileResponseJsonLoader;
import org.junit.Test;
import org.xml.sax.SAXException;

import java.io.IOException;

import static com.emarte.regurgitator.core.ConfigurationFile.loadFile;

public class CreateFileResponseJsonLoaderTest extends JsonLoaderTest {
    public CreateFileResponseJsonLoaderTest() {
        super(new CreateFileResponseJsonLoader());
    }

    @Test
    public void testThis() throws IOException, RegurgitatorException {
        assertExpectation("classpath:/CreateFileResponse.json", "com.emarte.regurgitator.extensions.web.CreateFileResponse:['create-file-response-1',com.emarte.regurgitator.core.ValueSource:[com.emarte.regurgitator.core.ContextLocation:['request-metadata:path-info'],null],null]");
    }

    @Test
    public void testPrefixed() throws SAXException, IOException, RegurgitatorException {
        assertExpectation("classpath:/CreateFileResponse_prefixed.json", "com.emarte.regurgitator.extensions.web.CreateFileResponse:['create-file-response-1',com.emarte.regurgitator.core.ValueSource:[com.emarte.regurgitator.core.ContextLocation:['request-metadata:path-info'],null],'/assets']");
    }

    @Test
    public void testFullLoadJson() throws RegurgitatorException {
        loadFile("classpath:/CreateFileResponse_fullLoad.json");
    }
}

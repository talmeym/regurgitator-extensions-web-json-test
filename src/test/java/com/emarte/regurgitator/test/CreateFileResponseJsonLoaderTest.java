/*
 * Copyright (C) 2017 Miles Talmey.
 * Distributed under the MIT License (license terms are at http://opensource.org/licenses/MIT).
 */
package com.emarte.regurgitator.test;

import com.emarte.regurgitator.extensions.web.CreateFileResponseJsonLoader;
import org.junit.Test;

import static com.emarte.regurgitator.core.ConfigurationFile.loadFile;
import static com.emarte.regurgitator.test.WebExtensionsLoaderTestExpectations.CreateFileResponse;
import static com.emarte.regurgitator.test.WebExtensionsLoaderTestExpectations.CreateFileResponse_prefixed;

public class CreateFileResponseJsonLoaderTest extends JsonLoaderTest {
    public CreateFileResponseJsonLoaderTest() {
        super(new CreateFileResponseJsonLoader());
    }

    @Test
    public void testThis() throws Exception {
        assertExpectation("classpath:/CreateFileResponse.json", CreateFileResponse);
    }

    @Test
    public void testPrefixed() throws Exception {
        assertExpectation("classpath:/CreateFileResponse_prefixed.json", CreateFileResponse_prefixed);
    }

    @Test
    public void testFullLoad() throws Exception {
        loadFile("classpath:/CreateFileResponse_fullLoad.json");
    }
}

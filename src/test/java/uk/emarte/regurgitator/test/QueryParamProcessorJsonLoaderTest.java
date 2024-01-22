/*
 * Copyright (C) 2017 Miles Talmey.
 * Distributed under the MIT License (license terms are at http://opensource.org/licenses/MIT).
 */
package uk.emarte.regurgitator.test;

import org.junit.Test;
import uk.emarte.regurgitator.extensions.web.QueryParamProcessorJsonLoader;

import static uk.emarte.regurgitator.core.ConfigurationFile.loadFile;
import static uk.emarte.regurgitator.test.WebExtensionsLoaderTestExpectations.QueryParamProcessor;

public class QueryParamProcessorJsonLoaderTest extends JsonLoaderTest {
    public QueryParamProcessorJsonLoaderTest() {
        super(new QueryParamProcessorJsonLoader());
    }

    @Test
    public void testLoader() throws Exception {
        assertExpectation("classpath:/QueryParamProcessor.json", QueryParamProcessor);
    }

    @Test
    public void testFullLoad() throws Exception {
        loadFile("classpath:/QueryParamProcessor_FullLoad.json");
    }
}

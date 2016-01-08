package com.emarte.regurgitator.test;

import com.emarte.regurgitator.core.*;
import com.emarte.regurgitator.extensions.web.QueryParamProcessorJsonLoader;
import org.junit.Test;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.util.HashSet;

import static com.emarte.regurgitator.core.ConfigurationFile.loadFile;
import static junit.framework.Assert.assertEquals;

public class QueryParamProcessorJsonLoaderTest extends JsonLoaderTest {
	public QueryParamProcessorJsonLoaderTest() {
		super(new QueryParamProcessorJsonLoader());
	}

	@Test
	public void testThis() throws Exception {
		assertExpectation("classpath:/QueryParamProcessor.json", "com.emarte.regurgitator.extensions.web.QueryParamProcessor:['value']");
	}

	@Test
	public void testFullLoad() throws Exception {
		loadFile("classpath:/QueryParamProcessor_FullLoad.json");
	}
}

package com.emarte.regurgitator.test;

import com.emarte.regurgitator.extensions.web.QueryParamProcessorJsonLoader;
import org.junit.Test;

import static com.emarte.regurgitator.core.ConfigurationFile.loadFile;

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

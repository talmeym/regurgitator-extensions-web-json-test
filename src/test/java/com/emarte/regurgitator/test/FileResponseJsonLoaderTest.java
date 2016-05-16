package com.emarte.regurgitator.test;

import com.emarte.regurgitator.core.RegurgitatorException;
import com.emarte.regurgitator.extensions.web.FileResponseJsonLoader;
import org.junit.Test;
import org.xml.sax.SAXException;

import java.io.IOException;

public class FileResponseJsonLoaderTest extends JsonLoaderTest {
	public FileResponseJsonLoaderTest() {
		super(new FileResponseJsonLoader());
	}

	@Test
	public void testThis() throws IOException, RegurgitatorException {
		assertExpectation("classpath:/FileResponse.json", "com.emarte.regurgitator.extensions.web.FileResponse:['file-response-1',com.emarte.regurgitator.core.ValueSource:[com.emarte.regurgitator.core.ContextLocation:['request-metadata:path-info'],null],null]");
	}

	@Test
	public void testPrefixed() throws SAXException, IOException, RegurgitatorException {
		assertExpectation("classpath:/FileResponse_prefixed.json", "com.emarte.regurgitator.extensions.web.FileResponse:['file-response-1',com.emarte.regurgitator.core.ValueSource:[com.emarte.regurgitator.core.ContextLocation:['request-metadata:path-info'],null],'/assets']");
	}

}

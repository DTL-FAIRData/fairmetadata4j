/**
 * The MIT License
 * Copyright © 2019 DTL
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.dtls.fairmetadata4j.parser;

import nl.dtls.fairmetadata4j.model.AccessRights;
import nl.dtls.fairmetadata4j.util.ExampleFilesUtils;
import org.eclipse.rdf4j.model.IRI;
import org.eclipse.rdf4j.model.Statement;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotNull;

/**
 * Unit tests for IdentifierParser.
 *
 * @author Rajaram Kaliyaperumal <rr.kaliyaperumal@gmail.com>
 * @author Kees Burger <kees.burger@dtls.nl>
 * @version 0.1
 * @since 2017-02-22
 */
public class AccessRightsParserTest {

    private final List<Statement> STMTS = ExampleFilesUtils.getFileContentAsStatements(
            ExampleFilesUtils.DATASET_METADATA_FILE, ExampleFilesUtils.DATASET_URI.toString());

    /**
     * Test null accessRights uri, this test is expected to throw exception
     *
     * @throws Exception
     */
    @Test(expected = NullPointerException.class)
    public void testParseNullAccessRightsUri() throws Exception {
        System.out.println("Test : Parse null id uri");
        AccessRightsParser.parse(STMTS, null);
    }

    /**
     * Test null rdf statements, this test is expected to throw exception
     *
     * @throws Exception
     */
    @Test(expected = NullPointerException.class)
    public void testParseNullStatements() throws Exception {
        System.out.println("Test : Parse null statements");
        IRI uri = ExampleFilesUtils.BIOSEM_ACCESS_RIGHTS_URI;
        AccessRightsParser.parse(null, uri);
    }

    /**
     * Test empty rdf statements, this test is expected to throw exception
     *
     * @throws Exception
     */
    @Test(expected = IllegalArgumentException.class)
    public void testParseEmptyStatements() throws Exception {
        System.out.println("Test : Parse empty statements");
        List<Statement> statements = new ArrayList();
        IRI uri = ExampleFilesUtils.BIOSEM_ACCESS_RIGHTS_URI;
        AccessRightsParser.parse(statements, uri);
    }

    /**
     * Test valid accessRights.
     */
    @Test
    public void testValidMetadataAccessRights() {
        System.out.println("Parse dataset accessRights");
        IRI uri = ExampleFilesUtils.BIOSEM_ACCESS_RIGHTS_URI;
        AccessRights result = AccessRightsParser.parse(STMTS, uri);
        assertNotNull(result);
    }

}

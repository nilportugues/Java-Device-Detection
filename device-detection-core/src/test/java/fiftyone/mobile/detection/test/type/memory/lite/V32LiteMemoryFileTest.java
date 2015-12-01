/*
 * This Source Code Form is copyright of 51Degrees Mobile Experts Limited.
 * Copyright © 2015 51Degrees Mobile Experts Limited, 5 Charlotte Close,
 * Caversham, Reading, Berkshire, United Kingdom RG4 7BY
 *
 * This Source Code Form is the subject of the following patent
 * applications, owned by 51Degrees Mobile Experts Limited of 5 Charlotte
 * Close, Caversham, Reading, Berkshire, United Kingdom RG4 7BY:
 * European Patent Application No. 13192291.6; and
 * United States Patent Application Nos. 14/085,223 and 14/085,301.
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0.
 *
 * If a copy of the MPL was not distributed with this file, You can obtain
 * one at http://mozilla.org/MPL/2.0/.
 *
 * This Source Code Form is "Incompatible With Secondary Licenses", as
 * defined by the Mozilla Public License, v. 2.0.
 */

package fiftyone.mobile.detection.test.type.memory.lite;

import fiftyone.mobile.detection.Dataset;
import fiftyone.mobile.detection.factories.StreamFactory;
import fiftyone.mobile.detection.Filename;
import fiftyone.mobile.detection.test.TestType;
import fiftyone.mobile.detection.test.common.UserAgentGenerator;
import fiftyone.mobile.detection.test.type.memory.MemoryBase;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import java.io.IOException;

@Category({TestType.DataSetLite.class, TestType.TypeMemory.class})
public class V32LiteMemoryFileTest extends MemoryBase {

    private static String filename = Filename.LITE_PATTERN_V32;
    private static Dataset dataset;

    @BeforeClass
    public static void setUp() throws IOException {
        if (fileExists(filename)) dataset = StreamFactory.create(filename, false);
    }

    @Before
    public void checkFileExists() {
        assertFileExists(filename);
    }

    @AfterClass
    public static void tearDown() throws IOException {
        if (dataset != null) dataset.close();
        dataset = null;
    }

    @Test
    @Category({TestType.DataSetLite.class, TestType.TypeMemory.class})
    public void uniqueUserAgentsMulti() throws IOException {
        super.userAgentsMulti(UserAgentGenerator.getUniqueUserAgents(), 20);
    }

    @Test
    public void uniqueUserAgentsSingle() throws IOException {
        super.userAgentsSingle(UserAgentGenerator.getUniqueUserAgents(), 20);
    }

    @Test
    public void randomUserAgentsMulti() throws IOException {
        super.userAgentsMulti(UserAgentGenerator.getRandomUserAgents(), 20);
    }

    @Test
    public void randomUserAgentsSingle() throws IOException {
        super.userAgentsSingle(UserAgentGenerator.getRandomUserAgents(), 20);
    }

    @Test
    public void badUserAgentsMulti() throws IOException {
        super.userAgentsMulti(UserAgentGenerator.getBadUserAgents(), 50);
    }

    @Test
    public void badUserAgentsSingle() throws IOException {
        super.userAgentsSingle(UserAgentGenerator.getBadUserAgents(), 50);
    }

    @Override
    protected Dataset getDataset() {
        return dataset;
    }
}

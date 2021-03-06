/**
 *
 * Copyright 2005-2006 The Apache Software Foundation or its licensors, as applicable.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package org.apache.xbean.spring.context;

import org.springframework.context.support.AbstractXmlApplicationContext;
import org.apache.xbean.spring.example.GinService;

/**
 * @author James Strachan
 * @version $Id$
 * @since 1.0
 */
public class GinUsingSpringTest extends SpringTestSupport {
    
    public void testWine() throws Exception {
        GinService service = (GinService) getBean("ginService");

        assertEquals("name", "Bombay Sapphire", service.getName());
    }

    protected AbstractXmlApplicationContext createApplicationContext() {
        return new ClassPathXmlApplicationContext("org/apache/xbean/spring/context/gin.xml");
    }
}

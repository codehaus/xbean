/**
 * 
 * Copyright 2005-2006 The Apache Software Foundation or its licensors,  as applicable.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); 
 * you may not use this file except in compliance with the License. 
 * You may obtain a copy of the License at 
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, 
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. 
 * See the License for the specific language governing permissions and 
 * limitations under the License. 
 * 
 **/
package org.apache.xbean.sca;

import org.osoa.sca.ModuleContext;
import org.osoa.sca.model.Component;

/**
 * A pluggable strategy for connecting XBean to some SCA runtime
 * 
 * @version $Revision$
 */
public interface ScaAdapter {

    ModuleContext getComponentContext(Object bean, String beanName);

    Component getComponentMetaData(Object bean, String beanName);

    Object getBeanSessionID(Object bean, String beanName);

}

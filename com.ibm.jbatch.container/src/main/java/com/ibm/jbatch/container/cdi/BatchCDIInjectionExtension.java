/**
 * Copyright 2013 International Business Machines Corp.
 *
 * See the NOTICE file distributed with this work for additional information
 * regarding copyright ownership. Licensed under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.ibm.jbatch.container.cdi;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.enterprise.event.Observes;
import javax.enterprise.inject.spi.AnnotatedType;
import javax.enterprise.inject.spi.BeanManager;
import javax.enterprise.inject.spi.BeforeBeanDiscovery;
import javax.enterprise.inject.spi.Extension;

public class BatchCDIInjectionExtension implements Extension {

    private final static String sourceClass = BatchProducerBean.class.getName();
    private final static Logger logger = Logger.getLogger(sourceClass);




    
    void beforeBeanDiscovery(@Observes BeforeBeanDiscovery bbd, BeanManager bm) {

        logger.log(Level.FINE, "BatchCDIInjectionExtension.beforeBeanDiscovery() bm=" + bm);

        AnnotatedType<BatchProducerBean> at = bm.createAnnotatedType(BatchProducerBean.class);
        bbd.addAnnotatedType(at);
        
        logger.log(Level.FINE, "BatchCDIInjectionExtension.beforeBeanDiscovery() added annotated type: " + BatchProducerBean.class.getName());
    }

}

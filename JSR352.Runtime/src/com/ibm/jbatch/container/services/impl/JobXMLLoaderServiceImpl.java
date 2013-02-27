/*
 * Copyright 2012 International Business Machines Corp.
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
package com.ibm.jbatch.container.services.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Logger;

import com.ibm.jbatch.container.config.impl.ServicesManagerImpl;
import com.ibm.jbatch.container.exception.BatchContainerServiceException;
import com.ibm.jbatch.spi.IBatchConfig;
import com.ibm.jbatch.spi.services.IJobXMLLoaderService;
import com.ibm.jbatch.spi.services.ServiceType;

public class JobXMLLoaderServiceImpl implements IJobXMLLoaderService {

    
    private final static Logger logger = Logger.getLogger(JobXMLLoaderServiceImpl.class.getName());
    private final static String CLASSNAME = JobXMLLoaderServiceImpl.class.getName();
    
    protected static IJobXMLLoaderService preferredJobXmlLoader = (IJobXMLLoaderService) ServicesManagerImpl.getInstance().getService(ServiceType.JOBXML_LOADER_SERVICE);
    
    public static final String PREFIX = "/META-INF/batch-jobs/";
    
    
    @Override
	public String loadJob(String id) {
	    
        String jobXML = preferredJobXmlLoader.loadJob(id);

        if (jobXML != null) {
            return jobXML;
        }
        
	    jobXML =  loadJobFromBatchJobs(id);
	    
	    if (jobXML == null) {
	        throw new BatchContainerServiceException("Could not load job xml with id: " + id);
	    }
	    
	    return jobXML;
	    
	}


	private static String loadJobFromBatchJobs(String id) {

	    ClassLoader tccl = Thread.currentThread().getContextClassLoader();
	    
	    URL path = tccl.getResource(PREFIX + id + ".xml" );
	    
	    String xmlString = readJobXML(path.getPath());
	    
	    return xmlString;
	    
    }


    @Override
	public String loadStep(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String loadXJCL(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	
    private static String readJobXML(String fileWithPath)  {

        StringBuffer xmlBuffer = ( fileWithPath==null ? null : new StringBuffer() );
        try {
        if ( !(fileWithPath==null) ) {
            BufferedReader in = new BufferedReader(new FileReader(new File(fileWithPath)));
            String input = in.readLine();
            do {
                if (input != null) {
                    xmlBuffer.append(input);
                    input = in.readLine();
                }
            } while (input!=null);
        }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        
        return ( xmlBuffer==null ? null : xmlBuffer.toString() );
    }


    @Override
    public void init(IBatchConfig batchConfig) throws BatchContainerServiceException {
        // TODO Auto-generated method stub
        
    }


    @Override
    public void shutdown() throws BatchContainerServiceException {
        // TODO Auto-generated method stub
        
    }
	
}
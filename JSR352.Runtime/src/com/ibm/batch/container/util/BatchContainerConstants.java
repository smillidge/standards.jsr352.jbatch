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
package com.ibm.batch.container.util;

public interface BatchContainerConstants {

	public static final String BATCH_ADMIN_CONFIG_FILE = "batch-config.properties";
	public static final String BATCH_INTEGRATOR_CONFIG_FILE = "batch-services.properties";
	
	public static final String J2SE_MODE = "J2SE_MODE";
	public static final String JNDI_NAME = "JNDI_NAME";
	public static final String WORK_MANAGER_JNDI_NAME = "WORK_MANAGER_JNDI_NAME";
		
	public static final String GLASSFISH_THREADPOOL_MAX_QUEUE_SIZE = "GLASSFISH_THREADPOOL_MAX_QUEUE_SIZE";
	public static final String GLASSFISH_THREADPOOL_MAX_POOL_SIZE = "GLASSFISH_THREADPOOL_MAX_POOL_SIZE";
	public static final String GLASSFISH_THREADPOOL_MIN_POOL_SIZE = "GLASSFISH_THREADPOOL_MIN_POOL_SIZE";
	public static final String GLASSFISH_THREADPOOL_IDLE_THREAD_TIMEOUT = "GLASSFISH_THREADPOOL_IDLE_THREAD_TIMEOUT";	

	public static final String JDBC_DRIVER = "JDBC_DRIVER";
	public static final String JDBC_URL = "JDBC_URL";
	public static final String DB_USER = "DB_USER";
	public static final String DB_PASSWORD = "DB_PWD";
	public static final String DEFAULT_JDBC_JNDI_NAME = "jdbc/batch";
}
/**
 *  Copyright (C) 2008-2017  Telosys project org. ( http://www.telosys.org/ )
 *
 *  Licensed under the GNU LESSER GENERAL PUBLIC LICENSE, Version 3.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *          http://www.gnu.org/licenses/lgpl.html
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package org.telosys.tools.commons.logger;

import org.telosys.tools.commons.ExceptionUtil;
import org.telosys.tools.commons.TelosysToolsLogger;

/**
 * Basic utility class for system console logging (only for DEBUG) 
 * 
 * @author Laurent GUERIN
 *
 */
public abstract class GenericLogger implements TelosysToolsLogger
{
	//----------------------------------------------------------------------------------
	protected abstract void print(String s) ;

	//----------------------------------------------------------------------------------
	@Override
	public final void log(Object object, String s) {
		if ( GlobalLoggingConfig.isLogEnabled() ) {
			String className = "???" ;
			if ( object != null ) {
				className = object.getClass().getSimpleName();
			}
			print("[LOG] (" + className + ") : " + s);
		}
	}
	
	//----------------------------------------------------------------------------------
	@Override
	public final void log(String s) {
		if ( GlobalLoggingConfig.isLogEnabled() ) {
			print("[LOG] " + s);
		}
	}

	//----------------------------------------------------------------------------------
	@Override
	public final void error(String s) {
		print("[ERROR] " + s);
	}

	//----------------------------------------------------------------------------------
	@Override
	public final void error(String s, Throwable e) {
		print("[ERROR] : " + s );
		//print("[ERROR EXCEPTION] : " + e.getClass().getSimpleName() + " " + e.getMessage() );
		logStackTrace(e);
	}

	//----------------------------------------------------------------------------------
	@Override
	public final void info(String s) {
		print("[INFO] " + s );
	}
	
	//----------------------------------------------------------------------------------
	@Override
	public final void logStackTrace (Throwable e) {
		print( "----- "  );
		print( " Exception : " + e.getClass().getName() );
		print( " Message   : " + e.getMessage() );
		printStackTrace(e) ;
		
		Throwable cause = e.getCause() ;
		while ( cause != null ) 
		{
			print( "----- "  );
			print( " Cause   : "  + cause.getClass().getName() );
			print( " Message : " + cause.getMessage() );
			printStackTrace(cause) ;
			
			cause = cause.getCause();
		}
	}

	//----------------------------------------------------------------------------------
    private void printStackTrace(Throwable ex)
    {
        print ( ExceptionUtil.getStackTraceAsString(ex) ) ;
    }
}

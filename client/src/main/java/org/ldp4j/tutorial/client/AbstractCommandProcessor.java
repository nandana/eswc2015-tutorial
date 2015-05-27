/**
 * #-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=#
 *   This file is part of the LDP4j Project:
 *     http://www.ldp4j.org/
 *
 *   Center for Open Middleware
 *     http://www.centeropenmiddleware.com/
 * #-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=#
 *   Copyright (C) 2014 Center for Open Middleware.
 * #-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=#
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *             http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 * #-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=#
 *   Artifact    : org.ldp4j.tutorial.client:eswc-2015-client:1.0.0-SNAPSHOT
 *   Bundle      : eswc-2015-client-1.0.0-SNAPSHOT.jar
 * #-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=#
 */
package org.ldp4j.tutorial.client;

public abstract class AbstractCommandProcessor implements CommandProcessor {


	private static final class NullShellConsole implements ShellConsole {

		@Override
		public String readLine() {
			throw new UnsupportedOperationException("Console is not readable");
		}

		@Override
		public ShellConsole title(String fmt, Object... args) {
			return this;
		}

		@Override
		public ShellConsole prompt(String fmt, Object... args) {
			return this;
		}

		@Override
		public ShellConsole error(String fmt, Object... args) {
			return this;
		}

		@Override
		public ShellConsole message(String fmt, Object... args) {
			return this;
		}

		@Override
		public ShellConsole metadata(String fmt, Object... args) {
			return this;
		}

		@Override
		public ShellConsole data(String fmt, Object... args) {
			return this;
		}

		@Override
		public boolean isClearable() {
			return false;
		}

		@Override
		public ShellConsole clear() {
			throw new UnsupportedOperationException("Console cannot be cleared");
		}

		@Override
		public boolean isReadable() {
			return false;
		}
	}

	private ShellConsole console;

	protected AbstractCommandProcessor() {
	}

	protected final ShellConsole console() {
		ShellConsole result=this.console;
		if(result==null) {
			result=new NullShellConsole();
		}
		return result;
	}

	@Override
	public final void setConsole(ShellConsole console) {
		this.console = console;
	}

}
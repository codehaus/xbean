/**
 *
 * Copyright 2005 David Blevins
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
 */
package org.xbean.telnet;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

public class Version extends Command {
    public static void register() {
        Command.register("version", Version.class);
    }

    public void exec(String[] args, InputStream in, PrintStream out) throws IOException {
        /*
         * Output startup message
         */
        Properties versionInfo = new Properties();
        try {
            versionInfo.load(new URL("resource:/openejb-version.properties").openConnection().getInputStream());
        } catch (java.io.IOException e) {
        }
        out.print("OpenEJB Remote Server ");
        out.print(versionInfo.getProperty("version"));
        out.print("    build: ");
        out.print(versionInfo.getProperty("date"));
        out.print("-");
        out.println(versionInfo.getProperty("time"));
        out.println(versionInfo.getProperty("url"));
    }
}

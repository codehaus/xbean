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
package org.xbean.terminal.telnet;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;

import org.xbean.command.CommandShell;

public class TelnetShell {

    private final String serverName;

    public TelnetShell(String serverName) {
        this.serverName = serverName;
    }

    public void service(Socket socket) throws IOException {

        try {
            service(socket.getInputStream(), socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (socket != null) socket.close();
        }
    }

    public void service(InputStream in, OutputStream out) throws IOException {
        InputStream telnetIn = null;
        PrintStream telnetOut = null;
        try {
            telnetIn = new TelnetInputStream(in, out);
            telnetOut = new TelnetPrintStream(out);

            telnetOut.println(serverName + " Console");
            telnetOut.println("type \'help\' for a list of commands");

            // TODO:1: Login
            //...need a security service first

            CommandShell shell = new CommandShell(serverName);
            shell.main(new String[]{}, telnetIn, telnetOut);

        } catch (Throwable t) {
            // TODO: log this
        } finally {
            if (telnetIn != null){
                telnetIn.close();
            }
            if (telnetOut != null) {
                telnetOut.close();
            }
        }
    }
}
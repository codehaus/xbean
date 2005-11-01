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

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class Help extends Command {
    public static void register() {
        Command.register("help", Help.class);
    }

    public void exec(String[] args, InputStream in, PrintStream out) throws IOException {
        HashMap hash = Command.commands;
        Set set = hash.keySet();
        Iterator cmds = set.iterator();
        while (cmds.hasNext()) {
            out.print(" " + cmds.next());
            out.println("");
        }
    }
}

package agentsoz.jill.util;

/*
 * #%L
 * Jill Cognitive Agents Platform
 * %%
 * Copyright (C) 2014 - 2015 by its authors. See AUTHORS file.
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Lesser Public License for more details.
 * 
 * You should have received a copy of the GNU General Lesser Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/lgpl-3.0.html>.
 * #L%
 */

import java.util.logging.Level;

import agentsoz.jill.Main;
import agentsoz.jill.config.GlobalConstant;

public class ArgumentsLoader {

	private static String logFile = "Run.log";
	private static Level logLevel = Level.WARNING;
	private static String agentClass = null;
	private static int numAgents = 0;
	private static int numCycles = -1;
	private static int numThreads = Runtime.getRuntime().availableProcessors();
	private static String pargs = "";
	private static long randomSeed = -1;
	private static String pout = null;
	private static boolean doPauseForUserInput = false;
	
	public static String usage() {
		return GlobalConstant.APP_HEADER + "\n\n" +
			"usage: " + Main.class.getName() + 
			"  [options] -c <agentclass> -i <cycles> -n <numagents>" + "\n" +
			"   -c <agentclass>   agent class to load" + "\n" +
			"   -d <debuglevel>   debug level (e.g., 'SEVERE', 'INFO', 'FINE')" + "\n" +
			"   -i <cycles>       number of cycles to perform before existing (runs forever if unspecified)" + "\n" +
			"   -l <logfile>      file for logging output" + "\n" +
			"   -n <numagent>     number of agents to create (of type <agentclass>)" + "\n" +
			"   -o <outfile>      file for program output" + "\n" +
			"   -p <pargs>        arguments string to pass to agent class (optional)" + "\n" +
			"   -r <randseed>     seed to use for random number generator (optional)" + "\n" +
			"   -t <numthreads>   number of threads used by execution engine (defaults to number of available cores)" + "\n" +
			"   -w                wait for Enter/Return key press (default is "+doPauseForUserInput+")"
			;
	}
	
	public static void parse(String[] args) {
		for (int i = 0; i < args.length; i++) {
			switch(args[i]) {
			case "-c":
				if (i+1 < args.length) {
					i++;
					agentClass = args[i];
				}
				break;
			case "-d":
				if (i+1 < args.length) {
					i++;
					try {
						logLevel = Level.parse(args[i]);
					} catch(Exception e) {
						abort("Unknown log level '"+args[i]+"'");
					}
				}
				break;
			case "-i":
				if (i+1 < args.length) {
					i++;
					try {
						numCycles = Integer.parseInt(args[i]);
					} catch (Exception e) {
						abort("Option value '"+args[i]+"' is not a number");
					}
				}
				break;
			case "-l":
				if (i+1 < args.length) {
					i++;
					logFile = args[i];
				}
				break;
			case "-n":
				if (i+1 < args.length) {
					i++;
					try {
						numAgents = Integer.parseInt(args[i]);
					} catch (Exception e) {
						abort("Option value '"+args[i]+"' is not a number");
					}
				}
				break;
			case "-o":
				if (i+1 < args.length) {
					i++;
					pout = args[i];
				}
				break;
			case "-p":
				if (i+1 < args.length) {
					i++;
					pargs = args[i];
				}
				break;
			case "-r":
				if (i+1 < args.length) {
					i++;
					try {
						randomSeed = Long.parseLong(args[i]);
					} catch (Exception e) {
						abort("Option value '"+args[i]+"' is not a number");
					}
				}
				break;
			case "-t":
				if (i+1 < args.length) {
					i++;
					try {
						numThreads = Integer.parseInt(args[i]);
					} catch (Exception e) {
						abort("Option value '"+args[i]+"' is not a number");
					}
				}
				break;
			case "-w":
				doPauseForUserInput = true;
				break;
			}	
		}
		// Abort if required args were not given
		if (args.length == 0) {
			abort(null);
		} else if (agentClass == null) {
			abort("Some required options were not given");
		}
	}

	public static int getNumThreads() {
		return numThreads;
	}

	public static String getLogFile() {
		return logFile;
	}

	public static Level getLogLevel() {
		return logLevel;
	}

	public static String getAgentClass() {
		return agentClass;
	}

	public static int getNumAgents() {
		return numAgents;
	}
	
	public static int getNumCycles() {
		return numCycles;
	}

	private static void abort(String err) {
		if (err != null) {
			System.err.println("\nERROR: " + err + "\n");
		}
		System.out.println(usage());
		System.exit(0);
	}

	public static String[] getProgramArguments() {
		return pargs.split(" ") ;
	}

	public static String getProgramOutputFile() {
		return pout ;
	}

	public static long getRandomSeed() {
		return randomSeed;
	}

	public static boolean doPauseForUserInput() {
		return doPauseForUserInput;
	}
}
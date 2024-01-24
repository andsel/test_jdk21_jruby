package org.dna;

import org.jruby.embed.ScriptingContainer;

import java.lang.management.ManagementFactory;
import java.util.List;


public class App {

    public static void main(String[] args) {
        String javaVersion = System.getProperty("java.version");
        System.out.println( "Running JRuby embedded interpreter in Java version: " +  javaVersion);
        List<String> jvmArgs = ManagementFactory.getRuntimeMXBean().getInputArguments();
        System.out.println("Running with JVM args: " + jvmArgs);
        //Ruby ruby = Ruby.getGlobalRuntime();
        ScriptingContainer ruby = new ScriptingContainer();

        String rubyScript = "hash_set = Java::JavaUtil::LinkedHashSet.new\n" +
                "hash_set << 1\n" +
                "hash_set << 2\n" +
                "hash_set << 3\n" +
                "\n" +
                "res = hash_set.map {|v| v % 2}\n" +
                "res.sum"; // must be 2, 1 for each odd number

        //final IRubyObject result = ruby.evalScriptlet(rubyScript);
        //if (!result.toJava(Long.class).equals(2L)) {
        //    System.out.println("Failure in running Ruby script expected 2 but return value was " + result);
        //}

        Object result = ruby.runScriptlet(rubyScript);
        System.out.println("Result from execution " + result);
    }
}
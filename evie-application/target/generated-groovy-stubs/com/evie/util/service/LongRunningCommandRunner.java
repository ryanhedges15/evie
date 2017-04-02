package com.evie.util.service;

import java.lang.*;
import java.io.*;
import java.net.*;
import java.util.*;
import groovy.lang.*;
import groovy.util.*;

public class LongRunningCommandRunner
  extends java.lang.Object  implements
    java.lang.Runnable,    groovy.lang.GroovyObject {
;
public LongRunningCommandRunner
(com.evie.commands.scheduled.Command c) {}
public  groovy.lang.MetaClass getMetaClass() { return (groovy.lang.MetaClass)null;}
public  void setMetaClass(groovy.lang.MetaClass mc) { }
public  java.lang.Object invokeMethod(java.lang.String method, java.lang.Object arguments) { return null;}
public  java.lang.Object getProperty(java.lang.String property) { return null;}
public  void setProperty(java.lang.String property, java.lang.Object value) { }
public  void setCommand(com.evie.commands.scheduled.Command value) { }
public  void setLastRun(java.sql.Timestamp value) { }
public  void run() { }
public  java.lang.String[] getCommand() { return (java.lang.String[])null;}
public  com.evie.util.processors.LineProcessor getLineProcessor() { return (com.evie.util.processors.LineProcessor)null;}
public  void setLineProcessor(com.evie.util.processors.LineProcessor lineProcessor) { }
public  java.sql.Timestamp getLastRun() { return (java.sql.Timestamp)null;}
}

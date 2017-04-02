package com.evie.util.service;

import java.lang.*;
import java.io.*;
import java.net.*;
import java.util.*;
import groovy.lang.*;
import groovy.util.*;

public class CommandTrackingService
  extends java.lang.Object  implements
    groovy.lang.GroovyObject {
;
public  groovy.lang.MetaClass getMetaClass() { return (groovy.lang.MetaClass)null;}
public  void setMetaClass(groovy.lang.MetaClass mc) { }
public  java.lang.Object invokeMethod(java.lang.String method, java.lang.Object arguments) { return null;}
public  java.lang.Object getProperty(java.lang.String property) { return null;}
public  void setProperty(java.lang.String property, java.lang.Object value) { }
public  org.slf4j.Logger getLogger() { return (org.slf4j.Logger)null;}
public  void setLogger(org.slf4j.Logger value) { }
public  java.util.List<com.evie.commands.scheduled.Command> getAllCommands() { return (java.util.List<com.evie.commands.scheduled.Command>)null;}
public  void setAllCommands(java.util.List<com.evie.commands.scheduled.Command> value) { }
public  java.util.List<com.evie.util.service.LongRunningCommandRunner> getCommandRunnerList() { return (java.util.List<com.evie.util.service.LongRunningCommandRunner>)null;}
public  void setCommandRunnerList(java.util.List<com.evie.util.service.LongRunningCommandRunner> value) { }
@javax.annotation.PostConstruct() public  void init() { }
@org.springframework.scheduling.annotation.Scheduled(fixedDelay=900000) public  void logAllRunningCommands() { }
}

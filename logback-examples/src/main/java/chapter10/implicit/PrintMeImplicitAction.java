/**
 * Logback: the generic, reliable, fast and flexible logging framework.
 * 
 * Copyright (C) 2000-2009, QOS.ch
 * 
 * This library is free software, you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation.
 */
package chapter10.implicit;

import org.xml.sax.Attributes;

import ch.qos.logback.core.joran.action.ImplicitAction;
import ch.qos.logback.core.joran.spi.InterpretationContext;
import ch.qos.logback.core.joran.spi.Pattern;

/**
 * 
 * A rather trivial implicit action which is applicable if an element has a
 * printme attribute set to true.
 * 
 * @author Ceki G&uuml;lc&uuml;
 */
public class PrintMeImplicitAction extends ImplicitAction {

  public boolean isApplicable(Pattern pattern, Attributes attributes,
      InterpretationContext ec) {
    String printmeStr = attributes.getValue("printme");

    return Boolean.valueOf(printmeStr).booleanValue();
  }

  public void begin(InterpretationContext ec, String name, Attributes attributes) {
    System.out.println("Element [" + name + "] asked to be printed.");
  }

  public void end(InterpretationContext ec, String name) {
  }
}

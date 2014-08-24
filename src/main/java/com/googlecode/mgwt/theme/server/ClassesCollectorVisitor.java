/*
 * Copyright 2010 Daniel Kurka
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.googlecode.mgwt.theme.server;

import com.google.gwt.resources.css.ast.Context;
import com.google.gwt.resources.css.ast.CssSelector;
import com.google.gwt.resources.css.ast.CssVisitor;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * A visitor that collects all classes of a style sheet.
 */
public class ClassesCollectorVisitor extends CssVisitor {

  private Set<String> allClasses = new HashSet<String>();

  public Set<String> getAllClasses() {
    return Collections.unmodifiableSet(allClasses);
  }

  @Override
  public boolean visit(CssSelector x, Context ctx) {
    allClasses.add(x.getSelector());
    return true;
  }
}

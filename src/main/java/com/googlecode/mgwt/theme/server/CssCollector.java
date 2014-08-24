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

import com.google.gwt.core.ext.UnableToCompleteException;
import com.google.gwt.dev.util.log.PrintWriterTreeLogger;
import com.google.gwt.resources.css.GenerateCssAst;
import com.google.gwt.resources.css.ast.CssStylesheet;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * CssCollector reads in css from a given directory, strips all properties and outputs it
 * into another directory.
 */
public class CssCollector {

  public static void main(String[] args) throws MalformedURLException, UnableToCompleteException, FileNotFoundException {
    if (args.length != 2) {
      System.out.println("Usage: CssCollector <css dir> <output dir>");
      System.exit(-1);
    }

    File cssDir = new File(args[0]);
    File outputDir = new File(args[1]);


    Set<File> allCssFiles = collectAllCssFiles(cssDir);
    Map<File, Set<String>> classesByFile = collectorClassPerOutFile(allCssFiles, outputDir);
    generateCssFiles(classesByFile);
    System.out.print("Generated " + allCssFiles.size() + " css files.");
  }

  private static void generateCssFiles(Map<File, Set<String>> classesByFile) throws FileNotFoundException {
    for (Entry<File, Set<String>> entry: classesByFile.entrySet()) {
      PrintWriter printWriter = new PrintWriter(entry.getKey());

      for (String className : entry.getValue()) {
        printWriter.append(className);
        printWriter.append(" {");
        printWriter.append("\n");
        printWriter.append("  \n");
        printWriter.append("}");
        printWriter.append("\n");
      }
      printWriter.close();
    }
  }

  private static Map<File, Set<String>> collectorClassPerOutFile(Set<File> allCssFiles,
      File outputDir) throws MalformedURLException, UnableToCompleteException {

    Map<File,Set<String>> map = new HashMap<File, Set<String>>();

    for (File file : allCssFiles) {

      CssStylesheet sheet =
          GenerateCssAst.exec(new PrintWriterTreeLogger(new PrintWriter(System.err)), file.toURI()
              .toURL());
      ClassesCollectorVisitor classesCollectorVisitor = new ClassesCollectorVisitor();
      classesCollectorVisitor.accept(sheet);
      Set<String> allClasses = classesCollectorVisitor.getAllClasses();

      File outfile = new File(outputDir, file.getName());
      map.put(outfile, allClasses);
    }
    return map;
  }

  private static Set<File> collectAllCssFiles(File cssDir) {
    Set<File> set = new HashSet<File>();
    collectAllCssFiles(set, cssDir);
    return set;
  }

  private static void collectAllCssFiles(Set<File> cssFiles, File cssDir) {
    if (!cssDir.isDirectory()) {
      throw new IllegalArgumentException("no directory");
    }

    for (File currentFile : cssDir.listFiles()) {
      if (currentFile.isFile() && currentFile.getName().endsWith(".css")) {
        cssFiles.add(currentFile);
      } else if (currentFile.isDirectory()) {
        if (currentFile.getAbsolutePath().contains("animation/")) {
          continue;
        }
        collectAllCssFiles(cssFiles, currentFile);
      }
    }
  }
}

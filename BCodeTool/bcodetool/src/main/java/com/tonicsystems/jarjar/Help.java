package com.tonicsystems.jarjar;

/**
 * Created by zhoubin on 2021/3/31.
 **/
public class Help {
    public static final String TEXT = "Jar Jar Links - A utility to repackage and embed Java libraries\n" +
            "Copyright 2007 Google Inc.\n" +
            "\n" +
            "Command-line usage:\n" +
            "\n" +
            "  java -jar jarjar.jar [help]\n" +
            "\n" +
            "    Prints this help message.\n" +
            "\n" +
            "  java -jar jarjar.jar strings <cp>\n" +
            "\n" +
            "    Dumps all string literals in classpath <cp>. Line numbers will be\n" +
            "    included if the classes have debug information.\n" +
            "\n" +
            "  java -jar jarjar.jar find <level> <cp1> [<cp2>]\n" +
            "\n" +
            "    Prints dependencies on classpath <cp2> in classpath <cp1>. If <cp2>\n" +
            "    is omitted, <cp1> is used for both arguments.\n" +
            "\n" +
            "    The level argument must be \"class\" or \"jar\". The former prints\n" +
            "    dependencies between individual classes, while the latter only\n" +
            "    prints jar->jar dependencies. A \"jar\" in this context is actually\n" +
            "    any classpath component, which can be a jar file, a zip file, or a\n" +
            "    parent directory (see below).\n" +
            "\n" +
            "  java -jar jarjar.jar process <rulesFile> <inJar> <outJar>\n" +
            "\n" +
            "    Transform the <inJar> jar file, writing a new jar file to <outJar>.\n" +
            "    Any existing file named by <outJar> will be deleted.\n" +
            "\n" +
            "    The transformation is defined by a set of rules in the file specified\n" +
            "    by the rules argument (see below).\n" +
            "\n" +
            "Classpath format:\n" +
            "\n" +
            "  The classpath argument is a colon or semi-colon delimited set\n" +
            "  (depending on platform) of directories, jar files, or zip files. See\n" +
            "  the following page for more details:\n" +
            "  http://java.sun.com/j2se/1.5.0/docs/tooldocs/solaris/classpath.html\n" +
            "  \n" +
            "  Mustang-style wildcards are also supported:\n" +
            "  http://bugs.sun.com/bugdatabase/view_bug.do?bug_id=6268383\n" +
            "\n" +
            "Rules file format:\n" +
            "\n" +
            "  The rules file is a text file, one rule per line. Leading and trailing\n" +
            "  whitespace is ignored. There are three types of rules:\n" +
            "\n" +
            "    rule <pattern> <result>\n" +
            "    zap <pattern>\n" +
            "    keep <pattern>\n" +
            "\n" +
            "  The standard rule (\"rule\") is used to rename classes. All references\n" +
            "  to the renamed classes will also be updated. If a class name is\n" +
            "  matched by more than one rule, only the first one will apply.\n" +
            "\n" +
            "  <pattern> is a class name with optional wildcards. \"**\" will\n" +
            "  match against any valid class name substring. To match a single\n" +
            "  package component (by excluding \".\" from the match), a single \"*\" may\n" +
            "  be used instead.\n" +
            "\n" +
            "  <result> is a class name which can optionally reference the\n" +
            "  substrings matched by the wildcards. A numbered reference is available\n" +
            "  for every \"*\" or \"**\" in the <pattern>, starting from left to\n" +
            "  right: \"@1\", \"@2\", etc. A special \"@0\" reference contains the entire\n" +
            "  matched class name.\n" +
            "\n" +
            "  The \"zap\" rule causes any matched class to be removed from the resulting\n" +
            "  jar file. All zap rules are processed before renaming rules.\n" +
            "\n" +
            "  The \"keep\" rule marks all matched classes as \"roots\". If any keep\n" +
            "  rules are defined all classes which are not reachable from the roots\n" +
            "  via dependency analysis are discarded when writing the output\n" +
            "  jar. This is the last step in the process, after renaming and zapping.\n" +
            "\n";
}

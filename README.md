# GraalVM Espresso Project

[![Java](https://img.shields.io/badge/Java-17-blue.svg)](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
[![GraalVM](https://img.shields.io/badge/GraalVM-22.3.r17--grl-brightgreen.svg)](https://www.graalvm.org/)
[![Truffle](https://img.shields.io/badge/Truffle-API-orange.svg)](https://www.graalvm.org/truffle/)
[![Espresso](https://img.shields.io/badge/Espresso-Java--on--Truffle-orange.svg)](https://www.graalvm.org/reference-manual/java-on-truffle/)

This project demonstrates the use of GraalVM, Truffle, and Espresso to securely execute Java bytecode within a sandboxed environment. The setup leverages GraalVM's polyglot capabilities and provides a secure context to run Java applications.

## Technologies Used

- **Java 17**: The project uses Java 17 as the programming language.
- **GraalVM 22.3.r17-grl**: The project uses GraalVM, installed via SDKMAN, to execute Java bytecode securely.
- **Truffle**: Truffle API is used to create and manage the execution of Java code.
- **Espresso**: Espresso enables running Java bytecode on top of the Truffle framework within GraalVM.

## Prerequisites

- **SDKMAN**: To manage your Java and GraalVM installations.
- **GraalVM**: Install GraalVM via SDKMAN with the following command:
  ```sh
  sdk install java 22.3.r17-grl
  ```
  

# GraalVM Playground

[![Java](https://img.shields.io/badge/Java-17-blue.svg)](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
[![GraalVM](https://img.shields.io/badge/GraalVM-22.3.r17--grl-brightgreen.svg)](https://www.graalvm.org/)
[![Truffle](https://img.shields.io/badge/Truffle-API-orange.svg)](https://www.graalvm.org/truffle/)
[![Espresso](https://img.shields.io/badge/Espresso-Java--on--Truffle-orange.svg)](https://www.graalvm.org/reference-manual/java-on-truffle/)

This project demonstrates how to implement sandboxing in GraalVM for Java applications using the Truffle API and Espresso project. It provides a secure environment for executing Java code by leveraging GraalVM's capabilities, ensuring that the execution is contained within a sandbox.


## Table of Contents
- [Features](#features)
- [Setup Instructions](#setup-instructions)
- [Usage](#usage)
- [Example Code](#example-code)
- [Contributing](#contributing)


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

## Features

- Secure sandboxing of Java applications
- Execution of Java methods in a controlled environment
- Utilization of GraalVM's polyglot capabilities
- Practical examples using Truffle API and Espresso

## Setup Instructions
* Clone the repository:
  ```shell
  git clone git@github.com:ih0r-d/graalvm-playground.git
  cd graalvm-playground
  ```
* Build the project:
  ```shell
  git clone git@github.com:ih0r-d/graalvm-playground.git
  cd graalvm-playground
  ```
* Run the application:
  ```shell
  java -jar target/graalvm-playground-0.0.1-SNAPSHOT.jarD
  ```

## Usage
To demonstrate the usage of the GraalVmExecutor class, initialize the executor, load a class, and execute methods within the secured GraalVM context.

## Example Code
For detailed implementation, refer to the `GraalvmPlaygroundApplication` and GraalVmExecutor classes in the source code. These classes showcase how to set up a secured GraalVM context, load Java classes, and execute methods using the Truffle API and Espresso project.

## Contributing
Contributions are welcome! 
Please open an issue or submit a pull request with your improvements.
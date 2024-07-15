package com.github.ih0rd;

import com.github.ih0rd.domain.HelloWorld;
import com.github.ih0rd.helpers.GraalVmExecutor;

public class GraalvmPlaygroundApplication {

    public static void main(String[] args) {

        var graalVMExecutor = new GraalVmExecutor();

        HelloWorld helloWorld = graalVMExecutor.loadClassIntoContext(HelloWorld.class);
        helloWorld.printHello();
        System.out.println("helloWorld.simplyMultiply(2,5) = " + helloWorld.simplyMultiply(2, 5));

        // Execute method via Truffle API & Espresso
        Object printHelloResult = graalVMExecutor.executeMethod(HelloWorld.class, "printHello");
        System.out.println("printHelloResult = " + printHelloResult);

        Object simplyMultiplyResult = graalVMExecutor.executeMethod(HelloWorld.class, "simplyMultiply", 2, 3);
        System.out.println("simplyMultiplyResult = " + simplyMultiplyResult);

        graalVMExecutor.closeContext();
    }

}

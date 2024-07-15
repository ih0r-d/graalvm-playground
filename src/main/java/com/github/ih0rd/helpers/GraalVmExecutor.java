package com.github.ih0rd.helpers;

import com.github.ih0rd.exceptions.GraalVMPlaygroundException;
import com.oracle.truffle.api.*;
import com.oracle.truffle.api.nodes.DirectCallNode;


import org.graalvm.polyglot.Context;

/**
 * A class to manage the execution of operations within a secured GraalVM polyglot context.
 */
public class GraalVmExecutor {

    private final Context context;

    /**
     * Constructs a new GraalVmExecutor with a secured GraalVM polyglot context.
     */
    public GraalVmExecutor() {
        context = ContextManager.getSecuredContext();
    }

    /**
     * Loads a class into the GraalVM polyglot context, creates an instance of the class,
     * and retrieves it from the context's polyglot bindings.
     *
     * @param <T>   The type of the class to be loaded.
     * @param clazz The class to be loaded and instantiated.
     * @return An instance of the class loaded from the context's polyglot bindings.
     * @throws GraalVMPlaygroundException if the class cannot be loaded or instantiated.
     */
    public <T> T loadClassIntoContext(Class<T> clazz) {
        try {
            var instance = clazz.getDeclaredConstructor().newInstance();
            var memberName = clazz.getSimpleName();
            context.getPolyglotBindings().putMember(memberName, instance);
            return context.getPolyglotBindings().getMember(memberName).as(clazz);
        } catch (Exception e) {
            throw new GraalVMPlaygroundException("Failed to load class into context", e);
        }
    }

    /**
     * Executes a specified method of a given class with provided arguments using Truffle.
     *
     * @param clazz      The class containing the method to be executed.
     * @param methodName The name of the method to be executed.
     * @param args       The arguments to be passed to the method during execution.
     * @return The result of the method execution.
     */
    public Object executeMethod(Class<?> clazz, String methodName, Object... args) {
        TruffleRuntime runtime = Truffle.getRuntime();
        var javaNode = new JavaNode(clazz, methodName, args);
        DirectCallNode directCallNode = runtime.createDirectCallNode(javaNode.getCallTarget());
        return directCallNode.call(args);
    }


    /**
     * Closes the GraalVM polyglot context if it is open.
     */
    public void closeContext() {
        if (context != null) {
            context.close();
        }
    }
}
package com.percolate.sdk.python.bridge;

import py4j.GatewayServer;

/**
 * Py4j java bridge.  See module README for details and usage.
 */
public class PercolateSdkPythonBridge {

    public static void main(String[] args) {
        PercolateSdkPythonBridge app = new PercolateSdkPythonBridge();
        GatewayServer server = new GatewayServer(app);
        System.out.println("Python Bridge Running.  Ctrl+C to stop.");
        server.start();
    }
}

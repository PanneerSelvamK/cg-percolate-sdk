package com.percolate.sdk.python.bridge;

import com.percolate.sdk.api.PercolateApi;
import com.percolate.sdk.api.request.license.LicenseV5Params;
import com.percolate.sdk.api.request.terms.TermsParams;
import com.percolate.sdk.dto.LicensesV5;

import java.io.IOException;
import java.util.ArrayList;

import py4j.GatewayServer;
import retrofit2.Response;

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

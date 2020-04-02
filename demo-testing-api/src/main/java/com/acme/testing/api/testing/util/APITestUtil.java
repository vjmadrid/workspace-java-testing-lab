package com.acme.testing.api.testing.util;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.util.Random;
import java.util.Scanner;

public class APITestUtil {
	
	private static final int DEFAULT_PORT = 8081;
	
	protected APITestUtil() {
		throw new IllegalStateException("APITestUtil");
	}

	private static boolean isFree(int port) {
        try {
            new ServerSocket(port).close();
            return true;
        } catch (IOException e) {
            return false;
        }
    }
	
	public static int getAvailablePort() {
        return new Random()
                .ints(6000, 9000)
                .filter(APITestUtil::isFree)
                .findFirst()
                .orElse(DEFAULT_PORT);
    }
	
	public static String inputStreamToString(InputStream is) {
        Scanner s = new Scanner(is).useDelimiter("\\A");
        return s.hasNext() ? s.next() : "";
    }

}

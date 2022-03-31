package com.compression.app;

import com.compression.app.logic.Compressor;
import com.compression.app.logic.RleCompressor;

public class Application {
    public Application() {
    }

    public void Run(String[] args){
        String test = "abbbbbbbbbbbbbbDDDCCC";

        Compressor compressor = new RleCompressor();

        String encoded = compressor.encode(test);
        System.out.println(encoded);
        String decoded = compressor.decode(encoded);
        System.out.println(decoded);
        System.out.println("do match: " + test.equals(decoded));

    }
}

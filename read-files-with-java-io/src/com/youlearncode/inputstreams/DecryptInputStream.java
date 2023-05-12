package com.youlearncode.inputstreams;

import java.io.IOException;
import java.io.InputStream;

public class DecryptInputStream extends EncryptInputStream {
  
  public DecryptInputStream(InputStream in, byte key) throws IOException {
    super(in, key);
  }
}

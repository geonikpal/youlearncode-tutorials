package com.youlearncode.inputstreams;

import com.youlearncode.exceptions.NotImplementedException;
import java.io.*;

public class EncryptInputStream extends FilterInputStream {
  
  private final byte[] buf;
  // Note that the variable count just holds the buf[] array length.
  private final int count;
  private int pos = 0, mark = 0;
  
  public EncryptInputStream(InputStream in, byte key) throws IOException {
    super(in);
    this.buf = encryptBuf(in.readAllBytes(), key);
    this.count = buf.length;
  }
  
  @Override
  public int read() {
    // Note that the & 0xff guarantees that only the last 8 bits will be read and any other will be ignored.
    return (pos >= count) ? -1 : (buf[pos++] & 0xff);
  }
  
  @Override
  public int read(byte[] b, int off, int len) {
    // Note that here we just throw a Custom Exception.
    throw new NotImplementedException("Implementation missing!");
  }
  
  @Override
  public byte[] readAllBytes() { return buf; }
  
  private byte[] encryptBuf(byte[] buffer, byte key) {
    byte[] buf_ = new byte[buffer.length];
    for (int i = 0; i < buffer.length; i++)
      buf_[i] = (byte)(buffer[i] ^ key);
    return buf_;
  }
  
  @Override
  public synchronized void mark(int readLimit) { mark = pos; }
  
  @Override
  public synchronized void reset() { pos = mark; }
  
  @Override
  public boolean markSupported() { return true; }
}
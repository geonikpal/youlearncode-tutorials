package com.youlearncode;

import com.youlearncode.bytes.streams.*;
import com.youlearncode.characters.streams.*;
import com.youlearncode.tools.Performance;

public class Main {
  
  public static void main(String[] args) {
    
    // Byte Streams
    //PipedStream.readUsingPipedInputStream();
    //Performance.getExecutionTime(FileStream::readUsingFileInputStream);
    //Performance.getExecutionTime(BufferedStream::readUsingBufferedInputStream);
    //Performance.getExecutionTime(SequenceStream::readUsingSequenceInputStream);
    //Performance.getExecutionTime(SequenceStream::readUsingSequenceInputStreamVector);
    //Performance.getExecutionTime(ByteArrayStream::readUsingByteArrayInputStream);
    //Performance.getExecutionTime(PushbackStream::readUsingPushbackInputStream);
    //Performance.getExecutionTime(ObjectStream::readUsingObjectInputStream);
    //Performance.getExecutionTime(EncryptedStream::readUsingEncryptedInputStream);
    //Performance.getExecutionTime(DataStream::readUsingDataInputStream);
    
    // Issue due to reading texts using Input Streams (byte streams)
    //Performance.getExecutionTime(FileStream::readNonASCIIUsingFileInputStream);
    
    // Character Streams
    //PipedStreamReader.readUsingPipedReader();
    //Performance.getExecutionTime(FileInputStreamReader::readUsingInputStreamReader);
    //Performance.getExecutionTime(FileStreamReader::readUsingFileReader);
    //Performance.getExecutionTime(StringStreamReader::readUsingStringReader);
    //Performance.getExecutionTime(CharArrayStreamReader::readUsingCharArrayReader);
    //Performance.getExecutionTime(BufferedStreamReader::readUsingBufferedReader);
    //Performance.getExecutionTime(LineNumberStreamReader::readUsingLineNumberReader);
    //Performance.getExecutionTime(PushbackStreamReader::readUsingPushbackStreamReader);
  }
}
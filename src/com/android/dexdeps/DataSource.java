package com.android.dexdeps;

import java.io.IOException;

public interface DataSource {
  void seek(long position) throws IOException;
  void readFully(byte[] buffer) throws IOException;
  void readFully(byte[] buffer, int offset, int length) throws IOException;
}

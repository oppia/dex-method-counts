package com.android.dexdeps;

import java.io.IOException;
import java.io.RandomAccessFile;

public final class RandomAccessFileDataSource implements DataSource {
  private final RandomAccessFile file;

  public RandomAccessFileDataSource(RandomAccessFile file) {
    this.file = file;
  }

  @Override
  public void seek(long position) throws IOException {
    file.seek(position);
  }

  @Override
  public void readFully(byte[] buffer) throws IOException {
    file.readFully(buffer);
  }

  @Override
  public void readFully(byte[] buffer, int offset, int length) throws IOException {
    file.readFully(buffer, offset, length);
  }
}

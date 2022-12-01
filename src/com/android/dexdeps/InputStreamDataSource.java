package com.android.dexdeps;

import java.io.DataInputStream;
import java.io.IOException;

public final class InputStreamDataSource implements DataSource {
  private final DataInputStream input;

  public InputStreamDataSource(DataInputStream input, int maxInputLength) {
    this.input = input;
    if (!input.markSupported()) {
      throw new IllegalArgumentException("Input stream must support marks.");
    }

    input.mark(maxInputLength);
  }

  @Override
  public void seek(long position) throws IOException {
    input.reset();
    long totalSkipped = 0L;
    long skipped;
    while ((skipped = input.skip(position - totalSkipped)) != 0L) {
      totalSkipped += skipped;
      if (totalSkipped >= position) break;
    }
    if (totalSkipped != position) {
      throw new IllegalStateException(
        "Failed to seek to position: " + position + " (skipped " + skipped + " bytes).");
    }
  }

  @Override
  public void readFully(byte[] buffer) throws IOException {
    input.readFully(buffer);
  }

  @Override
  public void readFully(byte[] buffer, int offset, int length) throws IOException {
    input.readFully(buffer, offset, length);
  }
}

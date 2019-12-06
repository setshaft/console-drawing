package com.drawingprogram.app;

public class DrawingHelper {
  char[][] charStream;
  int width, height;

  public DrawingHelper() {
  }

  public DrawingHelper(int width, int height) {
    if (width < 1 || height < 1) {
      throw new IllegalArgumentException("Canvas measurements cannot be less than 1");
    }
    this.width = width + 2;
    this.height = height + 2;
    this.charStream = new char[this.height][this.width];
    streamCanvas();
  }

  private void streamCanvas() {
    streamLine(0, 0, this.width - 1, 0, '-');
    streamLine(0, this.height - 1, this.width - 1, this.height - 1, '-');
    streamLine(0, 1, 0, this.height - 2, '|');
    streamLine(this.width - 1, 1, this.width - 1, this.height - 2, '|');
  }

  public String print() {
    checkIfCanvasIsThere();
    final StringBuilder stream = new StringBuilder();
    for (int yAxis = 0; yAxis < this.height; yAxis++) {
      for (int xAxis = 0; xAxis < this.width; xAxis++) {
        stream.append(this.charStream[yAxis][xAxis] == '\u0000' ? ' ' : this.charStream[yAxis][xAxis]);
      }
      stream.append("\n");
    }
    return stream.toString();
  }

  public void streamLine(final int x1, final int y1, final int x2, final int y2, final char character) {
    checkIfCanvasIsThere();
    for (int yAxis = y1; yAxis <= y2; yAxis++) {
      for (int xAxis = x1; xAxis <= x2; xAxis++) {
        this.charStream[yAxis][xAxis] = character;
      }
    }
  }

  public void streamRectangle(final int x1, final int y1, final int x2, final int y2, final char character) {
    checkIfCanvasIsThere();
    streamLine(x1, y1, x2, y1, character);
    streamLine(x1, y1, x1, y2, character);
    streamLine(x2, y1, x2, y2, character);
    streamLine(x1, y2, x2, y2, character);
  }

  public void fillColor(int x, int y, char character) {
    checkIfCanvasIsThere();
    if (this.charStream[y][x] != '\u0000') {
      return;
    }
    if (x > 0 || x < this.height || y > 0 || y < this.width) {
      if (this.charStream[y][x] == '\u0000') {
        this.charStream[y][x] = character;
      }
      fillColor(x + 1, y, character);
      fillColor(x - 1, y, character);
      fillColor(x, y - 1, character);
      fillColor(x, y + 1, character);
    }
  }

  private void checkIfCanvasIsThere() {
    if (this.charStream == null)
      throw new IllegalStateException("Canvas is not defined, please define with C {width} {height} and try again.");
  }
}

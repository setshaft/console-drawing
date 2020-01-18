package com.drawingprogram.types;

import com.drawingprogram.exceptions.InvalidCommandTypeException;
import com.drawingprogram.interfaces.SupportedType;

public class Canvas {
  char[][] charStream;
  int width, height;

  public Canvas(final int width, final int height) {
    if (width < 1 || height < 1) {
      throw new IllegalArgumentException("Canvas measurements cannot be less than 1");
    }
    this.width = width + 2;
    this.height = height + 2;
    this.charStream = new char[this.height][this.width];
    streamCanvas();
  }

  private void streamCanvas() {
    streamLine(new Line(0, 0, this.width - 1, 0), '-');
    streamLine(new Line(0, this.height - 1, this.width - 1, this.height - 1), '-');
    streamLine(new Line(0, 1, 0, this.height - 2), '|');
    streamLine(new Line(this.width - 1, 1, this.width - 1, this.height - 2), '|');
  }

  public void streamType(SupportedType command) throws InvalidCommandTypeException {
    if (command instanceof Line) {
      streamLine((Line) command, 'x');
    } else if (command instanceof Rectangle) {
      streamRectangle((Rectangle) command, 'x');
    } else if (command instanceof Bucket) {
      fillColor((Bucket) command);
    }
  }

  public StringBuilder render() {
    checkIfCanvasIsThere();
    final StringBuilder stream = new StringBuilder();
    for (int yAxis = 0; yAxis < this.height; yAxis++) {
      for (int xAxis = 0; xAxis < this.width; xAxis++) {
        stream.append(this.charStream[yAxis][xAxis] == '\u0000' ? ' ' : this.charStream[yAxis][xAxis]);
      }
      stream.append("\n");
    }
    System.out.println(stream.toString());
    return stream;
  }

  public void streamLine(Line line, char character) {
    checkIfCanvasIsThere();
    this.charStream = line.stream(this.charStream, character);
  }

  public void streamRectangle(Rectangle rectangle, final char character) {
    checkIfCanvasIsThere();
    this.charStream = rectangle.stream(charStream, character);
  }

  public void fillColor(Bucket bucket) {
    checkIfCanvasIsThere();
    this.charStream = bucket.stream(bucket.getX(), bucket.getY(), charStream, height, width);
  }

  private void checkIfCanvasIsThere() {
    if (this.charStream == null)
      throw new IllegalStateException("Canvas is not defined, please define with C {width} {height} and try again.");
  }
}

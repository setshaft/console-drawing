package com.drawingprogram.types;

import com.drawingprogram.interfaces.SupportedType;

public class Bucket implements SupportedType {
  private int x;
  private int y;
  private char character;

  public Bucket(int _x1, int _y1, char character) {
    setX(_x1);
    setY(_y1);
    setCharacter(character);
  }

  public char[][] stream(int start, int end, char[][] charStream, int height, int width) {
    if (charStream[end][start] != '\u0000') {
      return charStream;
    }
    if (start > 0 || start < height || y > 0 || y < width) {
      if (charStream[end][start] == '\u0000') {
        charStream[end][start] = character;
      }
      stream(start + 1, end, charStream, height, width);
      stream(start - 1, end, charStream, height, width);
      stream(start, end - 1, charStream, height, width);
      stream(start, end + 1, charStream, height, width);
    }
    return charStream;
  }

  public int getX() {
    return x;
  }

  public void setX(int x) {
    this.x = x;
  }

  public int getY() {
    return y;
  }

  public void setY(int y) {
    this.y = y;
  }

  public char getCharacter() {
    return character;
  }

  public void setCharacter(char character) {
    this.character = character;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + character;
    result = prime * result + x;
    result = prime * result + y;
    return result;
  }

}
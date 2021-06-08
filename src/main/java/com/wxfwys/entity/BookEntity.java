package com.wxfwys.entity;

import lombok.Data;

@Data
public class BookEntity {
  private int id;
  private String title;
  private String description;
  private String author;
  private String isbn;
  private String reader;
}

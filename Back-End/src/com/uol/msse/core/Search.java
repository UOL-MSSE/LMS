package com.uol.msse.core;


import com.uol.msse.data.BookItem;
import com.uol.msse.entity.Format;

import java.util.List;

public interface Search {

    List<BookItem> getAllByTitle(String title);

    List<BookItem> getAllByFormat(Format format);

    List<BookItem> getByUserName(String firstName, String lastName);

}

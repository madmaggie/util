package com.utils.course

import org.springframework.stereotype.Component

/**
 * Created by Rox on 18.12.2014.
 */
@Component
class PascalTriangle {

  def pascal(r: Integer, c: Integer) : Integer = {

    if ((r == 0) || (r == c)) return 1

    if (c == 0) return 1

    pascal((r-1), (c-1)) + pascal(r, (c-1))

  }
}


